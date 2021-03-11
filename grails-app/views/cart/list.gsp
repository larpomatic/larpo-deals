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
            <th class="uppercase">CREATION</th>
            <th class="uppercase">NAME</th>
            <th class="uppercase">DEAL</th>
        </tr>
        </thead>
        <tbody>

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