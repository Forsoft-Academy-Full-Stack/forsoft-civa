// contador
let count = 0;

// cria um array para os botões a fim de facilitar o acesso aos mesmos
let btnsAddCampo = document.getElementsByClassName('add');
// cria um array para os botões a fim de facilitar o acesso aos mesmos
let btnsRmvCampo = document.getElementsByClassName('rmv');

    for (i=0;i<btnsAddCampo.length;i++){
        btnsAddCampo[i].onclick = adicionarCampo;
    }
    // faz um loop de verificação para garantir que todos os botões de remover estejam funcionais
    for (i=0;i<btnsRmvCampo.length;i++) {
        btnsRmvCampo[i].onclick = removerCampo;
    }

function adicionarCampo() {
    // cria um array para as divs com a classe "optional" a fim de facilitar o acesso das mesmas
    // isso faz com que o js pegue sempre a última div sendo exibida
    let novaLinha = document.getElementsByClassName('optional')

    // faz com que a próxima div se torne visível
    novaLinha[count].style.display = 'flex';

    // após as etapas anteriores, adiciona 1 ao valor do contador para garantir que a div seguinte seja selecionada na próxima execução
    count++;

    btnsControleDocs();
};

function removerCampo() {
    // cria um array para as divs com a classe "optional" a fim de facilitar o acesso das mesmas
    // isso faz com que o js pegue sempre a última div sendo exibida
    let rmvLinha = document.getElementsByClassName('optional')

    // faz com que a próxima div deixe de aparecer
    rmvLinha[count-1].style.display = 'none';

    // após as etapas anteriores, decrescenta 1 do valor do contador para garantir que a div anterior seja selecionada na próxima execução
    count--;

    btnsControleDocs();
};

function btnsControleDocs() {    
    // avalia o valor da variável contadora no momento da execução, ou seja, qual é a últtima linha sendo exibida
    switch (count) {
        // se o valor for 0 (apenas a primeira linha de documentação está visível):
        case 0:
            btnsAddCampo[0].style.display = 'inline';
            btnsRmvCampo[0].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões da primeira linha como inline (para que sejam exibidos)
        break;
        // se o valor for 1 (se a última linha de documentação visível for a 2):
        case 1:
            btnsAddCampo[0].style.display = 'none';
            btnsRmvCampo[0].style.display = 'none';
            btnsAddCampo[1].style.display = 'inline';
            btnsRmvCampo[1].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam), e garantimos que os
            // botões da nova linha estejam visíveis
        break;
        case 2:
            btnsAddCampo[1].style.display = 'none';
            btnsRmvCampo[1].style.display = 'none';
            btnsAddCampo[2].style.display = 'inline';
            btnsRmvCampo[2].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam), e garantimos que os
            // botões da nova linha estejam visíveis
        break;
        case 3:
            btnsAddCampo[2].style.display = 'none';
            btnsRmvCampo[2].style.display = 'none';
            btnsAddCampo[3].style.display = 'inline';
            btnsRmvCampo[3].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam), e garantimos que os
            // botões da nova linha estejam visíveis
        break;
        // se o valor for 2 (se a última linha de documentação visível for a 3):
        case 4:
            btnsAddCampo[3].style.display = 'none';
            btnsRmvCampo[3].style.display = 'none';
            btnsAddCampo[4].style.display = 'inline';
            btnsRmvCampo[4].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam)
        break;
        
        case 5:
            btnsAddCampo[4].style.display = 'none';
            btnsRmvCampo[4].style.display = 'none';
            btnsAddCampo[5].style.display = 'inline';
            btnsRmvCampo[5].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam)
        break;
        
        case 6:
            btnsAddCampo[5].style.display = 'none';
            btnsRmvCampo[5].style.display = 'none';
            btnsAddCampo[6].style.display = 'inline';
            btnsRmvCampo[6].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam)
        break;
        
        case 7:
            btnsAddCampo[6].style.display = 'none';
            btnsRmvCampo[6].style.display = 'none';
            btnsAddCampo[7].style.display = 'inline';
            btnsRmvCampo[7].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam)
        break;
        
        case 8:
            btnsAddCampo[7].style.display = 'none';
            btnsRmvCampo[7].style.display = 'none';
            btnsAddCampo[8].style.display = 'inline';
            btnsRmvCampo[8].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam)
        break;
        
        case 9:
            btnsAddCampo[8].style.display = 'none';
            btnsRmvCampo[8].style.display = 'none';
            btnsAddCampo[9].style.display = 'inline';
            btnsRmvCampo[9].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam)
        break;
        
        case 10:
            btnsAddCampo[9].style.display = 'none';
            btnsRmvCampo[9].style.display = 'none';
            btnsAddCampo[10].style.display = 'inline';
            btnsRmvCampo[10].style.display = 'inline';
            // em resumo, definimos o atributo css display dos dois botões anteriores como none (para que desapareçam)
        break;
        
       
    };
};