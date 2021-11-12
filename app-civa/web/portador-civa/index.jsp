<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente
    
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("usuario"))) {
        // Caso for uma das duas opções
        // Redicionar para o login
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

        <link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/favicon-pc.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet">


        <!-- Font Icones -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/public/plugins/fontawesome-free/css/all.min.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/adminlte.min.css">

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
                <div class="content-header">
                    <div class="container-fluid">
                        <!---------------------------------------------------------------->

                        <div class="row">
                            <!-- HOME PROFISSIONAL DA SA&Uacute;DE -->
                            <!-- Content Wrapper. Contains page content -->
                            <div class="col-md-12 mt-4 mb-5">
                                <!-- .content -->
                                <div class="jumbotron">
                                    <h1 class="display-4">Ol&aacute;, Portador CIVA!</h1>
                                    <hr class="my-4">
                                    <p>Bem vindo ao seu painel CIVA, ${dados.nome} ${dados.sobrenome}!</p>
                                </div>
                                <!-- /.content -->
                            </div>
                        </div>


                        <div class="row">
                            <div class="col-md-12">
                                <!-- The time line -->
                                <div class="timeline">
                                    <!-- timeline time label -->
                                    <div class="time-label">
                                        <span class="bg-red">10 Feb. 2022</span>
                                    </div>
                                    <!-- /.timeline-label -->
                                    <!-- timeline item -->
                                    <div>
                                        <i class="fas fa-envelope bg-blue"></i>
                                        <div class="timeline-item">
                                            <span class="time"><i class="fas fa-clock"></i> 12:05</span>
                                            <h3 class="timeline-header"><a href="${pageContext.request.contextPath}/portador-civa/solicitacao-pendente.jsp">Suporte</a> voc&ecirc; recebeu um email</h3>
                                            <div class="timeline-body">
                                                verifique sua caixa de email
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END timeline item -->
                                    <!-- timeline item -->
                                    <div>
                                        <i class="fas fa-user bg-green"></i>
                                        <div class="timeline-item">
                                            <span class="time"><i class="fas fa-clock"></i>3 meses atr&aacute;s</span>
                                            <h3 class="timeline-header no-border"><a href="${pageContext.request.contextPath}/portador-civa/historico.jsp">Voc&ecirc; foi vacinado</a></h3>
                                        </div>
                                    </div>
                                    <!-- END timeline item -->

                                </div>
                                <!-- /.col -->
                            </div>

                            <!-- Main Footer -->

                        </div>
                        <!-- /.container-fluid -->
                    </div>
                </div>
            </div>
            <!-- ./wrapper -->

            <!-------------- Footer ------------------->
            <%@include file="footer.jspf" %>
            <!-- REQUIRED SCRIPTS -->

            <!-- jQuery -->
            <script src="${pageContext.request.contextPath}/public/plugins/jquery/jquery.min.js"></script>
            <!-- Bootstrap 4 -->
            <script src="${pageContext.request.contextPath}/public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
            <!-- AdminLTE App -->
            <script src="${pageContext.request.contextPath}/public/dist/js/adminlte.min.js"></script>
            <!-- AdminLTE for demo purposes -->
            <script src="${pageContext.request.contextPath}/public/dist/js/demo.js"></script>

            <script>
                $('#modal-default').modal('show');
            </script>
    </body>

</html>