$('.select2').select2();

let campos = ["name", "surname", "date-birth",
     "nacionalidade", "tipo-doc-1",
    "doc-1", "genero", "pais",
    "codigopostal", "endereco",
    "numero", "complemento", "bairro",
    "municipio", "estado", "contato1", "locacao", "email"];


let form = $("#form-meus-dados");


$("#salvar").click(function () {

    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Altera&ccedil;&atilde;o realizada com sucesso!';
                text = "Dados alterados.";
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