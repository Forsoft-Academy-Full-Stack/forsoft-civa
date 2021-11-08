<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>CIVA - Relatorio</title>

        <link
            rel="shortcut icon"
            href="./../public/img/favicon-gs.svg"
            type="image/x-icon"
            />

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet"
            />

        <!-- Font Icons Google -->
        <link
            href="https://fonts.googleapis.com/icon?family=Material+Icons+Round"
            rel="stylesheet"
            />

        <!-- Estilo icones -->
        <link
            rel="stylesheet"
            href="./../public/plugins/fontawesome-free/css/all.min.css"
            />

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="./../public/dist/css/adminlte.min.css" />
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
                                <h1 class="m-0">Relatorio</h1>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item">
                                        <a href="./index.jsp">Voltar</a>
                                    </li>
                                    <li class="breadcrumb-item active">Relatorio</li>
                                </ol>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>

                <!-- Main content -->
                <div class="content">
                    <div class="container-fluid">
                        <!---------------------------------------------------------------->

                        <!-- CABE&Ccedil;ALHO INFORMAÇ&Otilde;ES -->
                        <div class="row">
                            <div class="col-lg-3 col-6">
                                <!-- small box -->
                                <div class="small-box bg-info">
                                    <div class="inner">
                                        <h3>150</h3>

                                        <p>New Orders</p>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-bag"></i>
                                    </div>
                                    <a href="#" class="small-box-footer"
                                       >More info <i class="fas fa-arrow-circle-right"></i
                                        ></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-lg-3 col-6">
                                <!-- small box -->
                                <div class="small-box bg-success">
                                    <div class="inner">
                                        <h3>53<sup style="font-size: 20px">%</sup></h3>

                                        <p>Bounce Rate</p>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-stats-bars"></i>
                                    </div>
                                    <a href="#" class="small-box-footer"
                                       >More info <i class="fas fa-arrow-circle-right"></i
                                        ></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-lg-3 col-6">
                                <!-- small box -->
                                <div class="small-box bg-warning">
                                    <div class="inner">
                                        <h3>44</h3>

                                        <p>User Registrations</p>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-person-add"></i>
                                    </div>
                                    <a href="#" class="small-box-footer"
                                       >More info <i class="fas fa-arrow-circle-right"></i
                                        ></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-lg-3 col-6">
                                <!-- small box -->
                                <div class="small-box bg-danger">
                                    <div class="inner">
                                        <h3>65</h3>

                                        <p>Unique Visitors</p>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-pie-graph"></i>
                                    </div>
                                    <a href="#" class="small-box-footer"
                                       >More info <i class="fas fa-arrow-circle-right"></i
                                        ></a>
                                </div>
                            </div>
                            <!-- ./col -->
                        </div>

                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->

            <%@ include file="../partials/gerente/footer.jspf" %>

        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->

        <!-- jQuery -->
        <script src="./../public/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="./../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="./../public/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="./../public/dist/js/demo.js"></script>
    </body>
</html>
