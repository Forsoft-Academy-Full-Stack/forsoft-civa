$('.select2').select2();

let form = $("#form-painel-portador");
let campos = ["laboratorio", "vacina", "numerodoses",
    "lote", "unidade"];
let valor;

$("#cadastro").click(function () {
  
    if (tratar_campos(campos)) {
       
        $.get("", form.serialize(), (data, status) => {
            console.log("Entrou 2");
            if (status === 'success') {
                title = 'Cadastro realizado com sucesso!';
                text = "Vacina&ccedil;&atilde;o cadastrada.";
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


function limparCamposCadastroVacinacao() {
    $("#lote").val("");

    // Mudando a posi&ccedil;&atilde;o do select
    //seleciona o valor da posi&ccedil;&atilde;o desejada
    valor = $("#laboratorio option:eq(1)").val();
    //seleciona no select2 e disapara o evento
    $('#laboratorio').val(valor).trigger('change');

    valor = $("#vacina option:eq(1)").val();
    //seleciona no select2 e disapara o evento
    $('#vacina').val(valor).trigger('change');

    valor = $("#numerodoses option:eq(1)").val();
    //seleciona no select2 e disapara o evento
    $('#numerodoses').val(valor).trigger('change');

    valor = $("#unidade option:eq(1)").val();
    //seleciona no select2 e disapara o evento
    $('#unidade').val(valor).trigger('change');
}