let txtarea = document.getElementById('descricao');

function resetValorTextarea() {
    let senha = document.getElementById('senha');
    txtarea.value = '';
    senha.value='';
}

document.getElementById('custom-tabs-four-submit-tab').addEventListener('click', resetValorTextarea);

function setTamanhoTextarea() {
    txtarea.style.height = "20px";
    txtarea.style.height = (txtarea.scrollHeight)+"px";
}

txtarea.addEventListener('input', setTamanhoTextarea);