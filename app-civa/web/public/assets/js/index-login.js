function sendEmail(e, a, o, l) {
    Email.send({
        Host: "smtp.gmail.com",
        Username: "civa.forsoft.suporte@gmail.com",
        Password: "suporteciva2021A@",
        To: "civa.forsoft.suporte@gmail.com",
        From: "civa.forsoft.suporte@gmail.com",
        Subject: o,
        Body: "Enviado por: " + a + "\n" + l + "\nEmail de envio: " + e,
    }).then((e) => {
        (title = "Mensagem enviada!"),
            (text = ""),
            swalAlertSuccess(title, text, () => {
                location.reload();
            });
    });
}
$(".select2").select2(),
    $("#civa").val(""),
    $("#email").val(""),
    $(function () {
        $("#perfil").change(function (e) {
            "portador-civa" == $("#perfil").val()
                ? ($("#civa").val(""), $("#civa").hide(), $("#civa-logo").hide(), $("#user-logo").show(), $("#email").show())
                : ($("#email").val(""), $("#email").hide(), $("#civa").show(), $("#user-logo").hide(), $("#civa-logo").show());
        });
    }),
    $("#enviar").click(() => {
        let e = $("#name").val(),
            a = $("#email").val(),
            o = $("#subject").val(),
            l = $("#message").val();
        tratar_campos(["name", "email", "subject", "message"])
            ? ((title = "Enviando, aguarde alguns segundos..."), (text = ""), swalAlertLoading(title, callback), sendEmail(a, e, o, l))
            : ((title = "Campos n&atilde;o preenchidos!"), (text = "Todos os campos precisam ser preenchidos!"), swalAlertError(title, text, callback));
    });
