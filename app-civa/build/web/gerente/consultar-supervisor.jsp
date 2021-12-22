<%@page import="java.util.ArrayList"%>
<%@page import="dao.SupervisorDao"%>
<%@page import="model.Supervisor"%>
<%@page import="model.Supervisor"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gerente"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>

<%  
    try {
        String nomePessoa = null;
        nomePessoa = request.getParameter("nome");
        
        if (nomePessoa.equals("") || nomePessoa == null) {
            List<Supervisor> listaSupervisores = SupervisorDao.listByGerente(pessoa.getCodigoCiva());

            pageContext.setAttribute("supervisores", listaSupervisores);
        } else {
            List<Supervisor> listaSupervisores = SupervisorDao.listByGerenteNomeSupervisor(pessoa.getCodigoCiva(), nomePessoa);

            pageContext.setAttribute("supervisores", listaSupervisores);
        }

    } catch (Exception e) {
    }

%>    


<%@include file="header.jspf"%>
<script src="./../public/assets/js/gerente/consultar-supervisor.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@ include file="../partials/gerente/navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="../partials/gerente/menu.jspf" %>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Consultar Supervisor</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">

                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>

                                <li class="breadcrumb-item active">Consultar Supervisor</li>
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
                                    <div class="row">
                                        <div class="row col-md-12 col-sm-12">
                                            <div class="col-xl-2 col-sm-12 mb-2">
                                                <form action="" method="GET" id="pesquisa">
                                                    <select class="select2 select2-hidden-accessible" id="ordem-de-listagem"
                                                            name="ordem-de-listagem" style="width: 100%;" tabindex="-1"
                                                            aria-hidden="true">
                                                        <option value="nome">Nome A - Z</option>
                                                        <option value="nome">Nome Z - A</option>
                                                        <option value="cpf">CPF crescente</option>
                                                        <option value="cpf">CPF decrescente</option>
                                                    </select>
                                                </form>

                                            </div>

                                            <div class="col-xl-8 col-sm-12">
                                                <form action="" method="GET" id="pesquisa2">
                                                    <div class="input-group  mb-2">
                                                        <input type="text" class="form-control" id="nome"
                                                               name="nome" placeholder="Pesquisar Supervisor">
                                                        <div class="input-group-append">
                                                            <button class="btn btn-outline-secondary" type="submit"
                                                                    form="pesquisa2">Pesquisar</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>

                                            <div class="col-2">
                                                <div class="btn-group">
                                                    <button type="button" id="button-addon3" name="button-addon3"
                                                            class="btn btn-default">CSV</button>
                                                    <button type="button" id="button-addon4" name="button-addon4"
                                                            class="btn btn-default">PDF</button>
                                                    <button type="button" id="button-addon5" name="button-addon5"
                                                            class="btn btn-default">Excel</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Identifica&ccedil;&atilde;o</th>
                                                <th>Data de Nascimento</th>
                                                <th>C&oacute;digo CIVA</th>
                                                <th style="width:15%"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${supervisores}" var="supervisor">
                                                <tr>
                                                    <td><c:out value="${supervisor.pessoa.nomePessoa} ${supervisor.pessoa.sobrenomePessoa}" /></td>
                                                    <td><c:out value="${supervisor.documento1.documento}" /></td>
                                                    <td><c:out value="${supervisor.pessoa.dataNascimento}" /></td>
                                                    <td><c:out value="${supervisor.codigoCiva}" /></td>
                                                    <td>
                                                        <a
                                                            href="./painel-supervisor.jsp?codigoCiva=<c:out value="${supervisor.codigoCiva}" />"
                                                            class="btn btn-block btn-primary btn-sm"
                                                            >Consultar</a
                                                        >
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

                    <!-- PAGINA&Ccedil;&Atilde;O -->
                    <%@ include file="/partials/paginacao.jspf" %>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@ include file="../partials/gerente/footer.jspf" %>
    </div>
    <!-- ./wrapper -->

</body>
</html>