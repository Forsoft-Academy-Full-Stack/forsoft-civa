<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("usuario"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }
    
   // Caso contrário é um usuário válido, pode entrar na página
  
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
                                <h1 class="m-0">Hist&oacute;rico de Vacina&ccedil;&atilde;o</h1>
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.container-fluid -->
                </div>
                <!-- /.content-header ---------------------------------------------->




                <!-- Main content -->

                <div class="col-12">
                    <div class="card card-primary card-outline">
                        <div class="card-header">
                            <h3 class="card-title">&Uacute;ltimas vacinas tomadas.</h3>
                        </div>
                        <!-- ./card-header -->
                        <div class="card-body d-flex">
                            <table class="table text-nowrap">
                                <thead>
                                    <tr>
                                        <th>Vacina</th>
                                        <th>Laborat&oacute;rio</th>
                                        <th>Dose</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Coronavac</td>
                                        <td>Sinovac</td>
                                        <td>1&compfn; Dose</td>
                                    </tr>

                                </tbody>
                                <thead>
                                    <tr>
                                        <th>Data de aplica&ccedil;&atilde;o</th>
                                        <th>Estabelecimento</th>
                                        <th>Pa&iacute;s</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>29 de julho 2021</td>
                                        <td>Hospital Pan</td>
                                        <td>Brasil</td>
                                    </tr>

                                </tbody>
                            </table>
                            <div class="col aling-items-center p-3">
                                <div>
                                    <img src="../public/img/qrcode.png" alt="">
                                </div>
                                <div class="btn-group pl-2"><button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                                                    data-target="#modal-default">Visualizar</button></div>
                            </div>
                        </div>
                        <!-- ./card-body -->
                        <div class="card-body d-flex">
                            <table class="table text-nowrap">
                                <thead>
                                    <tr>
                                        <th>Vacina</th>
                                        <th>Laborat&oacute;rio</th>
                                        <th>Dose</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Coronavac</td>
                                        <td>Sinovac</td>
                                        <td>1&compfn; Dose</td>
                                    </tr>

                                </tbody>
                                <thead>
                                    <tr>
                                        <th>Data de aplica&ccedil;&atilde;o</th>
                                        <th>Estabelecimento</th>
                                        <th>Pa&iacute;s</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>29 de julho 2021</td>
                                        <td>Hospital Pan</td>
                                        <td>Brasil</td>
                                    </tr>

                                </tbody>
                            </table>
                            <div class="col aling-items-center p-3">
                                <div>
                                    <img src="../public/img/qrcode.png" alt="">
                                </div>
                                <div class="btn-group pl-2"><button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                                                    data-target="#modal-default">Visualizar</button></div>
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
            <!-- /.footer ------------------------------------------------------->
            <!-- modal------------------------------------>
            <%@include file="modal-certificado-civa.jspf" %>
            <!-- /.modal ------------------------------------------------------->
        </div>

        <!-- MODAL CERTIFICADO CIVA -->


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

        <script>
            $('#modal-default').modal('hide');
        </script>
    </body>

</html>