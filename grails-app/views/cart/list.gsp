<%--
  Created by IntelliJ IDEA.
  User: Samuel
  Date: 02/03/2021
  Time: 12:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<g:include view="_nav.gsp"/>
<body>
<div class="container">
  <table class="table table-striped">
    <thead>
    <tr>
      <th class="uppercase">creation</th>
      <th class="uppercase">name</th>
      <th class="uppercase">Deal</th>
    </tr>
    </thead>
    <tbody>


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

      </tr>
    </g:each>
    </tbody>
  </table>
</div>


</body>
</html>