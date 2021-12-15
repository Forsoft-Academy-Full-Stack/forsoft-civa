$('.select2').select2();
$("#civa").val("");
$("#email").val("");

$(function () {

    $('#perfil').change(function (e) {
        var escolha = $("#perfil").val();

        if (escolha == "portador-civa") {
            $("#civa").val("");
            $("#civa").hide();
            $('#civa-logo').hide();
            $('#user-logo').show();
            $("#email").show();
        } else {
            $("#email").val("");
            $("#email").hide();
            $("#civa").show();
            $('#user-logo').hide();
            $('#civa-logo').show();

        }

    });

});




$("#enviar").click(() => {



    let nome = $("#name").val();
    let email = $("#email").val();
    let subject = $("#subject").val();
    let message = $("#message").val();

    if (tratar_campos(["name", "email", "subject", "message"])) {
        title = 'Enviando, aguarde alguns segundos...';
        text = '';
        swalAlertLoading(title, callback);
        sendEmail(email, nome, subject, message);

    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }

});


function sendEmail(email, name, subject, message) {
    Email.send({
        Host: "smtp.gmail.com",
        Username: "civa.forsoft.suporte@gmail.com",
        Password: "suporteciva2021A@",
        To: 'civa.forsoft.suporte@gmail.com',
        From: "civa.forsoft.suporte@gmail.com",
        Subject: subject,
        Body: "Enviado por: " + name + "\n" + message + "\n" + "Email de envio: " + email,
    }).then(
            message => {
                title = 'Mensagem enviada!';
                text = '';
                swalAlertSuccess(title, text, () => {
                    location.reload();
                });
            }
    );
}
