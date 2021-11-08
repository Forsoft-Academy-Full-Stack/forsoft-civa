<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>CIVA</title>

  <link rel="shortcut icon" href="../public/img/favicon-gs.svg" type="image/x-icon">

  <!-- Google Font: Poppins -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">


 <!-- Google Font: Poppins -->
 <link rel="preconnect" href="https://fonts.googleapis.com">
 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
 <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">


  <!-- Select2 -->
  <link rel="stylesheet" href="../public/plugins/select2/css/select2.min.css"> 

 <!-- Estilo icones -->
 <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">
 
 <!-- Estilo pagina -->
 <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar --------------------------------------------->
 <%@ include file="navbar.jspf" %>
  <!-- /.navbar ------------------------------------------------------->




  <!-- MENU Main Sidebar Container ------------------------------------>
   <%@ include file="menu.jspf" %>



  <!-- Content Wrapper. Contains page content -------------------------->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Painel Supervisor</h1>
          </div><!-- /.col --> 
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
              <li class="breadcrumb-item active">Gerenciar Supervisor</li>
            </ol>
          </div>
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header ---------------------------------------------->







    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <!---------------------------------------------------------------->


        <div class="row">
          <div class="col-12 mb-4">
              <form action="">
                  <div class="input-group">
                      <input type="search" class="form-control form-control-lg" placeholder="Insira o codigo civa do portador">
                      <div class="input-group-append">
                          <button type="submit" class="btn btn-lg btn-primary">
                             Pesquisar
                          </button>
                      </div>
                  </div>
              </form>
          </div>
        </div>


        <!-- DADOS PORTADOR -->
        <div class="row mb-3">

          <div class="col-12">
            <div class="card card-primary">
                 
          
                <div class="card-header">
                  <h3 class="card-title">Dados Profissional Sa&uacute;de</h3>
                </div>
                <!-- /.card-header -->
                <!-- form start -->
                <form id="form-unidade-vinculada">
                                  <div class="card-body">
                    <%@include file="../partials/codigociva.jspf" %>
                    <hr>
                    <%@ include file="../partials/dadospessoais-ps-disabled.jspf" %>
                    <hr>
                   <%@ include file="../partials/enderecos-disabled.jspf" %>
                    <hr>
                    <%@ include file="../partials/contatos-disabled.jspf" %>
                </div>
                  
                  </form>
            </div>
      </div>
</div>
              <div class="col-12 row">
                <div class="mb-3 mt-3">
                  <a href="./ui046.jsp" class="btn btn-primary btn-lg">Vincular Nova unidade</a>
              </div>
              </div>
            <!-- TABELA VACINAS -->
            <div class="row">
              <div class="col-12">
                <div class="card card-primary">
                  <div class="card-header">
                    <h3 class="card-title">Unidades Vinculadas</h3>
          
                    
                  </div>
                  <!-- /.card-header -->
                  <div class="card-body table-responsive p-0">
                    <table class="table table-hover text-nowrap">
                      <thead>
                        <tr>
                          <th>Nome</th>
                          <th>Estado</th>
                          <th>C&oacute;digo Postal</th>
                          <th>Identificador</th>
                          <th>Desvincular Unidade</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>Hopital Pan</td>
                          <td>Rio de Janeiro</td>
                          <td>12016-102</td>
                          <td><span class="tag tag-success">215648</span></td>
                          <td><input class="btn btn-block" type="checkbox"></td>

                        </tr>
                        <tr>
                          <td>Hopital Pan</td>
                          <td>Rio de Janeiro</td>
                          <td>12016-102</td>
                          <td><span class="tag tag-success">215648</span></td>
                          <td><input class="btn btn-block" type="checkbox"></td>

                
                        </tr>
                        <tr>
                          <td>Hopital Pan</td>
                          <td>Rio de Janeiro</td>
                          <td>12016-102</td>
                          <td><span class="tag tag-success">215648</span></td>
                          <td><input class="btn btn-block" type="checkbox"></td>

                    
                        </tr>
                        <tr>
                          <td>Hopital Pan</td>
                          <td>Rio de Janeiro</td>
                          <td>12016-102</td>
                          <td><span class="tag tag-success">215648</span></td>
                          <td><input class="btn btn-block" type="checkbox"></td>

                   
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <!-- /.card-body -->
                </div>
                <!-- /.card -->
              </div>
            </div>
            <div class="col-12 row">
              <div class="mb-3 mt-3">
                <button type="submit" class="btn btn-primary btn-lg" form="form-unidade-vinculada">Salvar</button>
            </div>
            </div>



        <!-- /.row -->
      </div><!-- /.container-fluid -->
      <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title">Dados salvo com sucesso!</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">×</span>
              </button>
            </div>
            <div class="modal-body">
              <p></p>
            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='./indexs.jsp'">Close</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->



  
  





  <!-- Main Footer -->
  <%@ include file="footer.jspf" %>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="../public/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Select2 -->
<script src="../public/plugins/select2/js/select2.full.min.js"></script>
<!-- AdminLTE App -->
<script src="../public/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../public/dist/js/demo.js"></script>

<!-- VIACEP API -->
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
  function tratarCampos() {
    let erro = false;
    let campos = ['nacionality','postal-code','logrd-name','city','local','state', 'telf', 'email'];
    
        for (i=0;i<campos.length;i++) {
            if (document.getElementById(campos[i]).value == '') {
                erro = true;
            }
        }

        if (erro) {
            alert('Todos os campos devem ser preenchidos!');
        } else {
            // Exibe o modal desejado, baseado no id definido.
            $('#modal-default').modal('show');
            console.log('funcionou');
            event.preventDefault();

        }

        return !erro;
}

document.getElementById('form-unidade-vinculada').onsubmit = tratarCampos;
</script>
<script>
  $(function () {
    $('.select2').select2()
  });
</script>
</body>
</html>
