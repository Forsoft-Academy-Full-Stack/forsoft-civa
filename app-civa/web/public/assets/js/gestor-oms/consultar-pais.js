$('.select2').select2();

function tratarCampos() {
    let erro = false;
    let campos = ['name', 'surname', 'date-birth', 'identity', 'crm', 'nacionality', 'postal-code', 'logrd-name', 'city', 'local', 'state', 'telf', 'email'];

    for (i = 0; i < campos.length; i++) {
        if (document.getElementById(campos[i]).value == '') {
            erro = true;
        }
    }

    if (erro) {
        alert('Todos os campos devem ser preenchidos!');
    } else {
        // Exibe o modal desejado, baseado no id definido.
        $('#modal-default').modal('show');
        console.log('funcionou');
        event.preventDefault();

    }

    return !erro;
}

document.getElementById('form-meus-dados').onsubmit = tratarCampos;
