<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CIVA</title>

        <link rel="shortcut icon" href="../public/img/favicon-pc.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet">


        <!-- Font Icons Google -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">


        <!-- Font Icones -->
        <!-- Estilo icones -->
        <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">

        <!-- Select2 -->
        <link rel="stylesheet" href="../public/plugins/select2/css/select2.min.css">

        <!-- Font Icons Google -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">

        <!-- Estilo icones -->
        <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

        <script src="../public/plugins/sweetalert2/sweetalert2.all.min.js" defer></script>
        <!-- jQuery -->
        <script src="../public/plugins/jquery/jquery.min.js" defer></script>
        <!-- Bootstrap 4 -->
        <script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js" defer></script>
        <!-- Select2 -->
        <script src="../public/plugins/select2/js/select2.full.min.js" defer></script>



        <!-- AdminLTE App -->
        <script src="../public/dist/js/adminlte.min.js" defer></script>

        <!-- AXIOS -->
        <script src="https://unpkg.com/axios/dist/axios.min.js" defer></script>
        <!-- PESQUISAR CEP -->

        <!-- TODOS PAISES SELECT NACIONALIDADE -->
        <script src="../public/assets/js/getCountry.js" defer></script>

        <!-- AdminLTE for demo purposes -->

        <script src="../public/assets/js/default.js" defer></script>
        <script src="../public/assets/js/index-login.js" defer></script>



    </head>

    <body cz-shortcut-listen="true">
        <nav class="navbar navbar-expand navbar-white navbar-light justify-content-between border-bottom">
            <!-- Left navbar links -->
            <a href="./index.jsp">
                <img src="../public/img/icon-civa-footer-darkblue.svg" alt="logo civa" width="180px" class="ml-5">
            </a>
            <ul class="navbar-nav mr-5">
                <li class="nav-item d-none d-sm-inline-block">
                    <a href="#quemsomos" class="nav-link">Quem somos?</a>
                </li>
            </ul>
        </nav>
        <div class="login-page justify-content-around" style="flex-direction: row; background-color: #fff;">
            <div class="col-md-6 ">
                <!-- .content -->
                <div class="jumbotron ">
                    <h1 class="display-6">Bem vindo à carteira de vacinação CIVA.</h1>

                </div>
                <!-- /.content -->
            </div>
            <div class="login-box">
                <div class="card card-outline card-primary">

                    <div class="card-header text-center h1">
                        <p class="login-box-msg h4">Fa&ccedil;a seu login</p>
                    </div>
                    <div class="card-body">

                        <form action="${pageContext.request.contextPath}/auth" method="POST">
                            <div class="form-group input-group mb-3 col-xl-12 ">
                                <label for="exampleFormControlSelect1">Tipo de Acesso</label>
                                <select id="perfil" name="perfil" class="select2 select2-hidden-accessible"
                                        style="width: 100%;" tabindex="-1" aria-hidden="true">
                                    <option value="not-user" selected readonly>Selecionar acesso
                                    </option>
                                    <option value="usuario">Usu&aacute;rio</option>
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
                                <!-- /.col -->
                                <div class="d-flex justify-content-center">
                                    <div class="col-12 mb-4 d-flex justify-content-center"">
                                        <button type="Submit" class="btn btn-primary btn-lg" >Entrar</button>
                                    </div>
                                </div>
                                <!-- /.col -->
                            </div>
                        </form>
                        <div class="mb-3 d-flex justify-content-between">
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
                        <div class="d-flex justify-content-center  mt-3">
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
        <section class="content" id="quemsomos">

            <!-- Default box -->
            <div class="">
                <div class="card-body row justify-content-around">
                    <div class="col-5 text-center d-flex align-items-center justify-content-center">
                        <div class="">
                            <a href="./index.jsp">
                                <img src="../public/img/icon-civa-footer-darkblue.svg" alt="logo civa" width="180px" class="ml-5">
                            </a>
                            <p class="lead m-5 text-left">Somos uma carteira digital de vacinação de iniciativa da OMS, trabalhamos para garantir que a saúde e segurança da população.</p>
                        </div>
                    </div>
                    <div class="col-5">
                        <div class="card-header text-center h1">
                            <p class="login-box-msg lead">Entre em contato.</p>
                        </div>

                        <div class="form-group">
                            <label for="name">Nome</label>
                            <input type="text" id="name" class="form-control" name="name">
                        </div>
                        <div class="form-group">
                            <label for="email">E-Mail</label>
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

    </body>

</html>