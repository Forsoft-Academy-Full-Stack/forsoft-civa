<%@page import="model.Unidade"%>
<%@page import="dao.UnidadeDao"%>
<%@page import="dao.PessoaDao"%>
<%@page import="model.Vacina"%>
<%@page import="java.util.List"%>
<%@page import="dao.VacinaDao"%>
<%@page import="dao.PortadorCivaDao"%>
<%@page import="model.PortadorCiva"%>
<%@page import="model.PortadorCiva"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("profissional-saude"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");
    }

    // Caso contrário é um usuário válido, pode entrar na página  
%>

<%    try {
        String codigoCivaPortadorCiva = request.getParameter("codigoCiva");

        PortadorCiva portadorCiva = PortadorCivaDao.findByCodigoCiva(codigoCivaPortadorCiva);
        String codigoCivaGestao = PessoaDao.getCodigoCivaAcessoGestao(pessoa.getIdPessoa());

        List<Vacina> vacinas = VacinaDao.listByProfissionalSaude(codigoCivaGestao);
        List<Unidade> unidades = UnidadeDao.listUnidadeByProfissionalSaude(codigoCivaGestao);

        pageContext.setAttribute("portadorCiva", portadorCiva);
        pageContext.setAttribute("vacinas", vacinas);
        pageContext.setAttribute("unidades", unidades);

    } catch (Exception e) {
        response.sendRedirect("./vacinacao.jsp");
    }
%>

<%@include file="header.jspf"%>
<script src="../public/assets/js/cadastrar-vacinacao.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@ include file="./navbar.jspf" %>

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>
        <!-- /.sidebar ------------------------------------------------------>
        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Cadastrar nova vacina&ccedil;&atilde;o</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel portador CIVA</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->
                    <!-- DADOS PORTADOR -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados portador</h3>
                                </div>

                                <div class="card-body">
                                   
                                        <div class="row">
                                            <div class="form-group col-xl-12">
                                                <label for="codigoCiva">C&oacute;digo CIVA</label>
                                                <input type="text" class="form-control" id="codigo-civa" name="codigo-civa" placeholder="Ex: Frank" value="${portadorCiva.pessoa.codigoCiva}"
                                                       disabled>
                                            </div>                                      
                                        </div>
                                 

                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="nome">Nome</label>
                                            <input type="text" class="form-control" id="nome" name="nome" placeholder="Ex: Frank" value="${portadorCiva.pessoa.nomePessoa}"
                                                   disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="sobrenome">Sobrenome</label>
                                            <input type="text" class="form-control" id="sobrenome" name="sobrenome" placeholder="Ex: Sinatra"
                                                   value="${portadorCiva.pessoa.sobrenomePessoa}" disabled>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="data-nasc">Data de Nascimento</label>
                                            <input type="date" class="form-control" id="data-nasc" name="data-nasc" value="${portadorCiva.pessoa.dataNascimento}"
                                                   disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="identidade">Documento</label>
                                            <input type="text" class="form-control" id="identidade" name="identidade" value="${portadorCiva.documento1.documento}" disabled>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- DADOS VACINAÃÃO -->
                    <form class="row" id="form-painel-portador" >
                          <input type="hidden" class="form-control" id="codigo-civa" name="codigo-civa" value="${portadorCiva.pessoa.codigoCiva}">
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados vacina&ccedil;&atilde;o</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <div class="card-body">
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="vacina">Vacina</label>

                                            <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                                                    aria-hidden="true" name="vacina" id="vacina" >
                                                <option selected disabled value="">Selecionar</option>    
                                                <c:forEach items="${vacinas}" var="vacina" varStatus="loop">
                                                    <option value="${vacina.idVacina}">${vacina.nomeVacina}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-xl-6">                                           
                                            <label for="laboratorio">Laborat&oacute;rio</label>
                                            <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                                                    aria-hidden="true" name="laboratorio" id="laboratorio">
                                                <option selected disabled value="">Selecionar</option>
                                                <c:forEach items="${vacinas}" var="vacina" varStatus="loop">
                                                    <option value="${vacina.laboratorio}">${vacina.laboratorio}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="numerodoses">N&uacute;mero da dose</label>
                                            <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                                                    aria-hidden="true" name="numerodoses" id="numerodoses">
                                                <option selected disabled value="">Selecionar</option>
                                                <option>1&ordf</option>
                                                <option>2&ordf</option>
                                                <option>3&ordf</option>
                                                <option>&Uacute;nica</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="lote">Lote</label>
                                            <input type="text" class="form-control" name="lote" id="lote" placeholder="Ex: 123123-21">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-12">
                                            <label for="unidade">Unidade da vacina&ccedil;&atilde;o</label>
                                            <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                                                    aria-hidden="true" id="unidade" name="unidade">
                                                <option selected disabled value="">Selecionar</option>
                                                <c:forEach items="${unidades}" var="unidade" varStatus="loop">
                                                    <option value="${unidade.idUnidade}">${unidade.nome}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.row -->
                    </form>
                    <div class="row">
                        <div class="col-12 mb-4">
                            <button type="button" class="btn btn-primary btn-lg" id="cadastro">Cadastrar</button>
                        </div>
                    </div>
                    <!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        <!-- Main Footer -->
        <%@ include file="footer.jspf" %>
        <!-- ./footer -->
    </div>
    <!-- ./wrapper -->
</body>
</html>