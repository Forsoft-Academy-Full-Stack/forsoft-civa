<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("suporte-civa"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<!--Por favor não remover include nem head-->
<!--a abertura do head é feita no header.jspf-->
<!--Dessa forma fica menos poluído-->
<!--os links e scripts base ficam nesse header.jspf-->
<!--então aqui é chamado o js especifico para cada página -->
<!--e por fim o head é fechado -->
<%@include file="header.jspf"%>
<script src="../public/assets/js/profissional-saude/cadastrar-portador.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include  file="menu.jspf"%>

        <!-- TERMINO DO MENU LATERAL -->
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Cadastrar Portador</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Cadastrar Portador</li>
                            </ol>
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
                                        <h3 class="card-title">Dados Portador</h3>
                                    </div>
                                    <!-- /.cardheader -->
                                    <!-- Incio do form -->
                                    <form id="form-meus-dados">
                                        <div class="card-body">
                                            <%@ include file="../partials/dadospessoais-cadastro.jspf" %>
                                            <hr  class = "mb-4 mt-4">
                                            <%@ include file="../partials/enderecos-cadastro.jspf" %>
                                            <hr  class = "mb-4 mt-4">
                                            <%@ include file="../partials/contatos-cadastro.jspf" %> 
                                            <hr  class = "mb-4 mt-4">
                                            <%@ include file="../partials/senha-cadastro.jspf" %>
                                        </div>


                                    </form>
                                    <!-- /.form ending -->
                                </div>
                                <!-- /.cards -->
                            </div>

                            <div class="col-12 mb-4 ">
                                <button type="button" class="btn btn-primary btn-lg" id="salvar">Cadastrar</button>
                            </div>

                        </div>


                        <!-- /.row -->
                    </div>

                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content -->
        <!-- modal -->
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
                                onclick="location.href = '../ndex.jsp'">Finalizar</button>
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

        <!-- Main Footer -->
        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
        <%@include file="../partials/confirmar-senha.jspf"%>

    </div>
    <!-- ./wrapper -->

</body>

</html>