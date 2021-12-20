<%@page import="dao.GestorNacionalDao"%>
<%@page import="model.GestorNacional"%>
<%@page import="model.GestorNacional"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

%>
<%  
    try {
        GestorNacional gestorNacional = GestorNacionalDao.findByCodigociva(pessoa.getCodigoCiva(), pessoa.getCodigoCiva());
        pageContext.setAttribute("ator", gestorNacional);
    } catch (Exception e) {
    }

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/nova-solicitacao.js" defer></script>
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
                            <h1 class="m-0">Solicitar Suporte</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Solicitar Suporte</li>
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
                    <div class="card card-primary card-outline card-outline-tabs">
                        <div class="card-header p-0 border-bottom-0">
                            <ul class="nav nav-tabs" id="custom-tabs-four-tab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="custom-tabs-four-pending-tab" data-toggle="pill" href="#custom-tabs-four-pending" role="tab" aria-controls="custom-tabs-four-pending" aria-selected="true">Solicita&ccedil;&otilde;es Pendentes</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="custom-tabs-four-submit-tab" data-toggle="pill" href="#custom-tabs-four-submit" role="tab" aria-controls="custom-tabs-four-submit" aria-selected="false">Nova Solicita&ccedil;&atilde;o</a>
                                </li>                                
                            </ul>
                        </div>
                        <div class="card-body">
                            <div class="tab-content" id="custom-tabs-four-tabContent">
                                <div class="tab-pane fade show active" id="custom-tabs-four-pending" role="tabpanel" aria-labelledby="custom-tabs-four-pending-tab">
                                    <div class="row">
                                        <%@include file="../partials/solicitacao-pendente.jspf" %>
                                        <%@include file="../partials/solicitacao-pendente.jspf" %>
                                        <%@include file="../partials/solicitacao-pendente.jspf" %>
                                        <%@include file="../partials/solicitacao-pendente.jspf" %>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="custom-tabs-four-submit" role="tabpanel" aria-labelledby="custom-tabs-four-submit-tab">
                                    <%@ include file="../partials/nova-solicitacao.jspf" %>
                                </div>                              
                            </div>
                        </div>
                        <!-- /.card -->
                    </div>                   
                </div>
                <!-- </div> -->
                <!-- /.container-fluid -->
                
                <!-- /.content -->
            </div>
        </div>

        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- ./wrapper -->

</body>

</html>