<%@page import="dao.UnidadeDao"%>
<%@page import="model.Unidade"%>
<%@page import="model.Unidade"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

<%  
    try {
        Integer idUnidade = Integer.parseInt(request.getParameter("idUnidade"));
        Unidade unidade = UnidadeDao.findById(idUnidade);

        pageContext.setAttribute("ator", unidade);
        pageContext.setAttribute("unidade", unidade);

    } catch (Exception e) {
    }

%>    

<!--Por favor não remover include nem head-->
<!--a abertura do head é feita no header.jspf-->
<!--Dessa forma fica menos poluído-->
<!--os links e scripts base ficam nesse header.jspf-->
<!--então aqui é chamado o js especifico para cada página -->
<!--e por fim o head é fechado -->
<%@include file="header.jspf"%>
<script src="../public/assets/js/suporte-civa/gerenciar-unidade.js" defer></script>

</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include  file="menu.jspf"%>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Painel Unidade</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel Unidade</li>
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
                                    <h3 class="card-title">Dados Unidade</h3>
                                </div>
                                <!-- /.card-header -->

                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@ include file="../partials/dados-unidade-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/enderecos-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/contatos-unidade-disabled.jspf" %>
                                    </div>

                                </form>
                                <!-- /.form ending -->
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->

                    <!-- TABELA VACINAS -->
                    <!--
                    <div class="row">
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Profissionais vinculados</h3>

                                    <div class="card-tools">
                                        <div class="input-group input-group-sm" style="width: 150px;">

                                            <div class="input-group-append">


                                            </div>
                                        </div>
                                    </div>
                                </div>
                              
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Identidade</th>
                                                <th>C&oacute;digo Civa</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>

                                            </tr>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>

                                            </tr>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>

                                            </tr>
                                            <tr>
                                                <td>Maria Souza da Silva</td>
                                                <td>123.159.875-05</td>
                                                <td>BRA5521123456789</td>

                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                             
                            </div>
                        </div>
                    </div>
                    -->
                    <div class="row">
                        <div class="col-12 mb-4 ">
                            <!--button type="submit" class="btn btn-primary btn-lg" id="salvar">Salvar</button-->
                        </div>
                    </div>

                </div>



            </div>
            <!-- modal -->
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
                            <button type="button" class="btn btn-default" data-dismiss="modal">Finalizar</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- modal erro -->
            <div class="modal fade" id="modal-default2" style="display: none;" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Todos os dados obrigatorios devem ser preenchidos!</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">Ã</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p></p>
                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Finalizar</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content -->
        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- /.content-wrapper -->
    <!-- ./wrapper -->

</body>

</html>