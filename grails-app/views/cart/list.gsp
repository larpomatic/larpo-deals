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

<g:if test="${session.cart!=null}">
<div class="container">
  <h1>Current Cart</h1>
  <table class="table table-striped">
    <thead>
    <tr>
      <th class="uppercase">name</th>
      <th class="uppercase">Deal</th>

    </tr>
    </thead>
    <tbody>


      <tr>
        <td>${session.cart.name}</td>
        <td>
          <ol>
            <g:each in="${session.cart.deals}" var="d">
              <li>${d.name}</li>
            </g:each>
          </ol>
          ${session.cart.price}€
        </td>

      </tr>

    </tbody>
  </table>
</div>

  <g:form action="SaveCart">
    <button type="submit" class="btn btn-primary mb-2">Save Cart</button>
  </g:form>


</g:if>





<div class="container">
  <h1>Cart list</h1>
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
        ${c.price}€
      </td>

      </tr>
    </g:each>
    </tbody>
  </table>
</div>


</body>
</html>