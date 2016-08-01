$(document).ready(function() {
    init();
});

function init() {
    $('#btnHome').click(function() {
        $('#formRedirect').attr("action", "../home/index");
        $('#formRedirect').submit();
    });

    $('#btnPicture').click(function() {
        $('#formRedirect').attr("action", "fight");
        $('#gameMode').attr("value", "Picture");
        $('#formRedirect').submit();
    });
}