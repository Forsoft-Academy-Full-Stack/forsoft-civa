<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("profissional-saude"))) {
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
        <%@ include file="./navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">

            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->
                    <div class="row">
                        <!-- HOME PROFISSIONAL DA SAÃDE -->
                        <!-- Content Wrapper. Contains page content -->
                        <div class="col-md-12 mt-4 mb-5">
                            <!-- .content -->
                            <div class="jumbotron">
                                <h1 class="display-4">Ol&aacute;, profissional da sa&uacute;de!</h1>
                                <hr class="my-4">
                                <p>Bem vindo ao seu painel CIVA, ${dados.nome} ${dados.sobrenome}!</p>
                            </div>
                            <!-- /.content -->
                        </div>

                    </div>

                    <div class="row">

                    </div>
                    <!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@ include file="./footer.jspf" %>
        <!-- ./footer -->
    </div>
    <!-- ./wrapper -->

</body>

</html>