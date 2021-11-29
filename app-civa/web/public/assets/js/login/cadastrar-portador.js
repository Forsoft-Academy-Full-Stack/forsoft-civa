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
                $.get("", form.serialize(), (data, status) => {
                    if (status === 'success') {
                        title = 'Conta Criada!';
                        text = "Sua conta foi criada com sucesso! Fa&ccedil;a o login!.";
                        swalAlertSuccess(title, text, () => {
                            location.href = '../';
                        });


                    } else {
                        title = 'Erro!';
                        text = 'Algum erro ocorreu e seus dados n&atilde;o foram enviados.';
                        swalAlertError(title, text, callback);
                    }
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


