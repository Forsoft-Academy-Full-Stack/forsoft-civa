<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gestor-oms"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/gestor-oms/cadastrar-pais.js" defer></script>
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
                            <h1 class="m-0">Cadastrar Pa&iacute;s</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Cadastrar Pa&iacute;s</li>
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

                    <div class="card card-primary card-outline card-outline-tabs">
                        <div class="card-header p-0 border-bottom-0">
                            <ul class="nav nav-tabs" id="custom-tabs-four-tab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="custom-tabs-four-country-tab" data-toggle="pill" href="#custom-tabs-four-country" role="tab" aria-controls="custom-tabs-four-country" aria-selected="true">Dados Pa&iacute;s</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="custom-tabs-four-national-tab" data-toggle="pill" href="#custom-tabs-four-national" role="tab" aria-controls="custom-tabs-four-national" aria-selected="false">Dados Gestor Nacional</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="custom-tabs-four-support-tab" data-toggle="pill" href="#custom-tabs-four-support" role="tab" aria-controls="custom-tabs-four-support" aria-selected="false">Dados Suporte CIVA</a>
                                </li>                                                    
                            </ul>
                        </div>
                        <div class="card-body">
                            <div class="tab-content" id="custom-tabs-four-tabContent">
                                <div class="tab-pane fade show active" id="custom-tabs-four-country" role="tabpanel" aria-labelledby="custom-tabs-four-country-tab">
                                    <form id="dados-pais">
                                        <%@include file="../partials/dados-pais-cadastro.jspf" %>
                                        <hr class = "mb-4 mt-4">
                                        <%@include file="../partials/gestor-oms/tipo-doc-cadastro-gn.jspf" %>
                                        <hr class = "mb-4 mt-4">
                                        <%@include file="../partials/dados-pais-divisao-territorial-cadastro.jspf" %>
                                        <input type="hidden" value="cadastrar" class="form-control" id="option" name="option">
                                    </form>
                                </div>
                                <div class="tab-pane fade" id="custom-tabs-four-national" role="tabpanel" aria-labelledby="custom-tabs-four-national-tab">
                                    <form id="dados-gestor-nacional">
                                        <%@include file="../partials/gestor-oms/dadospessoais-ps-cadastro-gn.jspf" %>
                                        <hr class = "mb-4 mt-4">
                                        <%@ include file="../partials/gestor-oms/enderecos-cadastro-gn.jspf" %>
                                        <hr class = "mb-4 mt-4">
                                        <%@ include file="../partials/gestor-oms/contatos-cadastro-gn.jspf" %>
                                    </form>
                                </div>
                                <div class="tab-pane fade" id="custom-tabs-four-support" role="tabpanel" aria-labelledby="custom-tabs-four-support-tab">
                                    <form id="dados-suporte-civa">
                                        <%@include file="../partials/dadospessoais-ps-cadastro.jspf" %>
                                        <hr class = "mb-4 mt-4">
                                        <%@ include file="../partials/enderecos-cadastro.jspf" %>
                                        <hr class = "mb-4 mt-4">
                                        <%@ include file="../partials/contatos-cadastro-suporte.jspf" %>
                                    </form>
                                </div>                                                    
                            </div>
                        </div>
                        <!-- /.card -->
                    </div>

                    <div class="row">
                        <div class="col-12 mb-4">
                            <button type="button" class="btn btn-primary btn-lg" id="cadastrar">Cadastrar</button>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->                
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf" %>
    </div>

</body
</html>