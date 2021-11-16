<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("usuario"))) {
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
                <section class="content">


                    <!-- Default box -->
                    <div class="card">
                        <div class="d-flex align-items-center justify-content-between">
                            <p class="text-center h4 m-5">Termos de uso e pol&iacute;ticas de privacidade</p>
                            <div class="mr-5">
                                <a href="./index.jsp"><button type="button" class="btn btn-primary">Voltar</button></a>
                            </div>
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
                        </div>


                    </div>
                    <!-- /.card -->

                </section>

                <!-- /.row -->
            </div>

        </div>

        <!-- Main Footer -->
        <%@include file="footer.jspf" %>

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


</div>
<!-- ./wrapper -->

</body>

</html>