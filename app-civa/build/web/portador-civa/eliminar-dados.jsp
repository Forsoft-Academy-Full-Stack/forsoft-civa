<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CIVA</title>

        <link rel="shortcut icon" href="../public/img/Grupo-pc.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">


        <!-- Font Icones -->
        <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

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

            <!-- Default to the left -->
            <strong>CIVA &copy; <a href="">Forsoft Academy</a>.</strong>
        </footer>
    </div>
    <!-- ./wrapper -->

    <!-- REQUIRED SCRIPTS -->

    <!-- jQuery -->
    <script src="../public/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- AdminLTE App -->
    <script src="../public/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../public/dist/js/demo.js"></script>
</body>
</html>
