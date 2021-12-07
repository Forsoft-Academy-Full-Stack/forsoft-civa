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

$("#salvar").click(function () {
  
    if (tratar_campos(campos)) {
            $.post("/app-civa/profissionalSaude", form.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Profissional da Saude atualizado com sucesso!';
                text = "Cadastro atualizado.";
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