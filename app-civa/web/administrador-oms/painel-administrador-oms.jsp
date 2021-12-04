<%@page import="dao.AdministradorOmsDao"%>
<%@page import="model.AdministradorOms"%>
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

<%   
    try {

        String codigoCivaAdministradorOms = request.getParameter("codigoCiva");
        AdministradorOms administradorOms = AdministradorOmsDao.findByCodigCiva(codigoCivaAdministradorOms);

        pageContext.setAttribute("ator", administradorOms);

    } catch (Exception e) {
    }
%> 
<%@include file="header.jspf"%>
<script src="../public/assets/js/gestor-oms/painel-gestor-oms.js" defer></script>
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
                                    </div>
                                </form>                                
                            </div>
                        </div>

                        <div class="col-12 pb-4 d-flex justify-content-between">
                            <button type="button" id="salvar" class="btn btn-primary btn-lg" style="width:175px">Salvar</button>
                            <button type="button" class="btn btn-danger btn-lg" id="excluir" style="width:175px">Excluir</button>
                        </div>

                    </div>

                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
                <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Solicita&ccedil;&atilde;o enviada com sucesso!</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">Ã</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p></p>
                            </div>
                            <div class="modal-footer justify-content-between">
                                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href = 'painelgestoroms.jsp'">Close</button>
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
