<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("administrador-oms"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>

<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->
                    <div class="row">
                        <!-- HOME PROFISSIONAL DA SA&Uacute;DE -->
                        <!-- Content Wrapper. Contains page content -->
                        <div class="col-md-12 mt-4 mb-5">
                            <!-- .content -->
                            <div class="jumbotron">
                                <h1 class="display-4">Ol&aacute, Administrador OMS!</h1>
                                <hr class="my-4">
                                <p>Bem vindo ao seu painel CIVA, ${dados.nomePessoa} ${dados.sobrenomePessoa}!</p>
                            </div>
                            <!-- /.content -->
                        </div>
                    </div>
                    <div class="row">
                    </div>
                    <!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- ./wrapper -->

    <!-- REQUIRED SCRIPTS ------------------------------------------------------->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/public/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="${pageContext.request.contextPath}/public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- AdminLTE App -->
    <script src="${pageContext.request.contextPath}/public/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="${pageContext.request.contextPath}/public/dist/js/demo.js"></script>

</body>
</html>
