<%@page import="dao.PortadorCivaDao"%>
<%@page import="model.PortadorCiva"%>
<%@page import="model.PortadorCiva"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    try {
        PortadorCiva portadorciva = PortadorCivaDao.findByCodigoCiva(pessoa.getCodigoCiva());
        pageContext.setAttribute("ator", portadorciva);
    } catch (Exception e) {
    }

%>

<%@include file="header.jspf"%>
<script src="../public/assets/js/portador-civa/meus-dados.js" defer></script>
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
                            <h1 class="m-0">Meus Dados</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Meus Dados</li>
                            </ol>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->
            <div class="content ">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->

                    <div class="row">
                        <div class="col-12">


                            <div class="card card-primary card-outline">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Portador CIVA</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <%@ include file="../partials/codigociva.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/dadospessoais-disabled.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/enderecos-disabled.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@ include file="../partials/contatos-disabled.jspf" %>

                                        <div class="row float-right">
                                            <div class="col-12 mb-4">
                                                <!--a href="./index.jsp" class="btn btn-primary btn-lg">Voltar</a-->
                                            </div>
                                        </div>

                                    </div>

                                </form>

                            </div>
                        </div>
                        <!-- /.row -->
                    </div>


                    <!-- /.row -->
                </div><!-- /.container-fluid -->

            </div>
            <!-- /.content -->

        </div>
        <!-- /.content-wrapper -->

        <!-------------- footer ------------------->
        <%@include file="footer.jspf" %>
        <!--------------- /.footer --------------->
        <!-- modal start -->
        <%@include file="modal-alteracao-ok.jspf" %>
        <!-- /.modal-content -->

    </div>

    <!-- ./wrapper -->

</body>

</html>