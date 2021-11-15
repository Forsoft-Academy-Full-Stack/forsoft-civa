$('.select2').select2();

let campos = [];


let form = $("#form-meus-dados");


$("#salvar").click(function () {

    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Supervisor alterado com sucesso!';
                text = "Altera&ccedil;&atilde;o realizada.";
                swalAlertSuccess(title, text, callback);

            } else {
                title = 'Erro!';
                text = 'Algum erro ocorreu e seus dados n&atilde;o foram enviados.';
                swalAlertError(title, text, callback);
            }
        });
    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }
});


$("#excluir").click(function () {
    icon = "info"
    title = 'Deseja realmente excluir esse Supervisor?';
    text = 'A&ccedil;&atilde;o irrevers&iacute;vel';
    statusInfo = "Supervisor deletado",
    textInfo = "Exclus&atilde;o realizada."
    swalAlertDelete(title, text, statusInfo, textInfo);
});

pegarPaises("nacionalidade");