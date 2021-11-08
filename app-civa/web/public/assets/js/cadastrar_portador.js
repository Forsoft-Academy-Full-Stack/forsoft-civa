$('.select2').select2();

let campos = ["name", "surname", "date-birth",
     "nacionalidade", "tipo-doc-1",
    "doc-1", "pais",
    "codigopostal", "endereco",
    "numero", "complemento", "bairro",
    "municipio", "estado", "contato1", "locacao",
    "contato2", "email"];



let form = $("#form-meus-dados");
$("#cadastrar").click(function () {

    if (tratar_campos(arrayCampos)) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Cadastro realizado com sucesso!';
                text = "C&oacute;digo CIVA: " + gerarCodigoCiva();
                swalAlertSuccess(title, text, limparCamposCadastroPortador);

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


function gerarCodigoCiva() {
    return "BRASKSD32132121";
}

function limparCamposCadastroPortador() {
    $("#name").val("");
    $("#surname").val("");
    $("#date-birth").val("");
    $("#identity").val("");

    // Mudando a posi&ccedil;&atilde;o do select
    $('#nationality').select2();
    //seleciona o valor da posi&ccedil;&atilde;o desejada
    let valor = $("#nationality option:eq(1)").val();
    //seleciona no select2 e disapara o evento
    $('#nationality').val(valor).trigger('change');


    $("#codigopostal").val("");
    $("#logradouro").val("");
    $("#numerorua").val("");
    $("#numerorua").val("");
    $("#complemento").val("");
    $("#bairro").val("");
    $("#cidade").val("");
    $("#estado").val("");
    $("#telf").val("");
    $("#email").val("");
}

pegarPaises("nacionalidade");