/*TELA: profissional_saude_cadastrar-portador*/
    START TRANSACTION;

        /*Inserção na Tabela Pessoa*/
        INSERT INTO pessoa
        ( idpaisdenascimento, nome, sobrenome, genero, datadenascimento, ddidocontato, telefonecomddd)
        VALUES 
            (1,'Ludwig', 'Gonzaga','Homem Cis', '1982/02/06', '55', '21999999999');

        /*Inserção na Tabela Documento Civíl*/
        INSERT INTO docs 
        ( idpessoa, idtipodoc, documento, datadeemissao)
        VALUES 
            (1,1,'254.687.779-02', '2019/05/21');    

        /*Inserção na Tabela Endereco*/
        INSERT INTO endereco  
        (idpais, tipodelogradouro, logradouro, codigopostal, idsubdivisao1, idsubdivisao2, idsubdivisao3)
        VALUES 
            (1,'Rua','Martins Torres','24240-705','Rio de Janeiro','Niterói','Santa Rosa');


        /*Inserção na Tabela Pessoa_Endereço*/
        INSERT INTO pessoa_endereco 
        (idpessoaendereco,idpessoa,idendereco,numero,complemento)
        VALUES
            (1,2,'606-D','Apart.201 Bloco 9');
            
            /*Inserção na Tabela Acesso Gestão*/
            INSERT INTO acessopc ag
            ( idpessoa, idcadastrante, codigociva, cargo, email, senha, dataregistro)
            VALUES 
                (1,2,'BRA55123456789PC', 'Profissional da saude', 'mail@mail.com', '123deoliveira4','2021-10-15 - 11:05' );

    COMMIT;
    ROLLBACK;
/**/

/*TELA: profissional_saude_meus-dados*/ /*dúvida como colocar numa Query só as diversas documentações da pessoa*/
    /*DADOS PROFISSIONAL DE SAÚDE*/
    SELECT ag.codigociva,peag.nome , peag.sobrenome, peag.genero, peag.datadenascimento,pa.nomedopais, tidoc.nomedoc,doc.documento ,tidoc2.nomedoc, pa.nomedopais, en.codigopostal, en.logradouro,peen.numero, peen.complemento, en.idsubdivisao3,en.idsubdivisao2,peag.telefonecomddd,ag.email     from acessogestao ag
    left join pessoa peag 
    on ag.idpessoa = peag.idpessoa 
    left join docs doc 
    on peag.idpessoa = doc.idpessoa 
    LEFT JOIN pessoa_endereco peen 
    on peag.idpessoa = peen.idpessoa
    left join endereco en 
    on peen.idendereco = en.idendereco 
    LEFT join pais pa 
    on pa.idpais = en.idpais 
    LEFT JOIN tipodoc tidoc 
    on doc.idtipodoc = tidoc.idtipodoc 
    LEFT JOIN tipodoc tidoc2 
    on doc.idtipodoc = tidoc2.idtipodoc
    WHERE ag.codigociva LIKE 'BRA%0003PS';

    /*UNIDADES VINCULADAS*/
        SELECT uni.nome, en.idsubdivisao1,en.codigopostal, uni.registrodaunidade FROM unidade uni
        left join acessogestao_unidade aguni 
        on uni.idunidade = aguni.idunidade 
        left join endereco en 
        on uni.idendereco = en.idendereco 
        LEFT JOIN acessogestao ag
        on ag.idacessogestao = aguni.idacessogestao  
        LEFT JOIN pessoa peag 
        on ag.idpessoa = peag.idpessoa 
        Where ag.codigociva = 'BRA000000003PS';
/**/

/*TELA: profissional_saude_vacinacao-internacional*/
    /*DADOS PORTADOR CIVA*/
        SELECT 
        	apc.codigociva, pepc.nome,pepc.sobrenome,pepc.genero,pepc.datadenascimento,pa.nomedopais, 
        	tidoc.nomedoc, doc.documento   from acessopc apc
        left join pessoa pepc 
        on apc.idpessoa = pepc.idpessoa 
        LEFT JOIN docs doc
        on doc.idpessoa = pepc.idpessoa 
        LEFT join pais pa 
        on pepc.idpaisdenascimento = pa.idpais 
        LEFT join tipodoc tidoc 
        on doc.idtipodoc = tidoc.idtipodoc 
        WHERE apc.codigociva LIKE 'BRA000000025PC'; 



    /*HISTORICO DE VACINAS*/
        SELECT vac.nomevacina , vac.laboratorio , vacao.doseaplicada , pa.nomedopais, vacao.datadeaplicacao from vacinacao vacao
        left join acessopc apc 
        on vacao.idacessopc = apc.idacessopc
        left JOIN pessoa pepc
        on pepc.idpessoa = apc.idpessoa 
        LEFT join vacina vac
        on vacao.idvacina = vac.idvacina 
        left join unidade uni 
        on vacao.idunidade = uni.idunidade 
        LEFT JOIN endereco en 
        on uni.idendereco = en.idendereco 
        LEFT join pais pa 
        on en.idpais = pa.idpais
        WHERE apc.codigociva = 'BRA000000025PC';
/**/

/*TELA: profissional_saude_vacinacao-internacional*/
    /*DADOS DO PORTADOR*/
        SELECT pepc.nome, pepc.sobrenome, pepc.datadenascimento ,doc.documento FROM pessoa pepc
        left join docs doc
        on pepc.idpessoa = doc.idpessoa
        LEFT JOIN acessopc apc
        ON pepc.idpessoa = apc.idpessoa
        WHERE apc.codigociva = 'BRA000000025PC' ;

    /*INSERIR DADOS DE VACINAÇÃO*/
        INSERT into vacinacao vacao 
        (vacao.idacessopc, vacao.idunidade, vacao.idacessogestao, vacao.idvacina, vacao.lote, vacao.doseaplicada,vacao.datadeaplicacao)
        values
        (1,1,'33559F','1ª','2021-06-30');
/**/