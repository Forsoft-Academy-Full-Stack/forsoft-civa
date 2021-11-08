let campos = ["nome", "sobrenome", "datanascimento", "documento",
    "nacionalidade", "codigociva", "codigopostal", "logradouro",
    "numerorua", "complemento", "bairro", "cidade", "estado", "contato", "email"];

let modalConfirmacao = ["message-text", "confirm-password"];
let form = $("#form-meus-dados");

$('.select2').select2()

$("#salvar").click(function () {
    if (tratar_campos(campos)) {
        $('#exampleModal').modal('show');

        $("#avancar").click(function () {
            let tratarSenha = tratar_campos(modalConfirmacao);

            if (tratarSenha) {
                $.get("", form.serialize(), (data, status) => {
                    if (status === 'success') {
                        $('#exampleModal').modal('hide');

                        title = 'Solicita&ccedil;&atilde;o enviada com sucesso!';
                        text = "Envio realizado";
                        swalAlertSuccess(title, text, limparCamposConfirmacao);

                    } else {
                        $('#exampleModal').modal('hide');

                        title = 'Erro!';
                        text = 'Algum erro ocorreu e seus dados n&atilde;o foram enviados.';
                        swalAlertError(title, text, limparCamposConfirmacao);
                    }
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
        swalAlertError(title, text, () => $('#exampleModal').modal('hide'));
    }
});


function limparCamposConfirmacao() {
    $('#exampleModal').find("#confirm-password").val("");
    $('#exampleModal').find("#message-text").val("");
}

pegarPaises("nacionalidade");