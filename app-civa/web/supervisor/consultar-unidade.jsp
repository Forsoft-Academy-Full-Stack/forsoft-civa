<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("supervisor"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/supervisor/consultar-unidade.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@ include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>


        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">


            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Pesquisar Unidade</h1>
                        </div><!-- /.col -->

                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Consultar Unidade</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>

            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->
                    <!-- PESQUISA E FILTRO -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <div class="row">
                                        <div class="row col-md-12 col-sm-12">
                                            <div class="col-xl-2 col-sm-12 mb-2">
                                                <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                    <option value="1">Nome A - Z</option>
                                                    <option value="2">Nome Z - A</option>
                                                    <option value="3">CPF crescente</option>
                                                    <option value="3">CPF decrescente</option>
                                                </select>
                                            </div>

                                            <div class="col-xl-8 col-sm-12">
                                                <div class="input-group  mb-2">
                                                    <input type="text" class="form-control" placeholder="Pesquisar Unidade">
                                                    <div class="input-group-append">
                                                        <button class="btn btn-outline-secondary" type="button" id="button-addon2">Pesquisar</button>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-2"> 
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-default">CSV</button>
                                                    <button type="button" class="btn btn-default">PDF</button>
                                                    <button type="button" class="btn btn-default">Excel</button>
                                                </div>

                                            </div>

                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- TABELA -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-hover text-nowrap">
                                        <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Estado</th>
                                                <th>Munic&iacute;pio</th>
                                                <th>CEP</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Av Rio branco</td>
                                                <td>Rio de Janeiro</td>
                                                <td>Rio de janeiro</td>
                                                <td>50120-320</td>
                                                <td><a href="./painel-unidade.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                            </tr>
                                            <tr>
                                                <td>Av Rio branco</td>
                                                <td>Rio de Janeiro</td>
                                                <td>Rio de janeiro</td>
                                                <td>50120-320</td>
                                                <td><a href="./painel-unidade.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                            </tr>
                                            <tr>
                                                <td>Av Rio branco</td>
                                                <td>Rio de Janeiro</td>
                                                <td>Rio de janeiro</td>
                                                <td>50120-320</td>
                                                <td><a href="./painel-unidade.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                            </tr>
                                            <tr>
                                                <td>Av Rio branco</td>
                                                <td>Rio de Janeiro</td>
                                                <td>Rio de janeiro</td>
                                                <td>50120-320</td>
                                                <td><a href="./painel-unidade.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                            </tr>
                                            <tr>
                                                <td>Av Rio branco</td>
                                                <td>Rio de Janeiro</td>
                                                <td>Rio de janeiro</td>
                                                <td>50120-320</td>
                                                <td><a href="./painel-unidade.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                            </tr>
                                        </tbody>
                                    </table>

                                </div>
                                <!-- /.card-body -->

                            </div>

                        </div>

                    </div>

                    <!-- PAGINA&Ccedil;&Atilde;O -->
                    <div class="row">      
                        <div class="col-6">

                            <%@ include file="paginacao.jspf" %>
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
    </div>
    <!-- ./wrapper -->
</body>
</html>

