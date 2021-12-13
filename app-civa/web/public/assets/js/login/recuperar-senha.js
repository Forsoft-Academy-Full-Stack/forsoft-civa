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
               // let email = form_email.serialize().split("=")[1];
                let email = $("#email").val();
                
                let responseText2 = eval(jqXHR.responseText);
                let cod = responseText2.split("=")[3];               
                sendEmail(email, cod);
                
                title = 'Codigo enviado!';
                text = "Verifique o email informado.";
                swalAlertSuccess(title, text, () => {
                    // window.location.href = data.redirect;
                    // console.log(jqXHR.getAllResponseHeaders());
                    //console.log(data.responseText);
                    //console.log(data.redirect);
                    //console.log(data.responseData);
                    //console.log(jqXHR.getResponseHeader('location'));                                     
                    let responseText = eval(jqXHR.responseText);
                   
                    //responseText = eval(jqXHR.responseText);
                    
                    let arr = jqXHR.responseText.split("&");
                    arr.pop();                  
                    let location = arr.join('&');
                    location = location.split('./');
                                    
                  
                    window.location = location[1];


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


function sendEmail(email, codigoRecuperacao) {
    Email.send({
        Host: "smtp.gmail.com",
        Username: "civa.forsoft.suporte@gmail.com",
        Password: "suporteciva2021A@",
        To: email,
        From: "civa.forsoft.suporte@gmail.com",
        Subject: "Forsoft CIVA Recuperacao",
        Body: "C&oacute;digo de Recupera&ccedil;&atilde;o: " + codigoRecuperacao,
    }).then(
            message => {
               // title = 'Código enviado';
               // text = '';
               // swalAlertInfo(title, text, callback);
            }
    );
}
