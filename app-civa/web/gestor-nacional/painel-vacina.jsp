<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gestor-nacional"))) {
        // Caso for uma das duas opções
        // Redicionar para o login
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


        <!-- Font Icons Google -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">


        <!-- Font Icones -->
        <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

        <!-- Estilo Adicional -->
        <link rel="stylesheet" href="../public/dist/css/style.css">

    </head>

    <body class="hold-transition sidebar-mini">
        <div class="wrapper">

            <!-- Navbar --------------------------------------------->
            <%@include file="navbar.jspf" %>
            <!-- /.navbar ------------------------------------------------------->

            <!-- MENU Main Sidebar Container ------------------------------------>
            <%@include file="menu.jspf" %>

            <!-- Content Wrapper. Contains page content -------------------------->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <div class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1 class="m-0">Painel Vacina</h1>
                            </div>
                            <!-- /.col -->

                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="./gerenciar-vacina.jsp">Voltar</a></li>
                                    <li class="breadcrumb-item active">Painel Vacina</li>
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

                        <section class="content-header">
                            <div class="container-fluid">

                                <div class="row">
                                    <div class=" col-md-12">

                                        <div class="card card-primary">
                                            <div class="card-header">
                                                <h3 class="card-title">Dados Vacina</h3>
                                            </div>
                                            <!-- /.card-header -->
                                            <!-- form start -->
                                            <form id="form-cad-portador">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="form-group col-6">
                                                            <label for="name">ID vacina</label>
                                                            <input type="text" class="form-control" id="name" value="123456789" disabled>
                                                        </div>
                                                        <div class="form-group col-6">
                                                            <label for="surname">Dose</label>
                                                            <input type="text" class="form-control" id="surname" value="2 doses" disabled>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-6">
                                                            <label for="identity">Vacina</label>
                                                            <input type="text" class="form-control" id="identity" value="Coronavac" disabled>
                                                        </div>
                                                        <div class="form-group col-6">
                                                            <label for="dose">Laborat&oacute;rio</label>
                                                            <input class="form-control" id="dose" value="Sinovac" disabled>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-6">
                                                            <label for="vacina">Tipo de vacina</label>
                                                            <input type="text" class="form-control" id="vacina" value="Sars cov 2" disabled>
                                                        </div>
                                                        <div class="form-group col-6">
                                                            <label for="vacina">Tempo entre doses (em dias)</label>
                                                            <input type="text" class="form-control" id="vacina" value="25" disabled>
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-6">
                                                        <label for="date-aplication">Tempo para refor&ccedil;o (em dias)</label>
                                                        <input type="text" class="form-control" id="date-aplication" value="45" disabled>
                                                    </div>
                                                    <div class="custom-control custom-switch">
                                                        <input type="checkbox" class="custom-control-input bg-success" id="customSwitch2">
                                                        <label class="custom-control-label text-success" for="customSwitch2"></label>
                                                    </div>

                                                </div>
                                            </form>

                                        </div>
                                    </div>

                                    <div class="col-md-12 mb-3 mt-3">
                                        <button type="submit" class="btn btn-primary btn-lg" form="form-cad-portador">Desvincular</button>
                                    </div>

                                </div>

                            </div>
                            <!-- /.container-fluid -->
                        </section>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                    <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title">Vacina desvinculada com sucesso!</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">Ã</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <p></p>
                                </div>
                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href = './gerenciar-vacina.jsp'">Close</button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                    </div>
                    <!-- /.content -->
                </div>
                <!-- /.content-wrapper -->

            </div>
            <!-- Main Footer -->
            <%@include file="footer.jspf"%>

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
                                        function tratarCampos() {
                                            let erro = false;
                                            let campos = [];

                                            for (i = 0; i < campos.length; i++) {
                                                if (document.getElementById(campos[i]).value == '') {
                                                    erro = true;
                                                }
                                            }

                                            if (erro) {
                                                alert('Todos os campos devem ser preenchidos!');
                                            } else {
                                                // Exibe o modal desejado, baseado no id definido.
                                                $('#modal-default').modal('show');
                                                console.log('funcionou');
                                                event.preventDefault();

                                            }

                                            return !erro;
                                        }

                                        document.getElementById('form-cad-portador').onsubmit = tratarCampos;
            </script>

    </body>

</html>