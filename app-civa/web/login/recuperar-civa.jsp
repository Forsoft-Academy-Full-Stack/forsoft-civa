<%@include file="header.jspf"%>
<script src="../public/assets/js/smtp.js" defer></script>
<script src="../public/assets/js/login/recuperar-civa.js" defer></script>
</head>

<body class="content-wrapper " style="background: #fff;">
    <!-- Main content -->
    <%@include file="navbar.jspf" %>
    <div class="container d-flex align-items-center justify-content-center mt-5 mb-5">

        <div class="card card-outline card-primary">
            <div class="card-header text-center">
                <p class="h1" style="white-space: nowrap;">Recuperar CIVA</p>
            </div>
            <div class="card-body">
                <p class="login-box-msg">O c&oacute;digo CIVA ser&aacute; enviado para o seu email.</p>
                <form id="form-recuperar-civa">
                    <div class="input-group mb-3">
                        <input type="hidden" value="recuperar-civa" name="option">
                        <input type="email" class="form-control" id="email" name="email" placeholder="maria@mail.com">
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-envelope"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button type="button" class="btn btn-primary btn-block" id="enviar">ENVIAR</button>
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