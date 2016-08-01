$(document).ready(function(){
    init();
});

function init(){
    $('#btnFight').click(function(){
        $('#form').attr("action","../fight/index");
        $('#form').submit();
    });
    
}