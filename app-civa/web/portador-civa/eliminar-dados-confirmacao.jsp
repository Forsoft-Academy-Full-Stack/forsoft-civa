<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("usuario"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }
    
   // Caso contrário é um usuário válido, pode entrar na página
  
%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CIVA</title>

        <link rel="shortcut icon" href="../public/img/favicon-pc.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet">


        <!-- Font Icones -->
        <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

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
                <!-- /.content-header ---------------------------------------------->







                <!-- Main content -->

                <div class="col-12">
                    <div class="card card-primary card-outline">

                        <div class="card-body">
                            <div class="col d-flex flex-column justify-content-center align-items-center">
                                <img src="../public/img/pense-bem.svg" alt="Aten&ccedil;&atilde;o, eliminar dados">

                                <p class="text-center ml-5 mr-5">A elimina&ccedil;&atilde;o de seus dados &eacute; irrevers&iacute;vel, n&acute;o ser&aacute;
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
                                <a href="./conta-eliminada.jsp"><button type="button"
                                                                        class="btn btn-outline-danger">Excluir minha conta</button></a>
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

        <!-- REQUIRED SCRIPTS -->

        <!-- jQuery -->
        <script src="../public/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="../public/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="../public/dist/js/demo.js"></script>
    </body>

</html>