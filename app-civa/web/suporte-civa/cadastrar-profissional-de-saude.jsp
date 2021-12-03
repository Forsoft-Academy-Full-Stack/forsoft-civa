<%@page import="dao.ProfissionalSaudeDao"%>
<%@page import="java.util.List"%>
<%@page import="model.ProfissionalSaude"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é supervisor
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("suporte-civa"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }
    // Caso contrário é um usuário válido, pode entrar na página
%>


<%@include file="header.jspf"%>
<script src="../public/assets/js/supervisor/cadastrar-profissional-de-saude.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@ include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Cadastrar Profissional de Sa&uacute;de</h1>
                        </div><!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Cadastrar Profissional de Sa&uacute;de</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->

                    <div class="row">
                        <div class="col-12">

                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Profissional de Sa&uacute;de</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados" action="#" method="post">
                                    <div class="card-body">
                                        <%@ include file="../partials/dadospessoais-ps-cadastro.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/enderecos-cadastro.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/contatos-cadastro.jspf" %>
                                    </div>

                                </form>
                            </div>
                        </div>

                        <div class="col-12 mb-4">
                            <button type="submit" class="btn btn-primary btn-lg" form="form-meus-dados">Cadastrar</button>
                        </div>

                        <!-- /.row -->
                    </div>

                    <!-- /.row -->
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->
        <%@ include file="../partials/modals-cad.jspf" %>

        <!-- /.content-wrapper -->
        <!-- Main Footer -->
        <%@ include file="footer.jspf" %>
    </div>
    <!-- ./wrapper -->
    
</body>
</html>

