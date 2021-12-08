/*TELA: Cadastrar Supervisor*/

    START TRANSACTION
        INSERT INTO pessoa
        (nome, sobrenome, genero, datadenascimento, idpaisdenascimento, ddidocontato, 
        telefonecomddd)
        VALUES ('João', 'Canarinho', 'Homem Cis', '2000-03-16', 2, ('+ 55'),'(61) 999111111');

        INSERT INTO docs
        (idpessoa, idtipodoc, documento, datadeemissao)
        VALUES (5181,2, '93684900126', '2000-03-16');

        INSERT INTO endereco 
        (idpais, logradouro, codigopostal, idsubdivisao1, idsubdivisao2, idsubdivisao3)
        VALUES (1, 'Rua Alvaro Freitas', '67845333', 'Distrito Federal', 'Brasilia', 'Samambaia');

        INSERT INTO pessoa_endereco
        (idpessoa, idendereco, numero, complemento)
        VALUES (5181, 300, '15', 'torre 3');

        INSERT INTO acessogestao
        (idpessoa, idcadastrante, codigociva, cargo, email, dataregistro)
        VALUES (5181, 34, BRA000000003SU, 'Supervisor', 
        'canarinho123@gmail.com', '2021-12-12 10:00:00');

    COMMIT;
    ROLLBACK;

/**/

/*TELA: Consultar Supervisor*/

    SELECT peag.nome, doc.documento, doc.datadeemissao, apc.codigociva FROM pessoa peag
    LEFT JOIN docs doc on peag.idpessoa = doc.idpessoa
    LEFT JOIN acessopc apc on apc.idpessoa = peag.idpessoa

/**/

/*TELA: Consultar Unidade*/

    SELECT uni.nome, en.idsubdivisao1, en.idsubdivisao2, en.codigopostal
    FROM unidade uni
    LEFT JOIN endereco en on uni.idendereco = en.idendereco;

/*TELA: Gerenciar Supervisor*/

    SELECT peag.nome, peag.sobrenome, peag.genero, peag.datadenascimento, pa.nomedopais, tidoc.nomedoc,
    doc.documento, pa.nomedopais, en.codigopostal, en.logradouro, peen.numero, peen.complemento,
    en.idsubdivisao3, en.idsubdivisao2, en.idsubdivisao1, peag.telefonecomddd, ag.email
    FROM pessoa peag
    LEFT JOIN pais pa on peag.idpaisdenascimento = pa.nomedopais
    LEFT JOIN docs doc on doc.idpessoa = peag.idpessoa
    LEFT JOIN tipodoc tidoc on tidoc.idtipodoc = doc.idtipodoc
    LEFT JOIN pessoa_endereco peen on peen.idpessoa = peag.idpessoa
    LEFT JOIN endereco en on en.idendereco = peen.idendereco
    LEFT JOIN acessogestao ag on ag.idpessoa = peag.idpessoa
    WHERE ag.codigociva = 'BRA000000001SU'

    SELECT uni.nome, uni.locacao, en.codigopostal, uni.registrodaunidade
    FROM unidade uni
    LEFT JOIN acessogestao_unidade aguni on aguni.idunidade = uni.idunidade
    LEFT JOIN acessogestao ag on ag.idacessogestao = aguni.idacessogestao
    LEFT JOIN endereco en on en.idendereco = uni.idendereco 
    WHERE ag.codigociva = 'BRA000000001SU'

/**/

/*TELA: Gerenciar Unidade*/

    SELECT uni.nome, uni.registrodaunidade, uni.natureza, uni.tipodeestabelecimento, pa.nomedopais, 
    en.codigopostal, en.logradouro, uni.numeroendereco, en.idsubdivisao3, en.idsubdivisao2, en.idsubdivisao1,
    uni.contato, uni.locacao
    FROM unidade uni
    LEFT JOIN endereco en on en.idendereco = uni.idendereco
    LEFT JOIN pais pa on pa.idpais = en.idpais
    WHERE uni.idunidade = 1 ;
    /* Acredito que a chave nesse caso seja o idunidade, especificado no value do select da tela */

    SELECT peag.nome, doc.documento, ag.codigociva
    FROM acessogestao ag
    LEFT JOIN acessogestao_unidade aguni on aguni.idacessogestao = ag.idacessogestao
    LEFT JOIN unidade uni on uni.idunidade = aguni.idunidade
    LEFT JOIN pessoa peag on peag.idpessoa = ag.idpessoa
    LEFT JOIN docs doc on doc.idpessoa = peag.idpessoa
    LEFT JOIN tipodoc tidoc on doc.idtipodoc = tidoc.idtipodoc
    WHERE uni.idunidade = 1 and (tidoc.nomedoc = 'CPF' or tidoc.nomedoc = 'Social security');

    /* colocar INSERT se for necessário*/

/**/

/*TELA: Meus Dados*/

    SELECT ag.codigociva, peag.nome, peag.sobrenome, peag.genero, peag.datadenascimento, pa.nomedopais, 
    tidoc.nomedoc, doc.documento, pa.nomedopais, en.codigopostal, en.logradouro, peen.numero, peen.complemento,
    en.idsubdivisao3, en.idsubdivisao2, en.idsubdivisao1, peag.telefonecomddd, ag.email
    FROM acessogestao ag
    LEFT JOIN pessoa peag on peag.idpessoa = ag.idpessoa
    LEFT JOIN pais pa on pa.idpais = peag.idpaisdenascimento
    LEFT JOIN docs doc on doc.idpessoa = peag.idpessoa
    LEFT JOIN tipodoc tidoc on tidoc.idtipodoc = doc.idtipodoc
    LEFT JOIN pessoa_endereco peen on peen.idpessoa = peag.idpessoa
    LEFT JOIN endereco en on peen.idendereco = en.idendereco
    /*LEFT JOIN pais pais on pa.idpais = en.idpais*/
    WHERE ag.codigociva = 'BRA000000003GR'

/**/

/*TELA: Vincular Unidade*/

    SELECT uni.nome, uni.registrodaunidade, uni.natureza, uni.tipodeestabelecimento, pa.nomedopais, 
    en.codigopostal, en.logradouro, uni.numeroendereco, en.idsubdivisao3, en.idsubdivisao2, en.idsubdivisao1,
    uni.contato, uni.locacao
    FROM unidade uni
    LEFT JOIN endereco en on en.idendereco = uni.idendereco
    LEFT JOIN pais pa on pa.idpais = en.idpais
    WHERE uni.idunidade = 1 
    /* SELECIONA A UNIDADE NA BARRA DE PESQUISA E VINCULA COM O ID SELECIONADO */

    START TRANSACTION;
        INSERT INTO acessogestao_unidade
        (idacessogestao, idunidade)
        VALUES ((SELECT ag.idacessogestao FROM acessogestao ag WHERE ag.codigociva = 'BRA000000002SU'),
        (SELECT uni.idunidade FROM unidade uni WHERE uni.nome = 'Hospital da Lagoa'));
    COMMIT;
    ROLLBACK;

/**/