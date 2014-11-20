<!-- Una navbar UIkit, da importare con 'include' da PHP -->
    <nav class="uk-navbar">
    <ul class="uk-navbar-nav">
        <li class="uk-active"><a href="../index-old.html">Vecchia home</a></li>
        
        <!-- data-uk-dropdown permette di fare il menu -->
        <li class="uk-parent" data-uk-dropdown><a href="">Parametri</a>
            <!-- Effetto dinamico, usa JQuery -->
            <div class="uk-dropdown uk-dropdow-navbar">
                <ul class="uk-nav uk-navbar">
                    <li><a href="../parameters/pass.php">Passaggio di parametri</a></li>
                    <li><a href="../parameters/menu.php">Creazione dinamica dei menu</a></li>
                </ul>
            </div>
        </li>
        
        <li class="uk-parent" data-uk-dropdown><a href="">Cookie e sessioni</a>
            <div class="uk-dropdown uk-dropdow-navbar">
                <ul class="uk-nav uk-navbar">
                    <li><a href="../cookie_session/counter.php">Contatore</a></li>
                    <li><a href="../cookie_session/login_cookie.php">Login (cookie)</a></li>
                    <li><a href="../cookie_session/login_session.php">Login (session)</a></li>
                </ul>
            </div>
        </li>
        
    </ul>
</nav>
