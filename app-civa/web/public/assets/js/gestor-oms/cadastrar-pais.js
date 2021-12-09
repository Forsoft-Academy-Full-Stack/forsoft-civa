$('.select2').select2();

let campos_pais = ["pais", "continente",
    "ddi", "padrao-contato",
    "orgao-saude", "fuso-horario",
    "tipo-doc1-p", "doc1-p", "form-doc1-p", "subdivisao1", "subdivisao2",
    "subdivisao3", "subdivisao4", "subdivisao5", "subdivisao6", "subdivisao7", "sigla"];

let campos_gestor_nacional = ["nome-gn", "sobrenome-gn", "genero-gn",
    "data-nascimento-gn", "nacionalidade-gn", "tipo-doc1-gn", "doc1-gn",
    "nome-pais-gn", "cod-postal-gn", "nome-logrd-gn", "nome-num-gn",
    "nome-comple-gn", "bairro-gn", "municipio-gn", "estado-gn", "tele-gn",
    "email-gn"];

let campos_suporte_civa = ["nome", "sobrenome", "genero",
    "data-nascimento", "nacionalidade", "tipo-doc1", "doc1",
    "nome-pais", "cod-postal", "nome-logrd", "nome-num",
    "nome-comple", "bairro", "municipio", "estado", "tele",
    "email"];

let form1 = $("#dados-pais");
let form2 = $("#dados-gestor-nacional");
let form3 = $("#dados-suporte-civa");

//form2.hide();
//form3.hide();

$("#cadastrar").click(function () {

    if (tratar_campos(campos_pais)) {

        $.post("/app-civa/pais", form1.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Pa&iacute;s cadastrado com sucesso!';
                text = "Cadastro realizada.";
                swalAlertSuccess(title, text, () => {
                    location.reload();                                      

                });
            }
        }).fail(function (jqxhr, settings, ex) {
            title = 'Erro!';
            text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
            swalAlertError(title, text, callback);
        });

    } else {
        title = 'Erro!';
        text = '&Eacute; necess&aacute;rio preencher os dados do pa&iacute;s, do Gestor Nacional e do Suporte CIVA para finalizar o cadastro!';
        swalAlertError(title, text, callback);
    }

    if (tratar_campos(campos_gestor_nacional)) {

        $.post("/app-civa/pais", form2.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Gestor Nacional com sucesso!';
                text = "Cadastro realizada.";
                swalAlertSuccess(title, text, () => {      
                    location.reload();
                    //form2.hide();
                    //form3.show();
                    //form1.hide();

                });
            }
        }).fail(function (jqxhr, settings, ex) {
            title = 'Erro!';
            text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
            swalAlertError(title, text, callback);
        });

    } else {
        title = 'Erro!';
        text = '&Eacute; necess&aacute;rio preencher os dados do pa&iacute;s, do Gestor Nacional e do Suporte CIVA para finalizar o cadastro!';
        swalAlertError(title, text, callback);
    }
    
    
     if (tratar_campos(campos_suporte_civa)) {

        $.post("/app-civa/pais", form3.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Gestor Nacional com sucesso!';
                text = "Cadastro realizada.";
                swalAlertSuccess(title, text, () => {
                    window.location = './cadastrar-pais.jsp';

                });
            }
        }).fail(function (jqxhr, settings, ex) {
            title = 'Erro!';
            text = `Algum erro ocorreu e seus dados n&atilde;o foram enviados. Status: ${settings} ${ex}`;
            swalAlertError(title, text, callback);
        });

    } else {
        title = 'Erro!';
        text = '&Eacute; necess&aacute;rio preencher os dados do pa&iacute;s, do Gestor Nacional e do Suporte CIVA para finalizar o cadastro!';
        swalAlertError(title, text, callback);
    }



});

pegarPaises("nacionalidade");
pegarPaises("nacionalidade-gn");