<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<g:if test="${flash.message}">
    <div class="toast bg-primary text-light" style="position: absolute; top: 0; right: 0" data-delay="2000" data-tor-fx="show:pull.left(sm)">
        <div class="d-flex">
            <div class="toast-body">
                ${flash.message}
            </div>
            <button type="button" class="close text-light" data-dismiss="toast">&times;</button>
        </div>
    </div>

    <script>
        $('.toast').toast('show');
    </script>
</g:if>

<g:include view="_currentCart.gsp"/>

<div class="container">
    <h3><span class="badge badge-primary">Cart list</span></h3>
    <table class="table table-striped">
        <thead>
            <tr>
                <th class="uppercase">CREATION</th>
                <th class="uppercase">NAME</th>
                <th class="uppercase">DEAL</th>
                <th class="uppercase">COST</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${carts}" var="c">
                <tr>
                    <td>${c.dateCreated.format("dd/MM/yyy HH:mm")}</td>
                    <%-- <td>${c.dateCreated}</td> --%>
                    <td>${c.name}</td>
                    <td>
                        <ol>
                            <g:each in="${c.deals}" var="cd">
                                <li>${cd.name}</li>
                            </g:each>
                        </ol>
                    </td>
                    <td>${c.cost}€</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>

</body>
</html>