$('.select2').select2();

let campos = ["name", "surname", "date-birth",
     "nacionalidade", "tipo-doc-1",
    "doc-1", "tipo-doc-2", "doc-2",
    "country-name", "genero",
    "tipo-doc-3", "doc-3",
    "postal-code", "logrd-name",
    "num-name", "comple-name", "bairro",
    "city", "state", "telf", "email"];

let form = $("#form-meus-dados");

$("#salvar").click(function () {

    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Gerente cadastrado com sucesso!';
                text = "Cadastro realizada.";
                swalAlertSuccess(title, text, callback);

            } else {
                title = 'Erro!';
                text = 'Algum erro ocorreu e seus dados não foram enviados.';
                swalAlertError(title, text, callback);
            }
        });
    } else {
        title = 'Campos não preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }
});


pegarPaises("nacionalidade");