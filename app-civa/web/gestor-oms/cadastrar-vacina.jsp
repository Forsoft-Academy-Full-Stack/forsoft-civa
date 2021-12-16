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
<script src="../public/assets/js/gestor-oms/cadastrar-vacina.js" defer></script>
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
                            <h1 class="m-0">Cadastrar Vacina</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Cadastrar Vacina</li>
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

                    <div class="row mb-3">
                        <div class="col-xl-12">

                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Dose</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-vacina">
                                   
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-xl-12">
                                                <label for="nome">Nome</label>
                                                <input type="text" class="form-control" id="nome" name="nome">
                                            </div>
                                            <div class="form-group col-xl-12">

                                                <label for="lab">Laborat&oacute;rio</label>
                                                <input type="text" class="form-control" id="lab" name="lab">

                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="form-group col-xl-12">
                                                <label for="tipo-vacina">Tipo de Vacina</label>
                                                <input type="text" class="form-control" id="tipo-vacina" name="tipo-vacina">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-12">
                                                <label for="doses">Quantidade de Doses</label>
                                                <select class="select2 select2-hidden-accessible" id="doses" name="doses" style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                    <option selected disabled>Selecionar</option>
                                                    <option value="1">1 Dose</option>
                                                    <option value="2">2 Doses</option>
                                                    <option value="3">3 Doses</option>
                                                </select>
                                            </div>
                                        </div>


                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="intervalo-dose">Intervalo das Doses (em dias)</label>
                                                <input type="text" class="form-control" id="intervalo-dose" name="intervalo-dose">
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="tempo-reforco">Tempo para Refor&ccedil;o (em dias)</label>
                                                <input type="text" class="form-control" id="tempo-reforco" name="tempo-reforco">
                                            </div>

                                        </div>
                                    </div>
                                      <input type="hidden" value="cadastrar" class="form-control" id="option" name="option">                                   
                                </form>
                            </div>                         
                        </div>


                        <div class="col-12 mb-4">
                            <button type="button" class="btn btn-primary btn-lg" id="cadastrar">Cadastrar</button>
                        </div>

                        <!-- /.row -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->                
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf" %>
    </div>
    <!-- ./wrapper -->

</body>
</html>