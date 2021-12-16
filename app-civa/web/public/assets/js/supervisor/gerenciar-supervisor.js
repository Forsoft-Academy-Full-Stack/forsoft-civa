$('.select2').select2();

let form = $("#form-meus-dados");
let campos = ["nome", "sobrenome",
    "genero", "data-nascimento",
    "nacionalidade", "tipo-doc1", "doc1",
    "nome-pais", "cod-postal", "nome-logrd",
    "nome-num", "nome-comple", "bairro",
    "municipio", "estado", "tele", "email"];

$("#salvar").click(function () {

    if (tratar_campos(campos)) {
        
        title = 'Enviando, aguarde alguns segundos...';
        swalAlertLoading(title, callback);
        
        $.post("/app-civa/supervisor", form.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Supervisor atualizado com sucesso!';
                text = "Cadastro atualizado.";
                swalAlertSuccess(title, text, () => {
                    location.reload()
                });

            }
        }).fail(function (jqxhr, settings, ex) {
            title = 'Erro!';
            text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
            swalAlertError(title, text, callback);
        });
    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }
});

let form_excluir = $("#form-excluir");

$("#excluir").click(function () {
    title = 'Desativar Supervisor';
    text = 'Deseja desativar esse Supervisor?';
    swalAlertDelete(title, text, () => {
                
        title = 'Enviando, aguarde alguns segundos...';
        swalAlertLoading(title, callback);
        
        
        $.post("/app-civa/supervisor", form_excluir.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Desativado!';
                text = "Supervisor desativado com sucesso";
                swalAlertInfo(title, text, () => {
                    // redirecionar para o listar
                    window.location = './consultar-supervisor.jsp';
                });

            }
        }).fail(function (jqxhr, settings, ex) {
            title = 'Erro!';
            text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
            swalAlertError(title, text, callback);
        });
    });
});

