<%@include file="header.xhtml"%>
    <script src="../public/assets/js/cadastrar-gestor-nacional.js" defer></script>
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
                    <a href="" class="nav-link">Portador CIVA</a>
                </li>
            </ul>
        </nav>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <aside class="main-sidebar sidebar-dark-primary elevation-4">
            <!-- Brand Logo -->
            <a href="./index.jsp" class="brand-link">
                <img src="../public/img/favicon-gs.svg" alt="AdminLTE Logo" class="brand-image img-circle"
                    style="opacity: .8">
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
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                        data-accordion="false">
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

                        <li class="nav-item menu-open">
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
                                            <a href="./consultar-portador.jsp" class="nav-link">
                                                <i class="fas fa-search nav-icon"></i>
                                                <p>Consultar Portador</p>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="./cadastrar-portador.jsp" class="nav-link">
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
                                            <a href="./consultar-gerente.jsp" class="nav-link">
                                                <i class="fas fa-clipboard-check nav-icon"></i>
                                                <p>Consultar Gerente</p>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="./cadastrar-gerente.jsp" class="nav-link">
                                                <i class="fas fa-user-plus nav-icon"></i>
                                                <p>Cadastrar Gerente</p>
                                            </a>
                                        </li>

                                    </ul>
                                </li>
                            </ul>
                            <ul class="nav nav-treeview">
                                <li class="menu-open">
                                    <a href="#" class="nav-link active">
                                        <i class="fas fa-user-friends nav-icon"></i>
                                        <p>
                                            Gestores nacionais
                                            <i class="right fas fa-angle-left"></i>
                                        </p>
                                    </a>
                                    <ul class="nav nav-treeview">
                                        <li class="nav-item">
                                            <a href="./consultar-gestor-nacional.jsp" class="nav-link">
                                                <i class="fas fa-clipboard-check nav-icon"></i>
                                                <p>Consultar Gestor nacional</p>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="./cadastrar-gestor-nacional.jsp" class="nav-link active">
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
                                            <a href="./consultar-supervisor.jsp" class="nav-link">
                                                <i class="fas fa-clipboard-check nav-icon"></i>
                                                <p>Consultar supervisor</p>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="./cadastrar-supervisor.jsp" class="nav-link">
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
                                            <a href="./consultar-unidades.jsp" class="nav-link">
                                                <i class="fas fa-search nav-icon"></i>
                                                <p>Consultar unidade </p>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="./cadastrar-unidade.jsp" class="nav-link">
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
                                        <i class="fas fa-address-card nav-icon"></i>
                                        <p>
                                            Meus dados
                                        </p>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="./idioma.jsp" class="nav-link">
                                        <i class="fas fa-language nav-icon"></i>
                                        <p>
                                            Mudar Idioma
                                        </p>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="./manual.jsp" class="nav-link">
                                        <i class="fas fa-question-circle nav-icon"></i>
                                        <p>
                                            Manual CIVA
                                        </p>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="./solicitacoes.jsp" class="nav-link">
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
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Cadastrar Gestor Nacional</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="index.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Cadastrar Gestor nacional</li>
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
                    <!-- DADOS PORTADOR -->
                    <div class="row">
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Gestor nacional</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- Incio do form -->
                                <!-- Incio do form -->
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@ include file="../partials/dadospessoais-ps-cadastro.jspf" %>
                                        <hr>

                                        <%@ include file="../partials/enderecos-cadastro.jspf" %>

                                        <hr>
                                        <%@ include file="../partials/contatos-cadastro.jspf" %> 
                                    </div>

                                </form>
                                <!-- /.form ending -->
                            </div>
                            <!-- /.card-body -->
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
              
                <div class="row">
                    <div class="col-12 mb-4 ml-2">
                        <button type="button" class="btn btn-primary btn-lg" id="salvar">Salvar</button>
                    </div>
                </div>
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
       <%@include file="footer.xhtml"%>
    </div>
    <!-- ./wrapper -->

    <!-- REQUIRED SCRIPTS ------------------------------------------------------->

</body>

</html>