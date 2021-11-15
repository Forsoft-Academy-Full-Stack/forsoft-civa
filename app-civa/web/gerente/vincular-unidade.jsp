<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gerente"))) {
        // Caso for uma das duas opções
        // Redicionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
    <script src="./../public/assets/js/gerente/vincular-unidade.js" defer></script>
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
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Vincular Unidade</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./gerenciar-supervisor.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Vincular unidade</li>
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
                            <div class="row">
                                <div class="col-xl-12 col-sm-12">
                                    <div class="input-group  mb-2">
                                        <input type="text" class="form-control" id="pesquisar" name="pesquisar" placeholder="Pesquisar por unidade">
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-secondary" type="button" id="button-addon2" name="button-addon2">Pesquisar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Unidade</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- Incio do form -->
                                <form action="#" id="form-vincular-unidade" method="post" novalidate="novalidate">
                                    <div class="p-2">

                                        <%@ include file="../partials/dados-unidade-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/enderecos-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/contatos-unidade-disabled.jspf" %>

                                    </div>
                                </form>
                                <!-- /.form ending -->
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>

                <div class="row">
                    <div class="col-12 mb-4">
                        <button type="submit" class="btn btn-primary btn-lg" form="form-vincular-unidade"><a href="./gerenciar-supervisor.jsp" class="btn-primary">Vincular</a></button>
                    </div>
                </div>


            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content -->
        <!-- Main Footer -->

        <%@ include file="../partials/gerente/footer.jspf" %>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- ./wrapper -->

</body>
</html>
