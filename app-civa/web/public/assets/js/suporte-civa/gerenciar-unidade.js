$('.select2').select2();

let campos = ["name-unidade", "documento-registro", "tipo-estabelecimento",
     "natureza", "pais",
    "codigopostal", "endereco",
    "numero", "complemento", "bairro",
    "municipio", "estado", "contato1", "locacao"];


let form = $("#form-meus-dados");


$("#salvar").click(function () {

    if (tratar_campos(campos)) {
        
        title = 'Enviando, aguarde alguns segundos...';
        swalAlertLoading(title, callback);
        
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Unidade Alterada com sucesso!';
                text = "Altera&ccedil;&atilde;o realizada.";
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

let form_excluir = $("#form-excluir");

$("#excluir").click(function () {
    title = 'Deseja realmente excluir esse Gerente?';
    text = 'A&ccedil;&atilde;o irrevers&iacute;vel';
    swalAlertDelete(title, text, () => {
        
        
        title = 'Enviando, aguarde alguns segundos...';
        swalAlertLoading(title, callback);
        
        
        $.post("/app-civa/unidade", form_excluir.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Desativada!';
                text = "Unidade desativada com sucesso";
                swalAlertInfo(title, text, () => {
                    // redirecionar para o listar
                    window.location = './consultar-unidades.jsp';
                });

            }
        }).fail(function (jqxhr, settings, ex) {
            title = 'Erro!';
            text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
            swalAlertError(title, text, callback);
        });
    });
});



//pegarPaises("nacionalidade");