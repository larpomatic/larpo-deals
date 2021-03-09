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
        <g:each in="${cart}" var="d">
            <tr>
                <td>${d.dateCreated}</td>
                <td>${d.name}</td>
                <td>${d.deals}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>