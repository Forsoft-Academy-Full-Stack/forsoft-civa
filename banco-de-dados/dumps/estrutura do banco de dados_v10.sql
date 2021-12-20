/* Tabelas referentes Ordenadas em ordem Alfabética*/
   
   /* Tabela acessopc */
    CREATE TABLE forsoft.acessopc(
        idacessopc	int auto_increment NOT NULL,
        idpessoa	int,
        idcadastrante int,
        codigocivapc	varchar(20),
        emailpc	varchar(100),
        senhapc	varchar(20),
        dataregistropc varchar(30),
        statuspc tinyint (1),

        CONSTRAINT acessopc_PK PRIMARY KEY (idacessopc)
    );

    /* Tabela acesso gestao */
    CREATE TABLE forsoft.acessogestao(
        idacessogestao	int auto_increment NOT NULL,
        idpessoa	int,
        idcadastrante int,
        codigocivagestao	varchar(20),
        cargo	varchar(50),
        emailgestao	varchar(100),
        senhagestao	varchar(20),
        dataregistrogestao varchar(30),
        statusgestao tinyint (1),

        CONSTRAINT acessogestao_unidade_PK PRIMARY KEY (idacessogestao)
    );

    /* Tabela acesso gestao x unidade */
    CREATE TABLE forsoft.acessogestao_unidade(
        idgestaounidade	int auto_increment NOT NULL,
        idacessogestao	int,
        idunidade	int,
        status tinyint (1),

        CONSTRAINT acessogestao_unidade_PK PRIMARY KEY (idgestaounidade)
    );

    /* Tabel Código Certificado*/
    CREATE TABLE forsoft.codigocertificado(
        idcodigocertificado int auto_increment NOT NULL,
        idacessopc int,
        codigocertificado varchar(8),
        statuscodigocertificado tinyint(1),

        CONSTRAINT idcodigocertificado_unidade_PK PRIMARY KEY (idcodigocertificado)
    );

    /* Tabela Continente */
    CREATE TABLE forsoft.continente (
        idcontinente INT auto_increment NOT NULL,
        nomecontinente varchar(75) NULL,

        CONSTRAINT continente_PK PRIMARY KEY (idcontinente)
    );
    
    /* Tabela divisão territorial */
    CREATE TABLE forsoft.divisaoterritorial(
        idlocalidade int auto_increment NOT NULL,	
        idpais	int	,
        tiposubdivisao1	varchar(75),
        tiposubdivisao2	varchar(75),
        tiposubdivisao3	varchar(75),
        tiposubdivisao4	varchar(75),
        tiposubdivisao5	varchar(75),
        tiposubdivisao6	varchar(75),
        tiposubdivisao7	varchar(75),

        CONSTRAINT localidade_PK PRIMARY KEY (idlocalidade)
    );

    /* Tabela documentos */
    CREATE TABLE forsoft.docs(
        iddocs	int auto_increment NOT NULL,
        idpessoa	int,
        idtipodoc	int,
        documento	varchar(20),

        CONSTRAINT docs_PK PRIMARY KEY (iddocs)
    );

    /* Tabela Endereço */
    CREATE TABLE forsoft.endereco(
        idendereco	int auto_increment NOT NULL,
        idpais	int,
        tipodelogradouro varchar(12),
        logradouro	varchar(100),
        codigopostal	varchar(50),
        nomesubdivisao1 varchar(100), 
        nomesubdivisao2 varchar(100),
        nomesubdivisao3 varchar(100),
        nomesubdivisao4 varchar(100),
        nomesubdivisao5 varchar(100),
        nomesubdivisao6 varchar(100),
        nomesubdivisao7 varchar(100),
            
        CONSTRAINT endereco_Pk PRIMARY KEY (idendereco)
    );

    /* Tabela País */
    CREATE TABLE forsoft.pais (
        idpais int auto_increment NOT NULL,
        idcontinente int,
        idcadastrante int,
        nomedopais varchar (50),
        orgaoresponsavel varchar	(50),
        padraodecontato	varchar	(20),
        ddi	varchar	(50),
        sigla varchar	(3),
        statuspais tinyint(1),

        CONSTRAINT pais_PK PRIMARY KEY (idpais)
    );

    /* Tabela Pessoa */
    CREATE TABLE forsoft.pessoa(
        idpessoa	int auto_increment NOT NULL,
        idpaisdenascimento	int,
        nomepessoa	varchar(50),
        sobrenomepessoa	varchar(100),
        genero varchar(30),
        datadenascimento	varchar(16),
        ddidocontato	varchar(4),
        telefonecomddd	varchar(16),
        
        CONSTRAINT pessoa_PK PRIMARY KEY (idpessoa)
    );

    /* Tabela pessoa_endereco */
    CREATE TABLE forsoft.pessoa_endereco(
        idpessoaendereco	int auto_increment NOT NULL,
        idpessoa	int,
        idendereco	int,
        numero varchar(5),
        complemento varchar(50),

        CONSTRAINT pessoa_endereco_PK PRIMARY KEY (idpessoaendereco)
    );

    /* Tabela Solicitação alteração*/
    CREATE TABLE forsoft.solicitacaoalteracao(
        idsolicitacaoalteracao int auto_increment NOT NULL,
        idsolicitante int,
        descricao varchar(300),
        statussolicitacaoalteracao tinyint(1),

        CONSTRAINT solicitacaoalteracao_PK PRIMARY KEY (idsolicitacaoalteracao)
    );

    /*Tabela Reset de senha*/
    CREATE TABLE forsoft.resetsenha(
        idresetsenha int auto_increment NOT NULL,
        idacessopc int,
        idacessogestao int,
        codigo varchar(8),
        ativo varchar (10),

        CONSTRAINT resetsenha_PK PRIMARY KEY (idresetsenha)
    );

    /* Tabela tipo do documento */
    CREATE TABLE forsoft.tipodoc(
        idtipodoc	int auto_increment NOT NULL,
        idpais	int,
        nomedoc	varchar	(100),
        formatodoc	varchar	(30),
        nivel	varchar(30),

        CONSTRAINT tipodoc_PK PRIMARY KEY (idtipodoc)    
    ); 

    /* Tabela unidade */
    CREATE TABLE forsoft.unidade(
        idunidade	int auto_increment NOT NULL,	
        idendereco	int,
        numeroendereco varchar(5),
        nomeunidade		varchar(250),        
        contato		varchar(30),
        locacao		varchar(20),	
        natureza		varchar(20),	
        tipodeestabelecimento		varchar(20),	   	
        situacao		varchar(10),	
        datadecadastro		varchar(16),
        registrodaunidade		varchar(30),
        statusunidade tinyint (1),

        CONSTRAINT unidade_PK PRIMARY KEY (idunidade)
    );

    /* Tabela Vacina */
    CREATE TABLE forsoft.vacina (
        idvacina int auto_increment NOT NULL,
        laboratorio	varchar	(50),
        numerodedoses	varchar(16),
        nomevacina	varchar	(20),
        tipodevacina	varchar	(20),
        tempoentredoses	int,
        tempoparareforco int,

        CONSTRAINT vacina_PK PRIMARY KEY (idvacina)
    );

    /* Tabela vacina_pais */
    CREATE TABLE forsoft.vacina_do_pais(
        idvacinadopais	int auto_increment NOT NULL,
        idpais	int,
        idvacina	int,
        statusvacinapais tinyint (1),
        
        CONSTRAINT vacina_do_pais_PK PRIMARY KEY (idvacinadopais)
    );

    /* Tabela vacinação */
    CREATE TABLE forsoft.vacinacao(
        idvacinacao	int	auto_increment NOT NULL,
        idacessopc	int,
        idunidade int,
        idacessogestao	int,
        idvacina	int,
        lote		varchar(20),
        doseaplicada    varchar(12),
        datadeaplicacao varchar(19),
        
        
        CONSTRAINT vacinacao_PK PRIMARY KEY (idvacinacao)
    );

        /* Tabela Subdivisão */
    /*CREATE TABLE forsoft.subdivisao(
        idsubdivisao int auto_increment NOT NULL,
        idlocalidade int,
        nomesubdivisao varchar(50),
        valor varchar(50),

        CONSTRAINT subdivisao_PR PRIMARY KEY (idsubdivisao)
    );*/