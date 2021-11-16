<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("supervisor"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/supervisor/painel-profissional-saude.js" defer ></script>
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
                            <h1 class="m-0">Painel Supervisor</h1>
                        </div><!-- /.col --> 
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./consultar-profissional-de-saude.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Gerenciar Supervisor</li>
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
                            <form action="">
                                <div class="input-group">
                                    <input type="search" class="form-control form-control-lg" placeholder="Insira o código civa do portador">
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
                                    <h3 class="card-title">Dados Profissional Sa&uacute;de</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-unidade-vinculada">
                                    <div class="card-body">
                                        <%@include file="../partials/codigociva.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/dadospessoais-ps-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/enderecos-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/contatos-disabled.jspf" %>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 row">
                        <div class="mb-3 mt-3">
                            <a href="./vincular-unidade.jsp" class="btn btn-primary btn-lg">Vincular Nova unidade</a>
                        </div>
                    </div>
                    <!-- TABELA VACINAS -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Unidades Vinculadas</h3>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Estado</th>
                                                <th>C&oacute;digo Postal</th>
                                                <th>Identificador</th>
                                                <th>Desvincular Unidade</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Hopital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td><span class="tag tag-success">215648</span></td>
                                                <td><input class="btn btn-block" type="checkbox"></td>
                                            </tr>
                                            <tr>
                                                <td>Hopital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td><span class="tag tag-success">215648</span></td>
                                                <td><input class="btn btn-block" type="checkbox"></td>
                                            </tr>
                                            <tr>
                                                <td>Hopital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td><span class="tag tag-success">215648</span></td>
                                                <td><input class="btn btn-block" type="checkbox"></td>
                                            </tr>
                                            <tr>
                                                <td>Hopital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td><span class="tag tag-success">215648</span></td>
                                                <td><input class="btn btn-block" type="checkbox"></td>
                                            </tr>
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
                            <button type="submit" class="btn btn-primary btn-lg" form="form-unidade-vinculada">Salvar</button>
                        </div>
                    </div>

                    <!-- /.row -->
                </div><!-- /.container-fluid -->
                <%@ include file="../partials/modals-dados-salvos.jspf" %>
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@ include file="footer.jspf" %>
    </div>
    <!-- ./wrapper -->
</body>
</html>
