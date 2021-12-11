<%@page import="dao.UnidadeDao"%>
<%@page import="model.Unidade"%>
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
<%  
    try {
        PortadorCiva portadorCiva = PortadorCivaDao.findByCodigoCiva(pessoa.getCodigoCiva());
        pageContext.setAttribute("portadorCiva", portadorCiva);

        Unidade unidade = UnidadeDao.findById(portadorCiva.getListaVacinacao().get(0).getIdUnidade());
        pageContext.setAttribute("unidade", unidade);
    } catch (Exception e) {
    }

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/portador-civa/validar-civa-logado.js" defer></script>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <!-- Navbar --------------------------------------------->
        <%@include file="navbar.jspf" %>
        <!-- /.navbar ------------------------------------------------------->

        <!-- MENU Main Sidebar Container ------------------------------------>
        <%@include file="menu.jspf" %>
        <!-- /.menu ------------------------------------------------------->


        <!-- Content Wrapper. Contains page content -------------------------->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0">Leitor QRCODE</h1>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content-header ---------------------------------------------->

            <!-- Main content -->
            <div class="container-fluid">
                <!---------------------------------------------------------------->
                <section class="content d-flex justify-content-center">

                    <!-- Default box -->
                    <div class="card card-body card-primary card-outline " style="max-width: 700px;">
                        <div >
                            <p class="h3 text-center  mt-3">Leitor QRCODE</p>
                            <div class="justify-content-center d-flex mt-3">
                                <video src="#" style="border: 3px solid rgb(139, 138, 138); background: rgba(139, 138, 138, 0.342);"></video>
                            </div>
                            <div class="m-5">
                                <p class="text-center">N&atilde;o consegue escanear? Digite o c&oacute;digo de autententica&ccedil;&atilde;o.</p>
                                <input class="form-control form-control-sm text-center" type="text"
                                       placeholder="Digite o codigo de autentica&ccedil;&atilde;o" name="cod-civa" id="cod-civa">
                            </div>

                            <div class="modal-footer justify-content-between">
                                <button type="button" class="btn btn-block btn-primary"  data-toggle="modal"
                                        data-target="#modal-default">VALIDAR</button>
                                <a href="./index.jsp" class="btn btn-block btn-outline-primary">VOLTAR</a>
                            </div>
                        </div>

                    </div>
                    <!-- /.card -->

                </section>

                <!-- /.row -->
            </div>
        </div>

        <!-- Main Footer -->
        <%@include file="footer.jspf" %>

        <!-- Main Footer -->
        <%@include file="modal-certificado-civa-scan.jspf" %>
        <!-- /.content -->
    </div>

</body>
</html>