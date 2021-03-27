<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<br>

<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">NAME</th>
            <th class="uppercase">DEAL</th>
            <th class="uppercase">#</th>
        </tr>
        </thead>
        <tbody>

        <span class="badge bg-info text-dark">Current Cart</span>

        <g:each in="${currentCart}" var="c">
            <tr>
                <td>${c.name}</td>
                <td>
                    <g:each in="${c.deals}" var="d">
                        ${d.name}
                        <br/>
                    </g:each>
                </td>
                <td>
                    <g:form name="SaveForm" url="[action:'save', controller:'cart']" class="d-flex">
                        <button class="btn btn-secondary" type="submit">SAVE</button>
                    </g:form>
                </td>
            </tr>
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
            <th class="uppercase">DEAL</th>
        </tr>
        </thead>
        <tbody>

        <span class="badge bg-info text-dark">Cart List</span>

        <g:each in="${carts}" var="c">
            <tr>
                <td>${c.dateCreated.format("dd/MM/yyyy hh:mm")}</td>
                <td>${c.name}</td>
                <td>
                    <g:each in="${c.deals}" var="d">
                        ${d.name}
                        <br/>
                    </g:each>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>