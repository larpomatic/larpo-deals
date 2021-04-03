$(document).ready(function(){
    $(".myBtn").click(function(event){
        var URL="${createLink(controller:'cart', action:'addDealToCart')}";
        $.ajax({
            url: URL,
            data: {id: event.target.value},
            success: function(resp){
                $("#myModal").modal("show")
            }
        });
    });
    $("#myModal").click(function () {
        window.location.href = "${createLink(action:'list')}";
    })
});