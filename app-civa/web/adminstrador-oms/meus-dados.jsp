<%@page import="dao.SuporteCivaDao"%>
<%@page import="dao.SuporteCivaDao"%>
<%@page import="model.SuporteCiva"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Por favor não remover include nem head-->
<!--a abertura do head é feita no header.jspf-->
<!--Dessa forma fica menos poluído-->
<!--os links e scripts base ficam nesse header.jspf-->
<!--então aqui é chamado o js especifico para cada página -->
<!--e por fim o head é fechado -->
<%@include file="header.jspf"%>
<script src="../public/assets/js/suporte-civa/meus-dados.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include  file="menu.jspf"%>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Meus Dados</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Meus Dados</li>
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
                                    <h3 class="card-title">Dados Administrador OMS</h3>
                                </div>

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

                                <!-- /.card-header -->
                                <!-- form start -->

                            </div>
                        </div>
                    </div>
                    <!-- /.row -->

                    <!-- TABELA VACINAS -->
                    <!--
                    <div class="row">
                        <div class="col-12 mb-2">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Unidade vinculadas</h3>

                                    <div class="card-tools">
                                        <div class="input-group input-group-sm" style="width: 150px;">

                                            <div class="input-group-append">


                                            </div>
                                        </div>
                                    </div>
                                </div>
                              
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
                                                <td>Hospital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td>215648</td>

                                            </tr>
                                            <tr>
                                                <td>Hospital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td>215648</td>

                                            </tr>
                                            <tr>
                                                <td>Hospital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td>215648</td>

                                            </tr>
                                            <tr>
                                                <td>Hospital Pan</td>
                                                <td>Rio de Janeiro</td>
                                                <td>12016-102</td>
                                                <td>215648</td>

                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                               
                            </div>
                        </div>
                    </div>
                    -->

                    <div class="row">
                        <div class="col-12 mb-4">
                            <!--button type="button" id="salvar" class="btn btn-primary btn-lg" >Salvar</button-->
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->
            <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Cadastro realizado com sucesso!</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">Ã</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p></p>
                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal"
                                    onclick="location.href = './meus-dados.jsp'">Close</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.content -->
            </div>
        </div>
        <!-- /.content -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- /.content-wrapper -->


    <!-- ./wrapper -->

</body>

</html>