<%@page import="dao.GestorNacionalDao"%>
<%@page import="model.GestorNacional"%>
<%@page import="dao.PaisDao"%>
<%@page import="dao.VacinaDao"%>
<%@page import="model.Vacina"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gestor-nacional"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página
    try {
        List<Vacina> listaVacinas = VacinaDao.listByGestorOms();
        pageContext.setAttribute("vacinas", listaVacinas);

    } catch (Exception e) {
    }

%>
<%  
    try {
        Integer idVacina = Integer.parseInt(request.getParameter("idVacina"));
        
        Vacina vacina = VacinaDao.findById(idVacina);       
        pageContext.setAttribute("vacina", vacina);        
        
        GestorNacional gestorNacional = GestorNacionalDao.findByCodigociva(pessoa.getCodigoCiva(), pessoa.getCodigoCiva());        
        int idPais = PaisDao.getIdPaisByName(gestorNacional.getEndereco().getNomePais());
        
        pageContext.setAttribute("idPais", idPais);
                
    } catch (Exception e) {        
        
    }
%>


<%@include file="header.jspf"%>
<script src="../public/assets/js/gestor-nacional/selecionar-vacina.js" defer></script>
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
                            <h1 class="m-0">Selecionar Vacina</h1>
                        </div><!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Selecionar Vacina</li>
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

                    <div class="row">
                        <div class="col-12">

                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados da Vacina</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-selecionar-vacina" action="./selecionar-vacina.jsp?idVacina=<c:out value="${vacina.idVacina}" />" method="GET">
                                    <div class="card-body">
                                        <input type="hidden" value="vincular" name="option">
                                        <input type="hidden" value="${idPais}" name="id-pais">
                                        <div class="row"> 
                                            <div class="form-group col-xl-12">
                                                <label for="nome-vac">Escolher Vacina</label>
                                                <select class="form-control select2 select2-hidden-accessible" id="nome-vac" name="idVacina" style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                    <option selected>Selecionar</option>
                                                    <c:forEach items="${vacinas}" var="vacina2">
                                                        <option value="${vacina2.idVacina}">${vacina2.nomeVacina}</option>
                                                    </c:forEach>

                                                </select>
                                            </div>
                                          
                                        </div>         
                                         <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="tipovac">Nome Vacina</label>
                                                <input type="text" class="form-control" id="nome-vacina" name="nome-vacina" value="${vacina.nomeVacina}" readonly>
                                                <input type="hidden" class="form-control" id="id-vacina" name="id-vacina" value="${vacina.idVacina}" >
                                            
                                            </div>
                                                  <div class="form-group col-xl-6">
                                                <label for="laboratorio">Laborat&oacute;rio</label>
                                                <input type="text" class="form-control" id="laboratorio" name="laboratorio" value="${vacina.laboratorio}" readonly>

                                            </div>
                                           
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="tipovac">Tipo de Vacina</label>
                                                <input type="text" class="form-control" id="tipovac" name="tipovac" value="${vacina.tipoVacina}" readonly>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="doses">Quantidade de Doses</label>
                                                <input type="text" class="form-control" id="doses" name="doses" value="${vacina.numeroDoses}" readonly>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="timedoses">Intervalo das Doses (dias)</label>
                                                <input type="text" class="form-control" id="timedoses" name="timedoses" value="${vacina.tempoEntreDoses}" readonly>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="reforco">Tempo para Refor&ccedil;o (dias)</label>
                                                <input type="text" class="form-control" id="reforco" name="reforco" value="${vacina.tempoReforco}" readonly>
                                            </div>
                                        </div>

                                    </div>
                                </form>
                            </div>
                        </div>


                        <div class="col-12 mb-4">
                             <button type="submit" class="btn btn-primary btn-lg"  form="form-selecionar-vacina">Pesquisar</button>
                            <button type="button" class="btn btn-primary btn-lg" id="cadastrar" form="form-meus-dados">Cadastrar</button>
                        </div>

                        <!-- /.row -->
                    </div>
                    <!-- /.row -->
                </div><!-- /.container-fluid -->                
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- ./wrapper -->

</body>
</html>