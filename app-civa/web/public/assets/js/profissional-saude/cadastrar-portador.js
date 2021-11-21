$('.select2').select2();


let campos = ["name", "surname",
    "genero", "date-birth",
    "nacionality", "tipo-doc", "doc",
    "country-name","postal-code", "logrd-name",
    "num-name", "comple-name", "bairro",
    "city", "state", "telf", "email"];


let form = $("#form-meus-dados");


$("#salvar").click(function () {

    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Cadastro realizada com sucesso!';
                text = "Cadastro realizado.";
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


pegarPaises("nacionality");



