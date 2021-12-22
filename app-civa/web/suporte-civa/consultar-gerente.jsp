<%@page import="dao.GerenteDao"%>
<%@page import="java.util.List"%>
<%@page import="model.Gerente"%>
<%@page import="model.Gerente"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("suporte-civa"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>

<%    try {
        List<Gerente> listaGerentes = GerenteDao.listBySuporteCiva(pessoa.getCodigoCiva());
        pageContext.setAttribute("gerentes", listaGerentes);

    } catch (Exception e) {
    }

%>
<!--Por favor não remover include nem head-->
<!--a abertura do head é feita no header.jspf-->
<!--Dessa forma fica menos poluído-->
<!--os links e scripts base ficam nesse header.jspf-->
<!--então aqui é chamado o js especifico para cada página -->
<!--e por fim o head é fechado -->
<%@include file="header.jspf"%>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include  file="menu.jspf"%>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Consultar Gerente</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Consultar Gerente</li>
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
                                    <form action="" method="GET" id="pesquisa2">
                                        <div class="row">

                                            <div class="row col-md-12 col-sm-12">
                                                <div class="col-xl-2 col-sm-12 mb-2">
                                                    <select class="select2 select2-hidden-accessible" id="ordem-de-listagem"
                                                            name="ordem-delistagem" style="width: 100%;" tabindex="-1"
                                                            aria-hidden="true">
                                                        <option value="civa">C&oacute;digo CIVA</option>
                                                        <option value="az">Nome A - Z</option>
                                                        <option value="za">Nome Z - A</option>
                                                        <option value="cpfup">CPF crescente</option>
                                                        <option value="cpfdown">CPF decrescente</option>
                                                    </select>
                                                </div>
                                                <div class="col-xl-8 col-sm-12">

                                                    <div class="input-group  mb-2">
                                                        <input type="text" class="form-control" id="nome"
                                                               name="nome" placeholder="Pesquisar Gerente">
                                                        <div class="input-group-append">
                                                            <button class="btn btn-outline-secondary" type="submit"
                                                                    form="pesquisa2">Pesquisar</button>
                                                        </div>
                                                    </div>

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
                                            <c:forEach items="${gerentes}" var="gerente">                                            
                                                <tr>
                                                    <td><c:out value="${gerente.pessoa.nomePessoa} ${gerente.pessoa.sobrenomePessoa}" /></td>
                                                    <td><c:out value="${gerente.documento1.documento}" /></td>
                                                    <td><c:out value="${gerente.pessoa.dataNascimento}" /></td>
                                                    <td><c:out value="${gerente.codigoCiva}" /></td>
                                                    <td><a href="painel-gerente.jsp?codigoCiva=<c:out value="${gerente.codigoCiva}" />" class="btn btn-block btn-primary btn-sm">Consultar</a></td>
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