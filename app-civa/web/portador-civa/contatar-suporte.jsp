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
<script src="../public/assets/js/smtp.js" defer></script>
<script src="../public/assets/js/portador-civa/contatar-suporte.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include file="menu.jspf" %>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Contatar Suporte</h1>
                        </div>
                         <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Contatar Suporte</li>
                            </ol>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->

            <div class="col-12">
                <div class="card card-primary card-outline">
                    <div class="card-header">
                        <h3 class="card-title">Entre em contato com nosso suporte</h3>
                    </div>
                    <!-- ./card-header -->
                    <div class="card-body">
                        <form action="" id="contato-suporte">
                            <div class="form-group">
                                <label for="name">Nome</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="Maria">
                            </div>
                            <div class="form-group">
                                <label for="email">Email preferido para contato</label>
                                <input type="text" class="form-control" id="email" name="email" placeholder="maria@gmail.com">
                            </div>
                            <div class="form-group">
                                <label for="problema">Escreva seu problema, d&uacute;vida ou sugest&atilde;o.</label>
                                <textarea id="problema" name="problema" class="form-control"></textarea>
                            </div>
                        </form>
                    </div>
                    <!-- ./card-body -->
                    <div class="card-footer">
                        <div class="float-right">
                            <button type="button" class="btn btn-primary" id="enviar-suporte">Enviar</button>
                        </div>

                    </div>
                </div>
            </div>

            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->       
        <!-- Main Footer -->
        <%@include file="footer.jspf" %>

    </div>

</body>
</html>