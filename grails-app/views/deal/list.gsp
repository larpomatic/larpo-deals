<!DOCTYPE html>
<head>
    <%-- <g:set var="nav_button" value="Deal" scope="request"/> --%>
    <meta name="layout" content="main"/>
</head>

<body>

<g:if test="${flash.message}">
    <g:include view="_toast.gsp"/>
</g:if>

<div class="container">
    <table class="table table-striped">
        <tbody>
            <g:form class="form-inline" name="search" action="list">
                <tr>
                    <td><label class="sr-only" for="searchBar">SearchBar</label></td>
                    <td><input type="text" class="form-control mb-2 mr-sm-2" id="searchBar" placeholder="Search by name..." name="search" value="${search}"></td>
                    <td><button type="submit" class="btn btn-primary mb-2">Search</button></td>
                </tr>
            </g:form>
        </tbody>
    </table>
</div>

<div class="collapse" id="CurrentCart">
    <g:include view="_currentCart.gsp"/>
</div>

<script>
    $(function () {
        $('[data-toggle="popover"]').popover()
    })
</script>



<div class="container">
    <h3><span class="badge badge-primary">Deal list</span></h3>
    <table class="table table-striped">
        <thead>
            <tr>
                <th class="uppercase">CAPTION</th>
                <th class="uppercase">NAME</th>
                <th class="uppercase">DESCRIPTION</th>
                <th class="uppercase">PRICE</th>
                <th>#</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${deals}" var="d">
                <tr>
                    <td><img class="col-caption" src="${d.caption}"></td>
                    <td>${d.name}</td>
                    <td>${d.description}</td>
                    <td>${d.price}€</td>
                    <td>
                        <g:form name="addDealToCart" controller="cart" action="addDealToCart" id="${d.id}">
                            <button type="submit" class="btn btn-secondary" id="addDealToCartButton"
                                    name="addDealToCart"  value="${addDealToCart}">ADD</button>
                        </g:form>
                    </td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>

</body>
</html>