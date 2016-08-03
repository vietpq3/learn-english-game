$(document).ready(function() {
    init();
});

function init() {
    $('#btnHome').click(function() {
        $('#formRedirect').attr("action", "../home/index");
        $('#formRedirect').submit();
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
}
