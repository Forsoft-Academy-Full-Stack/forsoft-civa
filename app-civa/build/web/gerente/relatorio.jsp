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
                            <h1 class="m-0">Relat&oacute;rio</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">                               
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>                               
                                <li class="breadcrumb-item active">Relat&oacute;rio</li>
                            </ol>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>

            <!-- Main content -->
            <div class="card-header d-flex align-items-center">
                <div class="row btn-group shadow-sm mb-2 mt-2">
                    <a href="https://drive.google.com/file/d/1zJZj3HAC_oQ-i_HqUH85ys-3z_RphY15/view" target="_blank" class="mb-4">
                        <button type="button" class="btn btn-primary btn-md d-flex align-items-center" 
                                >Baixar Dados do Relat&oacute;rio<span class="material-icons-round ml-2" style="font-size:20px;">
                                fact_check
                            </span>
                        </button>
                    </a>
                   
                    <img src="../public/img/GR.png" class="img-fluid" alt="Baixar dados pelo gestor nacional">
                </div>
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
