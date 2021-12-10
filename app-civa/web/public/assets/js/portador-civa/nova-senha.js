$('.select2').select2();

let form = $("#nova-senha");
let campos = ["senha", "conf-senha"];

$("#nova-senha").click(function () {
  
    if (tratar_campos(campos)) {
       if (campos[0].value !== campos[1].value) {
        $.post("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Enviado!';
                text = "Senha cadastrada com sucesso!";
                swalAlertSuccess(title, text, () => {document.location.reload();});

            } else {
                title = 'Erro!';
                text = 'Algum erro ocorreu e seus dados n&atilde;o foram enviados.';
                swalAlertError(title, text, callback);
            }
        });
    } else {
        title = 'Erro!';
        text = 'As duas senhas informadas devem ser iguais!';
        swalAlertError(title, text, callback);
    }
    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos para poder enviar!';
        swalAlertError(title, text, callback);
    }
});
