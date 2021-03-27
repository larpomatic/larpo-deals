<span>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Larpo-Deals</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">

                <a class="nav-item nav-link" href="/">Home</a>
                <a class="nav-item nav-link" href="/deal/list">Deal</a>
                <a class="nav-item nav-link" href="/cart/list">Cart</a>
                <g:if test="${session.cart!=null}">
                    <div>
                        <img src="data:image/png;base64,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">
                        ${session.cart.price}
                    </div>
                </g:if>
            </div>
        </div>
    </nav>
</span>