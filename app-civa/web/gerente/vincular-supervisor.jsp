<%@page import="dao.SupervisorDao"%>
<%@page import="model.Supervisor"%>
<%@page import="model.Supervisor"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gerente"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%  
    try {

        String codigoCivaSupervisor = request.getParameter("codigoCiva");

        Supervisor supervisor = SupervisorDao.findByCodigoCiva(codigoCivaSupervisor);

        pageContext.setAttribute("ator", supervisor);

    } catch (Exception e) {
    }

%>



<%@include file="header.jspf"%>

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
                                <form action="" id="form-meus-dados" method="GET">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-md-11 p-0">
                                                <label for="codigoCiva">C&oacute;digo CIVA</label>
                                                <input type="text" class="form-control" id="codigoCiva" name="codigoCiva" value="${ator.codigoCiva}" placeholder="USA1223456789" >

                                            </div>
                                            <div class="form-group col-md-1 pl-0 pt-3 mt-3">
                                                <button type="submit" class="btn btn-default">
                                                    <i class="fa fa-search"></i>
                                                </button>
                                            </div>
                                        </div> 
                                        <hr>
                                        <%@include file="../partials/dadospessoais-ps-disabled.jspf" %>
                                    </div>
                                </form>
                            </div>
                        </div>


                        <div class="col-12 mb-4">
                            <button type="button" id="vincular" class="btn btn-primary btn-lg">
                                Vincular
                            </button>
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
    </div>
    <!-- ./wrapper -->
</body>
</html>

