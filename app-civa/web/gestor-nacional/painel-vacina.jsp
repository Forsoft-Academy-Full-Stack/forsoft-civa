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
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button">
                            <i class="fas fa-bars"></i>
                        </a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="" class="nav-link">Vacinas</a>
                    </li>
                </ul>
            </nav>
            <!-- /.navbar ------------------------------------------------------->

            <!-- MENU Main Sidebar Container ------------------------------------>
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Brand Logo -->
                <a href="index" class="brand-link">
                    <img src="../public/img/favicon-gs.svg" alt="AdminLTE Logo" class="brand-image img-circle" style="opacity: .8">
                    <span class="brand-text font-weight-light">CIVA</span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div class="image">
                            <img src="../public/img/no-user.svg" class="img-circle elevation-2" alt="User Image">
                        </div>
                        <div class="info">
                            <a href="#" class="d-block">${dados.nome}</a>
                            <a href="#" class="d-block">${dados.sobrenome}</a>
                        </div>
                    </div>



                    <!-- Sidebar Menu -->
                    <nav class="mt-2">
                        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                            <!-- ITENS DO MENU -->
                            <li class="nav-item">
                                <a href="./index.jsp" class="nav-link">
                                    <i class="nav-icon fas fa-home"></i>
                                    <p>
                                        Home
                                    </p>
                                </a>
                            </li>
                            <!-- ITEM GERENCIAR USUARIO DO MENU -->
                            <li class="nav-item  menu-open">
                                <a href="#" class="nav-link active">
                                    <!-- <i class="nav-icon fas fa-user-friends"></i> -->
                                    <p>Gestor Nacional
                                        <!-- <i class="right fas fa-angle-left"></i> -->

                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="fas fa-user-friends nav-icon"></i>
                                            <p>
                                                Gestores nacionais
                                                <i class="right fas fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="pesquisar-gestornacional.jsp" class="nav-link">
                                                    <i class="fas fa-clipboard-check nav-icon"></i>
                                                    <p>Consultar Gestor nacional</p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="cadastrar-gestornacional.jsp" class="nav-link">
                                                    <i class="fas fa-user-plus nav-icon"></i>
                                                    <p>Cadastrar Gestor nacional</p>
                                                </a>
                                            </li>

                                        </ul>
                                    </li>
                                </ul>

                                <ul class="nav nav-treeview">
                                    <li class="nav-item ">
                                        <a href="#" class="nav-link">
                                            <i class="fas fa-user-friends nav-icon"></i>
                                            <p>
                                                Gerentes
                                                <i class="right fas fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="pesquisar-gerente.jsp" class="nav-link">
                                                    <i class="fas fa-clipboard-check nav-icon"></i>
                                                    <p>Consultar gerentes </p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="cadastrar-gerente.jsp" class="nav-link">
                                                    <i class="fas fa-user-plus nav-icon"></i>
                                                    <p>Cadastrar gerentes</p>
                                                </a>
                                            </li>

                                        </ul>
                                    </li>
                                </ul>

                                <ul class="nav nav-treeview">
                                    <li class="nav-item menu-open">
                                        <a href="#" class="nav-link">
                                            <i class="fas fa-map-marker-alt nav-icon"></i>
                                            <p>
                                                Vacinas
                                                <i class="right fas fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="gerenciar-vacina.jsp" class="nav-link active">
                                                    <i class="fas fa-map nav-icon"></i>
                                                    <p>Consultar Vacina </p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="selecionar-vacina.jsp" class="nav-link">
                                                    <i class="fas fa-map-pin nav-icon"></i>
                                                    <p>Selecionar Vacina </p>
                                                </a>
                                            </li>

                                        </ul>
                                    </li>
                                </ul>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item ">
                                        <a href="#" class="nav-link">
                                            <i class="fas fa-map-marker-alt nav-icon"></i>
                                            <p>
                                                Suporte CIVA
                                                <i class="right fas fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="telanovasuporte.jsp" class="nav-link">
                                                    <i class="fas fa-map nav-icon"></i>
                                                    <p>Consultar suporte CIVA </p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="telanovacadsuporteciva.jsp" class="nav-link">
                                                    <i class="fas fa-map-pin nav-icon"></i>
                                                    <p>Cadastrar Suporte CIVA </p>
                                                </a>
                                            </li>

                                        </ul>
                                    </li>
                                </ul>


                                <ul class="nav nav-treeview">
                                    <li class="nav-item ">
                                        <a href="#" class="nav-link">
                                            <i class="fas fa-syringe nav-icon"></i>
                                            <p>
                                                Unidades
                                                <i class="right fas fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="pesquisar-unidade.jsp" class="nav-link">
                                                    <i class="fas fa-search nav-icon"></i>
                                                    <p>Consultar unidade </p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="cadastrar-unidade.jsp" class="nav-link">
                                                    <i class="fas fa-mouse-pointer nav-icon"></i>
                                                    <p>Cadastrar Unidade</p>
                                                </a>
                                            </li>

                                        </ul>
                                    </li>
                                </ul>



                                <!-- ITEM RELATORIO USUARIO DO MENU -->
                            <li class="nav-item">
                                <a href="./relatorio.jsp" class="nav-link">
                                    <i class="nav-icon fas fa-chart-pie"></i>
                                    <p>
                                        Relatorio
                                    </p>
                                </a>
                            </li>

                            <!-- ITEM PERFIL DO MENU -->
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fas fa-user-circle"></i>
                                    <p>
                                        Perfil
                                        <i class="right fas fa-angle-left"></i>

                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="./meus-dados.jsp" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>
                                                Meus dados
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="./idioma.jsp" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>
                                                Mudar Idioma
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="./manual.jsp" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>
                                                Manual CIVA
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="solicitacoes.jsp" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>
                                                Solicita&ccedil;&otilde;es pendentes
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="../login/index.jsp" class="nav-link">
                                            <i class="fas fa-sign-out-alt nav-icon"></i>
                                            <p>
                                                Sair
                                            </p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                    <!-- /.sidebar-menu -->
                </div>

                <!-- /.sidebar ------------------------------------------------------>
            </aside>

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
                                        <span aria-hidden="true">×</span>
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
            <footer class="main-footer">
                <!-- Default to the left -->
                <strong>CIVA &copy; <a href="">Forsoft Academy</a>.</strong>
            </footer>

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