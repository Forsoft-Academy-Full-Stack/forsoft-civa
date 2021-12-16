$('.select2').select2();

let campos = ['nome-vac', 'laboratorio',
    'tipovac', 'doses', 'timedoses', 'reforco'];

// Pegando o elemento form da p&aacute;gina
let form = $("#form-selecionar-vacina");



$("#nome-vac").change(() => {
    $("#nome-vacina").val("");
    $("#laboratorio").val("");
    $("#doses").val("");
    $("#tipovac").val("");
    $("#timedoses").val("");
    $("#reforco").val("");


})

$("#cadastrar").click(function () {

    if (tratar_campos(campos)) {
        
        title = 'Enviando, aguarde alguns segundos...';
        swalAlertLoading(title, callback);

        $.post("/app-civa/vacina", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Vacina cadastrada com sucesso!';
                text = "";
                swalAlertSuccess(title, text, () => {
                   window.location = './selecionar-vacina.jsp';
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