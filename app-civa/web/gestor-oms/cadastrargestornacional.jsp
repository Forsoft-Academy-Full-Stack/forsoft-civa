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


        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">



        <!-- Select2 -->
        <link rel="stylesheet" href="../public/plugins/select2/css/select2.min.css">

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
                                <h1 class="m-0">Cadastrar Gestor Nacional</h1>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="./o1cadastrospendentes.jsp">Voltar</a></li>
                                    <li class="breadcrumb-item active">Cadastrar Gestor Nacional</li>
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
                        <div class="row mb-3">

                            <div class="col-12">
                                <div class="card card-primary">


                                    <div class="card-header">
                                        <h3 class="card-title">Dados Gestor Nacional</h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <!-- form start -->
                                    <form action="#" id="form-cad-portador" method="post" novalidate="novalidate">
                                        <div class="card-body">

                                            <div class="row">
                                                <div class="form-group col-xl-6">
                                                    <label for="exampleFormControlInput1">ID Pa&iacute;s</label>
                                                    <input type="number" class="form-control" id="idpais" name="idpais" value="10" disabled>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-xl-6">
                                                    <label for="name">Nome</label>
                                                    <input type="text" class="form-control" id="name" name="name" placeholder="Ex: Bryan">
                                                </div>
                                                <div class="form-group col-xl-6">
                                                    <label for="surname">Sobrenome</label>
                                                    <input type="text" class="form-control" id="surname" name="surname" placeholder="Ex: Adams">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-xl-6">
                                                    <label for="date-birth">Data de Nascimento</label>
                                                    <input type="date" class="form-control" id="date-birth" name="date-birth">
                                                </div>
                                                <div class="form-group col-xl-6">
                                                    <label for="nacionality">Nacionalidade</label>
                                                    <input type="text" class="form-control" id="nacionality" name="nacionality">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <label for="doc-type">Tipo de Documento</label>
                                                    <select class="form-control" id="doc-type" name="doc-type">
                                                        <option value="" selected disabled>Selecionar</option>
                                                        <option value="CPF">CPF</option>
                                                        <option value="RG">RG</option>
                                                        <option value="PASSAPORTE">PASSAPORTE</option>
                                                        <option value="Social Security">Social Security</option>
                                                        <option value="U.S.PASSPORT">U.S.PASSPORT</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="doc-1">Documenta&ccedil;&atilde;o 1</label>
                                                    <input type="text" class="form-control" id="doc-1" name="doc-1">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <label for="doc-type">Tipo de Documento</label>
                                                    <select class="form-control" id="doc-type" name="doc-type">
                                                        <option value="" selected disabled>Selecionar</option>
                                                        <option value="CPF">CPF</option>
                                                        <option value="RG">RG</option>
                                                        <option value="PASSAPORTE">PASSAPORTE</option>
                                                        <option value="Social Security">Social Security</option>
                                                        <option value="U.S.PASSPORT">U.S.PASSPORT</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="doc-2">Documenta&ccedil;&atilde;o 2</label>
                                                    <input type="text" class="form-control" id="doc-2" name="doc-2">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <label for="doc-type">Tipo de Documento</label>
                                                    <select class="form-control" id="doc-type" name="doc-type">
                                                        <option value="" selected disabled>Selecionar</option>
                                                        <option value="CPF">CPF</option>
                                                        <option value="RG">RG</option>
                                                        <option value="PASSAPORTE">PASSAPORTE</option>
                                                        <option value="Social Security">Social Security</option>
                                                        <option value="U.S.PASSPORT">U.S.PASSPORT</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="doc-3">Documenta&ccedil;&atilde;o 3</label>
                                                    <input type="text" class="form-control" id="doc-3" name="doc-3">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-xl-6">
                                                    <label for="exampleFormControlInput1">Contato</label>
                                                    <input type="text" class="form-control" id="telf" name="telf" placeholder="Ex: 55+ (00) 9 0000-0000">
                                                </div>
                                                <div class="form-group col-xl-6">
                                                    <label for="exampleFormControlInput1">Email</label>
                                                    <input type="email" class="form-control" id="email" name="email" placeholder="Ex: nome@mail.com">
                                                </div>
                                            </div>


                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>




                        <div class="col-12 row">
                            <div class="mb-3 mt-3">
                                <button type="submit" class="btn btn-primary btn-lg" form="caralho">Cadastrar</button>
                            </div>
                        </div>

                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                    <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title">Cadastro realizado com sucesso!</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">×</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <p></p>
                                </div>
                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href = 'ui112.jsp'">Close</button>
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

        <!-- REQUIRED SCRIPTS -->

        <!-- jQuery -->
        <script src="./plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="./plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="./dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="./dist/js/demo.js"></script>

        <script>
                                        function tratarCampos() {
                                            let erro = false;
                                            let campos = ['name'];

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

                                        document.getElementById('caralho').onsubmit = tratarCampos;
        </script>
    </body>

</html>