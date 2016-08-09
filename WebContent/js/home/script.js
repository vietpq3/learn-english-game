$(document).ready(function(){
    init();
});

function init(){
    $('#btnFight').click(function(){
        $('#form').attr("action","../fight/index");
        $('#form').submit();
    });
    
    $('#btnLogout').click(function(){
    	window.location = "../logout/";
    });
}