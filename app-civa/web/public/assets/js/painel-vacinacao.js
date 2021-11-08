let campos = ["name", "surname", "date-birth", "identity", "idvacinacao", "vacina", "laboratorio", "dose", "dataaplicacao", "pais", "idunidade", "unidade", "codigociva", "lote"];
let form = $("#form-painel-vacinacao");

$('.select2').select2()

$("#salvar").click(function () {

    if (tratar_campos(campos)) {

        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Dados alterados com sucesso!';
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