<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("supervisor"))) {
        // Caso for uma das duas opções
        // Redicionar para o login
        response.sendRedirect("../login/");

    }
    
   // Caso contrário é um usuário válido, pode entrar na página
  
%>
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
            <h1 class="m-0">Mudar idioma</h1>
          </div><!-- /.col -->

          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
              <li class="breadcrumb-item active">Mudar idioma</li>
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
  <div class="col-12">
    <div class="card">
      <div class="card-body">
        <div class="form-group col-12">
          <label for="idioma">Idioma</label>
          <select class="select2 select2-hidden-accessible" id="idioma" name="idioma" style="width: 100%;" tabindex="-1" aria-hidden="true">
            <option value="2" selected>Portugu&ecirc;s (Brasil)</option>
          <option value="3">English (US)</option>
        </select>
      </div>
      </div>
    </div>
  </div>
</div>


<div class="row">
  <div class="col-12 mb-4">
    <button type="submit" class="btn btn-primary btn-lg" id="salvar-idioma" form="form-meus-dados">Salvar altera&ccedil;&atilde;o</button>
</div>
</div>


      </div><!-- /.container-fluid -->
            <div class="modal fade" id="modal-default" style="display: none;" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title">Dados Salvo com sucesso!</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">Ã</span>
              </button>
            </div>
            <div class="modal-body">
              <p></p>
            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='./indexsupervisor.jsp'">Close</button>
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
<script>

function exibemodal() {
    event.preventDefault();
    $('#modal-default').modal('show');
}

document.getElementById('salvar-idioma').onclick = exibemodal;

  $(function () {
    $('.select2').select2()
  });
</script>
<script>
  $(function () {
    $('.select2').select2()
  });
</script>

</body>
</html>
