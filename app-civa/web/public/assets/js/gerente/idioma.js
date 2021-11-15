$('.select2').select2();

let form = $("#idioma");

$("#salvar-alteracao").click(function () {
    // Por enquanto usando o get, mas depois usar o post para salvar
    // Ou usar outro mecânismo, caso não salve esse estado no banco de dados
    $.get("", form.serialize(), (data, status) => {
        if (status === 'success') {
            idiomaAlterado();
        } else {
            erroAlterarIdioma();
        }
    });
});


function idiomaAlterado() {
    Toast.fire({
        icon: 'success',
        title: 'Idioma alterado'
    })
}

function erroAlterarIdioma() {
    Toast.fire({
        icon: 'error',
        title: 'Idioma n&atilde;o foi alterado'
    })
}