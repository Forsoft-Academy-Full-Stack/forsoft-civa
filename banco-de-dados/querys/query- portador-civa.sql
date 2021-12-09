/*TELA: histórico de vacinação*/

    SELECT pepc.idpessoa,vac.nomevacina ,vac.laboratorio ,vacao.datadeaplicacao, vacao.lote, uni.nome , pa.nomedopais
    FROM pessoa pepc
    LEFT JOIN acessopc apc
    ON pepc.idpessoa = apc.idpessoa
    LEFT JOIN vacinacao vacao
    ON apc.idacessopc = vacao.idacessopc
    LEFT JOIN vacina vac
    ON vacao.idvacina = vac.idvacina
    LEFT JOIN unidade uni
    ON vacao.idunidade = uni.idunidade
    LEFT JOIN endereco en
    ON uni.idendereco = en.idendereco
    LEFT JOIN pais pa
    ON en.idpais = pa.idpais 
    WHERE apc.codigociva = 'USA000000001PC'

/**/

/*TELA: meus dados*/

    SELECT  apc.codigociva, pepc.nome, pepc.sobrenome,  pepc.genero, doc.documento, 
    pepc.datadenascimento, pa.nomedopais, en.codigopostal, en.idsubdivisao1, 
    en.idsubdivisao2, en.tipodelogradouro, en.logradouro, peen.numero, peen.complemento, 
    pepc.ddidocontato, pepc.telefonecomddd, apc.email
    FROM pessoa pepc
    LEFT JOIN acessopc apc
    ON pepc.idpessoa = apc.idpessoa
    LEFT JOIN docs doc
    ON pepc.idpessoa = doc.idpessoa
    LEFT JOIN pais pa
    ON pepc.idpaisdenascimento = pa.idpais
    LEFT JOIN pessoa_endereco peen
    ON pepc.idpessoa = peen.idpessoa
    LEFT JOIN endereco en
    ON peen.idendereco = en.idendereco
    WHERE apc.codigociva = 'USA000000001PC';

/**/

/*TELA: procurar certificado*/

    SELECT pepc.nome, pepc.sobrenome,  apc.codigociva, do.documento, pepc.datadenascimento, 
    pa.nomedopais, vacao.doseaplicada, vac.nomevacina, vacao.datadeaplicacao, uni.nome, en.codigopostal, peg.nome, peg.sobrenome 
    FROM pessoa pepc
    LEFT JOIN pais pa
    ON pepc.idpaisdenascimento = pa.idpais 
    LEFT JOIN acessopc apc
    ON pepc.idpessoa = apc.idpessoa
    LEFT JOIN docs do
    ON pepc.idpessoa = do.idpessoa
    LEFT JOIN vacinacao vacao
    ON apc.idacessopc = vacao.idacessopc
    LEFT JOIN vacina vac
    ON vacao.idvacina = vac.idvacina
    LEFT JOIN unidade uni 
    ON vacao.idunidade = uni.idunidade 
    LEFT JOIN endereco en 
    ON uni.idendereco = en.idendereco 
    LEFT JOIN acessogestao ag 
    ON vacao.idacessogestao = ag.idacessogestao
    LEFT JOIN pessoa peg 
    ON peg.idpessoa = ag.idpessoa 
    WHERE apc.codigociva = 'USA000000001PC';
    
/**/

/*TELA: redefinir senha*/
    
    SELECT apc.email,apc.senha, apc.idpessoa from acessopc apc WHERE apc.email = 'maryrock@mail.com.br';
    START TRANSACTION;
        UPDATE acessopc SET senha = 'novaSenha'
        WHERE email = 'maryrock@mail.com.br'
    COMMIT;
    ROLLBACK;

/**/