$('.select2').select2();

document.getElementById('form-meus-dados').onsubmit = abrirModal;

function abrirModal() {
    // Exibe o modal desejado, baseado no id definido.
    $('#modal-default').modal('show');
    console.log('funcionou');
    event.preventDefault();
}
