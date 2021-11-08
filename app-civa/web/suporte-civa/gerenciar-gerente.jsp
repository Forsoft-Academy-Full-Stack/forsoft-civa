<%@include file="header.xhtml"%>
    <script src="../public/assets/js/gerenciar-gerente.js" defer></script>
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
                    <a href="" class="nav-link">Suporte CIVA</a>
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
                                <li class="nav-item ">
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
                                <li class=" menu-open">
                                    <a href="#" class="nav-link active">
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
                                            <a href="./consultar-gestor-nacional.jsp" class="nav-link">
                                                <i class="fas fa-clipboard-check nav-icon"></i>
                                                <p>Consultar Gestor nacional</p>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="./cadastrar-gestor-nacional.jsp" class="nav-link">
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
                            <h1 class="m-0">Gerenciar Gerente</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./consultar-gerente.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Gerenciar Gerente</li>
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
                                    <h3 class="card-title">Dados Gerente</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- Incio do form -->
                                <!-- Incio do form -->
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@ include file="../partials/codigociva.jspf" %>
                                        <%@ include file="../partials/dadospessoais-ps-disabled.jspf" %>
                                         <hr>
                                        <%@ include file="../partials/enderecos-disabled.jspf" %>
                                         <hr>
                                       <%@ include file="../partials/contatos-disabled.jspf" %>
                                    </div>

                                </form>
                                <!-- /.form ending -->
                            </div>
                            <!-- /.card-body -->
                        </div>
                    </div>
                    <!-- /.row -->

                    <div class="row">
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Unidades Vinculadas</h3>
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
                                                <th>Estado</th>
                                                <th>CEP</th>
                                                <th>Identificador</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Hopital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td>215648</td>
                                            </tr>
                                            <tr>
                                                <td>Hopital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td>215648</td>
                                            </tr>
                                            <tr>
                                                <td>Hopital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td>215648</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <hr>
                                    <div class="d-flex justify-content-between align-items-center ml-2 mb-2">
                                        <a href="./vincular-unidade.jsp" class="btn btn-success btn-xs">Vincular
                                            Unidade</a>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 mb-4">
                            <button type="button" class="btn btn-primary btn-lg" id="salvar">Salvar</button>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->

            </div>

            <!-- modal -->
            <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Dados alterados com sucesso!</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p></p>
                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Finalizar</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- modal erro -->
            <div class="modal fade" id="modal-default2" style="display: none;" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Todos os dados obrigatorios devem ser preenchidos!</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p></p>
                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Finalizar</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.xhtml"%>
    </div>
    <!-- ./wrapper -->

</body>

</html>