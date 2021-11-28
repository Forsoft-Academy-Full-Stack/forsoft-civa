$('.select2').select2();
$("#civa").val("");
$("#email").val("");

$(function() {
                
    $('#perfil').change(function(e){
    	var escolha = $("#perfil").val();
       
        if (escolha =="portador-civa") {
                $("#civa").val("");
        	$("#civa").hide();                               
                $('#civa-logo').hide();
                $('#user-logo').show();
                $("#email").show();
        } else {
            $("#email").val("");
            $("#email").hide();            
            $("#civa").show();
            $('#user-logo').hide();
            $('#civa-logo').show();
            
        }
 
    });

});
