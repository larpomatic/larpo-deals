<div class="container">
    <h3><span class="badge badge-primary">Current Cart</span></h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">DEALS</th>
            <th class="uppercase">COST</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <ol>
                    <g:each in="${CurrentCart.deals}" var="cd">
                        <li>${cd.name}</li>
                    </g:each>
                </ol>
            </td>
            <td>${cost}€</td>
        </tr>
        <tr>
            <td>
            <g:form class="form-inline" name="SaveCart" action="save" controller="cart">
                <label class="sr-only" for="SaveCart">SaveCart</label>
                <input type="text" class="form-control mb-2 mr-sm-2" id="searchBar" placeholder="Cart name..." name="SaveCart" value="${SaveCart}">
                <button type="submit" class="btn btn-primary mb-2">save</button>
            </g:form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
