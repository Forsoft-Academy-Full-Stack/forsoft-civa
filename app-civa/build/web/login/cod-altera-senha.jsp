<% try {
        Integer idAtor = Integer.parseInt(request.getParameter("idAtor"));
        pageContext.setAttribute("idAtor", idAtor);

        String tipo = request.getParameter("tipo");
        pageContext.setAttribute("tipo", tipo);

    } catch (Exception e) {
        Integer idAtor = Integer.parseInt(request.getParameter("idAtor"));
        pageContext.setAttribute("idAtor", idAtor);

        String tipo = request.getParameter("tipo");
        pageContext.setAttribute("tipo", tipo);
    }

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/login/cod-alterar-senha.js" defer></script>
</head>

<body class="content-wrapper " style="background: #fff;">
    <!-- Main content -->
    <%@include file="navbar.jspf" %>
    <div class="container d-flex align-items-center justify-content-center mt-5 mb-5">
        <!-- /.login-logo -->
        <div class="card card-outline card-primary" style="min-width: 400px;">
            <div class="card-header text-center">
                <p class="h1" style="white-space: nowrap;">Recuperar senha</p>
            </div>
            <div class="card-body">
                <p class="login-box-msg">Insira o c&oacute;digo para alterar a senha.</p>
                <form id="altera-senha">
                    <input type="hidden" value="validar-cod" name="option">
                    <input type="hidden" value="${tipo}" name="tipo">
                    <input type="hidden" value="${idAtor}" name="idAtor">
                    <div class="form-group">

                        <input type="text" class="form-control mb-1" placeholder="C&oacute;digo enviado" id="codigo-enviado" name="codigo-enviado">
                        <div class="input-group-append">
                        </div>
                        <p>N&atilde;o recebeu? <a href="./recuperar-senha.jsp">Reenviar o c&oacute;digo.</a></p>
                        <div class="row">
                            <div class="col-12">
                                <button type="button" class="btn btn-primary btn-block" id="avancar"> <b>AVAN&Ccedil;AR</b></button>
                            </div>
                        </div>
                </form>
                <div class="d-flex justify-content-center">
                    <p class="mt-3 mb-1 ">
                        <a href="./recuperar-senha.jsp"><b>VOLTAR</b></a>
                    </p>
                </div>

            </div>
            <!-- /.card-body -->
        </div>
        <!-- /.card -->
    </div>

</div>
    <%@include file="footer.jspf" %>

    

<!-- /.login-box -->
</body>

</html>