$('.select2').select2();

let campos = ['nome-vac', 'laboratorio',
    'tipovac', 'doses', 'timedoses', 'reforco'];

// Pegando o elemento form da p&aacute;gina
let form = $("#form-meus-dados");

$("#cadastrar").click(function () {

    if (tratar_campos(campos)) {

        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Vacina cadastrada com sucesso!';
                text = "";
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