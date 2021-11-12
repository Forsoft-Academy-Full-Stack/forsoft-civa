<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("suporte-civa"))) {
        // Caso for uma das duas opções
        // Redicionar para o login
        response.sendRedirect("../login/");

    }
    
   // Caso contrário é um usuário válido, pode entrar na página
  
%>
<%@include file="header.xhtml"%>

    </head>

    <body class="hold-transition sidebar-mini">
        <div class="wrapper">

            <!-- Navbar --------------------------------------------->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button">
                            <i class="fas fa-bars"></i>
                        </a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="" class="nav-link">Consultar unidade</a>
                    </li>
                </ul>
            </nav>
            <!-- /.navbar ------------------------------------------------------->

            <!-- MENU Main Sidebar Container ------------------------------------>
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Brand Logo -->
                <a href="./index.jsp" class="brand-link">
                  <img src="../public/img/favicon-gs.svg" alt="AdminLTE Logo" class="brand-image img-circle"
                    style="opacity: .8">
                  <span class="brand-text font-weight-light">CIVA</span>
                </a>
          
                <!-- Sidebar -->
                <div class="sidebar">
                  <!-- Sidebar user panel (optional) -->
                  <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                    <div class="image">
                      <img src="../public/img/no-user.svg" class="img-circle elevation-2" alt="User Image">
                    </div>
                    <div class="info">
                       <a href="#" class="d-block">${dados.nome}</a>
                         <a href="#" class="d-block">${dados.sobrenome}</a>
                    </div>
                  </div>
          
                  <!-- Sidebar Menu -->
                  <nav class="mt-2">
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                      <!-- ITENS DO MENU -->
                      <li class="nav-item">
                        <a href="./index.jsp" class="nav-link">
                          <i class="nav-icon fas fa-home"></i>
                          <p>
                            Home
                          </p>
                        </a>
                      </li>
                      <!-- ITEM GERENCIAR USUARIO DO MENU -->
          
                      <li class="nav-item  menu-open">
                        <a href="#" class="nav-link">
                            <!-- <i class="nav-icon fas fa-user-friends"></i> -->
                            <p>Suporte Civa
                                <i class="right fas fa-angle-left"></i>
          
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                        <li class="nav-item">
                          <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-user-friends"></i>
                            <p>
                              Portador CIVA
                              <i class="right fas fa-angle-left"></i>
                            </p>
                          </a>
                          <ul class="nav nav-treeview">
                            <li class="nav-item">
                              <a href="./consultar-portador.jsp" class="nav-link">
                                <i class="fas fa-search nav-icon"></i>
                                <p>Consultar Portador</p>
                              </a>
                            </li>
                            <li class="nav-item">
                              <a href="./cadastrar-portador.jsp" class="nav-link">
                                <i class="fas fa-user-plus nav-icon"></i>
                                <p>Cadastrar Portador</p>
                              </a>
                            </li>
                          </ul>
                        </li>
                    </ul>
                    <ul class="nav nav-treeview">
                      <li class="nav-item ">
                          <a href="#" class="nav-link">
                              <i class="fas fa-user-friends nav-icon"></i>
                              <p>
                                  Gerente
                                  <i class="right fas fa-angle-left"></i>
                              </p>
                          </a>
                          <ul class="nav nav-treeview">
                              <li class="nav-item">
                                  <a href="./consultar-gerente.jsp" class="nav-link">
                                      <i class="fas fa-clipboard-check nav-icon"></i>
                                      <p>Consultar Gerente</p>
                                  </a>
                              </li>
                              <li class="nav-item">
                                  <a href="./cadastrar-gerente.jsp" class="nav-link">
                                      <i class="fas fa-user-plus nav-icon"></i>
                                      <p>Cadastrar Gerente</p>
                                  </a>
                              </li>
          
                          </ul>
                      </li>
                  </ul>
                    <ul class="nav nav-treeview">
                      <li class="nav-item ">
                          <a href="#" class="nav-link">
                              <i class="fas fa-user-friends nav-icon"></i>
                              <p>
                                  Gestores nacionais
                                  <i class="right fas fa-angle-left"></i>
                              </p>
                          </a>
                          <ul class="nav nav-treeview">
                              <li class="nav-item">
                                  <a href="./consultar-gestor-nacional.jsp" class="nav-link">
                                      <i class="fas fa-clipboard-check nav-icon"></i>
                                      <p>Consultar Gestor nacional</p>
                                  </a>
                              </li>
                              <li class="nav-item">
                                  <a href="./cadastrar-gestor-nacional.jsp" class="nav-link">
                                      <i class="fas fa-user-plus nav-icon"></i>
                                      <p>Cadastrar Gestor nacional</p>
                                  </a>
                              </li>
          
                          </ul>
                      </li>
                  </ul>
                  <ul class="nav nav-treeview">
                    <li class="nav-item ">
                        <a href="#" class="nav-link">
                            <i class="fas fa-user-friends nav-icon"></i>
                            <p>
                                Supervisor
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="./consultar-supervisor.jsp" class="nav-link">
                                    <i class="fas fa-clipboard-check nav-icon"></i>
                                    <p>Consultar supervisor</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="./cadastrar-supervisor.jsp" class="nav-link">
                                    <i class="fas fa-user-plus nav-icon"></i>
                                    <p>Cadastrar supervisor</p>
                                </a>
                            </li>
          
                        </ul>
                    </li>
                </ul>
                
                        <ul class="nav nav-treeview">
                            <li class="menu-open">
                                <a href="#" class="nav-link active">
                                    <i class="fas fa-syringe nav-icon"></i>
                                    <p>
                                        Unidades
                                        <i class="right fas fa-angle-left"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="./consultar-unidades.jsp" class="nav-link active">
                                            <i class="fas fa-search nav-icon"></i>
                                            <p>Consultar unidade </p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="./cadastrar-unidade.jsp" class="nav-link">
                                            <i class="fas fa-mouse-pointer nav-icon"></i>
                                            <p>Cadastrar Unidade</p>
                                        </a>
                                    </li>
          
                                </ul>
                            </li>
                        </ul>
          
          
                    <!-- ITEM RELATORIO USUARIO DO MENU -->
                    <li class="nav-item">
                      <a href="./relatorio.jsp" class="nav-link">
                        <i class="nav-icon fas fa-chart-pie"></i>
                        <p>
                          Relatorio
                        </p>
                      </a>
                    </li>
          
                    <!-- ITEM PERFIL DO MENU -->
                    <li class="nav-item">
                      <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-user-circle"></i>
                        <p>
                          Perfil
                          <i class="right fas fa-angle-left"></i>
                        </p>
                      </a>
                      <ul class="nav nav-treeview">
                        <li class="nav-item">
                          <a href="./meus-dados.jsp" class="nav-link">
                            <i class="fas fa-address-card nav-icon"></i>
                            <p>
                              Meus dados
                            </p>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a href="./idioma.jsp" class="nav-link">
                            <i class="fas fa-language nav-icon"></i>
                            <p>
                              Mudar Idioma
                            </p>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a href="./manual.jsp" class="nav-link">
                            <i class="fas fa-question-circle nav-icon"></i>
                            <p>
                              Manual CIVA
                            </p>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a href="./solicitacoes.jsp" class="nav-link">
                            <i class="fas fa-inbox nav-icon"></i>
                            <p>
                              Solicita&ccedil;&otilde;es pendentes
                            </p>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a href="#" class="nav-link">
                            <i class="fas fa-sign-out-alt nav-icon"></i>
                            <p>
                              Sair
                            </p>
                          </a>
                        </li>
                      </ul>
                    </li>
                    </ul>
                  </nav>
                  <!-- /.sidebar-menu -->
                </div>
                <!-- /.sidebar ------------------------------------------------------>
              </aside>

            <!-- Content Wrapper. Contains page content -------------------------->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <div class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1 class="m-0">Consultar Unidade</h1>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
                                    <li class="breadcrumb-item active">Consultar unidade</li>
                                </ol>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- Main content -->
                <div class="content">
                    <div class="container-fluid">
                        <!---------------------------------------------------------------->
                        <!-- PESQUISA E FILTRO -->
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="row col-md-12 col-sm-12">
                                                <div class="col-xl-2 col-sm-12 mb-2">
                                                    <select class="select2 select2-hidden-accessible" id="ordem-de-listagem" name="ordem-de-listagem" style="width: 100%;" tabindex="-1" aria-hidden="true">
                                                        <option value="1">Nome A - Z</option>
                                                        <option value="2">Nome Z - A</option>
                                                        <option value="3">CPF crescente</option>
                                                        <option value="3">CPF decrescente</option>
                                                    </select>
                                                </div>
                                                <div class="col-xl-8 col-sm-12">
                                                    <div class="input-group  mb-2">
                                                        <input type="text" class="form-control" id="pesquisar" name="pesquisar" placeholder="Pesquisar por unidade">
                                                        <div class="input-group-append">
                                                            <button class="btn btn-outline-secondary" type="button" id="button-addon2" name="button-addon2">Pesquisar</button>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-2">
                                                    <div class="btn-group">
                                                        <button type="button" id="button-addon3" name="button-addon3" class="btn btn-default">CSV</button>
                                                        <button type="button" id="button-addon4" name="button-addon4" class="btn btn-default">PDF</button>
                                                        <button type="button" id="button-addon5" name="button-addon5" class="btn btn-default">Excel</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- TABELA -->
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <!-- /.card-header -->
                                    <div class="card-body table-responsive p-0">
                                        <table class="table table-hover text-nowrap">
                                            <thead>
                                                <tr>
                                                    <th>Nome</th>
                                                    <th>Estado</th>
                                                    <th>Munic&iacute;pio</th>
                                                    <th>CEP</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Recanto do Trovador</td>
                                                    <td>Rio de Janeiro</td>
                                                    <td>Niter&oacute;i</td>
                                                    <td>50120-320</td>
                                                    <td><a href="./gerenciar-unidades.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Recanto do Trovador</td>
                                                    <td>Rio de Janeiro</td>
                                                    <td>Niter&oacute;i</td>
                                                    <td>50120-320</td>
                                                    <td><a href="./gerenciar-unidades.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Recanto do Trovador</td>
                                                    <td>Rio de Janeiro</td>
                                                    <td>Niter&oacute;i</td>
                                                    <td>50120-320</td>
                                                    <td><a href="./gerenciar-unidades.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Recanto do Trovador</td>
                                                    <td>Rio de Janeiro</td>
                                                    <td>Niter&oacute;i</td>
                                                    <td>50120-320</td>
                                                    <td><a href="./gerenciar-unidades.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Recanto do Trovador</td>
                                                    <td>Rio de Janeiro</td>
                                                    <td>Niter&oacute;i</td>
                                                    <td>50120-320</td>
                                                    <td><a href="./gerenciar-unidades.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Recanto do Trovador</td>
                                                    <td>Rio de Janeiro</td>
                                                    <td>Niter&oacute;i</td>
                                                    <td>50120-320</td>
                                                    <td><a href="./gerenciar-unidades.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Recanto do Trovador</td>
                                                    <td>Rio de Janeiro</td>
                                                    <td>Niter&oacute;i</td>
                                                    <td>50120-320</td>
                                                    <td><a href="./gerenciar-unidades.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Recanto do Trovador</td>
                                                    <td>Rio de Janeiro</td>
                                                    <td>Niter&oacute;i</td>
                                                    <td>50120-320</td>
                                                    <td><a href="./gerenciar-unidades.jsp" class="btn btn-block btn-primary btn-sm">Gerenciar</a></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.card-body -->
                                </div>
                            </div>
                        </div>
                        <!-- PAGINA&Ccedil;&Atilde;O -->
                        <div class="row">
                            <div class="col-6">
                                <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button page-item previous disabled" id="example2_previous">
                                            <a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">Anterior</a>
                                        </li>
                                        <li class="paginate_button page-item active"><a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">1</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0" class="page-link">2</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0" class="page-link">3</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0" class="page-link">4</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0" class="page-link">5</a></li>
                                        <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0" class="page-link">6</a></li>
                                        <li class="paginate_button page-item next" id="example2_next"><a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0" class="page-link">Pr&oacute;ximo</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
           <%@include file="footer.xhtml"%>
        </div>
        <!-- ./wrapper -->

     
    </body>

</html>