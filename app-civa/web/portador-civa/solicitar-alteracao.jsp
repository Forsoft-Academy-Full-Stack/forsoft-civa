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
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include  file="menu.jspf"%>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Solicitar Suporte</h1>
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
                        <div class="col-12 mb-3">


                            <div class="card card-primary card-outline">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Solicita&ccedil;&atilde;o Suporte</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-xl-12">
                                                <label for="name">Código CIVA</label>
                                                <input type="text" class="form-control" id="code-civa" name="code-civa" placeholder="BR123456" disabled>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="name">Nome</label>
                                                <input type="text" class="form-control" id="name" name="name" placeholder="Ricardo" disabled>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="sobrenome">Sobrenome</label>
                                                <input type="text" class="form-control" id="sobrenome" name="sobrenome" placeholder="Milos" disabled>
                                            </div>
                                            <div class="col-xl-6">
                                                <label for="doc">Tipo de Doc</label>
                                                <input type="text" class="form-control" id="tipo-doc" name="tipo-doc" value="CPF"></input>

                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="doc-register">Documento</label>
                                                <input type="text" class="form-control" id="doc" name="doc" placeholder="123456789" disabled>
                                            </div>
                                        </div>                    
                                        <div class="form-group col-xl-6">
                                            <label for="security">Anexe o Comprovante de Documenta&ccedil;&atilde;o</label>
                                            <input type="file" multiple="true" id="request-attachments" data-fileupload="true" data-dropzone="upload-dropzone" data-error="upload-error" data-create-url="/hc/pt-br/request_uploads" data-name="request[attachments][]" data-pool="request-attachments-pool" data-delete-confirm-msg="" aria-describedby="upload-error">
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="obs">Descri&ccedil;&atilde;o do Problema:</label>
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <textarea row="6" style="width: 26em" id="observacao" name="observacao"></textarea>
                                        </div>

                                        <div class="row">
                                            <div class="col-12 mb-4">
                                                <button type="button" class="btn btn-primary btn-lg" id="solicitar">Enviar</button>
                                            </div>
                                        </div>
                                        
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- </div> -->
                <!-- /.container-fluid -->
                <!-- modal -->
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
                                <button type="button" class="btn btn-default" data-dismiss="modal">Finalizar</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- modal erro -->
                <div class="modal fade" id="modal-default2" style="display: none;" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Todos os dados obrigatorios devem ser preenchidos!</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">Ã</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p></p>
                            </div>
                            <div class="modal-footer justify-content-between">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Finalizar</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.content -->
            </div>
        </div>

        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- ./wrapper -->

</body>

</html>