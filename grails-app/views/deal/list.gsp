<!DOCTYPE html>
<head>
    <g:set var="nav_button" value="Deal" scope="request"/>
    <meta name="layout" content="main"/>
</head>

<body>

<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">caption</th>
            <th class="uppercase">name</th>
            <th class="uppercase">description</th>
            <th class="uppercase">price</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${deals}" var="d">
            <tr>
                <td><img class="col-caption" src="${d.caption}"></td>
                <td>${d.name}</td>
                <td>${d.description}</td>
                <td>${d.price}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>