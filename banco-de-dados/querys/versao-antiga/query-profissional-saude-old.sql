/*TELA: profissional_saude_cadastrar-portador.txt*/
    START TRANSACTION;

        /*Inserção na Tabela Pessoa*/
        INSERT INTO pessoa
        ( idpaisdenascimento, nome, sobrenome, genero, datadenascimento, ddidocontato, telefonecomddd)
        VALUES 
            ((SELECT pa.idpais FROM pais pa
            WHERE pa.nomepais='Brasil'),'Ludwig', 'Gonzaga','Homem Cis', '1982/02/06', '55', '21999999999');

        /*Inserção na Tabela Documento Civíl*/
        INSERT INTO docs 
        ( idpessoa, idtipodoc, documento, datadeemissao)
        VALUES 
            ((SELECT pepc.idpessoa from pessoa pepc 
            LEFT JOIN pais pa
            ON pepc.idnacionalidade = pa.idpais
                WHERE pa.nomedopais = 'Brasil' 
                AND pepc.nome ='Ludwig' 
                AND pepc.sobrenome='Gonzaga' 
                AND pepc.datadenascimento='1982/02/06' 
                AND pepc.ddidocontato='55' 
                AND pepc.telefonecomddd ='21999999999'),
            (SELECT tidoc.idtipodoc FROM tipodoc tidoc
            LEFT JOIN pais pa
            ON tidoc.idpais=pa.idpais
                WHERE pa.nomedopais = 'Brasil'
                AND tidoc.nivel='Primário' ),
            '254.687.779-02', '2019/05/21');    

        /*Inserção na Tabela Endereco*/
        INSERT INTO endereco  
        (idpais, tipodelogradouro, logradouro, codigopostal, idsubdivisao1, idsubdivisao2, idsubdivisao3)
        VALUES 
            ((SELECT pa.idpais FROM forsoft.pais pa
                WHERE pa.nomedopais = 'Brasil'),
            'Rua','Martins Torres','24240-705','Rio de Janeiro','Niterói','Santa Rosa');


        /*Inserção na Tabela Pessoa_Endereço*/
        INSERT INTO pessoa_endereco 
        (idpessoaendereco,idpessoa,idendereco,numero,complemento)
        VALUES
            ((select pepc.idpessoa from pessoa pepc
            LEFT JOIN   docs do
            ON pepc.idpessoa = do.idpessoa    
                WHERE do.nivel = 'Primário' 
                AND do.documento ='254.687.779-02'),
            (select en.idendereco from endereco en
                WHERE en.tipodelogradouro = 'Rua' 
                AND en.logradouro = 'Martins Torres' 
                AND en.codigopostal = '24240-705' 
                AND en.idsubdivisao1 = 'Rio de Janeiro' 
                AND en.idsubdivisao2 = 'Niterói' 
                AND en.idsubdivisao3 = 'Santa Rosa'),
            '606-D','Apart.201 Bloco 9');
            
            /*Inserção na Tabela Acesso Gestão*/
            INSERT INTO acessopc ag
            ( idpessoa, idcadastrante, codigociva, cargo, email, senha, dataregistro)
            VALUES 
                ((SELECT pepc.idpessoa FROM pessoa pepc
                LEFT JOIN pais pa
                ON pepc.idnacionalidade = pa.idnacionalidade
                    WHERE pa.nomedopais = 'Brasil' 
                    AND pepc.nome ='Ludwig' 
                    AND pepc.sobrenome='Gonzaga' 
                    AND pepc.genero = 'Homem Cis' 
                    AND pepc.datadenascimento='1982/02/06' 
                    AND pepc.ddidocontato='55' 
                    AND pepc.telefonecomddd ='21999999999'),
                (SELECT ag.idacessogestao FROM acessogestao ag
                    WHERE ag.codigociva = 'BRA000000001PS'),
                'BRA55123456789PC', 'Profissional da saude', 'mail@mail.com', '123deoliveira4','2021-10-15 - 11:05' );

    COMMIT;
    ROLLBACK
/**/

