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
<%    //Buscar Lista de supervisores
    Vacina vacina = VacinaDao.find(1);

    pageContext.setAttribute("vacina", vacina);

    List<Vacina> listaVacinas = VacinaDao.list();
    pageContext.setAttribute("vacinas", listaVacinas);
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
                            <h1 class="m-0">Gerenciar Vacina</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Gerenciar vacina</li>
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
                                <h4 class="modal-title">Dados alterados com sucesso!</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">Ã</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p></p>
                            </div>
                            <div class="modal-footer justify-content-between">
                                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href = './gerenciarvacina.jsp'">Close</button>
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

                    <!-- DADOS PORTADOR -->
                    <div class="row mb-3">

                        <div class="col-12">
                            <div class="card card-primary">


                                <div class="card-header">
                                    <h3 class="card-title">Dados Vacina</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="formulario">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="name">ID vacina</label>
                                                <input type="text" class="form-control" id="idvacina" name="idvacina" value="${vacina.idVacina}" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="surname">N&uacute;mero de Doses</label>
                                                <input type="text" class="form-control" id="dose" name="idvacina" value="${vacina.numeroDoses}" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="date-birth">Vacina</label>
                                                <input type="text" class="form-control" id="vacina" value="${vacina.nomeVacina}" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="postal-code">Laborat&oacute;rio</label>
                                                <input type="text" class="form-control" id="lab" name="lab" value="${vacina.laboratorio}" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="postal-code">Tipo de Vacina</label>
                                                <input type="text" class="form-control" id="typevacina" name="typevacina" value="${vacina.tipoVacina}" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="postal-code">Tempo entre Doses (em dias)</label>
                                                <input type="text" class="form-control" id="timevacina" name="timevacina" value="${vacina.tempoEntreDoses}" disabled>
                                            </div>
                                            <div class="form-group col-xl-12">
                                                <label for="postal-code">Tempo para refor&ccedil;o (em dias)</label>
                                                <input type="text" class="form-control" id="typevacina" name="typevacina" value="${vacina.tempoReforco}" disabled>
                                            </div>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>

                    <!-- TABELA VACINAS -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Hist&oacute;rico de vacinas</h3>


                                </div>
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th style="cursor: pointer;">Vacina</th>
                                                <th style="cursor: pointer;">Laborat&oacute;rio</th>
                                                <th style="cursor: pointer;">Número de Doses</th>
                                                <th style="cursor: pointer;">ID Vacina</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                             <c:forEach items="${vacinas}" var="vacina">
                                                <tr>
                                                    <td><c:out value="${vacina.nomeVacina}" /></td>
                                                    <td><c:out value="${vacina.laboratorio}" /></td>                                                  
                                                    <td><c:out value="${vacina.numeroDoses} dose(s)" /></td>
                                                    <td><c:out value="${vacina.idVacina}" /></td>                                                
                                                </tr>
                                            </c:forEach> 
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                    </div>


                    <div class="col-12 row">
                        <div class="mb-3 mt-3">
                            <button type="submit" class="btn btn-primary btn-lg" form="formulario">Salvar</button>
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