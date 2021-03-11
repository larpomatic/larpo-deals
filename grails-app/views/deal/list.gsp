<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<br>

<div class="container">
    <div class="container">
        <div class="container-fluid">
            <g:form name="DealForm" action="list" class="d-flex">
                <input class="form-control me-2" placeholder="Search by name..." aria-label="Search by name..." name="search">
                <button class="btn btn-primary" type="submit">Search</button>
            </g:form>
        </div>
    </div>

    <br>

    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">CAPTION</th>
            <th class="uppercase">NAME</th>
            <th class="uppercase">DESCRIPTION</th>
            <th class="uppercase">PRICE</th>
            <th class="uppercase">#</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${deals}" var="d">
            <tr>
                <td><img class="col-caption" src="${d.caption}"/></td>
                <td>${d.name}</td>
                <td>${d.description}</td>
                <td>${d.price}</td>
                <td>
                    <g:form name="AddForm" url="[action:'addDealToCart', controller:'cart']" class="d-flex">
                        <button name="dealId" class="btn btn-secondary" type="submit">ADD</button>
                    </g:form>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>