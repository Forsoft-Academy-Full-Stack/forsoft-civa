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
                                <h1 class="m-0">Pesquisar Gerente</h1>
                            </div>
                            <!-- /.col -->

                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
                                    <li class="breadcrumb-item active">Consultar gerentes</li>
                                </ol>
                            </div>
                        </div>
                        <!-- /.row --> 
                    </div>
                    <!-- /.container-fluid -->
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
                                                        <input type="text" class="form-control" id="search-table" placeholder="Pesquisar Gerente">
                                                        <div class="input-group-append">
                                                            <button class="btn btn-outline-secondary" type="button" id="button-addon2" onclick="pesquisaNomes(); return false">Pesquisar</button>
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
                                        <table id="test-table" class="table table-hover text-nowrap">
                                            <thead>
                                                <tr>
                                                    <th style="cursor: pointer;">Nome</th>
                                                    <th style="cursor: pointer;">Identifica&ccedil;&atilde;o</th>
                                                    <th style="cursor: pointer;">Data</th>
                                                    <th style="cursor: pointer;">C&oacute;digo CIVA</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Bill Withers</td>
                                                    <td>123.155.189-15</td>
                                                    <td>04-07-1938</td>
                                                    <td>BRA132456789</td>
                                                    <td><a href="gerenciar-gerente.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Tom Jobim</td>
                                                    <td>065.354.200-01</td>
                                                    <td>25-01-1927</td>
                                                    <td>BRA313123534</td>
                                                    <td><a href="gerenciar-gerente.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Michael Jackson</td>
                                                    <td>215.489.158-14</td>
                                                    <td>29-10-1958</td>
                                                    <td>BRA312312321</td>
                                                    <td><a href="gerenciar-gerente.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>George Michael</td>
                                                    <td>554.489.489-15</td>
                                                    <td>25-06-1963</td>
                                                    <td>BRA519194156</td>
                                                    <td><a href="gerenciar-gerente.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Whitney Houston</td>
                                                    <td>194.891.981-48</td>
                                                    <td>09-10-1963</td>
                                                    <td>BRA651847616</td>
                                                    <td><a href="gerenciar-gerente.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Freddie Mercury</td>
                                                    <td>221.911.911-15</td>
                                                    <td>05-09-1946</td>
                                                    <td>BRA461668464</td>
                                                    <td><a href="gerenciar-gerente.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Bryan Adams</td>
                                                    <td>634.324.123-57</td>
                                                    <td>05-11-1959</td>
                                                    <td>BRA461666523</td>
                                                    <td><a href="gerenciar-gerente.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Elis Regina</td>
                                                    <td>884.054.264-05</td>
                                                    <td>17-05-1945</td>
                                                    <td>BRA312312323</td>
                                                    <td><a href="gerenciar-gerente.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
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

                                <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button page-item previous disabled" id="example2_previous">
                                            <a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">Anterior</a></li>

                                        <li class="paginate_button page-item active"><a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">1</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0" class="page-link">2</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0" class="page-link">3</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0" class="page-link">4</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0" class="page-link">5</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0" class="page-link">6</a></li>
                                        <li class="paginate_button page-item next" id="example2_next"><a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0" class="page-link">Pr&oacute;ximo</a></li>
                                    </ul>
                                </div>
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
             <%@include file="footer.jspf"%>
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS ------------------------------------------------------->

        <!-- jQuery -->
        <script src="../public/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Select2 -->
        <script src="../public/plugins/select2/js/select2.full.min.js"></script>
        <!-- Por Rodrigo Carlos -->
        <!-- pesquisa -->
        <script>
        function pesquisaNomes() {
            let input, filter, table, tr, td, i, txtValue;
            input = document.getElementById('search-table');
            filter = input.value.toUpperCase();
            table = document.getElementById("test-table");
            tr = table.getElementsByTagName("tr");

            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
        </script>
        <!-- tableSorter -->
        <script src="https://cdn.jsdelivr.net/tablesorter/2.17.4/js/jquery.tablesorter.min.js"></script>
        <script>
            $('#test-table').tablesorter();
        </script>

        <!-- AdminLTE App -->
        <script src="./../public/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="./../public/dist/js/demo.js"></script>

        <script>
            $(function () {
                $('.select2').select2()
            });
        </script>
    </body>

</html>
s