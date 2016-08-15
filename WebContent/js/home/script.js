$(document).ready(function(){
    init();
});

function init(){
    $('#btnFight').click(function(){
        $('#form').attr("action","../fight/index");
        $('#form').submit();
    });
    
    $('#btnLogout').click(function(event){
    	if(confirm('Do you want to logout?')){
    		window.location = "../logout/";
    	} else{
    		event.preventDefault();
    	}
    });
    
    $('#btnHighScore').click(function(){
    	window.location = "../home/highscore";
    });
    
}