<%@page import="dao.ProfissionalSaudeDao"%>
<%@page import="model.ProfissionalSaude"%>
<%@page import="dao.PortadorCivaDao"%>
<%@page import="model.PortadorCiva"%>
<%@page import="dao.VacinacaoDao"%>
<%@page import="model.Vacinacao"%>
<%@page import="model.Vacinacao"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("profissional-saude"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");
    }

    // Caso contrário é um usuário válido, pode entrar na página  
%>

<%  
    try {
        String codigoCivaPortadorCiva = request.getParameter("codigoCiva");
        PortadorCiva portadorCiva = PortadorCivaDao.findByCodigoCiva(codigoCivaPortadorCiva);

        Integer idVacinacao = Integer.parseInt(request.getParameter("idVacinacao"));
        Vacinacao vacinacao = VacinacaoDao.find(idVacinacao, portadorCiva.getListaVacinacao());

        String codigoCivaVacinador = VacinacaoDao.getCodigoCivaVacinador(codigoCivaPortadorCiva, Integer.parseInt(vacinacao.getCodigoCivaCadastrante()));
        
        pageContext.setAttribute("portadorCiva", portadorCiva);
        pageContext.setAttribute("vacinacao", vacinacao);
        pageContext.setAttribute("codigoCivaVacinador", codigoCivaVacinador);
    } catch (Exception e) {
    }

%> 

<%@include file="header.jspf"%>
<script src="../public/assets/js/profissional-saude/painel-vacinacao.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@ include file="./navbar.jspf" %>

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>
        <!-- /.sidebar ------------------------------------------------------>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Painel Vacina&ccedil;&atilde;o</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel Vacina&ccedil;&atilde;o</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->
                    <!-- DADOS PORTADOR -->
                    <div class="row">
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Portador CIVA</h3>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="name">Nome</label>
                                            <input type="text" id="name" id="name" class="form-control"  value="${portadorCiva.pessoa.nomePessoa}" disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="surname">Sobrenome</label>
                                            <input type="text" id="surname" name="surname" class="form-control" value="${portadorCiva.pessoa.sobrenomePessoa}" disabled>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="date-birth">Data de Nascimento</label>
                                            <input type="date" id="date-birth" name="date-birth"
                                                   class="form-control" value="${portadorCiva.pessoa.dataNascimento}" placeholder="00/00/0000" disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="doc">Documento</label>
                                            <input type="text" id="doc" name="doc"
                                                   class="form-control" value="${portadorCiva.documento1.documento}" placeholder="884.054.264-05" disabled>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- DADOS VACINA&ccedil;&atildeO -->
                    <form class="row" id="form-painel-vacinacao" >
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Vacina&ccedil;&atilde;o</h3>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <div class="row">
                                        <div class="form-group col-xl-12">
                                            <label for="idvacinacao">ID Vacina&ccedil;&atilde;o</label>
                                            <input type="text" class="form-control" id="idvacinacao" name="idvacinacao" value="${vacinacao.idVacinacao}"
                                                   readonly>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="vacina">Vacina</label>
                                            <input type="text" class="form-control" id="vacina" name="vacina" value="${vacinacao.vacina.nomeVacina}"
                                                   readonly>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="laboratorio">Laborat&oacute;rio</label>
                                            <input type="text" class="form-control" id="laboratorio" name="laboratorio" value="${vacinacao.vacina.laboratorio}"
                                                   readonly>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-12">
                                            <label for="dose">Dose</label>
                                            <input type="text" class="form-control" id="dose" name="dose" value="${vacinacao.doseAplicada}"
                                                   readonly>
                                        </div>                                                                               
                                    </div>

                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="data-aplicacao">Data de Aplica&ccedil;&atilde;o</label>
                                            <input type="date" class="form-control" value="${vacinacao.dataAplicacao}" id="data-aplicacao" name="data-aplicacao"
                                                   disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="data-aplicacao">Hora da Aplica&ccedil;&atilde;o</label>
                                            <input type="time" class="form-control" value="${vacinacao.hora}" id="data-aplicacao" name="data-aplicacao"
                                                   disabled>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="form-group col-xl-12">
                                            <label for="pais">Pa&iacute;s</label>
                                            <input type="text" class="form-control" id="pais" name="pais" value="${vacinacao.pais}" disabled>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="idunidade">ID Unidade</label>
                                            <input type="text" class="form-control" id="idunidade" name="idunidade" value="${vacinacao.idUnidade}" disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="unidade">Unidade de Vacina&ccedil;&atilde;o</label>
                                            <input type="text" class="form-control" id="unidade" value="${vacinacao.unidade}" disabled>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="codigociva">C&oacute;digo CIVA Profissional</label>
                                            <input type="text" class="form-control" id="codigociva" name="codigociva" value="${codigoCivaVacinador}"
                                                   disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="lote">Lote</label>
                                            <input type="text" class="form-control" id="lote" name="lote" value="${vacinacao.vacina.lote}" disabled>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-12 mb-4">
                            <!--button type="button" class="btn btn-primary btn-lg" id="salvar">Salvar</button-->
                        </div>
                    </div>
                    <!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@ include file="footer.jspf" %>
        <!-- ./footer -->
    </div>
    <!-- ./wrapper -->

</body>
</html>