$('.select2').select2();

let campos_pais = ["pais", "continente",
    "ddi", "padrao-contato",
    "orgao-saude",
    "tipo-doc1-p", "doc1-p", "form-doc1-p", "subdivisao1", "subdivisao2",
    "subdivisao3", "subdivisao4", "subdivisao5", "subdivisao6", "subdivisao7", "sigla"];

let campos_gestor_nacional = ["nome-gn", "sobrenome-gn", "genero-gn",
    "data-nascimento-gn", "doc1-gn",
    "cod-postal-gn", "nome-logrd-gn", "nome-num-gn",
    "nome-comple-gn", "bairro-gn", "municipio-gn", "estado-gn", "tele-gn",
    "email-gn"];

let campos_suporte_civa = ["nome", "sobrenome", "genero",
    "data-nascimento", "doc1",
    "cod-postal", "nome-logrd", "nome-num",
    "nome-comple", "bairro", "municipio", "estado", "tele",
    "email"];

let form1 = $("#dados-pais");
let form2 = $("#dados-gestor-nacional");
let form3 = $("#dados-suporte-civa");

form2.hide();
form3.hide();
let tag = 'pais';
$("#cadastrar").val("Avançar");

$("#cadastrar").click(function () {
    console.log(tag);
    if (tag === 'pais') {
        if (tratar_campos(campos_pais)) {
            title = 'Agora informe os dados do Gestor Nacional';
            text = 'Clique na aba Dados Gestor Nacional';
            swalAlertInfo(title, text, () => {
                form2.show();
                form3.hide();
                form1.hide();
                tag = 'gestor';
            });

        } else {
            title = 'Campos não preenchidos no pais!';
            text = `Preencha todos os campos`;
            swalAlertInfo(title, text, callback);
        }
    }
});


$("#cadastrar").click(function () {
    console.log(tag);
    if (tag === 'gestor') {
        if (tratar_campos(campos_gestor_nacional)) {
            title = 'Agora informe os dados do Suporte CIVA';
            text = 'Clique na aba Dados Suporte CIVA';
            swalAlertInfo(title, text, () => {
                form2.hide();
                form3.show();
                form1.hide();

                tag = 'suporte';
                $("#cadastrar").val("Cadastrar");
            });


        } else {
            title = 'Campos não preenchidos Gestor Nacional!';
            text = `Preencha todos os campos`;
            swalAlertInfo(title, text, callback);
        }

    }

});


$("#cadastrar").click(function () {
    console.log(tag);
    if (tag === 'suporte') {
        if (tratar_campos(campos_suporte_civa)) {

            title = 'Enviando, aguarde alguns segundos...';
            swalAlertLoading(title, callback)

            $.post("/app-civa/pais", $("#dados-pais, #dados-gestor-nacional, #dados-suporte-civa").serialize(), (data, status, jqXHR) => {
                console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
                if (status === 'success') {
                    title = 'País cadastrado com sucesso!';
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
            title = 'Campos não preenchidos Suporte CIVA!';
            text = `Preencha todos os campos`;
            swalAlertInfo(title, text, callback);
        }

    }
});


//pegarPaises("nacionalidade");
//pegarPaises("nacionalidade-gn");

getElement('#cod-postal').addEventListener('focusout', searchCep2);
getElement('#cod-postal-gn').addEventListener('focusout', searchCep3Gestor);