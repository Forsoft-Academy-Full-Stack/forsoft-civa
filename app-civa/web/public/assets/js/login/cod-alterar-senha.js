$('.select2').select2();


let form_alterar_senha = $("#altera-senha");

let campos = ["codigo-enviado"];

$("#avancar").click(function () {

    if (tratar_campos(campos)) {

        title = 'Enviando, aguarde alguns segundos...';
        text = '';
        swalAlertLoading(title, callback);

        $.post("/app-civa/login", form_alterar_senha.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'C&oacute;digo V&aacute;lido!';
                text = "";
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
            title = 'C&oacute;digo inv&aacute;lido!';
            text = 'digite um  c&oacute;digo v&aacute;lido.';
            swalAlertInfo(title, text, callback);                    
        });       

    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }
});