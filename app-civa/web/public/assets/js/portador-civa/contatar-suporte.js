$('.select2').select2();

let form = $("#contato-suporte");
let campos = ["name", "email", "problema"];

$("#enviar-suporte").click(function () {

    if (tratar_campos(campos)) {
        
        let name = $("#name").val();
        let email = $("#email").val();
        let problema = $("#problema").val();

        title = 'Enviando, aguarde alguns segundos...';
        text = '';
        swalAlertLoading(title, callback);

       

        sendEmail(email, name, "Problema, Dúvida ou Sugestão.", problema);

    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos para poder enviar!';
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
                title = 'Enviado!';
                text = "Agradecemos pelo contato! Responderemos através do seu e-mail!";
                swalAlertSuccess(title, text, () => {
                    location.reload();
                });
            }
    );
}
