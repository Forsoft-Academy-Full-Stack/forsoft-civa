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
<script src="../public/assets/js/login/alterar-senha.js" defer></script>
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

                <form id="form-altera-senha" method="POST">
                    <input type="hidden" value="nova-senha" name="option">
                    <input type="hidden" value="${tipo}" name="tipo">
                    <input type="hidden" value="${idAtor}" name="idAtor">
                    <div class="form-group">
                        <label for="nova-senha">Nova Senha</label>
                        <input type="password" class="form-control mb-1" placeholder="Nova Senha" id="nova-senha" name="nova-senha">
                        <label for="confimar-senha">Confimar Senha</label>
                        <input type="password" class="form-control mb-1" placeholder="Confirmar Senha" id="confimar-senha" name="confimar-senha">
                        <div class="input-group-append">
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-12">
                                <button type="button" class="btn btn-primary btn-block" id="alterar"> <b>ALTERAR</b></button>
                            </div>
                        </div>
                </form>
                <div class="d-flex justify-content-center">
                    <p class="mt-3 mb-1 ">
                        <a href="./cod-altera-senha.jsp"><b>VOLTAR</b></a>
                    </p>
                </div>
            </div>
            <!-- /.card-body -->
        </div>
        <!-- /.card -->
    </div>

</div>

<%@include file="footer.jspf" %>
<%@include file="modal-recuperar-senha.jspf" %>

</body>
</html>
