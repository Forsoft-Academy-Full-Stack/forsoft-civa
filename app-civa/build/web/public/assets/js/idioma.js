
$('.select2').select2()


let form = $("#idioma");
$("#salvar-alteracao").click(function () {

    $.get("", form.serialize(), (data, status) => {
        if (status === 'success') {
            idiomaAlterado();
        } else {
            erroAlterarIdioma();
        }
    });
});


function idiomaAlterado(){
    Toast.fire({
        icon: 'success',
        title: 'Idioma alterado'
    })
}

function erroAlterarIdioma(){
    Toast.fire({
        icon: 'error',
        title: 'Idioma n&atilde;o foi alterado'
    })
}