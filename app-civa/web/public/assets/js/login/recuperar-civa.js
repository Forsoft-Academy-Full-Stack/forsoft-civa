$('.select2').select2();

let form_recuperar_civa = $("#form-recuperar-civa");

let campos = ["email"];

$("#enviar").click(function () {

    if (tratar_campos(campos)) {

        title = 'Enviando, aguarde alguns segundos...';
        text = '';
        swalAlertLoading(title, callback);

        $.post("/login", $("#form-recuperar-civa").serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {               
                let email = $("#email").val();

                let codigoCivaRecuperacao = jqXHR.responseText;
                
                 sendEmail(email, codigoCivaRecuperacao);

                title = 'Codigo CIVA enviado!';
                text = "Verifique o email informado.";
                swalAlertSuccess(title, text, callback);

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
        Body: "C&oacute;digo CIVA: " + codigoRecuperacao,
    }).then(
            message => {
                // title = 'Código enviado';
                // text = '';
                // swalAlertInfo(title, text, callback);
            }
    );
}
