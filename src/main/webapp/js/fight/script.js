window.onload = function(){
    checkLoseFlag();
};

$(document).ready(function() {
    init();
});

function init() {
    $('#btnHome').click(function(event) {
        if(confirm('Do you want to go to Home?')){
        	$('#formRedirect').attr("action", "../home/index");
            $('#formRedirect').submit();
        } else{
        	event.preventDefault();
        }
    });

    $('#btnPicture').click(function() {
        $('#formActivities').attr("action", "fight");
        $('#gameMode').attr("value", "Picture");
        $('#formActivities').submit();
    });
    
    $('.picture').click(function(){
        $('#answer').attr("value", $(this).attr("answer"));
        $('#formActivities').attr("action", "fighting");
        $('#formActivities').submit();
    });
    
    $('#btnLogout').click(function(event){
    	if(confirm('Do you want to logout?')){
    		$('#formRedirect').attr("action", "../logout/");
        	$('#formRedirect').submit();
    	}else{
    		event.preventDefault();
    	}
    });
    
}

function checkLoseFlag(){
    if($('#loseFlag').val() == "true"){
        alert("You losed");
        window.location = "../home/index";
    }
}