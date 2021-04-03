<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <g:external dir="css" file="list.css" />
    <script type="text/javascript">
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
    </script>
    <title>${message(code: "larpo")}</title>
</head>

<body>
    <g:include view="_nav.gsp"/>
    <div class="card bg-light mb-3 mycontainer top">
        <g:form name="DealForm" action="list">
            <div class="line">
                <label class="sr-only" for="InputName"></label>
                <input type="text" class="myform-control mb-2 mr-sm-2" id="InputName" name="search"
                       placeholder="${message(code: "list.input.placeholder")}">
                <button type="submit" class="btn btn-primary mb-2">${message(code: "list.button.search.label")}</button>
            </div>
        </g:form>
    </div>
    <g:render template="/shared/cost" model="${cost}"/>
    <div class="card bg-light mb-3 mycontainer">
        <table class="table table-striped">
            <thead class="card-header">
                <tr>
                    <th class="text-uppercase">${message(code: "list.caption")}</th>
                    <th class="text-uppercase">${message(code: "name")}</th>
                    <th class="text-uppercase">${message(code: "list.description")}</th>
                    <th class="text-uppercase">${message(code: "list.price")}</th>
                    <th class="text-uppercase">#</th>
                </tr>
            </thead>
            <tbody class="card-body">
                <g:form name="CartForm" url="[action:'addDealToCart',controller:'cart']">
                    <g:each in="${deals}" var="d" >
                        <tr>
                            <td><img class="col-caption" src="${d.caption}"/></td>
                            <td>${d.name}</td>
                            <td>${d.description}</td>
                            <td>${d.price}€</td>
                            <td>
                                <button name="btn-modal" value="${d.id}" type="button"
                                        class="myBtn btn btn-block grey">${message(code: "list.button.add.label")}
                                </button>
                            </td>
                        </tr>
                    </g:each>
                </g:form>
            </tbody>
        </table>
    </div>
</body>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <a>${message(code: "popin.validation.add.deal.to.cart")}</a>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <g:form name="CartListForm" url="[action:'index',controller:'cart']">
                <div class="modal-footer text-xs-center">${message(code: "popin.validation.redirect.cart")}</div>
            </g:form>
        </div>
    </div>
</div>