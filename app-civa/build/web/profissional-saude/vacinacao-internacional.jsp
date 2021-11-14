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
</head>
<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@ include file="./navbar.jspf" %>

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
                            <h1 class="m-0">Vacina&ccedil;&atilde;o internacional</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./">Voltar</a></li>
                                <li class="breadcrumb-item active">Consultador portador</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->
            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->
                    <div class="row">
                        <div class="col-12 mb-4">
                            <form id="vacinacao-internacional">
                                <div class="input-group">
                                    <input type="search" class="form-control form-control-lg"
                                           placeholder="Insira o codigo civa do portador">
                                    <div class="input-group-append">
                                        <button type="submit" class="btn btn-lg btn-primary">
                                            Pesquisar
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- DADOS PORTADOR -->
                    <div class="row mb-3">
                        <div class="col-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Portador CIVA</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form>
                                    <div class="card-body">
                                        <%@ include file="../partials/codigociva.jspf" %>
                                        <hr>
                                        <%@ include file="../partials/dadospessoais-disabled.jspf" %>
                                        <hr>

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
                                                <th>Vacina</th>
                                                <th>Laborat&oacute;rio</th>
                                                <th>Dose</th>
                                                <th>Pa&iacute;s</th>
                                                <th>Data</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Coronavac</td>
                                                <td>Sinovac</td>
                                                <td>1&ordf; Dose</td>
                                                <td><span class="tag tag-success">Brasil</span></td>
                                                <td>11/03/2021</td>
                                            </tr>
                                            <tr>
                                                <td>Coronavac</td>
                                                <td>Sinovac</td>
                                                <td>1&ordf; Dose</td>
                                                <td><span class="tag tag-success">Brasil</span></td>
                                                <td>11/03/2021</td>
                                            </tr>
                                            <tr>
                                                <td>Coronavac</td>
                                                <td>Sinovac</td>
                                                <td>1&ordf; Dose</td>
                                                <td><span class="tag tag-success">Brasil</span></td>
                                                <td>11/03/2021</td>
                                            </tr>
                                            <tr>
                                                <td>Coronavac</td>
                                                <td>Sinovac</td>
                                                <td>1&ordf; Dose</td>
                                                <td><span class="tag tag-success">Brasil</span></td>
                                                <td>11/03/2021</td>
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
                            <a href="./cadastrar-vacinacao-internacional.jsp">
                                <button type="button" id="cadastro" class="btn btn-primary btn-lg">Cadastrar vacina&ccedil;&atilde;o</button>
                            </a>
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
        let form = $("#vacinacao-internacional");
        $("#cadastro").click(function () {

            if (tratar_campos()) {
                $.get("", form.serialize(), (data, status) => {
                    if (status === 'success') {
                        //$('#exampleModal').modal('hide');
                        //$('#exampleModal2').modal('show');
                        Swal.fire({
                            icon: 'success',
                            title: 'Cadastro realizado com sucesso!',
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
                        //$('#exampleModal').modal('hide');

                        Swal.fire({
                            icon: 'error',
                            title: '',
                            text: 'Ops... Algum erro ocorreu e seus dados n&atilde;o foram enviados :(!',
                            confirmButtonText: 'Finalizar'
                                    //confirmButtonColor: '#007bff'
                        });

                        //$('#exampleModal').find("#confirm-password").val("");
                        //$('#exampleModal').find("#message-text").val("");

                    }
                });
            }
        });
    </script>
</body>
</html>