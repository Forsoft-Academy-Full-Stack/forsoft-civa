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
          
        getElement(`#endereco`).value = cepResponse.logradouro !== undefined ? cepResponse.logradouro : "";
        getElement(`#municipio`).value = cepResponse.localidade !== undefined ? cepResponse.localidade : "";
        getElement(`#bairro`).value = cepResponse.bairro !== undefined ? cepResponse.bairro : "";
        //getElement(`#estado`).value = cepResponse.uf

        const respostaEstado = cepResponse.uf;
        let estadoApi = "";
        respostaEstado == "AC" ? estadoApi = "Acre" : null;
        respostaEstado == "AL" ? estadoApi = "Alagoas" : null;
        respostaEstado == "AP" ? estadoApi = "Amap&aacute" : null;
        respostaEstado == "AM" ? estadoApi = "Amazonas" : null;
        respostaEstado == "BA" ? estadoApi = "Bahia" : null;
        respostaEstado == "CE" ? estadoApi = "Cear&aacute" : null;
        respostaEstado == "DF" ? estadoApi = "Distrito Federal" : null;
        respostaEstado == "ES" ? estadoApi = "Esp&iacute;rito Santo" : null;
        respostaEstado == "GO" ? estadoApi = "Goi&aacute;s" : null;
        respostaEstado == "MA" ? estadoApi = "Maranh&atilde;o" : null;
        respostaEstado == "MT" ? estadoApi = "Mato Grosso" : null;
        respostaEstado == "MS" ? estadoApi = "Mato Grosso do Sul" : null;
        respostaEstado == "MG" ? estadoApi = "Minas Gerais" : null;
        respostaEstado == "PA" ? estadoApi = "Par&aacute;" : null;
        respostaEstado == "PB" ? estadoApi = "Para&iacute;ba" : null;
        respostaEstado == "PR" ? estadoApi = "Paran&aacute" : null;
        respostaEstado == "PE" ? estadoApi = "Pernambuco" : null;
        respostaEstado == "PI" ? estadoApi = "Piau&iacute" : null;
        respostaEstado == "RJ" ? estadoApi = "Rio de Janeiro" : null;
        respostaEstado == "RN" ? estadoApi = "Rio Grande do Norte" : null;
        respostaEstado == "RS" ? estadoApi = "Rio Grande do Sul" : null;
        respostaEstado == "RO" ? estadoApi = "Rond&ocirc;nia" : null;
        respostaEstado == "RR" ? estadoApi = "Roraima" : null;
        respostaEstado == "SC" ? estadoApi = "Santa Catarina" : null;
        respostaEstado == "SP" ? estadoApi = "S&atilde;o Paulo" : null;
        respostaEstado == "SE" ? estadoApi = "Sergipe" : null;
        respostaEstado == "TO" ? estadoApi = "Tocantins" : null;
        respostaEstado == undefined ? estadoApi = "CEP N&atilde;o existe." : null;
        console.log(respostaEstado);

        const select = document.querySelector('#estado');
        select.innerHTML = "<option selected>" + estadoApi + "</option>";

    }

}


async function searchCep2(event) {

    const cepValue = event.target.value;
    console.log(event, cepValue);
    // BUSCA API VIACEP
    if (cepValue) {
        const cepResponse = await axios.get(`https://viacep.com.br/ws/${cepValue}/json/`)
                .then(cep => {
                    return cep.data
                })
                .catch(erro => {

                });

        // DEFINE VALORES AOS INPUTS
        //getElement('#logradouro').value = cepResponse.logradouro
        //getElement('#cidade').value = cepResponse.localidade
        //getElement('#bairro').value = cepResponse.bairro
        //getElement('#estado').value = cepResponse.uf
        console.log(cepResponse.logradouro)
        getElement(`#nome-logrd`).value = cepResponse.logradouro !== undefined ? cepResponse.logradouro : "";
        getElement(`#municipio`).value = cepResponse.localidade !== undefined ? cepResponse.localidade : "";
        getElement(`#bairro`).value = cepResponse.bairro !== undefined ? cepResponse.bairro : "";
        //getElement(`#estado`).value = cepResponse.uf 

        const respostaEstado = cepResponse.uf;
        let estadoApi = "";
        respostaEstado == "AC" ? estadoApi = "Acre" : null;
        respostaEstado == "AL" ? estadoApi = "Alagoas" : null;
        respostaEstado == "AP" ? estadoApi = "Amap&aacute" : null;
        respostaEstado == "AM" ? estadoApi = "Amazonas" : null;
        respostaEstado == "BA" ? estadoApi = "Bahia" : null;
        respostaEstado == "CE" ? estadoApi = "Cear&aacute" : null;
        respostaEstado == "DF" ? estadoApi = "Distrito Federal" : null;
        respostaEstado == "ES" ? estadoApi = "Esp&iacute;rito Santo" : null;
        respostaEstado == "GO" ? estadoApi = "Goi&aacute;s" : null;
        respostaEstado == "MA" ? estadoApi = "Maranh&atilde;o" : null;
        respostaEstado == "MT" ? estadoApi = "Mato Grosso" : null;
        respostaEstado == "MS" ? estadoApi = "Mato Grosso do Sul" : null;
        respostaEstado == "MG" ? estadoApi = "Minas Gerais" : null;
        respostaEstado == "PA" ? estadoApi = "Par&aacute;" : null;
        respostaEstado == "PB" ? estadoApi = "Para&iacute;ba" : null;
        respostaEstado == "PR" ? estadoApi = "Paran&aacute" : null;
        respostaEstado == "PE" ? estadoApi = "Pernambuco" : null;
        respostaEstado == "PI" ? estadoApi = "Piau&iacute" : null;
        respostaEstado == "RJ" ? estadoApi = "Rio de Janeiro" : null;
        respostaEstado == "RN" ? estadoApi = "Rio Grande do Norte" : null;
        respostaEstado == "RS" ? estadoApi = "Rio Grande do Sul" : null;
        respostaEstado == "RO" ? estadoApi = "Rond&ocirc;nia" : null;
        respostaEstado == "RR" ? estadoApi = "Roraima" : null;
        respostaEstado == "SC" ? estadoApi = "Santa Catarina" : null;
        respostaEstado == "SP" ? estadoApi = "S&atilde;o Paulo" : null;
        respostaEstado == "SE" ? estadoApi = "Sergipe" : null;
        respostaEstado == "TO" ? estadoApi = "Tocantins" : null;
        respostaEstado == undefined ? estadoApi = "CEP N&atilde;o existe." : null;
        //respostaEstado == null ? estadoApi = "CEP N&atilde;o existe." : null;        
        console.log(respostaEstado);

        const select = document.querySelector('#estado');
        select.innerHTML = "<option selected>" + estadoApi + "</option>";


    }

}




async function searchCep3Gestor(event) {

    const cepValue = event.target.value;
    console.log(event, cepValue);
    // BUSCA API VIACEP
    if (cepValue) {
        const cepResponse = await axios.get(`https://viacep.com.br/ws/${cepValue}/json/`)
                .then(cep => {
                    return cep.data
                })
                .catch(erro => {

                });

        // DEFINE VALORES AOS INPUTS
        //getElement('#logradouro').value = cepResponse.logradouro
        //getElement('#cidade').value = cepResponse.localidade
        //getElement('#bairro').value = cepResponse.bairro
        //getElement('#estado').value = cepResponse.uf
        
        getElement(`#nome-logrd-gn`).value = cepResponse.logradouro !== undefined ? cepResponse.logradouro : "";
        getElement(`#municipio-gn`).value = cepResponse.localidade !== undefined ? cepResponse.localidade : "";
        getElement(`#bairro-gn`).value = cepResponse.bairro !== undefined ? cepResponse.bairro : "";
        //getElement(`#estado`).value = cepResponse.uf

        const respostaEstado = cepResponse.uf;
        let estadoApi = "";
        respostaEstado == "AC" ? estadoApi = "Acre" : null;
        respostaEstado == "AL" ? estadoApi = "Alagoas" : null;
        respostaEstado == "AP" ? estadoApi = "Amap&aacute" : null;
        respostaEstado == "AM" ? estadoApi = "Amazonas" : null;
        respostaEstado == "BA" ? estadoApi = "Bahia" : null;
        respostaEstado == "CE" ? estadoApi = "Cear&aacute" : null;
        respostaEstado == "DF" ? estadoApi = "Distrito Federal" : null;
        respostaEstado == "ES" ? estadoApi = "Esp&iacute;rito Santo" : null;
        respostaEstado == "GO" ? estadoApi = "Goi&aacute;s" : null;
        respostaEstado == "MA" ? estadoApi = "Maranh&atilde;o" : null;
        respostaEstado == "MT" ? estadoApi = "Mato Grosso" : null;
        respostaEstado == "MS" ? estadoApi = "Mato Grosso do Sul" : null;
        respostaEstado == "MG" ? estadoApi = "Minas Gerais" : null;
        respostaEstado == "PA" ? estadoApi = "Par&aacute;" : null;
        respostaEstado == "PB" ? estadoApi = "Para&iacute;ba" : null;
        respostaEstado == "PR" ? estadoApi = "Paran&aacute" : null;
        respostaEstado == "PE" ? estadoApi = "Pernambuco" : null;
        respostaEstado == "PI" ? estadoApi = "Piau&iacute" : null;
        respostaEstado == "RJ" ? estadoApi = "Rio de Janeiro" : null;
        respostaEstado == "RN" ? estadoApi = "Rio Grande do Norte" : null;
        respostaEstado == "RS" ? estadoApi = "Rio Grande do Sul" : null;
        respostaEstado == "RO" ? estadoApi = "Rond&ocirc;nia" : null;
        respostaEstado == "RR" ? estadoApi = "Roraima" : null;
        respostaEstado == "SC" ? estadoApi = "Santa Catarina" : null;
        respostaEstado == "SP" ? estadoApi = "S&atilde;o Paulo" : null;
        respostaEstado == "SE" ? estadoApi = "Sergipe" : null;
        respostaEstado == "TO" ? estadoApi = "Tocantins" : null;
        respostaEstado == undefined ? estadoApi = "CEP N&atilde;o existe." : null;
        console.log(respostaEstado);

        const select = document.querySelector('#estado');
        select.innerHTML = "<option selected>" + estadoApi + "</option>";

    }

}


