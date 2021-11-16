$('.select2').select2();

let arrayCampos = ["laboratorio", "vacina", "dose", "lote", "unidade"];
let form = $("#form-cad-vacinacao");

$("#cadastrar").click(() => {

    if (tratar_campos(arrayCampos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Cadastro realizado com sucesso!';
                text = "Vacina&ccedil;&atilde;o internacional cadastrada.";
                swalAlertSuccess(title, text, callback)

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
