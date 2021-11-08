<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CIVA - Gerenciar unidade</title>

        <link rel="shortcut icon" href="./../public/img/favicon-gs.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

        <!-- Select2 -->
        <link rel="stylesheet" href="./../public/plugins/select2/css/select2.min.css">

        <!-- Estilo icones -->
        <link rel="stylesheet" href="./../public/plugins/fontawesome-free/css/all.min.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="./../public/dist/css/adminlte.min.css">

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
                                <h1 class="m-0">Gerenciar Unidade</h1>
                            </div>
                            <!-- /.col -->

                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="./consultar-unidades.jsp">Voltar</a></li>
                                    <li class="breadcrumb-item active">Gerenciar unidade</li>
                                </ol>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- /.content-header ---------------------------------------------->

                <!-- Main content -->
                <div class="content">
                    <div class="container-fluid">
                        <!---------------------------------------------------------------->
                        <div class="row">
                            <div class="col-12 mb-3">
                                <div class="card card-primary">
                                    <div class="card-header">
                                        <h3 class="card-title">Dados Unidade</h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <!-- Incio do form -->
                                    <form action="#" id="form-gerenciar-unidade" method="post" novalidate="novalidate">
                                        <div class="p-2">
                                            <%@ include file="../partials/dados-unidade-disabled.jspf" %>
                                            <hr>
                                            <%@ include file="../partials/enderecos-disabled.jspf" %>
                                            <hr>
                                            <%@ include file="../partials/contatos-unidade-disabled.jspf" %>
                                        </div>
                                    </form>
                                    <!-- /.form ending -->
                                </div>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>

                    <!-- TABELA VACINAS -->
                    <div class="row">
                        <div class="col-12 mb-2">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Profissionais vinculados</h3>

                                    <div class="card-tools">
                                        <div class="input-group input-group-sm" style="width: 150px;">

                                            <div class="input-group-append">


                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Identidade</th>
                                                <th>C&oacute;digo Civa</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>

                                            </tr>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>

                                            </tr>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>

                                            </tr>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>

                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12 mb-4">
                            <button type="submit" class="btn btn-primary btn-lg" form="form-gerenciar-unidade">Salvar</button>
                        </div>
                    </div>


                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content -->
            <!-- Main Footer -->
            <%@ include file="../partials/gerente/footer.jspf" %>
        </div>
        <!-- /.content-wrapper -->



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
    </script>

</body>

</html>