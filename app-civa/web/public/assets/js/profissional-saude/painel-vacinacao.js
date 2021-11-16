$('.select2').select2();
let form = $("#form-painel-vacinacao");

$("#salvar").click(function () {

    if (tratar_campos()) {
        $.get("", form.serialize(), (data, status) => {
            if (status === 'success') {

                Swal.fire({
                    icon: 'success',
                    title: 'Dados alterados com sucesso!',
                    text: "Altera&ccedil;&atildeo realizada.",
                    confirmButtonText: 'Finalizar',
                    confirmButtonColor: '#007bff'
                });

                console.log("Dados enviados com sucesso :) !");

            } else {

                console.log("Ops... Algum erro ocorreu e seus dados n&atildeo foram enviados :(");

                Swal.fire({
                    icon: 'error',
                    title: '',
                    text: 'Ops... Algum erro ocorreu e seus dados n&atildeo foram enviados :(!',
                    confirmButtonText: 'Finalizar'
                });
            }
        });
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Todos os campos precisam ser preenchidos!',
            confirmButtonColor: '#007bff'
        })
    }
});
