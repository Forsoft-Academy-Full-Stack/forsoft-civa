let campos = ["identity", "name", "surname", "date-birth", "possaporte", "pais"];
let form = $("#vacinacao-internacional");

$("#cadastro").click(function () {

    if (tratar_campos(campos)) {
        
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {
                title = 'Cadastro realizado com sucesso';
                text = "Vacina&ccedil;&atilde;o Internacional cadastrada.";
                swalAlertSuccess(title, text, callback);
            } else {
                title = 'Erro!';
                text = 'Algum erro ocorreu e seus dados n&atilde;o foram enviados.';
                swalAlertError(title, text, callback);
            }
        });
    }
});
