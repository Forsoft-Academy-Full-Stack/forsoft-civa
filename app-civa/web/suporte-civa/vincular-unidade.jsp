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
<script src="../public/assets/js/suporte-civa/vincular-unidade.js" defer></script>
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
                            <h1 class="m-0">Vincular Unidade</h1>
                        </div>
                        <!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="" id="go-back">Voltar</a></li>
                                <li class="breadcrumb-item active">Vincular unidade</li>
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
                        <div class="col-12 mb-3">
                            <div class="row">
                                <div class="col-xl-12 col-sm-12">
                                    <div class="input-group  mb-2">
                                        <input type="text" class="form-control" id="pesquisar" name="pesquisar"
                                               placeholder="Pesquisar por unidade">
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-secondary" type="button" id="button-addon2"
                                                    name="button-addon2">Pesquisar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados Unidade</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- Incio do form -->

                                <form id="form-meus-dados">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="name">Nome da unidade</label>
                                                <input type="text" id="name-unidade" name="name-unidade"
                                                       class="form-control" value="Hospital e maternidade santos" readonly>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="documento-registro">Documento de registro</label>
                                                <input type="text" id="documento-registro" name="documento-registro"
                                                       class="form-control" value="24.456456/5" readonly>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="natureza">Natureza</label>
                                                <select disabled class="select2 select2-hidden-accessible"
                                                        style="width: 100%;" tabindex="-1" aria-hidden="true" id="natureza"
                                                        name="natureza">
                                                    <option value="pub" disabled>Selecionar</option>
                                                    <option value="pub" select>P&uacute;blica</option>
                                                    <option value="priv">Privada</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-xl-6">
                                                <label for="tipo-estabelecimento">Tipo de Estabelecimento</label>
                                                <select disabled class="select2 select2-hidden-accessible"
                                                        style="width: 100%;" tabindex="-1" aria-hidden="true"
                                                        id="tipo-estabelecimento" name="tipo-estabelecimento">
                                                    <option value="hospital" selected readonly>Hospital</option>
                                                </select>
                                            </div>

                                        </div>


                                        <hr>

                                        <div class="row">
                                            <div class="form-group col-xl-12">
                                                <label for="pais">Pa&iacute;s</label>
                                                <input type="text" id="pais" name="pais" class="form-control"
                                                       value="Brazil" readonly>
                                            </div>
                                        </div>


                                        <div class="row">

                                            <div class="form-group col-xl-12">
                                                <label for="codigopostal">CEP</label>
                                                <input type="text" class="form-control" id="codigopostal"
                                                       name="codigopostal" placeholder="Ex: 000000-000" maxlength="9"
                                                       value="20520-054" readonly>
                                            </div>
                                        </div>


                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="endereco">Endere&ccedil;o</label>
                                                <input type="text" id="endereco" name="endereco" class="form-control"
                                                       value="Vila peri" readonly>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="numero">N&uacute;mero</label>
                                                <input type="number" class="form-control" id="numero" name="numero"
                                                       placeholder="Ex: 000000-000" maxlength="9" value="123" readonly>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="complemento">Complemento</label>
                                                <input type="text" id="complemento" name="complemento"
                                                       class="form-control" value="Apto 1107 bloco 2" readonly>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="bairro">Bairro</label>
                                                <input type="text" class="form-control" id="bairro" name="bairro"
                                                       placeholder="Ex: 000000-000" maxlength="9" value="Queimados"
                                                       readonly>
                                            </div>

                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="municipio">Municipio</label>
                                                <input type="text" id="municipio" name="municipio" class="form-control"
                                                       value="Niter&oacute;i" readonly>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="estado">Estado</label>
                                                <input type="text" class="form-control" id="estado" name="estado"
                                                       placeholder="Cear&aacute;" maxlength="9" value="Rio de Janeiro" readonly>
                                            </div>

                                        </div>

                                        <div class="row">
                                            <div class="form-group col-xl-6">
                                                <label for="contato1">Contato</label>
                                                <input type="tel" class="form-control" id="contato1" name="contato1"
                                                       placeholder="Ex: 000000-000" maxlength="9" value="2199887755"
                                                       readonly>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="locacao">Loca&ccedil;&atilde;o</label>
                                                <input type="text" id="locacao" name="locacao" class="form-control"
                                                       value="Sua Locacao" readonly>
                                            </div>
                                        </div>
                                    </div>

                                </form>
                                <!-- /.form ending -->
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->

                    <div class="row">
                        <div class="col-12 mb-4">
                            <button type="button" id="salvar" class="btn btn-primary btn-lg">Vincular</button>
                        </div>
                    </div>
                </div>



            </div>
            <!-- /.container-fluid -->
            <!-- modal -->
            <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Unidade cadastrada com sucesso!</h4>
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
        </div>
        <!-- /.content -->
        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- /.content-wrapper -->

    <!-- ./wrapper -->

</body>

</html>