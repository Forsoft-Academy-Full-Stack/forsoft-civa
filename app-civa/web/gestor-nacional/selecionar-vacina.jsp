<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gestor-nacional"))) {
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

        <link rel="shortcut icon" href="../public/img/favicon-gs.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">


        <!-- Font Icons Google -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round"
              rel="stylesheet">

        <!-- Estilo icones -->
        <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

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
                                <h1 class="m-0">Selecionar Vacina</h1>
                            </div><!-- /.col -->

                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
                                    <li class="breadcrumb-item active">Selecionar Vacina</li>
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
                            <div class="col-12">

                                <div class="card card-primary">
                                    <div class="card-header">
                                        <h3 class="card-title">Dados dose</h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <!-- form start -->
                                    <form id="form-meus-dados">
                                        <div class="card-body">
                                            <div class="row"> 
                                                <div class="form-group col-xl-6">
                                                    <label for="exampleFormControlSelect1">Nome</label>
                                                    <select class="form-control select2 select2-hidden-accessible" id="state" style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                        <option selected>Coronavac</option>
                                                        <option>vac</option>
                                                        <option>vac</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row"> 
                                                <div class="form-group col-xl-6">
                                                    <label for="exampleFormControlSelect1">Laborat&oacute;rio</label>
                                                    <select class="form-control select2 select2-hidden-accessible" id="state" style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                        <option selected>Sinovac</option>
                                                        <option>Pfizer</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-xl-6">
                                                    <label for="exampleFormControlInput1">Tipo de Vacina</label>
                                                    <input type="text" class="form-control" id="tipovac" value="Sars cov2" disabled>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-xl-6">
                                                    <label for="exampleFormControlInput1">Quantidade de doses</label>
                                                    <input type="text" class="form-control" id="doses" value="2" disabled>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-xl-6">
                                                    <label for="exampleFormControlInput1">Intervalo das doses(dias)</label>
                                                    <input type="text" class="form-control" id="timedoses" value="25" disabled>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-xl-6">
                                                    <label for="exampleFormControlInput1">Tempo para refor&ccedil;o(dias)</label>
                                                    <input type="text" class="form-control" id="reforco" value="45" disabled>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>


                            <div class="col-12 mb-4">
                                <button type="submit" class="btn btn-primary btn-lg" form="form-meus-dados">Cadastrar</button>
                            </div>

                            <!-- /.row -->
                        </div>


                        <!-- /.row -->
                    </div><!-- /.container-fluid -->
                    <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title">Cadastro realizado com sucesso!</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">Ã</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <p></p>
                                </div>
                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-default" data-dismiss="modal"
                                            onclick="location.href = './index.jsp'">Close</button>
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
            <%@include file="footer.jspf"%>
        </div>

        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->

        <!-- jQuery -->
        <script src="../public/plugins/jquery/jquery.min.js"></script>
        <!-- modal -->
        <script>
                                                function tratarCampos() {
                                                    let erro = false;
                                                    let campos = [];

                                                    for (i = 0; i < campos.length; i++) {
                                                        if (document.getElementById(campos[i]).value == '') {
                                                            erro = true;
                                                        }
                                                    }

                                                    if (erro) {
                                                        alert('Todos os campos devem ser preenchidos!');
                                                    } else {
                                                        // Exibe o modal desejado, baseado no id definido.
                                                        $('#modal-default').modal('show');
                                                        console.log('funcionou');
                                                        event.preventDefault();

                                                    }

                                                    return !erro;
                                                }

                                                document.getElementById('form-meus-dados').onsubmit = tratarCampos;
        </script>
        <!-- Bootstrap 4 -->
        <script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="../public/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="../public/dist/js/demo.js"></script>
    </body>

</html>