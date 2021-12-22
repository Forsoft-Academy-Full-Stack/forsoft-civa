$('.select2').select2();

let campos_pais = ["pais", "continente",
    "ddi", "padrao-contato",
    "orgao-saude",
    "nivel-doc", "nome-doc", "formato-doc", "subdivisao1", "subdivisao2",
    "subdivisao3", "subdivisao4", "subdivisao5", "subdivisao6", "subdivisao7", "sigla"];

campos_pais = [];

let form = $("#form-meus-dados");

$("#salvar").click(() => {

    if (tratar_campos(campos_pais)) {
         title = 'Enviando, aguarde alguns segundos...';
         swalAlertLoading(title, callback);
                             
        $.post("/pais", $("#form-meus-dados").serialize(), (data, status, jqXHR) => {
            
            
           
            
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'País atualizado com sucesso!';
                text = "Atualização realizada.";
                swalAlertSuccess(title, text, () => {
                    window.location = './gerenciar-pais.jsp';

                });
            }
        }).fail(function (jqxhr, settings, ex) {
            title = 'Erro!';
            text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
            swalAlertError(title, text, callback);
        });

    } else {
        title = 'Campos não preenchidos!';
        text = 'Todos os campos precisam ser preenchidos!';
        swalAlertError(title, text, callback);
    }

});

//pegarPaises("nacionalidade");
