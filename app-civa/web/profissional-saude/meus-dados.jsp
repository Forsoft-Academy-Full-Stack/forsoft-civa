<%@page import="dao.ProfissionalSaudeDao"%>
<%@page import="model.ProfissionalSaude"%>
<%@page import="dao.UnidadeDao"%>
<%@page import="model.Unidade"%>
<%@page import="java.util.List"%>
<%@page import="dao.PortadorCivaDao"%>
<%@page import="model.PortadorCiva"%>
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
        ProfissionalSaude profissionalSaude = ProfissionalSaudeDao.findByCodigoCiva(pessoa.getCodigoCiva(), pessoa.getCodigoCiva());
        pageContext.setAttribute("ator", profissionalSaude);

        List<Unidade> listaUnidades = UnidadeDao.listUnidadeByProfissionalSaude(pessoa.getCodigoCiva());

        pageContext.setAttribute("unidades", listaUnidades);

    } catch (Exception e) {
    }

%> 



<%@include file="header.jspf"%>
<script src="./../public/assets/js/profissional-saude/meus-dados-suporte-civa.js" defer></script>
</head>
<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@ include file="./navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <%@ include file="menu.jspf" %>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Meus Dados</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Meus Dados</li>
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
                        <div class="col-12 mb-3">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Profissional de Sa&uacute;de</h3>
                                </div>
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@ include file="../partials/codigociva.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/dadospessoais-ps-disabled.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/enderecos-disabled.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/contatos-disabled.jspf" %>
                                    </div>
                                </form>
                                <!-- /.card-header -->
                                <!-- form start -->
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- TABELA VACINAS -->
                    <div class="row">
                        <div class="col-12 mb-2">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Unidades Vinculadas</h3>
                                    <div class="card-tools">
                                        <div class="input-group input-group-sm" style="width: 150px;">
                                            <div class="input-group-append">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Estado</th>
                                                <th>CEP</th>
                                                <th>Identificador</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${unidades}" var="unidade">
                                                <tr>                                                   
                                                    <td><c:out value="${unidade.nome}" /></td>
                                                    <td><c:out value="${unidade.endereco.nomesubdivisao3}" /></td>
                                                    <td><c:out value="${unidade.endereco.codigoPostal}" /></td>
                                                    <td><c:out value="${unidade.idUnidade}" /></td>
                                                </tr>
                                            </c:forEach>  
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 mb-4">
                            <!--button type="button" id="salvar" class="btn btn-primary btn-lg" >Salvar</button-->
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
            <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Cadastro realizado com sucesso!</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">Ã</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p></p>
                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal"
                                    onclick="location.href = './meus-dados.jsp'">Close</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.content -->
            </div>
        </div>
        <!-- /.content -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- /.content-wrapper -->
</body>
</html>


