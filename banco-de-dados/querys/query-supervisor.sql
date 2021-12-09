/*TELA: Cadadstrar Profissional*/

    START TRANSACTION; 
        INSERT INTO pessoa  
        (nome, sobrenome, genero, datadenascimento , idpaisdenascimento, ddidocontato,  telefonecomddd) 
        VALUES 
        ('Felipe','Gomes', 'Homem Cis', '1991-02-22', 1, '55', '(21) 96587-4225'); 
     
        INSERT INTO docs  
        (idpessoa, idtipodoc, documento) 
        VALUES 
        (5182, 2, '123.123- RJ'); 

        INSERT INTO endereco  
        (idpais, tipodelogradouro, logradouro, codigopostal, idsubdivisao1,  idsubdivisao2, idsubdivisao3) 
        VALUES 
        (1, 'Rua', 'Aldrin',  '22753-270', 'Rio de Janeiro', 'Jacarepagua', 'Anil'); 

        INSERT INTO pessoa_endereco  
        (idpessoa, idendereco, numero, complemento) 
        VALUES 
        (5182, 351, '295',  'Casa'); 

        INSERT INTO acessogestao  
        (idpessoa, idcadastrante , cargo, email) 
        VALUES 
        (5182, 34,  'Profissional de Saúde', 'felipe@hotmail.com'); 

    COMMIT; 
    ROLLBACK;

/**/

/*TELA: Consultar Profissional*/

    SELECT DISTINCT peag.nome, doc.documento, peag.datadenascimento, ag.codigociva  from pessoa peag 
    LEFT JOIN docs doc 
    ON peag.idpessoa = doc.idpessoa  
    LEFT JOIN acessogestao ag  
    ON peag.idpessoa = ag.idpessoa;

/**/

/*TELA: Consultar Unidade*/

    SELECT uni.nome, en.idsubdivisao1, en.idsubdivisao2, en.codigopostal  FROM unidade uni 
    LEFT JOIN endereco en  
    ON uni.idendereco = en.idendereco;

/**/

/*TELA: Painel Profissional*/

    SELECT DISTINCT ag.codigociva, peag.nome, peag.sobrenome, peag.genero,  peag.datadenascimento, pa.nomedopais, tidoc.nomedoc, doc.documento, pa.nomedopais, en.codigopostal, en.tipodelogradouro, peen.numero,  peen.complemento, en.idsubdivisao1, en.idsubdivisao2, en.idsubdivisao3, peag.telefonecomddd, ag.email FROM pessoa peag 
    LEFT JOIN acessogestao ag on peag.idpessoa = ag.idpessoa  
    LEFT JOIN pais pa on peag.idpaisdenascimento = pa.idpais  
    LEFT JOIN docs doc on peag.idpessoa = doc.idpessoa  
    LEFT JOIN tipodoc tidoc on doc.idtipodoc = tidoc.idtipodoc  LEFT JOIN pessoa_endereco peen on peag.idpessoa = peen.idpessoa  LEFT JOIN endereco en on peen.idendereco = en.idendereco 
    WHERE ag.cargo = 'Profissional de Saúde' and ag.codigociva = 'BRA000000010PS' 

    SELECT uni.nome, en.idsubdivisao1, en.codigopostal, uni.registrodaunidade FROM unidade uni 
    LEFT JOIN endereco en ON uni.idendereco = en.idendereco 
    LEFT JOIN acessogestao_unidade aguni ON uni.idunidade = aguni.idunidade  LEFT JOIN acessogestao ag ON aguni.idacessogestao = ag.idacessogestao  LEFT JOIN pessoa peag ON peag.idpessoa = ag.idpessoa  
    LEFT JOIN docs doc ON peag.idpessoa = doc.idpessoa  
    LEFT JOIN tipodoc tidoc ON doc.idtipodoc = tidoc.idtipodoc  
    WHERE ag.cargo = 'Profissional de Saúde' and tidoc.nivel = 'Profissional de Saúde' and ag.codigociva = 'BRA000000010PS'

/**/

/*TELA: Painel Unidade*/

    SELECT uni.nome, uni.registrodaunidade, uni.natureza, uni.tipodeestabelecimento,  pa.nomedopais, en.codigopostal, en.tipodelogradouro, 
    en.logradouro, uni.numeroendereco, uni.situacao, en.idsubdivisao1,  en.idsubdivisao2, en.idsubdivisao3, uni.contato, uni.locacao 
    FROM unidade uni 
    LEFT JOIN endereco en ON uni.idendereco = en.idendereco  
    LEFT JOIN pais pa ON en.idpais = pa.idpais  
    WHERE uni.nome = 'Hospital da Lagoa' ;

    SELECT peag.nome, doc.documento, ag.codigociva FROM pessoa peag LEFT JOIN acessogestao ag ON peag.idpessoa = ag.idpessoa  
    LEFT JOIN docs doc ON peag.idpessoa = doc.idpessoa  
    LEFT JOIN acessogestao_unidade aguni ON ag.idacessogestao = aguni.idacessogestao  LEFT JOIN unidade uni ON aguni.idunidade = uni.idunidade  
    LEFT JOIN tipodoc tidoc ON doc.idtipodoc = tidoc.idtipodoc  
    WHERE uni.nome = 'Hospital da Lagoa' AND tidoc.nivel = 'Profissional de Saúde';

/**/

/*TELA: Cadastrar Profissional*/

    SELECT uni.nome, uni.registrodaunidade, uni.natureza, uni.tipodeestabelecimento, pa.nomedopais, 
    en.codigopostal, en.logradouro, uni.numeroendereco, en.idsubdivisao3, en.idsubdivisao2, en.idsubdivisao1,
    uni.contato, uni.locacao
    FROM unidade uni
    LEFT JOIN endereco en on en.idendereco = uni.idendereco
    LEFT JOIN pais pa on pa.idpais = en.idpais
    WHERE uni.idunidade = 1 

    /* SELECIONA A UNIDADE NA BARRA DE PESQUISA E VINCULA COM O ID SELECIONADO*/
    START TRANSACTION;
        INSERT INTO acessogestao_unidade
        (idacessogestao, idunidade)
        VALUES ((SELECT ag.idacessogestao FROM acessogestao ag WHERE ag.codigociva = 'BRA000000010PS'),
        (SELECT uni.idunidade FROM unidade uni WHERE uni.nome = 'Hospital da Lagoa'));
    COMMIT;
    ROLLBACK;

/**/

/*TELA: Meus Dados*/

    SELECT DISTINCT ag.codigociva, peag.nome, peag.sobrenome, peag.genero,  peag.datadenascimento,
    pa.nomedopais, tidoc.nomedoc, doc.documento, pa.nomedopais, en.codigopostal, en.tipodelogradouro,
    peen.numero,  peen.complemento, en.idsubdivisao1, en.idsubdivisao2, en.idsubdivisao3,
    peag.telefonecomddd, ag.email FROM pessoa peag 
    LEFT JOIN acessogestao ag on peag.idpessoa = ag.idpessoa  
    LEFT JOIN pais pa on peag.idpaisdenascimento = pa.idpais  
    LEFT JOIN docs doc on peag.idpessoa = doc.idpessoa  
    LEFT JOIN tipodoc tidoc on doc.idtipodoc = tidoc.idtipodoc  LEFT JOIN pessoa_endereco peen on peag.idpessoa = peen.idpessoa  LEFT JOIN endereco en on peen.idendereco = en.idendereco 
    WHERE ag.codigociva = 'BRA000000009SU' ;
    SELECT uni.nome, en.idsubdivisao1, en.codigopostal, uni.registrodaunidade FROM unidade uni 
    LEFT JOIN endereco en ON uni.idendereco = en.idendereco 
    LEFT JOIN acessogestao_unidade aguni ON uni.idunidade = aguni.idunidade  LEFT JOIN acessogestao ag ON aguni.idacessogestao = ag.idacessogestao  WHERE ag.codigociva = 'BRA000000009SU' ;

/**/