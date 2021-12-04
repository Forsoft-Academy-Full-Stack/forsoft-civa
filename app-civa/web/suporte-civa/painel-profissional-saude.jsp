<%-- 
    Document   : gerenciar-supervisor
    Created on : 22/11/2021, 01:48:28
    Author     : felipegomes
--%>

<%@page import="dao.UnidadeDao"%>
<%@page import="model.Unidade"%>
<%@page import="dao.ProfissionalSaudeDao"%>
<%@page import="model.ProfissionalSaude"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Importando a library JSTL -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("suporte-civa"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>

<%    try {
        String codigoCivaProfissionalSaude = request.getParameter("codigoCiva");
        ProfissionalSaude listaProfissionalSaude = ProfissionalSaudeDao.findByCodigoCiva(codigoCivaProfissionalSaude);

        pageContext.setAttribute("ator", listaProfissionalSaude);

        List<Unidade> listaUnidade = UnidadeDao.listUnidadeByProfissionalSaude(codigoCivaProfissionalSaude);
        pageContext.setAttribute("unidades", listaUnidade);

    } catch (Exception e) {
    }

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/supervisor/painel-profissional-saude.js" defer ></script>
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
                            <h1 class="m-0">Painel Profissional de Sa&uacute;de</h1>
                        </div><!-- /.col --> 
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel Profissional de Sa&uacute;de</li>
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

                    <!-- DADOS PORTADOR -->
                    <div class="row mb-3">

                        <div class="col-12">
                            <div class="card card-primary">


                                <div class="card-header">
                                    <h3 class="card-title">Dados Profissional da Sa&uacute;de</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-unidade-vinculada">
                                    <div class="card-body">
                                        <%@include file="../partials/codigociva.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/dadospessoais-ps-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/enderecos-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/contatos-disabled.jspf" %>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Botões Savlar / Excluir -->                
                    <div class="col-12 pb-4 d-flex justify-content-between">
                        <button type="button" id="salvar" class="btn btn-primary btn-lg" style="width:175px">Salvar</button>
                        <button type="button" class="btn btn-danger btn-lg" id="excluir" style="width:175px">Excluir</button>
                    </div>

                    <!-- /.row -->
                </div><!-- /.container-fluid -->
                <%@ include file="../partials/modals-cad-unidade.jspf" %>
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
