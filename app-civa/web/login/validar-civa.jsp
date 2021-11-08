<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CIVA</title>

        <link rel="shortcut icon" href="../public/img/favicon-pc.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet">


        <!-- Font Icons Google -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">


        <!-- Font Icones -->
        <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

        <!-- Estilo Adicional -->
        <link rel="stylesheet" href="../public/dist/css/style.css">


    </head>

    <body class="content-wrapper">
        <!-- Main content -->
        <div class="modal fade show " id="modal-default" style="display: block; padding-right: 17px;" aria-modal="true">
            <div class="modal-dialog ">
                <div class="modal-content card-body card-primary card-outline">
                    <p class="h3 text-center  mt-3">Leitor QRCODE</p></video>
                    <div class="justify-content-center d-flex mt-3">
                        <video src="#" style="border: 3px solid rgb(139, 138, 138); background: rgba(139, 138, 138, 0.342);"></video>
                    </div>
                    <div class="m-5">
                        <p class="text-center">N&atilde;o consegue escanear? Digite o c&oacute;digo de autententica&ccedil;&atilde;o.</p>
                        <input class="form-control form-control-sm text-center" type="text"
                               placeholder="Digite o c&oacute;digo de autententica&ccedil;&atilde;o.">
                    </div>

                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-block btn-primary" data-toggle="modal"
                                data-target="#modal-default">VALIDAR</button>
                        <a href="./index.jsp" class="btn btn-block btn-outline-primary">VOLTAR</a>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->


            <!-- MODAL CERTIFICADO CIVA -->
            <div class="modal fade show " id="modal-default" style="display: none; padding-right: 17px;" aria-modal="true">
                <div class="modal-dialog ">
                    <div class="modal-content card-primary card-outline">
                        <div class="modal-header">
                            <h4 class="modal-title">Certificado CIVA</h4>
                            <button type="button" class="Close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">x</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="certificado-nome">Nome</label>
                                <input type="text" class="form-control form-control-sm" id="certificado-nome" name="certificado-nome"
                                       value="Samuel Claudino da Silva" disabled>
                            </div>
                            <div class="row">
                                <div class="form-group col mb-3">
                                    <label for="certificado-identidade">Identidade</label>
                                    <input type="text" class="form-control form-control-sm" id="certificado-identidade" name="certificado-identidade"
                                           value="123.456.789-09" disabled>
                                </div>
                                <div class="form-group col mb-3">
                                    <label for="certificado-b-day">Data de nascimento</label>
                                    <input type="text" class="form-control form-control-sm" id="certificado-b-day" value="31/09/1998" name="certificado-b-day"
                                           disabled>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col mb-3">
                                    <label for="certificado-civa-id">CIVA</label>
                                    <input type="text" class="form-control form-control-sm" id="certificado-civa-id" value="BR55123456789" name="certificado-dica-id"
                                           disabled>
                                </div>
                                <div class="form-group col mb-3">
                                    <label for="certificado-origem">Pa&iacute;s de origem</label>
                                    <input type="text" class="form-control form-control-sm" id="certificado-origem" value="Brasil" name="certificado-origem" disabled>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col mb-3">
                                    <label for="certificado-vacina">Vacina</label>
                                    <input type="text" class="form-control form-control-sm" id="certificado-vacina" name="certificado-vacina" value="Coronavac"
                                           disabled>
                                </div>
                                <div class="form-group col mb-3">
                                    <label for="certificado-dose">Doses</label>
                                    <input type="text" class="form-control form-control-sm" id="certificado-dose" name="certificado-dose" value="2" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                            <button type="button" class="btn btn-primary">Imprimir</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
        </div>

        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->

        <!-- jQuery -->
        <script src="../plugins/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="../plugins/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="../style/js/adminlte.min.js"></script>
        <script>
            $('#modal-default').modal('hide');
        </script>

        <!-- VERIFICA O CAMPO -->
        <script src="../verifica-campo.js"></script>
    </body>

</html>