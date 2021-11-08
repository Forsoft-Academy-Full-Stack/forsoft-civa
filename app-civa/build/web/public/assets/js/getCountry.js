
async function pegarPaises(idInputPais) {
    // PEGAR DADOS CEP
    const paises = await axios('./../public/assets/js/json/CountryCodes.json')
        .then(nameCountry => nameCountry.data )
        .catch(erro => window.alert('Houve um erro ao carregar a API paises!'));

    // EXIBIR NO INPUT NACIONALIDADE
    for (let x = 0; x < paises.length; x++) {
 
        const option = document.createElement('option');
        option.value = paises[x].code;
        option.innerText = paises[x].name;
        getElement(`#${idInputPais}`).appendChild(option);
    }

}
