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
<script src="../public/assets/js/gestor-oms/cadastros-pendentes.js" defer></script>
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
                            <h1 class="m-0">Solicita&ccedil;&otilde;es pendentes</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./">Voltar</a></li>
                                <li class="breadcrumb-item active">Cadastros pendentes</li>
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
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="mt-2 float-sm-left">Brasil</h4>
                                    <p class="mt-2 float-sm-right">Data do Inicio do Cadastro: 01/01/2021 </p>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <div class="profile-username"><span>
                                                <a href="cadastrar-gestor-nacional.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="#" class="link-secondary">Editar</a></span> <span>Dados do Pa&iacute;s</span></div>
                                        <div class="profile-username"><span><a href="cadastrar-documentacoes.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="cadastrar-documentacoes.jsp" class="link-secondary">Editar</a></span> <span>Documenta&ccedil;&otilde;es</span></div>
                                        <div class="profile-username"><span><a href="cadastrar-gestor-nacional.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="cadastrar-gestor-nacional.jsp" class="link-secundary">Editar</a></span> <span>Gestor Nacional</span>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                    <button class="btn btn-outline-danger">Cancelar Cadastro</button>
                                    <button class="btn btn-outline-secondary">Exportar Cadastro</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="mt-2 float-sm-left">Estados Unidos</h4>
                                    <p class="mt-2 float-sm-right">Data do Inicio do Cadastro: 01/01/2021 </p>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <div class="profile-username"><span>
                                                <a href="cadastrar-gestor-nacional.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="#" class="link-secondary">Editar</a></span> <span>Dados do Pa&iacute;s</span></div>
                                        <div class="profile-username"><span><a href="cadastrar-documentacoes.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="cadastrar-documentacoes.jsp" class="link-secondary">Editar</a></span> <span>Documenta&ccedil;&otilde;es</span></div>
                                        <div class="profile-username"><span><a href="cadastrar-gestor-nacional.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="cadastrar-gestor-nacional.jsp" class="link-secundary">Editar</a></span> <span>Gestor Nacional</span>
                                        </div>
                                    </div>
                                </div>

                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                    <button class="btn btn-outline-danger">Cancelar Cadastro</button>
                                    <button class="btn btn-outline-secondary">Exportar Cadastro</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="mt-2 float-sm-left">Canad&aacute;</h4>
                                    <p class="mt-2 float-sm-right">Data do Inicio do Cadastro: 01/01/2021 </p>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <div class="profile-username"><span>
                                                <a href="cadastrar-gestor-nacional.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="#" class="link-secondary">Editar</a></span> <span>Dados do Pa&iacute;s</span></div>
                                        <div class="profile-username"><span><a href="cadastrar-documentacoes.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="cadastrar-documentacoes.jsp" class="link-secondary">Editar</a></span> <span>Documenta&ccedil;&otilde;es</span></div>
                                        <div class="profile-username"><span><a href="cadastrar-gestor-nacional.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="cadastrar-gestor-nacional.jsp" class="link-secundary">Editar</a></span> <span>Gestor Nacional</span>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                    <button class="btn btn-outline-danger">Cancelar Cadastro</button>
                                    <button class="btn btn-outline-secondary">Exportar Cadastro</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="mt-2 float-sm-left">Argentina</h4>
                                    <p class="mt-2 float-sm-right">Data do Inicio do Cadastro: 01/01/2021 </p>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <div class="profile-username"><span>
                                                <a href="cadastrar-gestor-nacional.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="#" class="link-secondary">Editar</a></span> <span>Dados do Pa&iacute;s</span></div>
                                        <div class="profile-username"><span><a href="cadastrar-documentacoes.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="cadastrar-documentacoes.jsp" class="link-secondary">Editar</a></span> <span>Documenta&ccedil;&otilde;es</span></div>
                                        <div class="profile-username"><span><a href="cadastrar-gestor-nacional.jsp" class="link-primary">Cadastrar</a> <b>|</b> <a href="cadastrar-gestor-nacional.jsp" class="link-secundary">Editar</a></span> <span>Gestor Nacional</span>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                    <button class="btn btn-outline-danger">Cancelar Cadastro</button>
                                    <button class="btn btn-outline-secondary">Exportar Cadastro</button>
                                </div>
                            </div>
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
    <!-- ./wrapper -->

</body>
</html>
