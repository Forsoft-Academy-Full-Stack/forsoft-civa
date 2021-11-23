<%@page import="dao.VacinacaoDao"%>
<%@page import="model.Vacinacao"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("portador-civa"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%    
    List<Vacinacao> vacinacoes = VacinacaoDao.list();

    pageContext.setAttribute("vacinacoes", vacinacoes);
%>    

<%@include file="header.jspf"%>
<script src="../public/assets/js/portador-civa/historico.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include file="menu.jspf" %>
        <!-- /.menu ------------------------------------------------------->

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Hist&oacute;rico de Vacina&ccedil;&atilde;o</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Meus Dados</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->
            <div class="content ">
                <div class="container-fluid">
                    <div class="card card-primary card-outline">

                        <div class="card-body">
                            
                            <c:forEach items="${vacinacoes}" var="vacinacao">

                                <div class="row mb-4">
                                    <table class="col-sm-10 table text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>Vacina</th>
                                                <th>Laborat&oacute;rio</th>
                                                <th>Dose</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <tr>
                                                <td><c:out value="${vacinacao.vacina.nomeVacina}" /></td>
                                                <td><c:out value="${vacinacao.vacina.laboratorio}" /></td>
                                                <td><c:out value="${vacinacao.doseAplicada} Dose" /></td>
                                            </tr>

                                        </tbody>
                                        <thead>
                                            <tr>
                                                <th>Data de aplica&ccedil;&atilde;o</th>
                                                <th>Estabelecimento</th>
                                                <th>Pa&iacute;s</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <tr>
                                                <td><c:out value="${vacinacao.dataAplicacao}" /></td>
                                                <td><c:out value="${vacinacao.unidade}" /></td>
                                                <td><c:out value="${vacinacao.pais}" /></td>
                                            </tr>

                                        </tbody>
                                    </table>
                                    <div class="col aling-items-center p-3">
                                        <div>
                                            <img src="../public/img/qrcode.png" alt="">
                                        </div>
                                        <div class="btn-group pl-2"><button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                                                            data-target="#modal-default">Visualizar</button></div>
                                    </div>
                                </div>
                                <!-- ./row -->
                            </c:forEach>     

                            <!-- ./card-body -->
                            <div class="row float-right mr-3">
                                <div class="col-12 mb-4">
                                    <!--a href="./index.jsp" class="btn btn-primary btn-lg">Voltar</a-->
                                </div>
                            </div>
                        </div>



                    </div>
                </div>
            </div>
            <!-- /.content -->
        </div>
        <!-- Main Footer -->
        <%@include file="footer.jspf" %>
        <!-- /.footer ------------------------------------------------------->

    </div>
    <!-- /.content-wrapper -->


    <!-- MODAL CERTIFICADO CIVA -->
    <%@include file="modal-certificado-civa.jspf" %>

</body>
</html>
