<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gestor-nacional"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
    <script src="../public/assets/js/gestor-nacional/vincular-unidade-gestor.js" defer></script>
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
                            <h1 class="m-0">Vincular nova unidade</h1>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item">
                                    <a href="./consultar-portador.jsp">Voltar</a>
                                </li>
                                <li class="breadcrumb-item active">Consultar gerente</li>
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
                        <div class="col-12 mb-4">
                            <form action="">
                                <div class="input-group">
                                    <input
                                        type="search"
                                        class="form-control form-control-lg"
                                        placeholder="Digite aqui"
                                        />
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
                    <div class="content">
                        <div class="container-fluid">
                            <!---------------------------------------------------------------->

                            <div class="row">
                                <div class="col-lg-12 col-md-12">
                                    <div class="card card-primary">
                                        <div class="card-header">
                                            <h3 class="card-title">Dados Unidade</h3>
                                        </div>
                                        <!-- /.card-header -->
                                        <!-- form start -->
                                        <form id="form-meus-dados">
                                            <div class="card-body">
                                                <div class="form-group">
                                                    <label for="name">Nome</label>
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        id="name"
                                                        disabled=""
                                                        value="Hospital Pan"
                                                        />
                                                </div>
                                                <div class="form-group">
                                                    <label for="cep">CEP</label>
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        id="cep"
                                                        disabled=""
                                                        value="12345-122"
                                                        />
                                                </div>
                                                <div class="form-group">
                                                    <label for="country">Pa&iacute;s</label>
                                                    <select
                                                        class="form-control"
                                                        id="country"
                                                        disabled=""
                                                        >
                                                        <option selected="">Brasil</option>
                                                        <option>Estados Unidos</option>
                                                        <option>Canad&aacute;</option>
                                                        <option>Jap&atilde;o</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sub-div1">Sub-divis&atilde;o 1</label>
                                                    <select
                                                        class="form-control"
                                                        id="sub-div1"
                                                        disabled=""
                                                        >
                                                        <option id="sub-div1-option" disabled="">
                                                            Selecione
                                                        </option>
                                                        <option selected="">Rio de Janeiro</option>
                                                        <option>Niter&oacute;i</option>
                                                        <option>S&atilde;o Gon&ccedil;alo</option>
                                                        <option>M&eacute;ier</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sub-div2">Sub-divis&atilde;o 2</label>
                                                    <select
                                                        class="form-control"
                                                        id="sub-div2"
                                                        disabled=""
                                                        >
                                                        <option id="sub-div2-option" selected="">
                                                            Selecione
                                                        </option>
                                                        <option>Rio de Janeiro</option>
                                                        <option selected="">Niter&oacute;i</option>
                                                        <option>S&atilde;o Gon&ccedil;alo</option>
                                                        <option>M&eacute;ier</option>
                                                    </select>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group col-2">
                                                        <label for="tipo-logrd">Logradouro</label>
                                                        <select
                                                            class="form-control"
                                                            id="tipo-logrd"
                                                            disabled=""
                                                            >
                                                            <option>Selecione</option>
                                                            <option selected="">Av.</option>
                                                            <option>R.</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col pl-0">
                                                        <label for="logrd">&nbsp;</label>
                                                        <input
                                                            type="text"
                                                            class="form-control"
                                                            id="apiLogradouro"
                                                            disabled=""
                                                            value="Rio Branco"
                                                            />
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group col-2">
                                                        <label for="ddi-telf">Contato</label>
                                                        <input
                                                            type="text"
                                                            class="form-control"
                                                            id="ddi-telf"
                                                            disabled=""
                                                            value="+55"
                                                            />
                                                    </div>
                                                    <div class="form-group col pl-0">
                                                        <label for="telf">&nbsp;</label>
                                                        <input
                                                            type="text"
                                                            class="form-control"
                                                            id="telf"
                                                            disabled=""
                                                            value="(21) 9 1234-5678"
                                                            />
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group col-sm-6">
                                                        <label for="natureza">Natureza</label>
                                                        <select
                                                            class="form-control"
                                                            id="natureza"
                                                            disabled=""
                                                            >
                                                            <option>Selecione</option>
                                                            <option selected="">Publica</option>
                                                            <option>Privada</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-sm-6 pl-0">
                                                        <label for="tipo-estabelecimento"
                                                               >Tipo de estabelecimento</label
                                                        >
                                                        <input
                                                            type="text"
                                                            class="form-control"
                                                            id="tipo-estabelecimento"
                                                            disabled=""
                                                            value="Hospital"
                                                            />
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="col-12 row">
                                <div class="mb-3 mt-3">
                                    <button
                                        href="ui046.jsp"
                                        class="btn btn-primary btn-lg"
                                        form="form-meus-dados"
                                        >
                                        Salvar
                                    </button>
                                </div>
                            </div>

                            <!-- /.row -->
                        </div>
                    </div>
                    <!-- /.container-fluid -->
                </div>
            </div>

            <!-- TABELA VACINAS -->

            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
        <div
            class="modal fade"
            id="modal-default"
            style="display: none"
            aria-hidden="true"
            >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Unidade Vinculada com sucesso!</h4>
                        <button
                            type="button"
                            class="close"
                            data-dismiss="modal"
                            aria-label="Close"
                            >
                            <span aria-hidden="true">Ã</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p></p>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button
                            type="button"
                            class="btn btn-default"
                            data-dismiss="modal"
                            onclick="location.href = './gerenciar-gerente.jsp'"
                            >
                            Close
                        </button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
    </div>
    <!-- ./wrapper -->

</body>
</html>

