$('.select2').select2();

let campos = ["name", "surname", "genero", "date-birth",
     "nacionalidade", "tipo-doc-1", "tipo-doc-2", "doc-2",
     "tipo-doc-3", "doc-3",
    "doc-1", "country-name",
    "postal-code", "logrd-name",
    "num-name", "comple-name", "bairro",
    "city", "state", "telf", "email"];


let form = $("#form-meus-dados");


$("#cadastrar").click(function () {

    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Gestor nacional cadastrado com sucesso!';
                text = "Cadastro realizada.";
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


pegarPaises("nacionalidade");