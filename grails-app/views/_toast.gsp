<g:if test="${flash.b == "1"}">
<div class="toast bg-success text-light" style="position: absolute; top: 0; right: 0" data-delay="2000" data-tor-fx="show:pull.left(sm)">
</g:if>
<g:elseif test="${flash.b == "0"}">
<div class="toast bg-danger text-light" style="position: absolute; top: 0; right: 0" data-delay="2000" data-tor-fx="show:pull.left(sm)">
</g:elseif>
<g:else>
<div class="toast bg-primary text-light" style="position: absolute; top: 0; right: 0" data-delay="2000" data-tor-fx="show:pull.left(sm)">
</g:else>
    <div class="d-flex">
        <div class="toast-body">
            ${flash.message}
        </div>
        <button type="button" class="close text-light" data-dismiss="toast">&times;</button>
    </div>
</div>

<script>
    $('.toast').toast('show');
</script>