<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gestor-oms"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/gestor-oms/gerenciar-vacina.js" defer></script>
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
                            <h1 class="m-0">Gerenciar Vacina</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./consultarvacinas.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Gerenciar vacina</li>
                            </ol>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->

                <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Dados alterados com sucesso!</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">Ã</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p></p>
                            </div>
                            <div class="modal-footer justify-content-between">
                                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href = './gerenciarvacina.jsp'">Close</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.content -->
                </div>

            </div>
            <!-- /.content-header ---------------------------------------------->


            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->

                    <!-- DADOS PORTADOR -->
                    <div class="row mb-3">

                        <div class="col-12">
                            <div class="card card-primary">


                                <div class="card-header">
                                    <h3 class="card-title">Dados Vacina</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="formulario">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="name">ID vacina</label>
                                                <input type="text" class="form-control" id="idvacina" name="idvacina" value="1234567" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="surname">Dose</label>
                                                <input type="text" class="form-control" id="dose" name="idvacina" value="2 doses" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="date-birth">Vacina</label>
                                                <input type="text" class="form-control" id="vacina" name="vacina" value="Coronavac" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="postal-code">Laborat&oacute;rio</label>
                                                <input type="text" class="form-control" id="lab" name="lab" value="Sinovac" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="postal-code">Tipo de Vacina</label>
                                                <input type="text" class="form-control" id="typevacina" name="typevacina" value="Sars cov 2" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="postal-code">Tempo entre Doses (em dias)</label>
                                                <input type="text" class="form-control" id="timevacina" name="timevacina" value="25" disabled>
                                            </div>
                                            <div class="form-group col-xl-12">
                                                <label for="postal-code">Tempo para refor&ccedil;o (em dias)</label>
                                                <input type="text" class="form-control" id="typevacina" name="typevacina" value="45" disabled>
                                            </div>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>

                    <!-- TABELA VACINAS -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Hist&oacute;rico de vacinas</h3>


                                </div>
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>ID Pa&iacute;s</th>
                                                <th>Pa&iacute;s</th>
                                                <th>Continente</th>
                                                <th>Org&atilde;o de sa&uacute;de</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>120</td>
                                                <td>Brasil</td>
                                                <td>America do Sul</td>
                                                <td>SUS</td>
                                            </tr>
                                            <tr>
                                                <td>111</td>
                                                <td>EUA</td>
                                                <td>America do norte</td>
                                                <td>CDC</td>
                                            </tr>
                                            <tr>
                                                <td>012</td>
                                                <td>China</td>
                                                <td>&Aacute;sia</td>
                                                <td>HLF</td>
                                            </tr>
                                            <tr>
                                                <td>051</td>
                                                <td>Inglaterra</td>
                                                <td>Europa</td>
                                                <td>IMS</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                    </div>


                    <div class="col-12 row">
                        <div class="mb-3 mt-3">
                            <button type="submit" class="btn btn-primary btn-lg" form="formulario">Salvar</button>
                        </div>
                    </div>

                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf" %>
    </div>
    <!-- ./wrapper -->

</body>

</html>