<%@page import="java.util.List"%>
<%@page import="dao.VacinaDao"%>
<%@page import="model.Vacina"%>
<%@page import="model.Vacina"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%  
    try {
        Integer idVacina = Integer.parseInt(request.getParameter("idVacina"));
        Vacina vacina = VacinaDao.findById(idVacina);

        pageContext.setAttribute("vacina", vacina);

        List<Vacina> listaVacinas = VacinaDao.listByGestorOms();
        pageContext.setAttribute("vacinas", listaVacinas);
    } catch (Exception e) {
    }

%> 



<%@include file="header.jspf"%>
<script src="../public/assets/js/gestor-oms/gerenciar-vacina.js" defer></script>
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
                            <h1 class="m-0">Painel Vacina</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel Vacina</li>
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

                    <!-- DADOS PORTADOR -->
                    <div class="row mb-3">

                        <div class="col-12">
                            <div class="card card-primary">

                                <div class="card-header">
                                    <h3 class="card-title">Dados Vacina</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-vacina">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="idVacina">ID Vacina</label>
                                                <input type="text" class="form-control" id="idVacina" name="idVacina" value="${vacina.idVacina}" readonly>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="doses">N&uacute;mero de Doses</label>
                                                <input type="text" class="form-control" id="doses" name="doses" value="${vacina.numeroDoses}">
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="nome">Vacina</label>
                                                <input type="text" class="form-control" id="nome" name="nome" value="${vacina.nomeVacina}">
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="lab">Laborat&oacute;rio</label>
                                                <input type="text" class="form-control" id="lab" name="lab" value="${vacina.laboratorio}">
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="tipo-vacina">Tipo de Vacina</label>
                                                <input type="text" class="form-control" id="tipo-vacina" name="tipo-vacina" value="${vacina.tipoVacina}">
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="intervalo-dose">Tempo entre Doses (em dias)</label>
                                                <input type="text" class="form-control" id="intervalo-dose" name="intervalo-dose" value="${vacina.tempoEntreDoses}">
                                            </div>
                                            <div class="form-group col-xl-12">
                                                <label for="tempo-reforco">Tempo para Refor&ccedil;o (em dias)</label>
                                                <input type="text" class="form-control" id="tempo-reforco" name="tempo-reforco" value="${vacina.tempoReforco}">
                                            </div>
                                        </div>
                                    </div>
                                      <input type="hidden" value="atualizar" class="form-control" id="option" name="option">
                                   
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 row mb-3 mt-3">
                        <div>
                            <button type="button" class="btn btn-primary btn-lg" id="salvar">Salvar</button>
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