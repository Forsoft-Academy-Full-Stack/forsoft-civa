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
                                <p>Bem vindo ao seu painel CIVA, ${dados.nomePessoa} ${dados.sobrenomePessoa}!</p>
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
    </div>
</body>

</html>