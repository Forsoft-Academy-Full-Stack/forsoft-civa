$('.select2').select2();

const html = {
    get(element) {
        return document.querySelector(element);
    }
}

const filtro = html.get('#pesquisar');
const filtrobotao = html.get('#button-addon2');
// filtro.addEventListener("input", function(){
function filtrar() {
    const unidades = document.querySelectorAll('.coluna');
    if (filtro.value.length > 0) {
        for (let i = 0; i < unidades.length; i++) {
            const lugar = unidades[i];
            const tdNome = lugar.querySelector('.coluna-nome');
            const nome = tdNome.textContent;
            const expressao = new RegExp(this.value, "i");
            if (!expressao.test(nome)) {
                lugar.classList.add("invisivel");
            } else {
                lugar.classList.remove("invisivel");
            }
        }

    } else {
        for (let i = 0; i < unidades.length; i++) {
            const lugar = unidades[i];
            lugar.classList.remove("invisivel");
        }
    }
}