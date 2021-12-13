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
<%    try {
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
            <div class="modal fade show " id="modal-validar-form" style="display: block; padding-right: 17px;" aria-modal="true">
                <div class="modal-dialog ">
                    <div class="modal-content card-body card-primary card-outline">
                        <p class="h3 text-center  mt-3">Leitor QRCODE</p></video>
                        <div class="justify-content-center d-flex mt-3">
                            <video src="#" style="border: 3px solid rgb(139, 138, 138); background: rgba(139, 138, 138, 0.342);"></video>
                        </div>
                        <form id="validar-civa" name="validar-civa" action="../login/certificado-civa.jsp" method="GET">
                            <div class="m-5">
                                <p class="text-center">N&atilde;o consegue escanear? Digite o c&oacute;digo CIVA.</p>
                                <input class="form-control form-control-sm text-center" type="text" name="codigoCiva" id="codigoCiva"
                                       placeholder="Digite o c&oacute;digo de autententica&ccedil;&atilde;o.">
                                <input type="hidden" value="validar" class="form-control" id="option" name="option">
                            </div>
                        </form>
                        <div class="modal-footer justify-content-between">
                            <button form="validar-civa"  type="submit" class="btn btn-block btn-primary" data-toggle="modal"
                                    id="validar-cod">VALIDAR</button>
                            <a href="./index.jsp" class="btn btn-block btn-outline-primary">VOLTAR</a>
                        </div>

                    </div>
                    <!-- /.modal-content -->
                </div>

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