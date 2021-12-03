<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="dao.VacinacaoDao"%>
<%@page import="model.Vacinacao"%>
<%@page import="java.util.List"%>
<%@page import="dao.PortadorCivaDao"%>
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

<%  
   try {
        String codigoCivaPortadorCiva = request.getParameter("codigoCiva");
    
        PortadorCiva portadorciva = PortadorCivaDao.findByCodigoCiva(codigoCivaPortadorCiva);
  
        pageContext.setAttribute("ator", portadorciva);
        pageContext.setAttribute("vacinacoes", portadorciva.getListaVacinacao());
        pageContext.setAttribute("vacinacoes", VacinacaoDao.listByPortadorCivaInternacional(codigoCivaPortadorCiva));
           
    } catch (Exception e) {          
    }
   
    
%>


<%@include file="header.jspf"%>
<script src="../public/assets/js/profissional-saude/vacinacao-internacional.js" defer></script>
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
                            <h1 class="m-0">Vacina&ccedil;&atilde;o</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Vacina&ccedil;&atilde;o</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->
            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->
                    <div class="row">
                        <div class="col-12 mb-4">
                            <form action="" id="vacinacao-internacional" method="get">
                                <div class="input-group">
                                    <input type="search" id="codigoCiva" name="codigoCiva" value="${ator.codigoCiva}" class="form-control form-control-lg"
                                           placeholder="Insira o codigo civa do portador">
                                    <div class="input-group-append">
                                        <button type="submit" class="btn btn-lg btn-primary">
                                            Pesquisar
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- DADOS PORTADOR -->
                    <div class="row mb-3">
                        <div class="col-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Portador CIVA</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form>
                                    <div class="card-body">
                                        <%@ include file="../partials/codigociva.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/dadospessoais-ps-disabled.jspf" %>
                                        <hr>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- TABELA VACINAS -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Hist&oacute;rico de Vacinação</h3>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>Vacina</th>
                                                <th>Laborat&oacute;rio</th>
                                                <th>Dose</th>
                                                <th>Pa&iacute;s</th>
                                                <th>Data da Aplicação</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${vacinacoes}" var="vacinacao">
                                                <tr>
                                                    <td><c:out value="${vacinacao.vacina.nomeVacina}" /></td>
                                                    <td><c:out value="${vacinacao.vacina.laboratorio}" /></td>
                                                    <td><c:out value="${vacinacao.doseAplicada}" /></td>
                                                    <td><c:out value="${vacinacao.pais}" /></td>
                                                    <td><c:out value="${vacinacao.dataAplicacao}" /></td>                                                    
                                                </tr>
                                            </c:forEach>   
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                    </div>
                    <div class="col-12 row">
                        <div class="mb-3 mt-3">
                            <a href="./cadastrar-vacinacao.jsp?codigoCiva=<c:out value="${ator.codigoCiva}" />">
                                <button type="button" id="cadastro" class="btn btn-primary btn-lg">Cadastrar vacina&ccedil;&atilde;o</button>
                            </a>
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