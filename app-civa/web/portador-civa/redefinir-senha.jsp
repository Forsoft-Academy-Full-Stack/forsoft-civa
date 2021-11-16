<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("usuario"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/portador-civa/redefinir-senha.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include file="menu.jspf" %>
        <!-- /.menu ------------------------------------------------------->

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Redefinir Senha</h1>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->

                    <div class="col-xl-5">
                        <div class="card card-primary">
                            <!-- form start -->
                            <form action="" id="form-redefinir-senha">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="senha">Nova senha</label>
                                        <input type="password" class="form-control" id="senha">
                                    </div>
                                    <div class="form-group">
                                        <label for="conf-senha">Confirmar</label>
                                        <input type="password" class="form-control" id="conf-senha">
                                    </div>
                                </div>
                            </form>
                            <!-- ./form -->
                        </div>
                    </div>

                    <div class="col-12">
                        <div class="">
                            <button type="button" class="btn btn-primary btn-lg" form="form-meus-dados" data-toggle="modal"
                                    data-target="#modal-default">Salvar</button>
                        </div>
                    </div>

                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf" %>
    </div>

    <!-- modal start -->
    <%@include file="modal-alteracao-ok.jspf" %>
    <!-- ./wrapper -->

</body>

</html>