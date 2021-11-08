<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CIVA - Home</title>

        <link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/favicon-gs.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

        <!-- Font Icons Google -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round"
              rel="stylesheet">

        <!-- Estilo icones -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/public/plugins/fontawesome-free/css/all.min.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/adminlte.min.css">

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
                        <a href="" class="nav-link">Home</a>
                    </li>
                </ul>
            </nav>
            <!-- /.navbar ------------------------------------------------------->

            <!-- MENU Main Sidebar Container ------------------------------------>
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Brand Logo -->
                <a href="./index.jsp" class="brand-link">
                    <img src="${pageContext.request.contextPath}/public/img/favicon-gs.svg" alt="AdminLTE Logo" class="brand-image img-circle"
                         style="opacity: .8">
                    <span class="brand-text font-weight-light">CIVA</span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div class="image">
                            <img src="${pageContext.request.contextPath}/public/img/no-user.svg" class="img-circle elevation-2" alt="User Image">
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
                                <a href="./index.jsp" class="nav-link active">
                                    <i class="nav-icon fas fa-home"></i>
                                    <p>
                                        Home
                                    </p>
                                </a>
                            </li>
                            <!-- ITEM GERENCIAR USUARIO DO MENU -->

                            <li class="nav-item ">
                                <a href="#" class="nav-link">
                                    <!-- <i class="nav-icon fas fa-user-friends"></i> -->
                                    <p>Suporte Civa
                                        <i class="right fas fa-angle-left"></i>

                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="nav-icon fas fa-user-friends"></i>
                                            <p>
                                                Portador CIVA
                                                <i class="right fas fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/suporte-civa/consultar-portador.jsp" class="nav-link">
                                                    <i class="fas fa-search nav-icon"></i>
                                                    <p>Consultar Portador</p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/suporte-civa/cadastrar-portador.jsp" class="nav-link">
                                                    <i class="fas fa-user-plus nav-icon"></i>
                                                    <p>Cadastrar Portador</p>
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
                                                Gerente
                                                <i class="right fas fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/suporte-civa/consultar-gerente.jsp" class="nav-link">
                                                    <i class="fas fa-clipboard-check nav-icon"></i>
                                                    <p>Consultar Gerente</p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/suporte-civa/cadastrar-gerente.jsp" class="nav-link">
                                                    <i class="fas fa-user-plus nav-icon"></i>
                                                    <p>Cadastrar Gerente</p>
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
                                                Gestores nacionais
                                                <i class="right fas fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/suporte-civa/consultar-gestor-nacional.jsp" class="nav-link">
                                                    <i class="fas fa-clipboard-check nav-icon"></i>
                                                    <p>Consultar Gestor nacional</p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/suporte-civa/cadastrar-gestor-nacional.jsp" class="nav-link">
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
                                                Supervisor
                                                <i class="right fas fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/suporte-civa/consultar-supervisor.jsp" class="nav-link">
                                                    <i class="fas fa-clipboard-check nav-icon"></i>
                                                    <p>Consultar supervisor</p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/suporte-civa/cadastrar-supervisor.jsp" class="nav-link">
                                                    <i class="fas fa-user-plus nav-icon"></i>
                                                    <p>Cadastrar supervisor</p>
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
                                                <a href="${pageContext.request.contextPath}/suporte-civa/consultar-unidades.jsp" class="nav-link">
                                                    <i class="fas fa-search nav-icon"></i>
                                                    <p>Consultar unidade </p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/suporte-civa/cadastrar-unidade.jsp" class="nav-link">
                                                    <i class="fas fa-mouse-pointer nav-icon"></i>
                                                    <p>Cadastrar Unidade</p>
                                                </a>
                                            </li>

                                        </ul>
                                    </li>
                                </ul>


                                <!-- ITEM RELATORIO USUARIO DO MENU -->
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/suporte-civa/relatorio.jsp" class="nav-link">
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
                                        <a href="${pageContext.request.contextPath}/suporte-civa/meus-dados.jsp" class="nav-link">
                                            <i class="fas fa-address-card nav-icon"></i>
                                            <p>
                                                Meus dados
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/suporte-civa/idioma.jsp" class="nav-link">
                                            <i class="fas fa-language nav-icon"></i>
                                            <p>
                                                Mudar Idioma
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/suporte-civa/manual.jsp" class="nav-link">
                                            <i class="fas fa-question-circle nav-icon"></i>
                                            <p>
                                                Manual CIVA
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/suporte-civa/solicitacoes.jsp" class="nav-link">
                                            <i class="fas fa-inbox nav-icon"></i>
                                            <p>
                                                Solicita&ccedil;&otilde;es pendentes
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
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

                <!-- Main content -->
                <div class="content">
                    <div class="container-fluid">
                        <!---------------------------------------------------------------->
                        <div class="row">
                            <!-- HOME PROFISSIONAL DA SA&Uacute;DE -->
                            <!-- Content Wrapper. Contains page content -->
                            <div class="col-md-12 mt-4 mb-5">
                                <!-- .content -->
                                <div class="jumbotron">
                                    <h1 class="display-4">Ol&aacute, Suporte CIVA!</h1>
                                    <hr class="my-4">
                                     <p>Bem vindo ao seu painel CIVA, ${dados.nome} ${dados.sobrenome}!</p>
                                </div>
                                <!-- /.content -->
                            </div>
                        </div>
                        <div class="row">
                        </div>
                        <!-- /.row -->
                    </div><!-- /.container-fluid -->
                </div>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <footer class="main-footer">
                <!-- Default to the left -->
                <strong><img src="${pageContext.request.contextPath}/public/img/icon-civa-footer-darkblue.svg" alt="logo civa" width="70px">&nbsp by <a href="https://www.forsoftacademy.com.br/" target="_blank">Forsoft Academy</a></strong>
            </footer>
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS ------------------------------------------------------->

        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/public/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="${pageContext.request.contextPath}/public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/public/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="${pageContext.request.contextPath}/public/dist/js/demo.js"></script>

    </body>
</html>
