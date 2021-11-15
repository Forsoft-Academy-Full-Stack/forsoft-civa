<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente

    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("profissional-saude"))) {
        // Caso for uma das duas opções
        // Redicionar para o login
        response.sendRedirect("../login/");
    }

    // Caso contrário é um usuário válido, pode entrar na página  
%>
<%@include file="header.jspf"%>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
 <!-- Navbar --------------------------------------------->
        <%@ include file="./navbar.jspf" %>

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@ include file="menu.jspf" %>
        <!-- /.sidebar ------------------------------------------------------>

        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Painel vacina&ccedil;&atilde;o</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./gerenciar-portador.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Painel portador CIVA</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->
                    <!-- DADOS PORTADOR -->
                    <div class="row">
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados portador</h3>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="name">Nome</label>
                                            <input type="text" id="name" id="name" class="form-control"  value="Elis" disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="surname">Sobrenome</label>
                                            <input type="text" id="surname" name="surname" class="form-control" value="Regina" disabled>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="date-birth">Data de nascimento</label>
                                            <input type="date" id="date-birth" name="date-birth"
                                                   class="form-control" placeholder="00/00/0000" disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="doc">Documento</label>
                                            <input type="text" id="doc" name="doc"
                                                   class="form-control"placeholder="884.054.264-05" disabled>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- DADOS VACINA&ccedil;&atildeO -->
                    <form class="row" id="form-painel-vacinacao" >
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados vacina&ccedil;&atilde;o</h3>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <div class="row">
                                        <div class="form-group col-xl-12">
                                            <label for="idvacinacao">ID vacina&ccedil;&atilde;o</label>
                                            <input type="text" class="form-control" id="idvacinacao" name="idvacinacao" value="5649841"
                                                   readonly>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="vacina">Vacina</label>
                                            <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                                                    aria-hidden="true" id="vacina" name="vacina" disabled>
                                                <option value="2" selected>CoronaVac</option>
                                                <option value="3">Pfizer</option>
                                                <option value="3">AstraZeneca</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="laboratorio">Laborat&oacute;rio</label>
                                            <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                                                    aria-hidden="true" id="laboratorio" name="laboratorio" disabled>
                                                <option value="2" selected>Sinovac</option>
                                                <option value="3">Oxford</option>
                                                <option value="3">Sputinik V</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="dose">Dose</label>
                                            <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                                                    aria-hidden="true" id="dose" name="dose" disabled>
                                                <option value="2" selected>2Â° Dose</option>
                                                <option value="3">1Â° Dose</option>
                                                <option value="3">Dose unica</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="dataaplicacao">Data de aplica&ccedil;;&atilde;o</label>
                                            <input type="date" class="form-control" value="2021-03-17" id="dataaplicacao" name="dataaplicacao"
                                                   disabled>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="form-group col-xl-12">
                                            <label for="pais">Pa&iacute;s</label>
                                            <input type="text" class="form-control" id="pais" name="pais" value="Brasil" disabled>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="idunidade">ID unidade</label>
                                            <input type="text" class="form-control" id="idunidade" name="idunidade" value="6518842" disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="unidade">Unidade de vacina&ccedil;&atilde;o</label>
                                            <input type="text" class="form-control" id="unidade" name="unidade" value="Hospital Pan" disabled>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="codigociva">C&oacute;digo CIVA profissional</label>
                                            <input type="text" class="form-control" id="codigociva" name="codigociva" value="BRA55123456789"
                                                   disabled>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="lote">Lote</label>
                                            <input type="text" class="form-control" id="lote" name="lote" value="12412412-21" disabled>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-12 mb-4">
                            <button type="button" class="btn btn-primary btn-lg" id="salvar">Salvar</button>
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
        <!-- ./footer -->
    </div>
    <!-- ./wrapper -->
    <script>
        $(function () {
            $('.select2').select2()
        });

        let form = $("#form-painel-vacinacao");

        $("#salvar").click(function () {

            if (tratar_campos()) {
                $.get("", form.serialize(), (data, status) => {
                    if (status === 'success') {

                        Swal.fire({
                            icon: 'success',
                            title: 'Dados alterados com sucesso!',
                            text: "Altera&ccedil;&atildeo realizada.",
                            confirmButtonText: 'Finalizar',
                            confirmButtonColor: '#007bff'
                        });

                        console.log("Dados enviados com sucesso :) !");

                    } else {

                        console.log("Ops... Algum erro ocorreu e seus dados n&atildeo foram enviados :(");

                        Swal.fire({
                            icon: 'error',
                            title: '',
                            text: 'Ops... Algum erro ocorreu e seus dados n&atildeo foram enviados :(!',
                            confirmButtonText: 'Finalizar'
                        });
                    }
                });
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Todos os campos precisam ser preenchidos!',
                    confirmButtonColor: '#007bff'
                })
            }
        });

    </script>
</body>
</html>