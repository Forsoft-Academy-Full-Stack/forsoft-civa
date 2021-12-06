$('.select2').select2();

let campos = ["pais", "continente",
    "ddi", "padrao-contato",
    "orgao-saude", "fuso-horario",
    "tipo-doc1", "doc1", "form-doc1"];

let form = $("#form-meus-dados");

$("#salvar").click(() => {

    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Alterações cadastradas com sucesso!';
                text = "";
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

//pegarPaises("nacionalidade");
