<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente
    
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gestor-oms"))) {
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


        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">



        <!-- Select2 -->

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
            <!-- TERMINO DO MENU LATERAL -->

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <div class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1 class="m-0">Cadastrar Gestor OMS</h1>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
                                    <li class="breadcrumb-item active">Cadastrar Gestor OMS</li>
                                </ol>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- content -->
                <div class="content">
                    <div class="container-fluid">
                        <!-- container-fluid -->
                        <div class="row">
                            <!-- row -->
                            <div class="col-md-12">
                                <!-- col -->
                                <div class="card card-primary">
                                    <!-- cards -->
                                    <div class="card-header">
                                        <!-- /.cardheader -->
                                        <h3 class="card-title">Dados Gestor OMS</h3>
                                    </div>
                                    <!-- /.cardheader -->
                                    <!-- Incio do form -->
                                    <form action="#" id="form-cadastrar-gestor" method="post" novalidate="novalidate">
                                        <div class="p-2">
                                            <%@ include file="../partials/dadospessoais-ps-cadastro.jspf" %>
                                            <hr>

                                            <%@ include file="../partials/enderecos-cadastro.jspf" %>

                                            <hr>
                                            <%@ include file="../partials/contatos-cadastro.jspf" %>
                                        </div>
                                    </form>
                                    <!-- /.form ending -->
                                </div>
                                <!-- /.cards -->
                                <div class="mb-3 mt-3">
                                    <button type="submit" class="btn btn-primary btn-lg" form="form-cadastrar-gestor">Cadastrar</button>
                                </div>
                            </div>
                            <!-- /.col -->
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
                                        <span aria-hidden="true">Ã</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <p></p>
                                </div>
                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href = 'ui110.jsp'">Close</button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.content -->
                    </div>
                </div>
                <!-- /.content -->









            </div>

            <!-- Main Footer -->
            <%@include file="footer.jspf" %>
            <!-- /.control-sidebar -->
        </div>

        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->

        <!-- jQuery -->
        <script src="../public/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- jquery-validation -->
        <script src="../public/plugins/jquery-validation/jquery.validate.js"></script>
        <script src="../public/plugins/jquery-validation/additional-methods.js"></script>
        <!-- AdminLTE App -->
        <script src="../public/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="../public/dist/js/demo.js"></script>
        <script>
                                        $(function () {
                                            $.validator.setDefaults({
                                                submitHandler: function () {
                                                    alert("Form successful submitted!");
                                                }
                                            });
                                            $('#form-cadastrar-gestor').validate({
                                                rules: {
                                                    nome: {
                                                        required: true,
                                                    },
                                                    sobrenome: {
                                                        required: true,
                                                    },
                                                    identidade: {
                                                        required: true,
                                                    },
                                                    datadenascimento: {
                                                        required: true,
                                                    },
                                                    email: {
                                                        required: true,
                                                        email: true,
                                                    },
                                                    contato: {
                                                        required: true,
                                                    },
                                                    nacionalidade: {
                                                        required: true,
                                                    },
                                                    codigopostal: {
                                                        required: true,
                                                    },
                                                    endereco: {
                                                        required: true,
                                                    },
                                                    numero: {
                                                        required: true,
                                                    },
                                                    complemento: {
                                                        required: true,
                                                    },
                                                    subdiv1: {
                                                        required: true,
                                                    },
                                                    subdiv2: {
                                                        required: true,
                                                    },
                                                    subdiv3: {
                                                        required: true,
                                                    },

                                                },

                                                errorElement: 'span',
                                                errorPlacement: function (error, element) {
                                                    error.addClass('invalid-feedback');
                                                    element.closest('.form-group').append(error);
                                                },
                                                highlight: function (element, errorClass, validClass) {
                                                    $(element).addClass('is-invalid');
                                                },
                                                unhighlight: function (element, errorClass, validClass) {
                                                    $(element).removeClass('is-invalid');
                                                }
                                            });
                                        });
        </script>
        <script>
            function tratarCampos() {
                let erro = false;
                let campos = ['name', 'surname', 'identity', 'date-birth', 'nationality', 'tel', 'email'];

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

            document.getElementById('form-cadastrar-gestor').onsubmit = tratarCampos;
        </script>

    </body>

</html>