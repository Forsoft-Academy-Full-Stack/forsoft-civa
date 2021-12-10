$('.select2').select2();

let form = $("#form-painel-portador");
let form2 = $("#dados-pc");
let campos = ["laboratorio", "vacina", "numerodoses",
    "lote", "unidade"];
let valor;

$("#cadastro").click(function () {  
    if (tratar_campos(campos)) {       
       $.post("/app-civa/vacinacao", $(form, form2).serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Vacinação cadastrada com sucesso!';
                text = "Cadastro atualizado.";
                swalAlertSuccess(title, text, () => {
                    window.location = "./vacinacao.jsp";
                });

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