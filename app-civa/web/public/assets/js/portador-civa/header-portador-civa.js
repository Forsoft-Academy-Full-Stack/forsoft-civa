
// redirecionar página de acordo com o histórico do navegador

window.onload = function(){
    document.querySelector('#go-back').onclick = redirecionarPagina;
};

redirecionarPagina = function() {
    event.preventDefault();
    
   if (document.referrer === "") { // impede a página de voltar para um site fora do hostname e faz o botão voltar ir para o index.
       document.getElementById('go-back').addEventListener('click', () => {
       window.location.replace("http://localhost:8080/app-civa/portador-civa/index.jsp");
       }) & document.querySelector('#go-back').click();
       }
   else {
        document.getElementById('go-back').addEventListener('click', () => {
        history.back();
        }) & document.querySelector('#go-back').click();
    };
};