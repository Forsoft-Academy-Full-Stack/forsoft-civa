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
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-xl-12">
                                                <label for="nationality">Nome</label>
                                                <select class="form-control" id="nome" name="nome">
                                                    <option selected>Selecionar</option>
                                                    <option>Coronavac</option>
                                                    <option>Pfizer</option>
                                                    <option>Astrazeneca</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-xl-12">
                                                <label for="nationality">Laborat&oacute;rio</label>
                                                <select class="form-control" id="lab" name="lab">
                                                    <option selected>Selecionar</option>
                                                    <option>sinovac</option>
                                                    <option>----</option>
                                                    <option>----</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-xl-12">
                                                <label for="exampleFormControlInput1">Tipo de Vacina</label>
                                                <input type="text" class="form-control" id="tipo-vacina" name="tipo-vacina">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-12">
                                                <label for="exampleFormControlSelect1">Quantidade de doses</label>
                                                <select class="select2 select2-hidden-accessible" id="doses" name="doses" style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                    <option selected>Selecionar</option>
                                                    <option value="2">1 Dose</option>
                                                    <option value="3">2 Dose</option>
                                                    <option value="3">3 Dose</option>
                                                </select>
                                            </div>
                                        </div>


                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlInput1">Intervalo das doses (em dias)</label>
                                                <input type="text" class="form-control" id="intervalo-dose" name="intervalo-dose">
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlInput1">Tempo para refor&ccedil;o (em dias)</label>
                                                <input type="text" class="form-control" id="tempo-reforco" name="tempo-reforco">
                                            </div>

                                        </div>
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
                                <button type="button" class="btn btn-default" data-dismiss="modal" form="form-meus-dados" onclick="location.href = 'o3cadastrarvacina.jsp'">Close</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.content -->
                </div>
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
