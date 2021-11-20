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
<%@include file="header.jspf"%>
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
                            <h1 class="m-0">Termos de Uso</h1>
                        </div>    
                    </div>  
                </div>
            </div>

            <div class="container-fluid">
                <!---------------------------------------------------------------->

                <section class="content">

                    <!-- Default box -->
                    <div class="card">
                        <div class="content-header">
                            <div class="container-fluid">
                                <div class="row mb-2">
                                    <div class="col-sm-6">
                                        <h1 class="m-0">Termos de uso</h1>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.container-fluid -->
                        </div>

                        <div>
                            <p class="text-left m-3">Lorem ipsum dolor sit amet. Hic consequatur tenetur et ipsum
                                commodi ad dolorum autem ad fugiat pariatur et minima laudantium est quae nihil. Sit
                                quae facilis aut modi molestiae eos dicta animi sit repudiandae veritatis sed
                                neque maiores. Lorem ipsum consectetur etiam viverra primis tortor dictum egestas nam
                                urna ut, et in dictum dui morbi nulla enim at cursus aenean. dictum interdum orci
                                euismod fames sagittis lacus aliquet, vehicula pharetra
                                et praesent torquent tincidunt, primis dictumst faucibus cursus posuere neque. mauris
                                vel quisque aptent sollicitudin arcu dolor, quisque ornare aliquam justo tortor, class
                                senectus mattis cras duis. lectus est leo euismod
                                potenti felis fames feugiat consequat pellentesque, nec hac mi ad netus a conubia massa
                                tellus bibendum, iaculis tempus at nisl metus nisi quam cursus. condimentum risus
                                bibendum vestibulum leo torquent etiam, quisque gravida
                                feugiat tortor sapien, sociosqu convallis netus dui dictumst. 1. Lorem ipsum 11.Lorem
                                ipsum consectetur etiam viverra primis tortor dictum egestas nam urna ut, et in dictum
                                dui morbi nulla enim at cursus aenean. dictum
                                interdum orci euismod fames sagittis lacus aliquet, vehicula pharetra et praesent
                                torquent tincidunt, primis dictumst faucibus cursus posuere neque. mauris vel quisque
                                aptent sollicitudin arcu dolor, quisque ornare aliquam
                                justo tortor. 12. class senectus mattis cras duis. lectus est leo euismod potenti felis
                                fames feugiat consequat pellentesque, nec hac mi ad netus a conubia massa tellus
                                bibendum, iaculis tempus at nisl metus nisi quam cursus.
                                condimentum risus bibendum vestibulum leo torquent etiam, quisque gravida feugiat tortor
                                sapien, sociosqu convallis netus dui dictumst.
                            </p>
                            <div class="row float-right mr-3">
                                <div class="col-12 mb-4">
                                    <a href="./index.jsp" class="btn btn-primary btn-lg">Voltar</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </section>

            </div>

        </div>

        <!-- Main Footer -->
        <%@include file="footer.jspf" %>

        <!-- /.content -->
    </div>

</body>

</html>