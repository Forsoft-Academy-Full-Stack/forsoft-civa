$('.select2').select2();

let form = $("#form-meus-dados");
let campos = ['name', 'surname', 'genero', 'date-birth', 'nacionalidade', 'tipo-doc', 'doc',
    'country-name', 'postal-code', 'logrd-name', 'numero', 'comple-name', 'bairro',
    'municipio', 'estado', 'telf', 'email'];
let valor;

$("#salvar").click(function () {
  
    if (tratar_campos(campos)) {
       
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Alterações realizadas com sucesso!';
                text = "";
                swalAlertSuccess(title, text, () => {document.location.reload();});

            } else {
                title = 'Erro!';
                text = 'Algum erro ocorreu e seus dados n&atilde;o foram enviados.';
                swalAlertError(title, text, callback);
            }
        });
    } else {
        title = 'Campos n&atilde;o preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }
});

$("#excluir").click(function() {
   $.get("", form.serialize(), (data, status) => {
        if (status === 'sucess'){
            title = 'Cuidado!';
            text = 'Deseja mesmo excluir o cadastro? Essa ação não pode ser revertida!';
            swalAlertError(title, text, callback);
        } else {
            title = 'Erro!';
            text = 'Algum erro ocorreu e seus dados n&atilde;o foram enviados.';
            swalAlertError(title, text, callback);
        }
   }); 
});