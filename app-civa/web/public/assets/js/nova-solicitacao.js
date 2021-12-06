$('.select2').select2();

let campos = ['code-civa','name', 
    'sobrenome', 'tipo-doc', 'doc', 'senha', 
    'descricao'];

let form = $("#form-meus-dados");
$("#solicitar").click(function () {    
    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Enviado!';
                text = "Agradecemos pelo contato! Em breve responderemos em seu e-mail!";
                swalAlertSuccess(title, text, () => {document.location.reload();});

            } else {
                title = 'Erro!';
                text = 'Algum erro ocorreu e seus dados n&atilde;o foram enviados.';
                swalAlertError(title, text, callback);
            }
        });
    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos para poder enviar!';
        swalAlertError(title, text, callback);
    }    
});
