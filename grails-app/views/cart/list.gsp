<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<br>

<div class="container">
    <div class="d-flex flex-row-reverse">
        <div class="badge text-dark" style="background-color: #dee2e6">
            <h6>
                Cart cost:
                <span class="badge bg-info text-light">${totalPrice} €</span>
            </h6>
        </div>
    </div>

    <br>

    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">NAME</th>
            <th class="uppercase">DEAL</th>
            <th class="uppercase"></th>
        </tr>
        </thead>
        <tbody>

        <h3>
            <span class="badge bg-primary text-light">Current Cart</span>
        </h3>

        <g:each in="${currentCart}" var="c">
            <g:form name="SaveForm" url="[action:'save', controller:'cart']" class="d-flex">
                <tr>
                    <td>
                        <input class="form-control me-2" placeholder="Rename current cart" aria-label="Rename current cart" name="rename">
                    </td>
                    <td>
                        <ol>
                            <g:each in="${c.deals}" var="d">
                                <li>${d.name}</li>
                            </g:each>
                        </ol>
                    </td>
                    <td>
                        <button class="btn btn-secondary" type="submit">SAVE</button>
                    </td>
                </tr>
            </g:form>
        </g:each>
        </tbody>
    </table>
</div>

<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">CREATION</th>
            <th class="uppercase">NAME</th>
            <th class="uppercase">DEALS</th>
            <th class="uppercase">COST</th>
        </tr>
        </thead>
        <tbody>

        <h3>
            <span class="badge bg-primary text-light">Cart List</span>
        </h3>

        <g:each in="${carts}" var="c">
            <tr>
                <td>${c.dateCreated.format("dd/MM/yyyy hh:mm")}</td>
                <td>${c.name}</td>
                <td>
                    <ol>
                        <g:each in="${c.deals}" var="d">
                            <li>${d.name}</li>
                        </g:each>
                    </ol>
                </td>
                <td>${c.cost} €</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>