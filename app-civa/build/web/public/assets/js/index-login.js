$('.select2').select2();

$(function() {
                
    $('#perfil').change(function(e){
    	var escolha = $("#perfil").val();
        if (escolha =="usuario") {
        	$("#civa").hide();
                $('#civa-logo').hide();
                $('#user-logo').show();
            $("#email").show();
        } else {
            $("#email").hide();
            $("#civa").show();
            $('#user-logo').hide();
            $('#civa-logo').show();
            
        }
 
    });

});
