<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("portador-civa"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
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
                            <h1 class="m-0">Eliminar dados</h1>
                        </div><!-- /.col --> 
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->
            <div class="col-12">
                <div class="card card-primary card-outline">

                    <div class="card-body">
                        <div class="d-flex flex-column justify-content-center align-items-center">
                            <div class="align-items-center"><img style="width: 200px;" src="../public/img/Pay-attention-amico-1.svg" alt="Aten&ccedil;&atilde;o, eliminar dados"></div>
                            <div class="d-flex flex-column justify-content-center align-items-center">
                                <h3>Elimina&ccedil;&atilde;o de dados</h3>
                                <p style="width: 500px; text-align: center">Conforme determina a Lei 13.709/2018, voc&ecirc; tem o direito de solicitar a elimina&ccedil;&atilde;o total dos dados tratados pelo CIVA.</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex justify-content-center">
                            <a href="./eliminar-dados-confirmacao.jsp"><button type="button" class="btn btn-primary">CONTINUAR</button></a>
                        </div>
                    </div>
                    <!-- ./card-body -->
                </div>
            </div>

            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf" %>
    </div>
    <!-- ./wrapper -->

</body>
</html>
