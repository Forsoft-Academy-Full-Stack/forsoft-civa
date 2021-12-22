<%@page import="dao.VacinaDao"%>
<%@page import="model.Vacina"%>
<%@page import="model.Vacina"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gestor-nacional"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>

<%  
    try {
        List<Vacina> listaVacinas = VacinaDao.listByGestorNacional(pessoa.getCodigoCiva());
        pageContext.setAttribute("vacinas", listaVacinas);

    } catch (Exception e) {
    }

%>


<%@include file="header.jspf"%>
<script src="../public/assets/js/gestor-nacional/gerenciar-vacina.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@ include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">

            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Consultar Vacina</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Consultar Vacina</li>
                            </ol>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>

            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->

                    <!-- PESQUISA E FILTRO -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <form action="" method="GET">
                                        <div class="row">
                                            <div class="row col-md-12 col-sm-12">
                                                <div class="col-xl-2 col-sm-12 mb-2">
                                                    <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                        <option value="nome-az">Nome A - Z</option>
                                                        <option value="nome-za">Nome Z - A</option>
                                                        <option value="cpf-asc">CPF crescente</option>
                                                        <option value="cpf-des">CPF decrescente</option>
                                                    </select>
                                                </div>

                                                <div class="col-xl-8 col-sm-12">
                                                    <div class="input-group  mb-2">
                                                        <input type="text" class="form-control" id="search-table" placeholder="Pesquisar por vacina">
                                                        <div class="input-group-append">
                                                            <button class="btn btn-outline-secondary" type="button" id="button-addon2" onclick="pesquisaNomes(); return false">Pesquisar</button>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-2">
                                                    <div class="btn-group">
                                                        <button type="button" class="btn btn-default">CSV</button>
                                                        <button type="button" class="btn btn-default">PDF</button>
                                                        <button type="button" class="btn btn-default">Excel</button>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                    </form>


                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- TABELA -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table id="test-table" class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th style="cursor: pointer;">Vacina</th>
                                                <th style="cursor: pointer;">Laborat&oacute;rio</th>
                                                <th style="cursor: pointer;">Número de Doses</th>
                                                <th style="cursor: pointer;">ID Vacina</th>
                                                <th style="width:15%"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${vacinas}" var="vacina">
                                                <tr>
                                                    <td><c:out value="${vacina.nomeVacina}" /></td>
                                                    <td><c:out value="${vacina.laboratorio}" /></td>                                                  
                                                    <td><c:out value="${vacina.numeroDoses} dose(s)" /></td>
                                                    <td><c:out value="${vacina.idVacina}" /></td>
                                                    <td><a href="painel-vacina.jsp?idVacina=<c:out value="${vacina.idVacina}" />" class="btn btn-block btn-primary btn-sm">Consultar</a></td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>

                                </div>
                                <!-- /.card-body -->

                            </div>

                        </div>

                    </div>

                    <!-- PAGINA&Ccedil;&Atilde;O -->
                    <%@include file="../partials/paginacao.jspf" %>

                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- ./wrapper -->
</body>

</html>
