// PEGA ELEMENTOS HTML
function getElement(id) {
    return document.querySelector(id)
}

// INPUT CEP
// // Chamar somente nas páginas que buscam cep
//getElement('#codigopostal').addEventListener('focusout', searchCep);

async function searchCep(event) {

    const cepValue = event.target.value;
    console.log(event, cepValue);
    // BUSCA API VIACEP
    if (cepValue) {
        const cepResponse = await axios.get(`https://viacep.com.br/ws/${cepValue}/json/`)
                .then(cep => {
                    return cep.data
                })
                .catch(erro => window.alert('CEP n&atilde;o encrontrado'));

        // DEFINE VALORES AOS INPUTS
        //getElement('#logradouro').value = cepResponse.logradouro
        //getElement('#cidade').value = cepResponse.localidade
        //getElement('#bairro').value = cepResponse.bairro
        //getElement('#estado').value = cepResponse.uf

        getElement(`#endereco`).value = cepResponse.logradouro
        getElement(`#municipio`).value = cepResponse.localidade
        getElement(`#bairro`).value = cepResponse.bairro
        getElement(`#estado`).value = cepResponse.uf

    }

}