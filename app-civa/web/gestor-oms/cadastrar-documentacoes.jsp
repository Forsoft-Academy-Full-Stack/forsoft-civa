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
    <script src="../public/assets/js/gestor-oms/cadastrar-documentacoes.js" defer></script>
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
                            <h1 class="m-0">Cadastrar documenta&ccedil;&atilde;o</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Cadastrar documento</li>
                            </ol>
                        </div>
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
                                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href = './indexsupervisor.jsp'">Close</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.content -->
                </div>
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
                                    <h3 class="card-title">Documenta&ccedil;&atilde;o Cidad&atilde;o</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados">
                                    <div class="p-2">
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="doc-nacional">Nome documenta&ccedil;&atilde;o nacional</label>
                                                <input type="text" class="form-control" id="doc-nacional" placeholder="Ex: CPF">
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="formato-nacional">Formato documenta&ccedil;&atilde;o nacional</label>
                                                <input type="text" class="form-control" id="formato-nacional" placeholder="Ex: NNH-NNN-NHN">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="doc-adicional">Nome documenta&ccedil;&atilde;o adicional</label>
                                                <input type="text" class="form-control" id="doc-acional" placeholder="Ex: CNH">
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="formato-adc">Formato documenta&ccedil;&atilde;o adicional</label>
                                                <input type="text" class="form-control" id="formato-adc" placeholder="Ex: NNH-NNN-NHN">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-3">
                                                <button class="btn btn-block btn-primary btn-sm">Adicionar documenta&ccedil;&atilde;o adicional</button>
                                            </div>
                                        </div>

                                    </div>
                            </div>

                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Documenta&ccedil;&atilde;o Profissional de Sa&uacute;de</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados">
                                    <div class="p-2">
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="doc-nacional-profissional">Nome documenta&ccedil;&atilde;o Profissional de Sa&uacute;de</label>
                                                <input type="text" class="form-control" id="doc-nacional-profissional" placeholder="Ex: CRM">
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="formato-nacional-profissional">Formato documenta&ccedil;&atilde;o Profissional de Sa&uacute;de</label>
                                                <input type="text" class="form-control" id="formato-nacional-profissional" placeholder="Ex: NNH-NNN-NHN">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-3">
                                                <button class="btn btn-block btn-primary btn-sm">Adicionar documenta&ccedil;&atilde;o adicional</button>
                                            </div>
                                        </div>

                                    </div>
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
