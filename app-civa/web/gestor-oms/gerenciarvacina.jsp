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
                                        <span aria-hidden="true">×</span>
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
                                                <div class="form-group col-xl-6">
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

        <!-- REQUIRED SCRIPTS -->
        <script>
            document.getElementById('formulario').onsubmit = tratarCampos

            function tratarCampos() {
                let erro = false;
                let campos = ['dose', 'vacina', 'lab'];

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
        </script>

        <!-- jQuery -->
        <script src="./../public/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="./../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="./../public/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="./../public/dist/js/demo.js"></script>
    </body>

</html>