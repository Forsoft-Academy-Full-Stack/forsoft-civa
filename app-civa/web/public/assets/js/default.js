$('.select2').select2();
// // Variaveis que ser&atilde;o usadas pelo swal alert nas outras p&aacute;ginas
// Ao importar aqui n&atilde;o &eacute; necess&aacute;rio copiar para os demais aquivos.
let icon;
let title;
let text;
let confirmButtonText;
let confirmButtonCollor;
let statusInfo;
let textInfo;
let callback = () => { };


tratar_campos = (campos) => {
    let erro = false;
  
    for (i = 0; i < campos.length; i++) {
        if (document.getElementById(campos[i]).value === '') {
            erro = true;
         
        }
    }
    return !erro;

}

function swalAlert(icon, title, text, confirmButtonText, confirmButtonCollor, callback){
    Swal.fire({
        icon: icon,
        title: title,
        text: text,
        confirmButtonText: confirmButtonText,
        confirmButtonColor: confirmButtonCollor,
        html: text
    }).then(callback);
}

function swalAlertSuccess(title, text, callback){
    Swal.fire({
        icon: 'success',
        title: title,
        text: text,
        confirmButtonText: 'Finalizar',
        confirmButtonColor: '#007bff',
        html: text
    }).then(callback);
}

function swalAlertInfo(title, text, callback){
    Swal.fire({
        icon: 'info',
        title: title,
        text: text,
        confirmButtonText: 'Finalizar',
        confirmButtonColor: '#007bff',
        html: text
    }).then(callback);
}

function swalAlertError(title, text, callback){
    Swal.fire({
        icon: 'error',
        title: title,
        text: text,
        confirmButtonText: 'Finalizar',
        confirmButtonColor: '#007bff',
        html: text
    }).then(callback);
}

function swalAlertDelete(title, text, statusInfo, textInfo){
    Swal.fire({
        title: title,
        text: text,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#007bff',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Deletar',
        html: text
      }).then((result) => {
        if (result.isConfirmed) {
          Swal.fire(
            statusInfo,
            textInfo,
            'success'
          )
        }
      })
}


const Toast = Swal.mixin({
    toast: true,
    position: 'top-start',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
})


setAbaAtiva();


function setAbaAtiva() {
    let pageURL = window.location.href;
    let abas = document.getElementsByClassName('nav-link');
      
   
    for (i=0;i<abas.length;i++) {
      
        // Confere se a url da página possui o texto presente na linkagem do elemento
        if (pageURL.includes(abas[i].href)) {
            // adiciona a classe "active", alterando a cor de fundo do elemento
            abas[i].classList.add('active');
            
            // adiciona a classe "menu-open" no elemento pai de toda a estrutura daquele ator (a cada .parentElement, suba uma hierarquia), fazendo as outras opções serem exibidas
            ((abas[i].parentElement).parentElement).parentElement.classList.add('menu-open');
        }
    }
}