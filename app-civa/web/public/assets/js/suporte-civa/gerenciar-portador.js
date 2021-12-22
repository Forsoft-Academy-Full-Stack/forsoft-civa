$('.select2').select2();

let campos = ["nome", "sobrenome",
    "genero", "data-nascimento",
    "nacionalidade", "tipo-doc1", "doc1",
    "nome-pais", "cod-postal", "nome-logrd",
    "nome-num", "nome-comple", "bairro",
    "municipio", "estado", "tele", "email"];

let form = $("#form-meus-dados");


$("#salvar").click(function () {

    if (tratar_campos(campos)) {
                
        title = 'Enviando, aguarde alguns segundos...';
        swalAlertLoading(title, callback);
        
        
        $.post("/portador", form.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Portador atualizado com sucesso!';
                text = "Cadastro realizada.";
                swalAlertSuccess(title, text, () => {
                    location.reload();
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
    title = 'Desativar Portador';
    text = 'Deseja desativar esse portador?';
    swalAlertDelete(title, text, () => {
        
        
        title = 'Enviando, aguarde alguns segundos...';
        swalAlertLoading(title, callback);
        
        
        $.post("/portador", form_excluir.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Desativado!';
                text = "Portador desativa com sucesso";
                swalAlertInfo(title, text, () => {
                    // redirecionar para o listar
                    window.location = './consultar-portador.jsp?nome=';
                });

            }
        }).fail(function (jqxhr, settings, ex) {
            title = 'Erro!';
            text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
            swalAlertError(title, text, callback);
        });
    });
});


pegarPaises('nacionalidade');