<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("suporte-civa"))) {
        // Caso for uma das duas opções
        // Redicionar para o login
        response.sendRedirect("../login/");

    }
   // Caso contrário é um usuário válido, pode entrar na página
%>
<%@include file="header.xhtml"%>
    <script src="../public/assets/js/vincular-unidade.js" defer></script>

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
                    <a href="" class="nav-link">Vincular unidade</a>
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
                                <li class="menu-open">
                                    <a href="#" class="nav-link active">
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
                            <h1 class="m-0">Vincular Unidade</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./gerenciar-supervisor.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Vincular unidade</li>
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
                            <div class="row">
                                <div class="col-xl-12 col-sm-12">
                                    <div class="input-group  mb-2">
                                        <input type="text" class="form-control" id="pesquisar" name="pesquisar"
                                            placeholder="Pesquisar por unidade">
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-secondary" type="button" id="button-addon2"
                                                name="button-addon2">Pesquisar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Unidade</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- Incio do form -->

                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="name">Nome da unidade</label>
                                                <input type="text" id="name-unidade" name="name-unidade"
                                                    class="form-control" value="Hospital e maternidade santos" readonly>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="documento-registro">Documento de registro</label>
                                                <input type="text" id="documento-registro" name="documento-registro"
                                                    class="form-control" value="24.456456/5" readonly>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="natureza">Natureza</label>
                                                <select disabled class="select2 select2-hidden-accessible"
                                                    style="width: 100%;" tabindex="-1" aria-hidden="true" id="natureza"
                                                    name="natureza">
                                                    <option value="pub" disabled>Selecionar</option>
                                                    <option value="pub" select>P&uacute;blica</option>
                                                    <option value="priv">Privada</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="tipo-estabelecimento">Tipo de Estabelecimento</label>
                                                <select disabled class="select2 select2-hidden-accessible"
                                                    style="width: 100%;" tabindex="-1" aria-hidden="true"
                                                    id="tipo-estabelecimento" name="tipo-estabelecimento">
                                                    <option value="hospital" selected readonly>Hospital</option>
                                                </select>
                                            </div>

                                        </div>


                                        <hr>

                                        <div class="row">
                                            <div class="form-group col-xl-12">
                                                <label for="pais">Pa&iacute;s</label>
                                                <input type="text" id="pais" name="pais" class="form-control"
                                                    value="Brazil" readonly>
                                            </div>
                                        </div>


                                        <div class="row">

                                            <div class="form-group col-xl-12">
                                                <label for="codigopostal">CEP</label>
                                                <input type="text" class="form-control" id="codigopostal"
                                                    name="codigopostal" placeholder="Ex: 000000-000" maxlength="9"
                                                    value="20520-054" readonly>
                                            </div>
                                        </div>


                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="endereco">Endere&ccedil;o</label>
                                                <input type="text" id="endereco" name="endereco" class="form-control"
                                                    value="Vila peri" readonly>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="numero">N&uacute;mero</label>
                                                <input type="number" class="form-control" id="numero" name="numero"
                                                    placeholder="Ex: 000000-000" maxlength="9" value="123" readonly>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="complemento">Complemento</label>
                                                <input type="text" id="complemento" name="complemento"
                                                    class="form-control" value="Apto 1107 bloco 2" readonly>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="bairro">Bairro</label>
                                                <input type="text" class="form-control" id="bairro" name="bairro"
                                                    placeholder="Ex: 000000-000" maxlength="9" value="Queimados"
                                                    readonly>
                                            </div>

                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="municipio">Municipio</label>
                                                <input type="text" id="municipio" name="municipio" class="form-control"
                                                    value="Niter&oacute;i" readonly>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="estado">Estado</label>
                                                <input type="text" class="form-control" id="estado" name="estado"
                                                    placeholder="Cear&aacute;" maxlength="9" value="Rio de Janeiro" readonly>
                                            </div>

                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="contato1">Contato</label>
                                                <input type="tel" class="form-control" id="contato1" name="contato1"
                                                    placeholder="Ex: 000000-000" maxlength="9" value="2199887755"
                                                    readonly>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="locacao">Loca&ccedil;&atilde;o</label>
                                                <input type="text" id="locacao" name="locacao" class="form-control"
                                                    value="Sua Locacao" readonly>
                                            </div>
                                        </div>
                                    </div>

                                </form>
                                <!-- /.form ending -->
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->

                    <div class="row">
                        <div class="col-12 mb-4">
                            <button type="button" id="salvar" class="btn btn-primary btn-lg">Vincular</button>
                        </div>
                    </div>
                </div>



            </div>
            <!-- /.container-fluid -->
            <!-- modal -->
            <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Unidade cadastrada com sucesso!</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">Ã</span>
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
                                <span aria-hidden="true">Ã</span>
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
        </div>
        <!-- /.content -->
        <!-- Main Footer -->
         <%@include file="footer.xhtml"%>
    </div>
    <!-- /.content-wrapper -->

    <!-- ./wrapper -->

</body>

</html>