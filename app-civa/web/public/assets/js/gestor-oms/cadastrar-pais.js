$('.select2').select2();

let campos = ["pais", "continente",
    "orgao-saude", "fuso-horario",
    "tipo-doc", "nome-doc",
    "formato-doc"];

let campos_dados_pessoais = ["nome", "sobrenome",
    "genero", "data-nascimento",
    "nacionalidade", "tipo-doc1", "doc1"];

let form = $("#form-meus-dados");

$("#prosseguir").click(() => {
    if (tratar_campos(campos)) {

        location.href = "cadastrar-gestor-nacional.jsp";
        

    } else {
        title = 'Campos não preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }
});


$("#salvar").click(() => {

    if (tratar_campos(campos_dados_pessoais)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Pa&iacute;s cadastrado com sucesso!';
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
