<%
if ((session.getAttribute("dados") == null) || (session.getAttribute("perfil") != "usuario" )) { 
    response.sendRedirect("../login/");
} 
%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CIVA</title>

        <link rel="shortcut icon" href="../public/img/favicon-pc.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet">


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
                                <h1 class="m-0">Leitor QRCODE</h1>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- /.content-header ---------------------------------------------->

                <!-- Main content -->
                <div class="container-fluid">
                    <!---------------------------------------------------------------->


                    <section class="content d-flex justify-content-center">


                        <!-- Default box -->
                        <div class="card card-body card-primary card-outline " style="max-width: 700px;">
                            <div >
                                <p class="h3 text-center  mt-3">Leitor QRCODE</p>
                                <div class="justify-content-center d-flex mt-3">
                                    <video src="#" style="border: 3px solid rgb(139, 138, 138); background: rgba(139, 138, 138, 0.342);"></video>
                                </div>
                                <div class="m-5">
                                    <p class="text-center">N&atilde;o consegue escanear? Digite o c&oacute;digo de autententica&ccedil;&atilde;o.</p>
                                    <input class="form-control form-control-sm text-center" type="text"
                                           placeholder="Digite o codigo de autentica&ccedil;&atilde;o" name="cod-civa" id="cod-civa">
                                </div>

                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-block btn-primary"  data-toggle="modal"
                                            data-target="#modal-default">VALIDAR</button>
                                    <a href="./index.jsp" class="btn btn-block btn-outline-primary">VOLTAR</a>
                                </div>
                            </div>



                        </div>
                        <!-- /.card -->

                    </section>

                    <!-- /.row -->
                </div>

            </div>

            <!-- Main Footer -->
            <%@include file="footer.jspf" %>

            <!-- Main Footer -->
            <%@include file="modal-certificado-civa.jspf" %>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->


    </div>
    <!-- ./wrapper -->

    <!-- REQUIRED SCRIPTS -->

    <!-- jQuery -->
    <script src="../public/plugins/jquery/jquery.min.js "></script>
    <!-- Bootstrap 4 -->
    <script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js "></script>
    <!-- AdminLTE App -->
    <script src="../public/dist/js/adminlte.min.js "></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../public/dist/js/demo.js "></script>
    <script>
        $('#modal-default').modal('hide');
    </script>
</body>

</html>