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
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Brand Logo -->
                <a href="index.jsp" class="brand-link">
                    <img src="${pageContext.request.contextPath}/public/img/favicon-pc.svg" alt="CIVA Logo" class="brand-image img-circle"
                         style="opacity: .8">
                    <span class="brand-text font-weight-light">CIVA</span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div class="image">
                            <img src="${pageContext.request.contextPath}/public/img/no-user.svg" class="img-circle elevation-2"
                                 alt="User Image">
                        </div>
                        <div class="info">
                            <a href="#" class="d-block">${dados.nome}</a>
                            <a href="#" class="d-block">${dados.sobrenome}</a>
                        </div>
                    </div>


                    <!-- Sidebar Menu -->
                    <nav class="mt-2">
                        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                            data-accordion="false">
                            <!-- ITENS DO MENU -->
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/portador-civa/" class="nav-link">
                                    <i class="nav-icon fas fa-home"></i>
                                    <p>
                                        Home
                                    </p>
                                </a>
                            </li>
                            <!-- ITEM HIST&Atilde;RICO DO MENU -->
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/portador-civa/historico.jsp" class="nav-link">
                                    <i class="nav-icon fas fa-file-invoice"></i>
                                    <p>
                                        Hist&oacute;rico
                                    </p>
                                </a>
                            </li>

                            <!-- ITEM PERFIL DO MENU -->
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fas fa-user-circle"></i>
                                    <p>
                                        Perfil
                                        <i class="right fas fa-angle-left"></i>

                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/portador-civa/meus-dados.jsp" class="nav-link">
                                            <i class="nav-icon fas fa-address-card"></i>
                                            <p>
                                                Meus dados
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/portador-civa/redefinir-senha.jsp" class="nav-link">
                                            <i class="nav-icon fas fa-lock"></i>
                                            <p>
                                                Redefinir senha
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/portador-civa/idioma.jsp" class="nav-link">
                                            <i class="nav-icon fas fa-language"></i>
                                            <p>
                                                Mudar Idioma
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/portador-civa/faq.jsp" class="nav-link">
                                            <i class="nav-icon fas fa-question-circle"></i>
                                            <p>
                                                FAQ
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/portador-civa/contatar-suporte.jsp" class="nav-link">
                                            <i class="nav-icon fas fa-envelope"></i>
                                            <p>
                                                Contatar suporte
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/portador-civa/solicitacao-pendente.jsp" class="nav-link">
                                            <i class="fas fa-inbox nav-icon"></i>
                                            <p>
                                                Solicita&ccedil;&otilde;es pendentes
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/portador-civa/eliminar-dados.jsp" class="nav-link">
                                            <i class="nav-icon fas fa-user-times"></i>
                                            <p>
                                                Eliminar meus dados
                                            </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/portador-civa/termo-de-uso.jsp" class="nav-link">
                                            <i class="nav-icon fas fa-file-alt"></i>
                                            <p>
                                                Termos de uso
                                            </p>
                                        </a>
                                    </li>

                                </ul>
                            </li>

                            <!-- ITEM PERFIL DO MENU -->
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/portador-civa/validar-civa-logado.jsp" class="nav-link">
                                    <i class="nav-icon fas fa-qrcode"></i>
                                    <p>
                                        Escanear QR-CODE
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/exit" class="nav-link">
                                    <i class="nav-icon fas fa-sign-out-alt"></i>
                                    <p>
                                        Sair
                                    </p>
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <!-- /.sidebar-menu -->
                </div>
                <!-- /.sidebar ------------------------------------------------------>
            </aside>

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