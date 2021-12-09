<%@page import="dao.UnidadeDao"%>
<%@page import="dao.GerenteDao"%>
<%@page import="dao.GerenteDao"%>
<%@page import="model.Gerente"%>
<%@page import="model.Gerente"%>
<%@page import="model.Unidade"%>
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
        Integer idUnidade = Integer.parseInt(request.getParameter("idUnidade"));
        Unidade unidade = UnidadeDao.findById(idUnidade);

        List<Gerente> listaGerente = GerenteDao.listByIdUnidade(idUnidade);
        
        pageContext.setAttribute("ator", unidade);
        pageContext.setAttribute("unidade", unidade);
        pageContext.setAttribute("idUnidade", idUnidade);
        pageContext.setAttribute("gerentes", listaGerente);

    } catch (Exception e) {
    }

%>

<%@include file="header.jspf"%>
<script src="../public/assets/js/gestor-nacional/painel-unidade-gestor.js" defer></script>
</head>


<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include file="menu.jspf" %>
        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Painel Unidade</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item">
                                    <a href="" id="go-back">Voltar</a>
                                </li>
                                <li class="breadcrumb-item active">Painel Unidade</li>
                            </ol>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->

                    <div class="row">
                        <div class="col-12 mb-3">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Unidade</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@include file="../partials/dados-unidade-disabled.jspf"%>
                                        <hr  class = "mb-4 mt-4">
                                        <%@include file="../partials/enderecos-disabled.jspf"%>
                                        <hr  class = "mb-4 mt-4">
                                        <%@include file="../partials/contatos-unidade-disabled.jspf" %>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->

                    <!-- TABELA VACINAS -->
                    <div class="row">
                        <div class="col-12 mb-2">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Gerentes vinculados</h3>

                                    <div class="card-tools">
                                        <div
                                            class="input-group input-group-sm"
                                            style="width: 150px"
                                            >
                                            <div class="input-group-append"></div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table
                                        id="test-table"
                                        class="table table-hover text-nowrap"
                                        >
                                        <thead>
                                            <tr>
                                                <th style="cursor: pointer">Nome Gerente</th>
                                                <th style="cursor: pointer">Identidade</th>
                                                <th style="cursor: pointer">C&oacute;digo Civa</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${gerentes}" var="gerente">
                                                <tr>
                                                    <td><c:out value="${gerente.pessoa.nomePessoa} ${gerente.pessoa.sobrenomePessoa}" /></td>
                                                    <td><c:out value="${gerente.documento1.documento}" /></td>
                                                    <td><c:out value="${gerente.codigoCiva}" /></td>
                                                </tr>
                                            </c:forEach>                                                                                              
                                        </tbody>
                                    </table>
                                    <hr>
                                    <div class="row ">
                                        <div class="col d-flex justify-content-xl-start  ml-4 mb-2">
                                            <a href="./vincular-gerente.jsp?idUnidade=<c:out value="${idUnidade}"/>" class="btn btn-success btn-xs">Vincular gerente</a>
                                        </div>                                  

                                        <div class="col  d-flex justify-content-xl-end align-items-center ml-2 mb-2 mr-4">
                                            <a href="./desvincular-gerente.jsp?idUnidade=<c:out value="${idUnidade}"/>" class="btn btn-danger btn-xs">Desvincular Gerente</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                    </div>

                </div>
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

