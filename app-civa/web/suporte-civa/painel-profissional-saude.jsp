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
        ProfissionalSaude profissionalSaude = ProfissionalSaudeDao.findByCodigoCiva(codigoCivaProfissionalSaude);

        pageContext.setAttribute("ator", profissionalSaude);

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
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@include file="../partials/codigociva.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/dadospessoais-alteracao.jspf" %>                                      

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="tipo-doc-2">Tipo de Documento 2</label>
                                                <input type="text" id="tipo-doc-2" name="tipo-doc-2" class="form-control" placeholder="Ex: Passaporte" value="${ator.documento2.nomeTipoDoc}" >

                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="doc-2">Documenta&ccedil;&atilde;o 2</label>
                                                <input type="text" id="tipo-doc-2" name="doc-2" class="form-control"
                                                       placeholder="Ex: BR12345678" value="${ator.documento2.documento}" >
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="tipo-doc-3">Tipo de Documento 3</label>
                                                <input type="text" id="tipo-doc-3" name="tipo-doc-3" class="form-control" placeholder="Ex: CPF" value="${ator.documento3.nomeTipoDoc}" >
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="doc-3">Documenta&ccedil;&atilde;o 3</label>
                                                <input type="text" id="doc-3" name="doc-3" class="form-control"
                                                       placeholder="Ex: 08275467509" value="${ator.documento3.documento}" >
                                            </div>
                                        </div>


                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="tipo-doc-4">Tipo de Documento 4</label>
                                                <input type="text" id="tipo-doc-4" name="tipo-doc-4" class="form-control" placeholder="Ex: CPF" value="${ator.documento4.nomeTipoDoc}" >                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="doc4">Documenta&ccedil;&atilde;o 4</label>
                                                <input type="text" id="doc4" name="doc-4" class="form-control"
                                                       placeholder="Ex: 08275467509" value="${ator.documento4.documento}" >
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="tipo-doc-5">Tipo de Documento 5</label>
                                                <input type="text" id="tipo-doc-5" name="tipo-doc-5" class="form-control" placeholder="Ex: CPF" value="${ator.documento5.nomeTipoDoc}" >
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="doc5">Documenta&ccedil;&atilde;o 5</label>
                                                <input type="text" id="doc4" name="doc-5" class="form-control"
                                                       placeholder="Ex: 08275467509" value="${ator.documento5.documento}" >
                                            </div>
                                        </div>

                                        <hr>
                                        <%@ include file="../partials/enderecos-alteracao.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/contatos-alteracao.jspf" %>
                                        <input type="hidden" value="atualizar" class="form-control" id="option" name="option">
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
