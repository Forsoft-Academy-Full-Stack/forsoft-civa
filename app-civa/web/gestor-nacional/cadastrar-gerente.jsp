<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("gestor-nacional"))) {
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
                                <h1 class="m-0">Cadastrar Gerente</h1>
                            </div>
                            <!-- /.col -->

                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item">
                                        <a href="./index.jsp">Voltar</a>
                                    </li>
                                    <li class="breadcrumb-item active">Cadastrar Gerente</li>
                                </ol>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- /.content-header ---------------------------------------------->

                <!-- Main content -->
                <div class="content">
                    <div class="container-fluid">
                        <!---------------------------------------------------------------->

                        <div class="row">
                            <div class="col-12">
                                <div class="card card-primary">
                                    <div class="card-header">
                                        <h3 class="card-title">Dados Gerente</h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <!-- form start -->
                                    <form id="form-meus-dados">
                                        <div class="card-body">
                                            <%@include
                                                file="../partials/dadospessoais-ps-cadastro.jspf" %>
                                                <hr />
                                                <%@include file="../partials/enderecos-cadastro.jspf" %>
                                                <hr />
                                                <%@include file="../partials/contatos-cadastro.jspf" %>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                                <div class="col-12 mb-4">
                                    <button
                                        type="submit"
                                        class="btn btn-primary btn-lg"
                                        form="form-meus-dados"
                                        >
                                        Cadastrar
                                    </button>
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.container-fluid -->
                        <div
                            class="modal fade"
                            id="modal-default"
                            style="display: none"
                            aria-hidden="true"
                            >
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Cadastro realizado com sucesso!</h4>
                                        <button
                                            type="button"
                                            class="close"
                                            data-dismiss="modal"
                                            aria-label="Close"
                                            >
                                            <span aria-hidden="true">Ã</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <p></p>
                                    </div>
                                    <div class="modal-footer justify-content-between">
                                        <button
                                            type="button"
                                            class="btn btn-default"
                                            data-dismiss="modal"
                                            onclick="location.href = './index_gestor.jsp'"
                                            >
                                            Close
                                        </button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                        </div>
                    </div>
                    <!-- /.content -->
                </div>
                <!-- /.content-wrapper -->

                <!-- Main Footer -->
                <%@include file="footer.jspf"%>
            </div>
            <!-- ./wrapper -->

            <script>
                                const html = {
                                    get(element) {
                                        return document.querySelector(element)
                                    }
                                }

                                async function getUser() {
                                    const campoEstado = html.get('#state')
                                    const campoCidade = html.get('#city')
                                    const campoBairro = html.get('#local')
                                    const campoLogradouro = html.get('#logrd-name')
                                    // const campoDdd = html.get("#inputDdd");
                                    const cepDigitado = html.get('#postal-code')

                                    const response = await axios.get(
                                            `https://viacep.com.br/ws/${cepDigitado.value}/json/`
                                            )
                                    const estado = response.data.uf
                                    const cidade = response.data.localidade
                                    const bairro = response.data.bairro
                                    const logradouro = response.data.logradouro
                                    // const ddd = response.data.ddd;

                                    campoEstado.innerHTML = `<option selected="">${estado}</option>`
                                    campoCidade.innerHTML = `<option selected="">${cidade}</option>`
                                    campoBairro.innerHTML = `<option selected="">${bairro}</option>`
                                    campoLogradouro.value = `${logradouro}`
                                    // campoDdd.value = `${ddd}`;
                                }
            </script>
            <script>
                function tratarCampos() {
                    let erro = false
                    let campos = [
                        'name',
                        'surname',
                        'nationality',
                        'date-birth',
                        'identy',
                        'postal-code',
                        'logrd-name',
                        'city',
                        'local',
                        'state',
                        'telf',
                        'email'
                    ]

                    for (i = 0; i < campos.length; i++) {
                        if (document.getElementById(campos[i]).value == '') {
                            erro = true
                        }
                    }

                    if (erro) {
                        alert('Todos os campos devem ser preenchidos!')
                    } else {
                        // Exibe o modal desejado, baseado no id definido.
                        $('#modal-default').modal('show')
                        console.log('funcionou')
                        event.preventDefault()
                    }

                    return !erro
                }

                document.getElementById('form-meus-dados').onsubmit = tratarCampos
            </script>
            <script>
                $(function () {
                    $('.select2').select2()
                })
            </script>
        </body>
    </html>
