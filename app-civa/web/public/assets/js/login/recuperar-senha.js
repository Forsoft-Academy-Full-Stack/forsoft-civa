$('.select2').select2();

let form_tipo_acesso = $("#form-tipo-acesso");
let form_email = $("#form-email");

let campos = ["tipo", "email"];

$("#enviar").click(function () {

    if (tratar_campos(campos)) {

        title = 'Enviando, aguarde alguns segundos...';
        text = '';
        swalAlertLoading(title, callback);

        $.post("/app-civa/login", $("#form-tipo-acesso, #form-email").serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Codigo enviado!';
                text = "Verifique o email informado.";
                swalAlertSuccess(title, text, () => {
                   // window.location.href = data.redirect;
                  // console.log(jqXHR.getAllResponseHeaders());
                   //console.log(data.responseText);
                   //console.log(data.redirect);
                   //console.log(data.responseData);
                   //console.log(jqXHR.getResponseHeader('location'));                                     
                   var responseText = eval(jqXHR.responseText);
                  window.location = responseText;
                  
                   
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