$('.select2').select2();

function tratarCampos() {
    let erro = false;
    let campos = ['identity', 'name', 'surname', 'genero', 'date-birth', 'nacionalidade', 'tipo-doc-1', 'doc-1', 'tipo-doc-2', 'doc-2', 'tipo-doc-3', 'doc-3', 'country-name', 'postal-code', 'logrd-name', 'numero', 'comple-name', 'bairro', 'municipio', 'cidade', 'telf', 'email'];

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

document.getElementById('form-unidade-vinculada').onsubmit = tratarCampos;