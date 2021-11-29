$('.select2').select2();

let campos = ["nome", "documento-registro", "natureza","tipo-estabelecimento", 
    "nome-pais","cod-postal", "nome-logrd","nome-num", "nome-comple", "bairro","municipio", "estado", 
    "tele","locacao"];


let form = $("#form-meus-dados");


$("#salvar").click(function () {

    if (tratar_campos(campos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Unidade cadastrada com sucesso!';
                text = "Cadastro realizada.";
                swalAlertSuccess(title, text, callback);

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


//pegarPaises("nacionalidade");