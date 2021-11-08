<%@include file="header.xhtml"%>
<script src="./../public/assets/js/cadastrar-portador.js" defer></script>
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
                    <a href="" class="nav-link">Cadastrar portador</a>
                </li>
            </ul>
        </nav>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>
        <!-- TERMINO DO MENU LATERAL -->
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Cadastrar Portador</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="../index.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Cadastrar portador</li>
                            </ol>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- content -->
                <div class="content">
                    <div class="container-fluid">
                        <!-- container-fluid -->
                        <div class="row">
                            <!-- row -->
                            <div class="col-md-12">
                                <!-- col -->
                                <div class="card card-primary">
                                    <!-- cards -->
                                    <div class="card-header">
                                        <!-- /.cardheader -->
                                        <h3 class="card-title">Dados Portador</h3>
                                    </div>
                                    <!-- /.cardheader -->
                                    <!-- Incio do form -->
                                    <form id="form-meus-dados">
                                        <div class="card-body">

                                            <%@ include file="../partials/dadospessoais-cadastro.jspf" %>
                                            <hr>
                                            <%@ include file="../partials/enderecos-cadastro.jspf" %>
                                            <hr>
                                            <%@ include file="../partials/contatos-cadastro.jspf" %>

                                        </div>

                                    </form>
                                    <!-- /.form ending -->
                                </div>
                                <!-- /.cards -->
                            </div>

                            <div class="col-12 mb-4 ">
                                <button type="button" class="btn btn-primary btn-lg" id="salvar">Cadastrar</button>
                            </div>

                        </div>




                        <!-- /.row -->
                    </div>

                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content -->
        <!-- modal -->
        <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Cadastro realizado com sucesso!</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p></p>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onclick="location.href = '../ndex.jsp'">Finalizar</button>
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

        <!-- Main Footer -->
        <!-- Main Footer -->
        <%@include file="footer.xhtml"%>

    </div>
    <!-- ./wrapper -->

</body>

</html>