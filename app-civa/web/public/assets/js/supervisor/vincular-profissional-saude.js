$('.select2').select2();

let campos = ["nome", "sobrenome",
    "genero", //"data-nascimento",
    "nacionalidade",
    "tipo-doc1", "doc1", "tipo-doc2", "doc2"];

let form = $("#form-meus-dados");
let campos_confirmar_senha = ["senha-confirmacao"];
let modal_confirmar_senha = $("#modal-confirmar-senha");

$("#vincular").click(() => {

    if (tratar_campos(campos)) {
        modal_confirmar_senha.modal("show");
        $("#confirmar").click(() => {
            if (tratar_campos(campos_confirmar_senha)) {
                modal_confirmar_senha.modal("hide");

                $.post("/app-civa/unidade", form.serialize(), (data, status, jqXHR) => {
                    console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
                    if (status === 'success') {
                        title = 'Profissional vinculado com sucesso!';
                        text = "Cadastro realizada.";
                        swalAlertSuccess(title, text, callback);

                    }
                }).fail(function (jqxhr, settings, ex) {
                    title = 'Erro!';
                    text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
                    swalAlertError(title, text, callback);
                });
            }
        });

    } else {
        title = 'lalalalala';
        text = 'Pesquise o c&oacute;digo do Profissional desejado';
        swalAlertError(title, text, callback);
    }

});


pegarPaises("nacionalidade");