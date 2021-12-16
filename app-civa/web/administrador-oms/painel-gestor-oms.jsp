<%@page import="dao.GestorOmsDao"%>
<%@page import="model.GestorOms"%>
<%@page import="model.GestorOms"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("administrador-oms"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página
%>

<%    try {

        String codigoCivaGestorOms = request.getParameter("codigoCiva");
        GestorOms gestorOms = GestorOmsDao.findByCodigCiva(codigoCivaGestorOms);

        pageContext.setAttribute("ator", gestorOms);

    } catch (Exception e) {
    }

%> 
<%@include file="header.jspf"%>
<script src="../public/assets/js/administrador-oms/painel-gestor-oms.js" defer></script>
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
                            <h1 class="m-0">Painel Gestor OMS</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel Gestor OMS</li>
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


                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Gestor OMS</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@ include file="../partials/codigociva.jspf"%>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/dadospessoais-alteracao.jspf"%>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/enderecos-alteracao.jspf"%>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/contatos-alteracao.jspf"%>
                                        <input type="hidden" value="atualizar" class="form-control" id="option" name="option">
                                    </div>
                                </form>    

                                <form id="form-excluir">
                                    <input type="hidden" class="form-control" id="codigo-civa" name="codigo-civa" value="${ator.codigoCiva}" >
                                    <input type="hidden" value="deletar" class="form-control" id="option" name="option">
                                </form>
                            </div>
                        </div>

                        <div class="col-12 pb-4 d-flex justify-content-between">
                            <button type="button" id="salvar" class="btn btn-primary btn-lg" style="width:175px">Salvar</button>
                            <button type="button" class="btn btn-danger btn-lg" id="excluir" style="width:175px">Desativar</button>
                        </div>

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