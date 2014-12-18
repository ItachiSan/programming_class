<!DOCTYPE html>
<html>

<head>
    <?php include('../lib/header.php')?>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Esercizi BDLab</title>
</head>

<body>
    <h1 class="uk-article-title">Accesso alle basi di dati</h1>
    <?php include('../lib/navigation.php')?>
    <?php include('../lib/functions.php')?>
    

<?php
// Apriamo la connessione
$db = open_pg_connection();
if($db)
    echo('Connected');
else
    echo('Not connected');
// Definire il comando SQL

// Elaborare il risultato

// Chiudere la connessione
close_pg_connection($db);
?>


</body>

</html>
