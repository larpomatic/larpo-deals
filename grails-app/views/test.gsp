<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31/03/2021
  Time: 01:16
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>
<body>
<button type="button" class="btn btn-lg btn-danger" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?">Click to toggle popover</button>

<p>
  <a class="btn btn-secondary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Link with href
  </a>
<p>
  <button class="btn btn-secondary" type="button" data-toggle="collapse" data-target="#CurrentCart" aria-expanded="false" aria-controls="collapseExample">
    Button with data-target
  </button>
</p>
<div class="collapse" id="CurrentCart">
  <g:include view="_currentCart.gsp"/>
</div>

<script>
    $(function () {
  $('[data-toggle="popover"]').popover()
})
</script>

</body>
</html>