<%@include file="header.jspf"%>

<script src="../public/assets/js/smtp.js" defer></script>
<script src="../public/assets/js/login/recuperar-senha.js" defer></script>
<
</head>

<body class="content-wrapper " style="background: #fff;">

    <!-- Main content -->
    <%@include file="navbar.jspf" %>
    <div class="container d-flex align-items-center justify-content-center mt-5 mb-5">


        <div class="card card-outline card-primary">
            <div class="card-header text-center">
                <p class="h1" style="white-space: nowrap;">Recuperar senha</p>
                <form  id="form-tipo-acesso">
                    <div class=""row>
                        <label for="tipo">Tipo de Acesso</label>
                        <select id="tipo" name="tipo" class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
                            <option selected value="" selected disabled>Selecionar</option>
                            <option value="portador">Usuário</option>
                            <option value="gestor">Gestores</option>
                        </select>
                        <input type="hidden" value="recuperar-senha" name="option">
                    </div>
                </form>

            </div>
            <div class="card-body">
                <p class="login-box-msg">Um email ser&aacute; enviado com um c&oacute;digo para a redefini&ccedil;&atilde;o de senha.</p>
                <form  id="form-email">
                    <div class="input-group mb-3">
                        <input type="email" class="form-control" id="email" name="email" placeholder="maria@mail.com">
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-envelope"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button type="button"  id="enviar" class="btn btn-primary btn-block">ENVIAR</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>
                <div class="d-flex justify-content-center">
                    <p class="mt-3 mb-1 ">
                        <a href="./index.jsp"><b>Voltar</b></a>
                    </p>
                </div>

            </div>
            <!-- /.card-body -->
        </div>
        <!-- /.card -->

    </div>

    <%@include file="footer.jspf" %>



</body>
</html>
