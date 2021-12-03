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
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Manual CIVA</h1>
                        </div><!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Manual CIVA</li>
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

                    <!-- PDF MANUAL CIVA -->
                    <div class="row">
                        <div class="col-12 mb-4" style="height: 700px;">
                            <iframe src="../public/assets/manual/manual-civa.pdf" type="application/pdf" width="100%"
                                    height="100%"></iframe>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12 mb-4">
                            <a href="./../public/assets/manual/manual-civa.pdf" target="_blank"><button type="submit"
                                                                                                        class="btn btn-primary btn-lg">Abrir PDF</button></a>
                        </div>
                    </div>


                </div><!-- /.container-fluid -->
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