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
<script src="../public/assets/js/portador-civa/historico.js" defer></script>
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
                            <h1 class="m-0">Hist&oacute;rico de Vacina&ccedil;&atilde;o</h1>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->

            <div class="col-12">
                <div class="card card-primary card-outline">
                    <div class="card-header">
                        <h3 class="card-title">&Uacute;ltimas vacinas tomadas.</h3>
                    </div>
                    <!-- ./card-header -->
                    <div class="card-body d-flex">
                        <table class="table text-nowrap">
                            <thead>
                                <tr>
                                    <th>Vacina</th>
                                    <th>Laborat&oacute;rio</th>
                                    <th>Dose</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Coronavac</td>
                                    <td>Sinovac</td>
                                    <td>1&compfn; Dose</td>
                                </tr>

                            </tbody>
                            <thead>
                                <tr>
                                    <th>Data de aplica&ccedil;&atilde;o</th>
                                    <th>Estabelecimento</th>
                                    <th>Pa&iacute;s</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>29 de julho 2021</td>
                                    <td>Hospital Pan</td>
                                    <td>Brasil</td>
                                </tr>

                            </tbody>
                        </table>
                        <div class="col aling-items-center p-3">
                            <div>
                                <img src="../public/img/qrcode.png" alt="">
                            </div>
                            <div class="btn-group pl-2"><button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                                                data-target="#modal-default">Visualizar</button></div>
                        </div>
                    </div>
                    <!-- ./card-body -->
                    <div class="card-body d-flex">
                        <table class="table text-nowrap">
                            <thead>
                                <tr>
                                    <th>Vacina</th>
                                    <th>Laborat&oacute;rio</th>
                                    <th>Dose</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Coronavac</td>
                                    <td>Sinovac</td>
                                    <td>1&compfn; Dose</td>
                                </tr>

                            </tbody>
                            <thead>
                                <tr>
                                    <th>Data de aplica&ccedil;&atilde;o</th>
                                    <th>Estabelecimento</th>
                                    <th>Pa&iacute;s</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>29 de julho 2021</td>
                                    <td>Hospital Pan</td>
                                    <td>Brasil</td>
                                </tr>

                            </tbody>
                        </table>
                        <div class="col aling-items-center p-3">
                            <div>
                                <img src="../public/img/qrcode.png" alt="">
                            </div>
                            <div class="btn-group pl-2"><button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                                                data-target="#modal-default">Visualizar</button></div>
                        </div>
                    </div>
                    <!-- ./card-body -->
                </div>
            </div>

            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf" %>
        <!-- /.footer ------------------------------------------------------->
        <!-- modal------------------------------------>
        <%@include file="modal-certificado-civa.jspf" %>
        <!-- /.modal ------------------------------------------------------->
    </div>

</body>
</html>
