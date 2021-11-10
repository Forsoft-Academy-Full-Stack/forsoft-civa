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
                                <h1 class="m-0">Termos de Uso</h1>
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


                    <section class="content">


                        <!-- Default box -->
                        <div class="card">
                            <div class="d-flex align-items-center justify-content-between">
                                <p class="text-center h4 m-5">Termos de uso e pol&iacute;ticas de privacidade</p>
                                <div class="mr-5">
                                    <a href="./index.jsp"><button type="button" class="btn btn-primary">Voltar</button></a>
                                </div>
                            </div>

                            <div>
                                <p class="text-left m-3">Lorem ipsum dolor sit amet. Hic consequatur tenetur et ipsum
                                    commodi ad dolorum autem ad fugiat pariatur et minima laudantium est quae nihil. Sit
                                    quae facilis aut modi molestiae eos dicta animi sit repudiandae veritatis sed
                                    neque maiores. Lorem ipsum consectetur etiam viverra primis tortor dictum egestas nam
                                    urna ut, et in dictum dui morbi nulla enim at cursus aenean. dictum interdum orci
                                    euismod fames sagittis lacus aliquet, vehicula pharetra
                                    et praesent torquent tincidunt, primis dictumst faucibus cursus posuere neque. mauris
                                    vel quisque aptent sollicitudin arcu dolor, quisque ornare aliquam justo tortor, class
                                    senectus mattis cras duis. lectus est leo euismod
                                    potenti felis fames feugiat consequat pellentesque, nec hac mi ad netus a conubia massa
                                    tellus bibendum, iaculis tempus at nisl metus nisi quam cursus. condimentum risus
                                    bibendum vestibulum leo torquent etiam, quisque gravida
                                    feugiat tortor sapien, sociosqu convallis netus dui dictumst. 1. Lorem ipsum 11.Lorem
                                    ipsum consectetur etiam viverra primis tortor dictum egestas nam urna ut, et in dictum
                                    dui morbi nulla enim at cursus aenean. dictum
                                    interdum orci euismod fames sagittis lacus aliquet, vehicula pharetra et praesent
                                    torquent tincidunt, primis dictumst faucibus cursus posuere neque. mauris vel quisque
                                    aptent sollicitudin arcu dolor, quisque ornare aliquam
                                    justo tortor. 12. class senectus mattis cras duis. lectus est leo euismod potenti felis
                                    fames feugiat consequat pellentesque, nec hac mi ad netus a conubia massa tellus
                                    bibendum, iaculis tempus at nisl metus nisi quam cursus.
                                    condimentum risus bibendum vestibulum leo torquent etiam, quisque gravida feugiat tortor
                                    sapien, sociosqu convallis netus dui dictumst.
                                </p>
                            </div>


                        </div>
                        <!-- /.card -->

                    </section>

                    <!-- /.row -->
                </div>

            </div>

            <!-- Main Footer -->
            <%@include file="footer.jspf" %>

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
</body>

</html>