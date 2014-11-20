<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Passaggio parametri GET/POST</title>
    <!-- Carichiamo JQuery e UIkit -->
    <link href="../css/uikit.min.css" rel="stylesheet" type="text/CSS">
    <script src="../js/jquery.js"></script>
    <script src="../js/uikit.min.js"></script>
</head>

<body>
    <h1>Passaggio parametri GET/POST</h1>
    <!-- Includi codice HTML/PHP con l'include...! -->
    <?php include_once('../include/navigator.php');?>
    <!-- Stampa elementi (in un array, ricorsivamente) passati col metodo GET -->
    <?php if($_GET) print_r($_GET);?>

    <!-- Form per richiesta multipla di input -->
    <form class="uk-form" action="pass.php" method="GET">
        <fieldset data-uk-margin>
            <legend>Passaggio di parametri con il metodo GET</legend>
            <input type="text" name="person[name]" placeholder="Nome">
            <input type="text" name="person[surname]" placeholder="Cognome">
            <input type="date" name="person[birthdate]" placeholder="Data di nascita">
            <input type="number" name="person[height]" placeholder="Altezza (cm)">
            <select name="pref_color">
                <option value="#0000FF">Blu</option>
                <option value="#FF0000">Rosso</option>
                <option value="#00FF00">Verde</option>
            </select>
            <button class="uk-button">Invia dati</button>
        </fieldset>
    </form>

</body>

</html>
<!--  -->
