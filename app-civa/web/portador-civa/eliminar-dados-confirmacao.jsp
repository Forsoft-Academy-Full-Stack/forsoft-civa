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
<%@include file="header.jspf"%>
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
                            <h1 class="m-0">Eliminar dados</h1>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>

            <!-- Main content -->

            <div class="col-12">
                <div class="card card-primary card-outline">

                    <div class="card-body">
                        <div class="col d-flex flex-column justify-content-center align-items-center">
                            <img src="../public/img/pense-bem.svg" alt="Aten&ccedil;&atilde;o, eliminar dados">

                            <p class="text-center ml-5 mr-5">A elimina&ccedil;&atilde;o de seus dados &eacute; irrevers&iacute;vel, n&atilde;o ser&aacute;
                                poss&iacute;vel recuperar seus dados de vacina&ccedil;&atilde;o caso deseje no futuro, pense bem pois a
                                exclus&atilde;o &eacute; definitiva!</p>
                        </div>
                    </div>
                    <div class="col d-flex flex-column justify-content-center align-items-center">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="gridCheck">
                            <label class="form-check-label" for="gridCheck">
                                Tenho total ci&ecirc;ncia e quero deletar meus dados.
                            </label>
                        </div>

                        <div class="float-right mb-3 mt-3">
                            <a href="./index.jsp"> <button type="button" class="btn btn-primary mr-3">Cancelar</button></a>
                            <a href="./conta-eliminada.jsp"><button type="button" class="btn btn-outline-danger">Excluir minha conta</button></a>
                        </div>

                    </div>

                    <!-- ./card-body -->
                </div>
            </div>

            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- footer------------------------------------>
        <%@include file="footer.jspf" %>
        <!-- /.footer ------------------------------------------------------->
    </div>

    <!-- ./wrapper -->

</body>
</html>
