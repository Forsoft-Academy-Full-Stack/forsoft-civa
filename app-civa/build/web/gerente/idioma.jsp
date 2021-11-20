<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gerente"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/gerente/idioma.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@ include file="../partials/gerente/navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="../partials/gerente/menu.jspf" %>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Mudar idioma</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">

                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>

                                <li class="breadcrumb-item active">Mudar idioma</li>
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
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="form-group col-12">
                                        <label for="idioma">Idioma</label>
                                        <select
                                            class="select2 select2-hidden-accessible"
                                            id="idioma"
                                            name="idioma"
                                            style="width: 100%"
                                            tabindex="-1"
                                            aria-hidden="true"
                                            >
                                            <option value="2" selected>
                                                Portugu&ecirc;s (Brasil)
                                            </option>
                                            <option value="3">English (US)</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12 mb-4">
                            <button
                                type="submit"
                                class="btn btn-primary btn-lg"
                                form="form-meus-dados"
                                >
                                Salvar altera&ccedil;&atilde;o
                            </button>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@ include file="../partials/gerente/footer.jspf" %>
    </div>
    <!-- ./wrapper -->
</body>
</html>
