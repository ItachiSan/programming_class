<!DOCTYPE html>
<html>
    <head>
    <title>Ricetta da preparare</title>
    </head>

    <body>
    Ecco la ricetta che devi preparare:
    <!-- <?php QUALCOSA ?> rende QUALCOSA uno script PHP! -->
    <?php
    /*
    Commento in PHP pari alla C... Yeah!
    Sotto recupero dalla POST il dato 'categoria' e lo metto in 'scelta'
    $_POST è una supervariabile ("suprema"... in realtà definita a livello del linguaggio)
    $_POST rappresenta l'intera richiesta POST...!
    */
    $scelta=$_POST['categoria'];
    echo $scelta;
    ?>
    </body>

</html>
