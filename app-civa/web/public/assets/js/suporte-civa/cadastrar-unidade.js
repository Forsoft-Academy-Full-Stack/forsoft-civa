$('.select2').select2();

let campos = ["nome", "documento-registro", "natureza","tipo-estabelecimento", 
    "nome-pais","cod-postal", "nome-logrd","nome-num", "nome-comple", "bairro","municipio", "estado", 
    "tele","locacao"];


let form = $("#form-meus-dados");


$("#salvar").click(function () {

    if (tratar_campos(campos)) {
        $.post("/app-civa/unidade", form.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Unidade cadastrada com sucesso!';
                text = "Cadastro realizada.";
                swalAlertSuccess(title, text, () => {
                    window.location = "./cadastrar-unidade.jsp";
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


//pegarPaises("nacionalidade");