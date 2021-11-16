<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("profissional-saude"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");
    }

    // Caso contrário é um usuário válido, pode entrar na página  
%>
<%@include file="header.jspf"%>
    <script src="../public/assets/js/profissional-saude/solicitacoes.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@ include file="./navbar.jspf" %>

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>
        <!-- /.sidebar ------------------------------------------------------>
        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Solicita&ccedil;&otilde;es pendentes</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Home</li>
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
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    Status: <b>Pendente</b>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nesciunt voluptatem rerum dolorum
                                            impedit officiis quae, reiciendis asperiores nam quaerat aliquid velit iste ea ullam assumenda
                                            voluptates, molestias dolores accusamus quisquam!
                                        </p>
                                    </div>
                                    <p class="mt-2">Data solicita&ccedil;&atilde;o: 01/01/2021 </p>
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                    <button type="button" onclick="cancelarSolicitacao()" class="btn btn-outline-danger">Cancelar solicita&ccedil;&atilde;o</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    Status: <b>Pendente</b>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nesciunt voluptatem rerum dolorum
                                            impedit officiis quae, reiciendis asperiores nam quaerat aliquid velit iste ea ullam assumenda
                                            voluptates, molestias dolores accusamus quisquam!
                                        </p>
                                    </div>
                                    <p class="mt-2">Data solicita&ccedil;&atilde;o: 01/01/2021 </p>
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                    <button type="button" onclick="cancelarSolicitacao()" class="btn btn-outline-danger">Cancelar solicita&ccedil;&atilde;o</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    Status: <b>Pendente</b>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nesciunt voluptatem rerum dolorum
                                            impedit officiis quae, reiciendis asperiores nam quaerat aliquid velit iste ea ullam assumenda
                                            voluptates, molestias dolores accusamus quisquam!
                                        </p>
                                    </div>
                                    <p class="mt-2">Data solicita&ccedil;&atilde;o: 01/01/2021 </p>
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                    <button type="button" onclick="cancelarSolicitacao()" class="btn btn-outline-danger">Cancelar solicita&ccedil;&atilde;o</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    Status: <b>Pendente</b>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nesciunt voluptatem rerum dolorum
                                            impedit officiis quae, reiciendis asperiores nam quaerat aliquid velit iste ea ullam assumenda
                                            voluptates, molestias dolores accusamus quisquam!
                                        </p>
                                    </div>
                                    <p class="mt-2">Data solicita&ccedil;&atilde;o: 01/01/2021 </p>
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                    <button type="button" onclick="cancelarSolicitacao()" class="btn btn-outline-danger">Cancelar
                                        solicita&ccedil;&atilde;o</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        <!-- Main Footer -->
        <%@ include file="footer.jspf" %>
        <!-- ./footer -->
    </div>
    <!-- ./wrapper -->

</body>
</html>