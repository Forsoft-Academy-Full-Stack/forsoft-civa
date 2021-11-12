<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("profissional-saude"))) {
        // Caso for uma das duas opções
        // Redicionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página  
%>

<%@include file="header.jspf"%>
<script src="./../public/assets/js/painel_portador.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <nav class="main-header navbar navbar-expand navbar-white navbar-light">
            <!-- Left navbar links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" data-widget="pushmenu" href="#" role="button">
                        <i class="fas fa-bars"></i>
                    </a>
                </li>
                <li class="nav-item d-none d-sm-inline-block">
                    <a href="" class="nav-link">Portador CIVA</a>
                </li>
            </ul>
        </nav>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>
        <!-- /.sidebar ------------------------------------------------------>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">

            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Painel portador CIVA</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./">Voltar</a></li>
                                <li class="breadcrumb-item active">Consultar portador</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>

            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->

                    <!-- DADOS PORTADOR -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados portador</h3>
                                </div>
                                <form id="form-painel-portador">
                                    <div class="card-body">
                                        <%@ include file="../partials/codigociva.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/dadospessoais-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/enderecos-disabled.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/contatos-disabled.jspf" %>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->

                    <!-- HISTORICO DE VACINA&ccedil;&atilde;O -->
                    <div class="row">
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Hist&oacute;rico de vacina&ccedil;&atilde;o</h3>

                                    <div class="card-tools">
                                        <div class="input-group input-group-sm" style="width: 150px;">

                                            <div class="input-group-append">


                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>Vacina</th>
                                                <th>Laborat&oacute;rio</th>
                                                <th>Dose</th>
                                                <th>Pa&i&iacute;</th>
                                                <th>Data</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Coronavac</td>
                                                <td>Butantan</td>
                                                <td>1&ordf; Dose</td>
                                                <td>Brasil</td>
                                                <td>20/03/2021</td>
                                                <td><a href="./painel-vacinacao.jsp"
                                                       class="btn btn-block btn-primary btn-sm">Ver mais</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Coronavac</td>
                                                <td>Butantan</td>
                                                <td>1&ordf; Dose</td>
                                                <td>Brasil</td>
                                                <td>20/03/2021</td>
                                                <td><a href="./painel-vacinacao.jsp"
                                                       class="btn btn-block btn-primary btn-sm">Ver mais</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Coronavac</td>
                                                <td>Butantan</td>
                                                <td>1&ordf; Dose</td>
                                                <td>Brasil</td>
                                                <td>20/03/2021</td>
                                                <td><a href="./painel-vacinacao.jsp"
                                                       class="btn btn-block btn-primary btn-sm">Ver mais</a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12 mb-4">
                            <button type="button" id="salvar" class="btn btn-primary btn-lg">Salvar</button>
                        </div>
                    </div>

                    <!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@ include file="footer.jspf" %>
        <!-- ./footer -->
    </div>
    <!-- ./wrapper -->

    <script>
        $(function () {
            $('.select2').select2()
        });

        // Pegando o elemento form da pÃ¡gina
        let form = $("#form-painel-portador");

        $("#salvar").click(function () {

            if (tratar_campos()) {
                $.get("", form.serialize(), (data, status) => {
                    if (status === 'success') {
                        //$('#exampleModal').modal('hide');
                        //$('#exampleModal2').modal('show');
                        Swal.fire({
                            icon: 'success',
                            title: 'Dados alterados com sucesso!',
                            text: "Altera&ccedil;&atilde;o realizada.",
                            confirmButtonText: 'Finalizar',
                            confirmButtonColor: '#007bff'
                        });

                        console.log("Dados enviados com sucesso :) !");
                        // Limpando os campos do modal de altera&ccedil;&atilde;o e confirma&ccedil;&atilde;o de senha ap&oacute;s o envio
                        //$('#exampleModal').find("#confirm-password").val("");
                        //$('#exampleModal').find("#message-text").val("");
                    } else {
                        // Abrir Modal informando o erro
                        // Por enquanto mostrar=ndo somente com o console.log()
                        console.log("Ops... Algum erro ocorreu e seus dados n&atilde;o foram enviados :(");
                        $('#exampleModal').modal('hide');

                        Swal.fire({
                            icon: 'error',
                            title: '',
                            text: 'Ops... Algum erro ocorreu e seus dados n&atilde;o foram enviados :(!',
                            confirmButtonText: 'Finalizar'
                                    //confirmButtonColor: '#007bff'
                        });

                        $('#exampleModal').find("#confirm-password").val("");
                        $('#exampleModal').find("#message-text").val("");

                    }
                });
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Todos os campos precisam ser preenchidos!',
                    confirmButtonColor: '#007bff'
                })
            }
        });

    </script>

</body>

</html>