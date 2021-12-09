$('.select2').select2();

let form = $("#form-meus-dados");
let campos = ["nome", "sobrenome",
    "genero", "data-nascimento",
    "nacionalidade", "tipo-doc1", "doc1",
    "nome-pais", "cod-postal", "nome-logrd",
    "nome-num", "nome-comple", "bairro",
    "municipio", "estado", "tele", "email"];

$("#salvar").click(function () {

    if (tratar_campos(campos)) {
        $.post("/app-civa/administradorOms", form.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Administrador OMS atualizado com sucesso!';
                text = "Cadastro atualizado.";
                swalAlertSuccess(title, text, () => {
                    location.reload()
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

$("#excluir").click(function () {
    $.get("", form.serialize(), (data, status) => {
        if (status === 'sucess') {
            title = 'Cuidado!';
            text = 'Deseja mesmo excluir o cadastro? Essa ação não pode ser revertida!';
            swalAlertError(title, text, callback);
        } else {
            title = 'Erro!';
            text = 'Algum erro ocorreu e seus dados n&atilde;o foram enviados.';
            swalAlertError(title, text, callback);
        }
    });
});