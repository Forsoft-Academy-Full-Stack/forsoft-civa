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
<script src="../public/assets/js/cadastrar-vacinacao-internacional.js" async></script>
 </head>



<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@ include file="./navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->


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
                            <h1 class="m-0">Cadastrar nova vacina&ccedil;&atilde;o</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="./vacinacao-internacional.jsp">Voltar</a></li>
                                <li class="breadcrumb-item active">Vacina&ccedil;&atilde;o internacional</li>
                            </ol>
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>


            <!-- Main content -->
            <div class="content">
                <div class="container-fluid">
                    <!---------------------------------------------------------------->

                    <!-- DADOS VACINA&ccedil;&atilde;O -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados portador</h3>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="nome">Nome</label>
                                            <input type="text" class="form-control" id="nome" name="nome" value="Bryan" readonly>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="sobrenome">Sobrenome</label>
                                            <input type="text" class="form-control" id="sobrenome" name="sobrenome" value="Adams" readonly>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="date-birth">Data de nascimento</label>
                                            <input type="date" id="date-birth" name="date-birth"
                                                   class="form-control" placeholder="00/00/0000" value="1945-05-17" readonly>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="doc">Documento</label>
                                            <input type="text" id="doc" name="doc" class="form-control" value="8697894894" readonly>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- DADOS VACINA&ccedil;&atilde;O -->
                    <form class="row" id="form-cad-vacinacao">
                        <div class="col-12 mb-4">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Dados vacina&ccedil;&atilde;o</h3>
                                </div>
                                <div class="card-body">
                                    <!-- /.card-header -->
                                    <!-- form start -->
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="laboratorio">Laborat&oacute;rio</label>
                                            <select class="select2 select2-hidden-accessible" id="laboratorio" name="laboratorio"
                                                    style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                <option selected disabled value="">Selecionar</option>
                                                <option>BioNTech</option>
                                                <option>Oxford</option>
                                                <option>Sputnik V</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="vacina">Vacina</label>
                                            <select class="select2 select2-hidden-accessible" id="vacina" name="vacina" style="width: 100%;"
                                                    tabindex="-1" aria-hidden="true">
                                                <option selected disabled value="">Selecionar</option>
                                                <option>Pfizer</option>
                                                <option>AstraZeneca</option>
                                                <option>Johnson & Johnson</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xl-6">
                                            <label for="dose">N&uacutemero da dose</label>
                                            <select class="select2 select2-hidden-accessible" id="dose" name="dose" style="width: 100%;"
                                                    tabindex="-1" aria-hidden="true">
                                                <option selected disabled value="">Selecionar</option>
                                                <option>1&ordf Dose</option>
                                                <option>2&ordf Dose</option>
                                                <option>Dose unica</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="lote">Lote</label>
                                            <input type="number" class="form-control" id="lote" name="lote" placeholder="Ex: 123123-21">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-12">
                                            <label for="unidade">Unidade da vacina&ccedil;&atilde;o</label>
                                            <select class="select2 select2-hidden-accessible" id="unidade" name="unidade" style="width: 100%;"
                                                    tabindex="-1" aria-hidden="true">
                                                <option selected disabled value="">Selecionar</option>
                                                <option>Hospital Pan</option>
                                                <option>Hospital Casa Italiano</option>
                                                <option>Hospital Federal do AndaraÃ­</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <!-- /.row -->

                    <div class="row">
                        <div class="col-12 mb-4">
                            <button class="btn btn-primary btn-lg" id="cadastrar">Cadastrar</button>
                        </div>
                    </div>

                </div>
                <!-- /.content -->
            </div>
            <!-- /.content- -->
        </div>
        <!-- /.wrapper -->

        <!-- Main Footer -->
        <%@include file="footer.jspf"%>
        <!-- ./footer -->
        <!-- ./wrapper -->
</body>

</html>