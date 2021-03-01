<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">CAPTION</th>
            <th class="uppercase">NAME</th>
            <th class="uppercase">DESCRIPTION</th>
            <th class="uppercase">PRICE</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${deals}" var="d">
            <tr>
                <td><img class="col-caption" src="${d.caption}"/></td>
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