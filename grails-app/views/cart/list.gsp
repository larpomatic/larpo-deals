<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

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
                </tr>
            </g:each>
        </tbody>
    </table>
</div>

</body>
</html>