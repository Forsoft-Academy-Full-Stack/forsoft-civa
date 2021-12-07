$('.select2').select2();

let campos = ['idvacina', 'dose', 'vacina', 'lab', 'typevacina', 'timevacina', 'timereforco'];

let form = $("#form-vacina");
$("#salvar").click(function () {    
    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Dados alterados com sucesso!';
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