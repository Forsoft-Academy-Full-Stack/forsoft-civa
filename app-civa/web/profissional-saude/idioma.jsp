<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CIVA</title>

        <link rel="shortcut icon" href="./../public/img/favicon-gs.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet">



        <!-- Select2 -->
        <link rel="stylesheet" href="./../public/plugins/select2/css/select2.min.css">

        <!-- Estilo icones -->
        <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="./../public/dist/css/adminlte.min.css">
        <script src="../public/plugins/sweetalert2/sweetalert2.all.min.js"></script>


    </head>

    <body class="hold-transition sidebar-mini">
        <div class="wrapper">

            <!-- Navbar --------------------------------------------->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button">
                            <i class="fas fa-bars"></i>
                        </a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="" class="nav-link">Perfil</a>
                    </li>
                </ul>
            </nav>
            <!-- /.navbar ------------------------------------------------------->

            <!-- MENU Main Sidebar Container ------------------------------------>
            <%@ include file="menu.jspf" %>
            <!-- /.sidebar ------------------------------------------------------>

            <!-- Content Wrapper. Contains page content -------------------------->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <div class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1 class="m-0">Mudar idioma</h1>
                            </div><!-- /.col -->

                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
                                    <li class="breadcrumb-item active">Home</li>
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

                        <form class="row" id="idioma">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="form-group col-12">
                                            <label for="language">Idioma</label>
                                            <select id="language" name="language" class="select2 select2-hidden-accessible"
                                                    style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                <option value="1" selected>Portugu&ecirc;s (Brasil)</option>
                                                <option value="2">English (US)</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>

                        <div class="row">
                            <div class="col-12 mb-4">
                                <button type="button" class="btn btn-primary btn-lg" id="salvar-alteracao">Salvar
                                    altera&ccedil;&atilde;o</button>
                            </div>
                        </div>

                    </div><!-- /.container-fluid -->
                </div>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <%@ include file="footer.jspf" %>
            <!-- ./footer -->
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->

        <!-- jQuery -->
        <script src="./../public/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="./../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Select2 -->
        <script src="./../public/plugins/select2/js/select2.full.min.js"></script>
        <!-- AdminLTE App -->
        <script src="./../public/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="./../public/dist/js/demo.js"></script>

        <script>
            $(function () {
                $('.select2').select2()
            });


            let form = $("#idioma");
            $("#salvar-alteracao").click(function () {

                $.get("", form.serialize(), (data, status) => {
                    if (status === 'success') {

                        const Toast = Swal.mixin({
                            toast: true,
                            position: 'top-start',
                            showConfirmButton: false,
                            timer: 3000,
                            timerProgressBar: true,
                            didOpen: (toast) => {
                                toast.addEventListener('mouseenter', Swal.stopTimer)
                                toast.addEventListener('mouseleave', Swal.resumeTimer)
                            }
                        })

                        Toast.fire({
                            icon: 'success',
                            title: 'Idioma alterado'
                        })

                    } else {
                        console.log("Ops... Algum erro ocorreu e seus dados n&atilde;o foram enviados :(");

                        const Toast = Swal.mixin({
                            toast: true,
                            position: 'top-start',
                            showConfirmButton: false,
                            timer: 3000,
                            timerProgressBar: true,
                            didOpen: (toast) => {
                                toast.addEventListener('mouseenter', Swal.stopTimer)
                                toast.addEventListener('mouseleave', Swal.resumeTimer)
                            }
                        })

                        Toast.fire({
                            icon: 'error',
                            title: 'Idioma n&atilde;o foi alterado'
                        })
                    }
                });
            });

        </script>

    </body>

</html>