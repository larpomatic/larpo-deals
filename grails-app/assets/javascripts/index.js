$(document).ready(function(){
    $("#myBtn").click(function(e){
        $("#renameModal").modal({
            backdrop: 'static'
        })
    });
    $("#rename-button").click(function (e) {
        e.preventDefault()
        $("#renameModal").hide()
        var URL="${createLink(action:'save')}";
        $.ajax({
            url: URL,
            data: {rename: document.getElementById("renameCart").value},
            success: function(resp){
                $("#myModal").modal("show")
            }
        });
    })
    $("#save-button").click(function (e) {
        e.preventDefault()
        $("#renameModal").hide()
        var URL="${createLink(action:'save')}";
        $.ajax({
            url: URL,
            data: {rename: document.getElementById("renameCart").value},
            success: function(resp){
                $("#myModal").modal("show")
            }
        });
    })
    $("#myModal").click(function () {
        window.location.href = "${createLink(action:'index')}";
    })
});