<%--
  Created by IntelliJ IDEA.
  User: Samuel
  Date: 18/02/2021
  Time: 18:15
--%>


<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<g:include view="_nav.gsp"/>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">caption</th>
            <th class="uppercase">name</th>
            <th class="uppercase">Description</th>
            <th class="uppercase">price</th>
        </tr>
        </thead>
        <tbody>
            <g:each in="${deals}" var="d">
                <tr>
                    <td><img src=${d.caption}></td>
                    <td>${d.name}</td>
                    <td>${d.description}</td>
                    <td>${d.price}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>


<g:javascript library="application"/>
</html>