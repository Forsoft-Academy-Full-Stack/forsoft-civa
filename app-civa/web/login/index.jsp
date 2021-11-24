<%@include file="header.jspf"%>
    <script src="../public/assets/js/index-login.js" defer></script>
</head>

<body cz-shortcut-listen="true">
    <%@include file="navbar.jspf" %>
    
        <div class="container">
            <div class="row py-5 mt-4 align-items-center" style="background-color: #fff;">
                <div class="col-md-5 pr-lg-2 mb-5 mb-md-0">
                    <!-- .content -->
                    <div class="jumbotron ">
                        <h1 class="display-6">Bem vindo &agrave; carteira de vacina&ccedil;&atilde;o CIVA.</h1>
                    </div>
                    <!-- /.content -->
                </div>
                <div class="col-md-7 col-lg-6 ml-auto">
                    <div class="card card-outline card-primary">
                        <div class="card-header text-center h1">
                            <p class="login-box-msg h4">Fa&ccedil;a seu login</p>
                        </div>
                        <div class="card-body">
                            <form action="${pageContext.request.contextPath}/auth" id="login" method="POST">
                                <div class="input-group mb-3 ">
                                    <label for="exampleFormControlSelect1">Tipo de Acesso</label>
                                    <select id="perfil" name="perfil" class=" form-select form-select-lg mb-3 select2 select2-hidden-accessible"
                                            style="width: 100%;" tabindex="-1" aria-hidden="true">
                                        <option value="not-user" selected readonly>Selecionar acesso</option>
                                        <option value="portador-civa">Usu&aacute;rio</option>
                                        <option value="gerente">Gerente</option>
                                        <option value="supervisor">Supervisor</option>
                                        <option value="profissional-saude">Profissional da Sa&uacute;de</option>
                                        <option value="suporte-civa">Suporte CIVA</option>
                                        <option value="gestor-nacional">Gestor Nacional</option>
                                        <option value="gestor-oms">Gestor OMS</option>
                                    </select>
                                </div>
                                <div class="input-group mb-3">
                                    <input type="email" id="email" name="email" class="form-control" placeholder="Email">
                                    <input type="text" id="civa" name="civa" style="display: none;" class="form-control" placeholder="civa">
                                    <div class="input-group-append" id="user-logo">
                                        <div class="input-group-text">
                                            <span class="fas fa-envelope"></span>
                                        </div>
                                    </div>
                                    <div class="input-group-append" style="display: none;" id="civa-logo">
                                        <div class="input-group-text">
                                            <span class="fas fa-passport"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="input-group mb-3">
                                    <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" >
                                    <div class="input-group-append">
                                        <div class="input-group-text">
                                            <span class="fas fa-lock"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col d-flex justify-content-center"">
                                        <button type="Submit" form="login" class="btn btn-primary btn-block">Entrar</button>
                                    </div>
                                    <!-- /.col -->
                                </div>
                            </form>
                            <div class="mb-3 d-flex justify-content-between my-4">
                                <p class="mb-1">
                                    <a href="./recuperar-senha.jsp">Esqueceu sua senha?</a>
                                </p>
                                <p class="mb-0">
                                    <a href="./recuperar-civa.jsp" class="text-center">Recuperar CIVA</a>
                                </p>
                            </div>
                            <div class="d-flex justify-content-center">
                                <a href="./validar-civa.jsp" class="btn btn-outline-primary"><i class="fas fa-qrcode mr-1"></i>VALIDAR
                                    CIVA</a>
                            </div>
                            <div class="d-flex justify-content-center  my-3">
                                <p>N&atilde;o tem uma conta ainda? <span class="text-danger"> <a href="./cadastro-portador.jsp"><b>Criar conta</b></span></a>
                                </p>
                            </div>
                            <div class="mt-5 text-center">
                                <strong>CIVA &copy; <a href="https://www.forsoftacademy.com.br/">Forsoft Academy</a>.</strong>
                            </div>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
            </div><!-- /.login-page -->
            <section class="content rounded" id="quemsomos" style="background: #E9ECEF">

                <!-- Default box -->
                <div class="card-body">
                    <div class=" row justify-content-around">
                        <div class="col-md-5 pr-lg-2 mb-5 mb-md-0 text-center d-flex align-items-center justify-content-center">
                            <div class="">
                                <a href="./index.jsp">
                                    <img src="../public/img/icon-civa-footer-darkblue.svg" alt="logo civa" width="180px" class="ml-5">
                                </a>
                                <p class="lead m-5 text-left">Somos uma carteira digital de vacina&ccedil;&atilde;o de iniciativa da OMS, trabalhamos para garantir que a Sa&uacute;de e seguran&ccedil;a da popula&ccedil;&atilde;o.</p>
                            </div>
                        </div>
                        <div class="col-md-7 col-lg-6 ml-auto">
                            <div class="card-header text-center h1">
                                <p class="login-box-msg lead">Entre em contato.</p>
                            </div>

                            <div class="form-group">
                                <label for="name">Nome</label>
                                <input type="text" id="name" class="form-control" name="name">
                            </div>
                            <div class="form-group">
                                <label for="email">E-mail</label>
                                <input type="email" id="email" class="form-control" name="email">
                            </div>
                            <div class="form-group">
                                <label for="subject">Assunto</label>
                                <input type="text" id="subject" class="form-control" name="subject">
                            </div>
                            <div class="form-group">
                                <label for="message">Mensagem</label>
                                <textarea id="message" name="message" class="form-control" rows="4"></textarea>
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" value="Enviar">
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="footer.jspf" %>

            </section>
        </div>

</body>

</html>