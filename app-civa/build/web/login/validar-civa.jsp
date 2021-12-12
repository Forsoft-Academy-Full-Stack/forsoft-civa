<%@include file="header.jspf"%>
<%@page import="dao.VacinacaoDao"%>
<!--<script defer>
    $('#modal-default').modal('show');
    
</script>-->

<!-- VERIFICA O CAMPO -->
<!--<script src="../public/assets/js/login/verifica-campo.js" defer></script>-->
</head>

<body class="content-wrapper">
    <!-- Main content -->
    <div class="modal fade show " id="modal-validar-form" style="display: block; padding-right: 17px;" aria-modal="true">
        <div class="modal-dialog ">
            <div class="modal-content card-body card-primary card-outline">
                <p class="h3 text-center  mt-3">Leitor QRCODE</p></video>
                <div class="justify-content-center d-flex mt-3">
                    <video src="#" style="border: 3px solid rgb(139, 138, 138); background: rgba(139, 138, 138, 0.342);"></video>
                </div>
            <form id="validar-civa" name="validar-civa" action="certificado-civa.jsp" method="GET">
                    <div class="m-5">
                        <p class="text-center">N&atilde;o consegue escanear? Digite o c&oacute;digo CIVA.</p>
                        <input class="form-control form-control-sm text-center" type="text" name="codigoCiva" id="codigoCiva"
                               placeholder="Digite o c&oacute;digo de autententica&ccedil;&atilde;o.">
                        <input type="hidden" value="validar" class="form-control" id="option" name="option">
                    </div>
                </form>
                <div class="modal-footer justify-content-between">
                    <button form="validar-civa"  type="submit" class="btn btn-block btn-primary" data-toggle="modal"
                             id="validar-cod">VALIDAR</button>
                    <a href="./index.jsp" class="btn btn-block btn-outline-primary">VOLTAR</a>
                </div>

            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->


        <!-- MODAL CERTIFICADO CIVA -->
                
          
        <!--
        <div class="modal fade show " id="modal-certificado-civa" style="display: none; padding-right: 17px;" aria-modal="true">
            <div class="modal-dialog ">
                <div class="modal-content card-primary card-outline">
                    <div class="modal-header">
                        <h4 class="modal-title">Certificado CIVA</h4>
                        <button type="button" class="Close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">x</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="certificado-nome">Nome</label>
                            <input type="text" class="form-control form-control-sm" id="certificado-nome" name="certificado-nome"
                                   value="Samuel Claudino da Silva" disabled>
                        </div>
                        <div class="row">
                            <div class="form-group col mb-3">
                                <label for="certificado-identidade">Identidade</label>
                                <input type="text" class="form-control form-control-sm" id="certificado-identidade" name="certificado-identidade"
                                       value="123.456.789-09" disabled>
                            </div>
                            <div class="form-group col mb-3">
                                <label for="certificado-b-day">Data de nascimento</label>
                                <input type="text" class="form-control form-control-sm" id="certificado-b-day" value="31/09/1998" name="certificado-b-day"
                                       disabled>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col mb-3">
                                <label for="certificado-civa-id">CIVA</label>
                                <input type="text" class="form-control form-control-sm" id="certificado-civa-id" value="BR55123456789" name="certificado-dica-id"
                                       disabled>
                            </div>
                            <div class="form-group col mb-3">
                                <label for="certificado-origem">Pa&iacute;s de origem</label>
                                <input type="text" class="form-control form-control-sm" id="certificado-origem" value="Brasil" name="certificado-origem" disabled>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col mb-3">
                                <label for="certificado-vacina">Vacina</label>
                                <input type="text" class="form-control form-control-sm" id="certificado-vacina" name="certificado-vacina" value="Coronavac"
                                       disabled>
                            </div>
                            <div class="form-group col mb-3">
                                <label for="certificado-dose">Doses</label>
                                <input type="text" class="form-control form-control-sm" id="certificado-dose" name="certificado-dose" value="2" disabled>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary">Imprimir</button>
                    </div>
                </div>
            
            </div>
            
        </div>-->
        
    </div>

    <!-- ./wrapper -->

</body>

</html>