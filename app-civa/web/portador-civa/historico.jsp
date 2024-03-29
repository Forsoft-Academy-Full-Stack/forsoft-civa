<%@page import="dao.ProfissionalSaudeDao"%>
<%@page import="model.ProfissionalSaude"%>
<%@page import="model.Unidade"%>
<%@page import="dao.UnidadeDao"%>
<%@page import="dao.PortadorCivaDao"%>
<%@page import="model.PortadorCiva"%>
<%@page import="model.PortadorCiva"%>
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
    //if ((pessoa == null) || (!session.getAttribute("perfil").equals("portador-civa"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
    //    response.sendRedirect("../login/");

    //}

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%    try {
        PortadorCiva portadorCiva = PortadorCivaDao.findByCodigoCiva(pessoa.getCodigoCiva());
        pageContext.setAttribute("portadorCiva", portadorCiva);
        
        pageContext.setAttribute("vacinadores", portadorCiva.getNomesCadastranteVacina());

        pageContext.setAttribute("unidades", portadorCiva.getUnidadesVacinacao());
        
        //Unidade unidade = UnidadeDao.findById(portadorCiva.getListaVacinacao().get(0).getIdUnidade());
        //pageContext.setAttribute("unidade", unidade);

        ProfissionalSaude profissionalSaude = ProfissionalSaudeDao.findByCodigoCiva(portadorCiva.getListaVacinacao().get(0).getCodigoCivaCadastrante(), pessoa.getCodigoCiva());
        pageContext.setAttribute("profissionalSaude", profissionalSaude);
    } catch (Exception e) {
    }

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
                                <li class="breadcrumb-item active">Hist&oacute;rico de Vacina&ccedil;&atilde;o</li>
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
                        <div class="card-header d-flex align-items-center">
                            <div class="row btn-group shadow-sm mb-2 mt-2">
                                <button type="button" class="btn btn-primary btn-md d-flex align-items-center" data-toggle="modal"
                                        data-target="#modal-default"><span class="material-icons-round mr-2" style="font-size:20px;">
                                        fact_check
                                    </span>Visualizar Certificado CIVA
                                </button>
                            </div>
                        </div>                        

                        <div class="card-body pb-0">
                            <c:forEach items="${portadorCiva.listaVacinacao}" var="vacinacao">
                                <div class="row mb-4 border border-info rounded-lg shadow-sm">                               


                                    <table class="col-xl-12 table text-nowrap table-striped  ">

                                        <thead>
                                            <tr class="table-primary">
                                                <th>Vacina</th>
                                                <th>Laborat&oacute;rio</th>
                                                <th>Dose</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <tr class="table-light">
                                                <td ><c:out value="${vacinacao.vacina.nomeVacina}"/></td>
                                                <td><c:out value="${vacinacao.vacina.laboratorio}" /></td>
                                                <td><c:out value="${vacinacao.doseAplicada}" /></td>
                                            </tr>

                                        </tbody>
                                        <thead>
                                            <tr class="table-primary">
                                                <th>Data de Aplica&ccedil;&atilde;o</th>
                                                <th>Estabelecimento</th>
                                                <th>Pa&iacute;s</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <tr class="table-light">
                                                <td><c:out value="${vacinacao.dataAplicacao}" /></td>
                                                <td><c:out value="${vacinacao.unidade}" /></td>
                                                <td><c:out value="${vacinacao.pais}" /></td>
                                            </tr>

                                        </tbody>
                                    </table>



                                </div>
                            </c:forEach> 
                            <!-- ./row -->

                            <!-- ./card-body -->
                            
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