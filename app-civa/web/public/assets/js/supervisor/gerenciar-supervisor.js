$("#salvar").click(function () {
  
    if (tratar_campos(campos)) {
            $.post("/app-civa/supervisor", form.serialize(), (data, status, jqXHR) => {
            console.log("Data: " + data.responseData + ", Status: " + status + ", jqXHR: " + jqXHR);
            if (status === 'success') {
                title = 'Supervisor atualizado com sucesso!';
                text = "Cadastro atualizado.";
                swalAlertSuccess(title, text, callback);

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