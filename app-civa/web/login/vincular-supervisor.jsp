<%@page import="dao.SupervisorDao"%>
<%@page import="model.Supervisor"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%  
    try {
        //Integer idUnidade = Integer.parseInt(request.getParameter("idUnidade"));
        pageContext.setAttribute("idUnidade", 1);
          
        String codigoCivaSupervisor = request.getParameter("codigoCiva");
        Supervisor supervisor = SupervisorDao.findByCodigoCiva(codigoCivaSupervisor, "BRA000000005GR");
        pageContext.setAttribute("ator", supervisor);

    } catch (Exception e) {
        //Integer idUnidade = Integer.parseInt(request.getParameter("idUnidade"));
        pageContext.setAttribute("idUnidade", 1);
    }
%>


<%@include file="header.jspf"%>
<script src="../public/assets/js/vincular-gestor-unidade.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@ include file="../partials/gerente/navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="../partials/gerente/menu.jspf" %>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Vincular Supervisor</h1>
                        </div><!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Vincular Supervisor</li>
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
                                    <h3 class="card-title">Dados Supervisor</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <input type="hidden" value="vincular" name="option">
                                        <%@include file="../partials/pesquisar-codigo-civa.jspf" %>
                                        <hr  class = "mb-4 mt-4">
                                        <%@include file="../partials/dadospessoais-disabled.jspf" %>
                                    </div>
                                </form>
                            </div>
                        </div>


                        <div class="col-12 mb-4">
                            <button type="button" id="vincular" class="btn btn-primary btn-lg">Vincular</button>
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
        <%@ include file="../partials/gerente/footer.jspf" %>

        <!-- Modal confirmar senha / vincular -->
        <%@ include file="../partials/confirmar-senha.jspf" %>
    </div>
    <!-- ./wrapper -->
</body>
</html>

