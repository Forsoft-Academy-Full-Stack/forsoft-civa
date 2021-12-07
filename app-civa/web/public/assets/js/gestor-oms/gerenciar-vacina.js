$('.select2').select2();

let campos = ['nome', 'lab', 'tipo-vacina', 'doses', 'intervalo-dose', 'tempo-reforco'];

let form = $("#form-vacina");
$("#salvar").click(function () {
    if (tratar_campos(campos)) {
        $.post("/app-civa/vacina", form.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Vacina atualizada com sucesso!';
                text = "Alterada com sucesso!.";
                swalAlertSuccess(title, text, () => {
                   location.reload();
                });

            }
        }).fail(function (jqxhr, settings, ex) {
            title = 'Erro!';
            text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
            swalAlertError(title, text, callback);
        });
    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos para poder enviar!';
        swalAlertError(title, text, callback);
    }
});