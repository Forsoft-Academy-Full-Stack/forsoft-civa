<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("supervisor"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/supervisor/painel-unidade.js" defer ></script>
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
                            <h1 class="m-0">Painel Unidade</h1>
                        </div><!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel Unidade</li>
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
                        <div class="col-12 mb-3">


                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Meus dados</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@ include file="../partials/dados-unidade-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/enderecos-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/contatos-unidade-disabled.jspf" %>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>

                    <!-- TABELA VACINAS -->
                    <div class="row">
                        <div class="col-12 mb-2">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Profissionais de Sa&uacute;de Vinculados</h3>

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
                                                <th>Identidade</th>
                                                <th>C&oacute;digo CIVA</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>
                                            </tr>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>
                                            </tr>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>
                                            </tr>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>   
                                            </tr>
                                        </tbody>
               
                                    </table>
                                    <hr>
                                    <div class="row ">
                                        <div class="col d-flex justify-content-xl-start  ml-4 mb-2">
                                            <a href="./vincular-profissional-saude.jsp" class="btn btn-success btn-xs">Vincular Supervisor</a>
                                        </div>                                  

                                        <div class="col  d-flex justify-content-xl-end align-items-center ml-2 mb-2 mr-4">
                                            <a href="./vincular-profissional-saude.jsp" class="btn btn-danger btn-xs">Desvincular Supervisor</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>

                    </div>

                </div><!-- /.container-fluid -->
                <%@ include file="../partials/modals-dados-salvos.jspf" %>
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@ include file="footer.jspf" %>
    </div>
    <!-- ./wrapper -->
</body>
</html>
