<%@page import="dao.VacinaDao"%>
<%@page import="dao.VacinacaoDao"%>
<%@page import="model.Vacinacao"%>
<%@page import="model.Vacinacao"%>
<%@page import="java.util.List"%>
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

        pageContext.setAttribute("ator", portadorCiva);
        pageContext.setAttribute("portadorCiva", portadorCiva);
    } catch (Exception e) {
    }


%>


<%@include file="header.jspf"%>
<script src="../public/assets/js/suporte-civa/gerenciar-portador.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@ include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->
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
                            <h1 class="m-0">Painel Portador CIVA</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel Portador CIVA</li>
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
                                    <h3 class="card-title">Dados Portador CIVA</h3>
                                </div>
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@ include file="../partials/codigociva.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/dadospessoais-alteracao.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/enderecos-alteracao.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/contatos-alteracao.jspf" %>
                                        <input type="hidden" value="atualizar" class="form-control" id="option" name="option">

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- HISTORICO DE VACINA&ccedil;&atilde;O -->
                    <div class="row">
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Hist&oacute;rico de Vacina&ccedil;&atilde;o</h3>
                                    <div class="card-tools">
                                        <div class="input-group input-group-sm" style="width: 150px;">

                                            <div class="input-group-append">

                                            </div>
                                        </div>
                                    </div>
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
                                                <th>Data de Aplica&ccedil;&atilde;o</th>

                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:set var="codigoCivaPortadorCiva" value="${portadorCiva.codigoCiva}"/>

                                            <c:forEach items="${portadorCiva.listaVacinacao}" var="vacinacao">

                                                <tr>
                                                    <td><c:out value="${vacinacao.vacina.nomeVacina}" /></td>
                                                    <td><c:out value="${vacinacao.vacina.laboratorio}" /></td>
                                                    <td><c:out value="${vacinacao.doseAplicada}" /></td>
                                                    <td><c:out value="${vacinacao.pais}" /></td>
                                                    <td><c:out value="${vacinacao.dataAplicacao}" /></td>
                                                    <td><a href="./painel-vacinacao.jsp?codigoCiva=<c:out value="${codigoCivaPortadorCiva}"/>&idVacinacao=<c:out value="${vacinacao.idVacinacao}"/>"
                                                           class="btn btn-block btn-primary btn-sm">Ver mais</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>   

                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 mb-4">
                            <button type="button" id="salvar" class="btn btn-primary btn-lg">Salvar</button>
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