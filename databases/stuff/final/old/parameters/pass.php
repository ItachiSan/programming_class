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
    <!-- Funzioni nostre -->
    <?php include_once('../include/library.php');?>
    <!-- Stampa elementi (in un array, ricorsivamente) passati col metodo GET -->
    <?php
    //if($_GET){ 
    //if(isset($_GET['person']['name']) && ($_GET['person']['name'])){
    if($_GET['formid'] == 'formGET'){
    
    /*
    print('<pre>');
    print_r($_GET);
    print('</pre>');
    */
    stampa_array_con_pre($_GET);
    
    print('<div>');
    print($_GET['person']['name']);
    print(' ');
    print($_GET['person']['surname']);
    print('</div>');
    
    $person=$_GET['person'];
    print('<div>');
        print('<div style="color:'.$_GET['pref_color'].'" class="uk-text-bold">');
        print($person['name']);
        print('</div>');
        print('<div class="uk-text-bold">');
        print($person['surname']);
        print('</div>');
    print('</div>');
    }
    
    if($_POST['formid'] == 'formPOST'){
    print('<pre>');
    print_r($_POST);
    print('</pre>');
    
    print('<div>');
    print($_POST['person']['name']);
    print(' ');
    print($_POST['person']['surname']);
    print('</div>');
    
    $person=$_POST['person'];
    print('<div>');
        print('<div style="color:'.$_POST['pref_color'].'" class="uk-text-bold">');
        print($person['name']);
        print('</div>');
        print('<div class="uk-text-bold">');
        print($person['surname']);
        print('</div>');
    print('</div>');
    }
    ?>

    <!-- Form per richiesta multipla di input, con GET -->
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
            <!-- Valore nascosto per identificare questo specifico elemento -->
            <input type="hidden" name="formid" value="formGET">
            <button class="uk-button">Invia dati</button>
        </fieldset>
    </form>

    <!-- Form per richiesta multipla di input, con POST -->
    <form class="uk-form" action="pass.php" method="POST">
        <fieldset data-uk-margin>
            <legend>Passaggio di parametri con il metodo POST</legend>
            <input type="text" name="person[name]" placeholder="Nome">
            <input type="text" name="person[surname]" placeholder="Cognome">
            <input type="date" name="person[birthdate]" placeholder="Data di nascita">
            <input type="number" name="person[height]" placeholder="Altezza (cm)">
            <select name="pref_color">
                <option value="#0000FF">Blu</option>
                <option value="#FF0000">Rosso</option>
                <option value="#00FF00">Verde</option>
            </select>
            <!-- Valore nascosto per identificare questo specifico elemento -->
            <input type="hidden" name="formid" value="formPOST">
            <button class="uk-button">Invia dati</button>
        </fieldset>
    </form>


</body>

</html>
<!--  -->
