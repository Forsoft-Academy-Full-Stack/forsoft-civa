$('.select2').select2();

let campos = ["nome", "sobrenome",
    "genero", //"data-nascimento",
    "nacionalidade",
    "tipo-doc1", "doc1", "tipo-doc2", "doc2"];

let form = $("#form-meus-dados");
let campos_confirmar_senha = ["senha-confirmacao"];
let modal_confirmar_senha = $("#modal-confirmar-senha");

$("#vincular").click(() => {

    $("#confirmar").click(() => {
        if (tratar_campos(campos_confirmar_senha)) {
            modal_confirmar_senha.modal("hide");

            $.post("/app-civa/portador", form.serialize(), (data, status, jqXHR) => {
                console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
                if (status === 'success') {
                    title = 'Portador atualizado com sucesso!';
                    text = "Cadastro realizada.";
                    swalAlertSuccess(title, text, callback);

                }
            }).fail(function (jqxhr, settings, ex) {
                title = 'Erro!';
                text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
                swalAlertError(title, text, callback);
            });
        } else {
            title = 'lalalalala';
            text = 'Pesquise o c&oacute;digo do Profissional desejado';
            swalAlertError(title, text, callback);
        }
    });
    if (tratar_campos(campos)) {

        modal_confirmar_senha.modal("show");

        $("#confirmar").click(() => {
            if (tratar_campos(campos_confirmar_senha)) {
                modal_confirmar_senha.modal("hide");

                $.post("/app-civa/portador", form.serialize(), (data, status, jqXHR) => {
                    console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
                    if (status === 'success') {
                        title = 'Profissional vinculado com sucesso!';
                        text = "V&iacute;nculo realizado.";
                        swalAlertSuccess(title, text, callback);

                    }
                }).fail(function (jqxhr, settings, ex) {
                    title = 'Erro!';
                    text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
                    swalAlertError(title, text, callback);
                });
            } else {
                title = 'Senha n&atilde;o preenchida';
                text = 'Digite a senha do profissional selecionado';
                swalAlertError(title, text, callback);
            }
        });

    } else {
        title = 'Profissional n&atilde;o pesquisado';
        text = 'Pesquise o c&oacute;digo do Profissional desejado';
        swalAlertError(title, text, callback);
    }

});


pegarPaises("nacionalidade");