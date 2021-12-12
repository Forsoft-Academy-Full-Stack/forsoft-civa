$('.select2').select2();

let campos = ["nome", "sobrenome",
    "genero", "data-nascimento",
    "nacionalidade", "tipo-doc1", "doc1",
    "nome-pais", "cod-postal", "nome-logrd",
    "nome-num", "nome-comple", "bairro",
    "municipio", "estado", "tele", "email", "senha", "confirmar-senha"];

let form = $("#form-meus-dados");

$("#salvar").click(() => {

    if (tratar_campos(campos)) {
        let mesma_senha = $("#senha").val() === $("#confirmar-senha").val();

        if (mesma_senha) {
            if ($("#termos-uso").is(":checked")) {
                $.post("/app-civa/portador", form.serialize(), (data, status, jqXHR) => {
                    console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
                    if (status === 'success') {
                        title = 'Codigo enviado!';
                        text = "Verifique o email informado.";
                        swalAlertSuccess(title, text, () => {
                           // window.location = './';
                        });

                    }
                }).fail(function (jqxhr, settings, ex) {
                    title = 'Erro!';
                    text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
                    swalAlertError(title, text, callback);
                });
            } else {
                title = 'Termos de Uso';
                text = 'Para criar o cadastro &eacute; precisso ler e aceitar os termos de uso ';
                swalAlertInfo(title, text, callback);
            }
        } else {
            title = 'Senhas diferentes!';
            text = 'Inserir senha e confirma&ccedil;&atilde;o de senha iguais.';
            swalAlertError(title, text, callback);
        }

    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }
});


pegarPaises("nacionalidade");