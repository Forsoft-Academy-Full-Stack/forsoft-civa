$('.select2').select2();
$('#modal-certificado-civa').modal('show');

let campos = ["cod-ver"];

let form = $("#validar-civa");

$("#validar-cod").click(() => {

    if (tratar_campos(campos)) {

        $.post("/app-civa/login", form.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
               $("#modal-certificado-civa").modal("show");
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
        //$("#modal-certificado-civa").modal("hide");
    }

});


pegarPaises("nacionalidade");