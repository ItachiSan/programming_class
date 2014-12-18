<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/uikit.min.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/uikit.min.js"></script>
<title>
Esercizi BDlab
</title>
</head>
<body>
<h1 class="uk-article-title">BDLab 2014 - Esempi</h1>

<nav class="uk-navbar">

    <ul class="uk-navbar-nav">
        <li><a href="index.php">Pagina principale</a></li>
        <li class="uk-parent" data-uk-dropdown>
            <a href="">Parametri</a>

            <div class="uk-dropdown uk-dropdown-navbar submenu">
                <ul class="uk-nav uk-nav-navbar">
                    <li><a href="parameters/pass.php">Passaggio di parametri</a></li>
                    <li><a href="parameters/menu.php">Menù dinamico</a></li>
                </ul>
            </div>

        </li>
        
        <li class="uk-parent" data-uk-dropdown>
            <a href="">Cookie e sessioni</a>

            <div class="uk-dropdown uk-dropdown-navbar submenu">
                <ul class="uk-nav uk-nav-navbar">
                    <li><a href="cookie_session/counter.php">Contatore</a></li>
                    <li><a href="cookie_session/login_cookie.php">Login (cookie)</a></li>
                    <li><a href="cookie_session/login_session.php">Login (session)</a></li>
                </ul>
            </div>

        </li>
    </ul>

</nav>

</body>
</html>