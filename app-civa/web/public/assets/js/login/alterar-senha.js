$('.select2').select2();


let form_alterar_senha = $("#form-altera-senha");

let campos = ["nova-senha", "confimar-senha"];

$("#alterar").click(function () {

    let senhas_iguais = $("#nova-senha").val() === $("#confimar-senha").val();

    if (tratar_campos(campos)) {

        if (senhas_iguais) {
            title = 'Enviando, aguarde alguns segundos...';
            text = '';
            swalAlertLoading(title, callback);

            $.post("/app-civa/login", form_alterar_senha.serialize(), (data, status, jqXHR) => {
                console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
                if (status === 'success') {
                    title = 'Senha alterada com successo!';
                    text = "Sua senha foi alterada com successo, fa&ccedil;a o seu login.";
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
            title = 'Senhas diferentes';
            text = 'digite senha e confirmar senha iguais!';
            swalAlertInfo(title, text, callback);
        }

    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }
});