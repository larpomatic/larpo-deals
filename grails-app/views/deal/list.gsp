<%--
  Created by IntelliJ IDEA.
  User: Anatole
  Date: 23/02/2021
  Time: 17:14
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
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
                <td><img class="col-caption" src="${d.caption}"/></td>
                <td>${d.name}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>