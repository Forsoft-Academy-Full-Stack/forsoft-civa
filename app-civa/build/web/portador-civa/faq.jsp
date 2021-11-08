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
                                <h1 class="m-0">FAQ</h1>
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.container-fluid -->
                </div>
                <!-- /.content-header ---------------------------------------------->







                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-12" id="accordion">
                            <div class="card card-primary card-outline">
                                <a class="d-block w-100" data-toggle="collapse" href="#collapseOne">
                                    <div class="card-header">
                                        <h4 class="card-title w-100">
                                            1. Lorem ipsum dolor sit amet
                                        </h4>
                                    </div>
                                </a>
                                <div id="collapseOne" class="collapse show" data-parent="#accordion">
                                    <div class="card-body">
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                                    </div>
                                </div>
                            </div>
                            <div class="card card-primary card-outline">
                                <a class="d-block w-100" data-toggle="collapse" href="#collapseTwo">
                                    <div class="card-header">
                                        <h4 class="card-title w-100">
                                            2. Aenean massa
                                        </h4>
                                    </div>
                                </a>
                                <div id="collapseTwo" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
                                    </div>
                                </div>
                            </div>
                            <div class="card card-primary card-outline">
                                <a class="d-block w-100" data-toggle="collapse" href="#collapseThree">
                                    <div class="card-header">
                                        <h4 class="card-title w-100">
                                            3. Donec quam felis
                                        </h4>
                                    </div>
                                </a>
                                <div id="collapseThree" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.
                                    </div>
                                </div>
                            </div>
                            <div class="card card-teal card-outline">
                                <a class="d-block w-100" data-toggle="collapse" href="#collapseFour">
                                    <div class="card-header">
                                        <h4 class="card-title w-100">
                                            4. Donec pede justo
                                        </h4>
                                    </div>
                                </a>
                                <div id="collapseFour" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu.
                                    </div>
                                </div>
                            </div>
                            <div class="card card-teal card-outline">
                                <a class="d-block w-100" data-toggle="collapse" href="#collapseFive">
                                    <div class="card-header">
                                        <h4 class="card-title w-100">
                                            5. In enim justo
                                        </h4>
                                    </div>
                                </a>
                                <div id="collapseFive" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis
                                        pretium.
                                    </div>
                                </div>
                            </div>
                            <div class="card card-teal card-outline">
                                <a class="d-block w-100" data-toggle="collapse" href="#collapseSix">
                                    <div class="card-header">
                                        <h4 class="card-title w-100">
                                            6. Integer tincidunt
                                        </h4>
                                    </div>
                                </a>
                                <div id="collapseSix" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->


            <!-- Main Footer -->
            <%@include file="footer.jspf" %>

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