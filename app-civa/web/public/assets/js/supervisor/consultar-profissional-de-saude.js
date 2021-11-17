$('.select2').select2();

document.getElementById('form-meus-dados').onsubmit = tratarCampos;

function tratarCampos() {
    let erro = false;
    let campos = ['name', 'surname', 'genero', 'date-birth', 'nacionalidade', 'tipo-doc-1', 'doc-1', 'tipo-doc-2', 'doc-2', 'tipo-doc-3', 'doc-3', 'country-name', 'postal-code', 'logrd-name', 'num-name', 'comple-name', 'local', 'city', 'state', 'telf', 'email'];

    for (i = 0; i < campos.length; i++) {
        if (document.getElementById(campos[i]).value == '') {
            erro = true;
        }
    }

    if (erro) {
        alert('Todos os campos devem ser preenchidos!');
    } else {
        // Exibe o modal desejado, baseado no id definido.
        $('#modal-default').modal('show');
        console.log('funcionou');
        event.preventDefault();

    }

    return !erro;
}

const html = {
    get(element) {
        return document.querySelector(element);
    }
}

async function getUser() {
    const campoEstado = html.get("#state");
    const campoCidade = html.get("#city");
    const campoBairro = html.get("#local");
    const campoLogradouro = html.get("#logrd-name");
    // const campoDdd = html.get("#inputDdd");
    const cepDigitado = html.get("#postal-code");


    const response = await axios.get(`https://viacep.com.br/ws/${cepDigitado.value}/json/`);
    const estado = response.data.uf;
    const cidade = response.data.localidade;
    const bairro = response.data.bairro;
    const logradouro = response.data.logradouro;
    // const ddd = response.data.ddd;


    campoEstado.innerHTML = `<option selected="">${estado}</option>`;
    campoCidade.innerHTML = `<option selected="">${cidade}</option>`;
    campoBairro.innerHTML = `<option selected="">${bairro}</option>`;
    campoLogradouro.value = `${logradouro}`;
    // campoDdd.value = `${ddd}`;
};