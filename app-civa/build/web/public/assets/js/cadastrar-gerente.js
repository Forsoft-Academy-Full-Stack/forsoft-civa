$('.select2').select2();

function exibemodal() {
    event.preventDefault();
    $('#modal-default').modal('show');
}

document.getElementById('form-meus-dados').onsubmit = exibemodal;