$('.select2').select2();

let campos = ['nome', 'lab', 'tipo-vacina', 'doses', 'intervalo-dose', 'tempo-reforco'];

let form = $("#form-vacina");
$("#cadastrar").click(function () {  
    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Vacina cadastrada com sucesso!';
                text = "";
                swalAlertSuccess(title, text, () => {document.location.reload();});

            } else {
                title = 'Erro!';
                text = 'Algum erro ocorreu e os dados n&atilde;o foram enviados.';
                swalAlertError(title, text, callback);
            }
        });
    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos para poder enviar!';
        swalAlertError(title, text, callback);
    }    
});