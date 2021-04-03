<%@ page import="larpo.cart.Cart" %>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <g:external dir="css" file="index.css" />
    <script type="text/javascript">
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
    </script>
    <title>${message(code: "larpo")}</title>
</head>

<body>
    <g:include view="_nav.gsp"/>
    <g:if test="${session.getAttribute("CurrentCart") != null}">
        <g:form name="CartSavedInMemory" action="save">
            <div class="flex">
                <h3 class="bot">
                    <span class="badge custom-badge">${message(code: "cart.current.label")}</span>
                </h3>
                <g:render template="/shared/cost" model="${cost}"/>
                <button type="button" class="grey btn save-button" id="myBtn">${message(code: "cart.button.save.label")}</button>
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-body">
                                <a>${message(code: "popin.validation.save.cart")}</a>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </g:form>
        <div class="mycontainer">
            <table class="table table-responsive-xl table-striped">
                <thead>
                    <tr>
                        <th class="text-uppercase">${message(code: "name")}</th>
                        <th class="text-uppercase">${message(code: "deal")}</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${session.getAttribute("CurrentCart") as Cart}" var="cart">
                        <tr>
                            <td>${cart.name}</td>
                            <td>
                                <g:each in="${cart.deals}" var="deal" status="counter">
                                    ${counter + 1}. ${deal.name} <g:if test="${cart.quantities.get(deal.id as String) > 1}">x${cart.quantities.get(deal.id as String)}</g:if><br/>
                                </g:each>
                            </td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </div>
    </g:if>
    <h3 class="bot">
        <span class="badge custom-badge">${message(code: "cart.list")}</span>
    </h3>
    <div class="mycontainer">
        <table class="table table-responsive-xl table-striped">
            <thead>
                <tr>
                    <th class="text-uppercase">${message(code: "cart.creation")}</th>
                    <th class="text-uppercase">${message(code: "name")}</th>
                    <th class="text-uppercase">${message(code: "deal")}</th>
                    <th class="text-uppercase">${message(code: "price")}</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${carts}" var="cart">
                    <tr>
                        <td>
                            <g:dateFormat format="dd/MM/yyyy HH:mm" value="${cart.dateCreated}"></g:dateFormat>
                        </td>
                        <td>${cart.name}</td>
                        <td>
                            <g:each in="${cart.deals}" var="deal" status="counter">
                                ${counter + 1}. ${deal.name} <g:if test="${cart.quantities.get(deal.id as String) > 1}">x${cart.quantities.get(deal.id as String)}</g:if><br/>
                            </g:each>
                        </td>
                        <td>${cart.price} €</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</body>
<div id="renameModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <g:form name="RenameForm" action="save">
                    <div class="form-group">
                        <label class="control-label">${message(code: "popin.validation.rename.cart")}</label>
                        <div>
                            <label>
                                <input type="text" class="form-control input-lg" name="rename" value="" id="renameCart">
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button type="button" class="btn btn-info btn-block custom-template" id="rename-button"><b>${message(code: "cart.rename")}</b></button>
                        </div>
                    </div>
                </g:form>
            </div>
            <div class="modal-footer text-xs-center">
                ${message(code: "popin.validation.no.rename.cart")}
            </div>
        </div>
    </div>
</div>