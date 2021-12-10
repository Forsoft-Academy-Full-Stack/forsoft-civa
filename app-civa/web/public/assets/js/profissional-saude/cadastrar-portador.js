$('.select2').select2();

let campos = ["nome", "sobrenome",
    "genero", "data-nascimento",
    "nacionalidade", "tipo-doc1", "doc1",
    "nome-pais", "cod-postal", "nome-logrd",
    "nome-num", "nome-comple", "bairro",
    "municipio", "estado", "tele", "email", "senha", "confirmar-senha"];

let campos_confirmar_senha = ["senha-confirmacao"];

let form = $("#form-meus-dados");
let modal_confirmar_senha = $("#modal-confirmar-senha");

$("#salvar").click(() => {

    if (tratar_campos(campos)) {

        modal_confirmar_senha.modal("show");

        $("#confirmar").click(() => {
            if (tratar_campos(campos_confirmar_senha)) {
                modal_confirmar_senha.modal("hide");

                title = 'Enviando, aguarde alguns segundos...';
                swalAlertLoading(title, callback);

                $.post("/app-civa/portador", form.serialize(), (data, status, jqXHR) => {
                    console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
                    if (status === 'success') {
                        title = 'Portador cadastrado com sucesso!';
                        text = "Cadastro realizada.";
                        swalAlertSuccess(title, text, () => {
                            window.location = './cadastrar-portador.jsp'
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

    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }
});


pegarPaises("nacionalidade");



