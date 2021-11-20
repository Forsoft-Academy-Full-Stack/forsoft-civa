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
<script src="../public/assets/js/gestor-oms/painel-gestor-oms.js" defer></script>
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
                            <h1 class="m-0">Painel Gestor OMS</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel Gestor OMS</li>
                            </ol>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->

                    <div class="row">
                        <div class="col-12">


                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Gestor OMS</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados">
                                    <div class="p-2">
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlInput1">Nome</label>
                                                <input type="text" class="form-control" id="name" name="name" value="Maria" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlInput1">Sobrenome</label>
                                                <input type="text" class="form-control" id="surname" name="surname" value="Almeida" disabled>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlInput1">Data de nascimento</label>
                                                <input type="date" class="form-control" id="date-birth" name="date-birth" placeholder="00/00/0000" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlInput1">Identidade</label>
                                                <input type="text" class="form-control" id="identity" name="identity" value="101.154.807-02" disabled>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-6">
                                                <label for="exampleFormControlSelect1">Pa&iacute;s</label>
                                                <input type="text" class="form-control" id="pais" name="pais" value="Brasil" disabled>
                                            </div>
                                            <div class="form-group col-6">
                                                <label for="exampleFormControlInput1">CEP</label>
                                                <input type="text" class="form-control" id="postal-code" name="postal-code" value="22758-006" disabled>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="form-group col-6">
                                                <label for="exampleFormControlSelect1">Endere&ccedil;o</label>
                                                <input type="text" class="form-control" id="endereco" name="endereco" placeholder="Av Rio Branco">
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlSelect1">N&uacute;mero</label>
                                                <input type="text" class="form-control" id="numero" name="numero" value="64" disabled>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlSelect1">Complemento</label>
                                                <input type="text" class="form-control" id="complemento" name="complemento" value="201" disabled>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlSelect1">Bairro</label>
                                                <input type="text" class="form-control" id="bairro" name="bairro" value="Niteroi" disabled>

                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlSelect1">Municipio</label>
                                                <input type="text" class="form-control" id="municipio" name="municipio" value="Niteroi" disabled>
                                            </div>
                                            <div class="form-group col-6">
                                                <label for="exampleFormControlSelect1">Estado</label>
                                                <input type="text" class="form-control" id="estado" name="estado" value="Rio de Janeiro" disabled>

                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlInput1">Contato</label>
                                                <input type="text" class="form-control" id="telf" name="telf" placeholder=" (21) 9 8788-9894">
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="exampleFormControlInput1">Email</label>
                                                <input type="email" class="form-control" id="email" name="email" placeholder="maria1612_almeida@gmail.com">
                                            </div>
                                        </div>
                                    </div>
                            </div>
                        </div>


                        <div class="col-12 mb-4">
                            <button type="submit" class="btn btn-primary btn-lg" form="form-meus-dados">Salvar</button>
                        </div>

                        <!-- /.row -->
                    </div>

                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
                <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Solicita&ccedil;&atilde;o enviada com sucesso!</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">Ã</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p></p>
                            </div>
                            <div class="modal-footer justify-content-between">
                                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href = 'painelgestoroms.jsp'">Close</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.content -->
                </div>
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
