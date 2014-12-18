<!DOCTYPE html>
<html>

<head>
    <?php include('../lib/header.php')?>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Esercizi BDLab</title>
</head>

<body>
    <h1 class="uk-article-title">Il caso di SQL Injection</h1>
    <?php include('../lib/navigation.php')?>
    <?php include('../lib/functions.php')?>
    
    <div class="uk-panel">
        <form action="<?php print($_SERVER['PHP_SELF']);?>" method="POST">
        <label>Prodotti inadatti a </label>
        <input class="uk-form-width-large" type="text" name="intolleranza"/>
        <button>Cerca</button>
        </form>
    </div>

<?php
// Apriamo la connessione
$db = open_pg_connection();
if($db)
    echo('Connected');
else
    echo('Not connected');

// Definire il comando SQL
$sql = "SELECT p.*, i.intolleranza FROM prodotto p LEFT JOIN inadatto_a i ON p.id=i.prodotto";

$cerca = '';
if(isset($_POST['intolleranza'])){
    $cerca = " WHERE intolleranza=$1";
    $sql .= $cerca;
}

// Elaborare il risultato
$result=pg_prepare($db, 'mysqlquery', $sql);

$data=Array();
if($_POST['intolleranza'] <> ''){
    $data[] = 
}
$result=pg_execute($db, 'mysqlquery', $data)
?>
<table class="uk-table uk-table-striped">
<tr>
    <th>Ingrediente</th>
    <th>Marca</th>
    <th>Data di acquisto</th>
    <th>Scadenza</th>
    <th>Intolleranza</th>
</tr>
<?php
while($row=pg_fetch_assoc($result)){
    //print_r($row);
    print('<tr>'.PHP_EOL);
    print('<td>'.$row['ingrediente'].'</td>'.PHP_EOL);
    print('<td>'.$row['marca'].'</td>'.PHP_EOL);
    print('<td>'.$row['data_acquisto'].'</td>'.PHP_EOL);
    print('<td>'.$row['scadenza'].'</td>'.PHP_EOL);
    print('<td>'.$row['intolleranza'].'</td>'.PHP_EOL);
    print('</tr>');
    }
?>
</table>
<?php
// Chiudere la connessione
close_pg_connection($db);
?>


</body>

</html>

<!DOCTYPE html>
<html>

<head>
    <?php include('../lib/header.php')?>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Esercizi BDLab</title>
</head>

<body>
    <h1 class="uk-article-title">Il caso di SQL Injection</h1>
    <?php include('../lib/navigation.php')?>
    <?php include('../lib/functions.php')?>
    
    <div class="uk-panel">
        <form action="<?php print($_SERVER['PHP_SELF']);?>" method="POST">
        <label>Prodotti inadatti a </label>
        <input class="uk-form-width-large" type="text" name="intolleranza"/>
        <input class="uk-form-width-large" type="text" name="marca"/>
        <button>Cerca</button>
        </form>
    </div>

<?php
// Apriamo la connessione
$db = open_pg_connection();
if($db)
    echo('Connected');
else
    echo('Not connected');

// Definire il comando SQL
$sql = "SELECT p.*, i.intolleranza FROM prodotto p LEFT JOIN inadatto_a i ON p.id=i.prodotto";

if(isset($_POST['intolleranza'])){
    $sql .= " WHERE intolleranza = $1 AND marca = $2";
}


$result=pg_prepare($db, 'mysqlquery', $sql);
$data = Array();

if($where <> ''){
    $data[] = $_POST['intolleranza'];
    $data[] = $_POST['marca'];
}
// Elaborare il risultato
$result=pg_execute($db, 'mysqlquery', $data);
?>
<table class="uk-table uk-table-striped">
<tr>
    <th>Ingrediente</th>
    <th>Marca</th>
    <th>Data di acquisto</th>
    <th>Scadenza</th>
    <th>Intolleranza</th>
</tr>
<?php
while($row=pg_fetch_assoc($result)){
    //print_r($row);
    print('<tr>'.PHP_EOL);
    print('<td>'.$row['ingrediente'].'</td>'.PHP_EOL);
    print('<td>'.$row['marca'].'</td>'.PHP_EOL);
    print('<td>'.$row['data_acquisto'].'</td>'.PHP_EOL);
    print('<td>'.$row['scadenza'].'</td>'.PHP_EOL);
    print('<td>'.$row['intolleranza'].'</td>'.PHP_EOL);
    print('</tr>');
    }
?>
</table>
<?php
// Chiudere la connessione
close_pg_connection($db);
?>


</body>

</html><!DOCTYPE html>
<html>

<head>
    <?php include('../lib/header.php')?>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Esercizi BDLab</title>
</head>

<body>
    <h1 class="uk-article-title">Il caso di SQL Injection</h1>
    <?php include('../lib/navigation.php')?>
    <?php include('../lib/functions.php')?>
    
    <div class="uk-panel">
        <form action="<?php print($_SERVER['PHP_SELF']);?>" method="POST">
        <label>Prodotti inadatti a </label>
        <input class="uk-form-width-large" type="text" name="intolleranza"/>
        <input class="uk-form-width-large" type="text" name="marca"/>
        <button>Cerca</button>
        </form>
    </div>

<?php
// Apriamo la connessione
$db = open_pg_connection();
if($db)
    echo('Connected');
else
    echo('Not connected');

// Definire il comando SQL
$sql = "SELECT p.*, i.intolleranza FROM prodotto p LEFT JOIN inadatto_a i ON p.id=i.prodotto";

if(isset($_POST['intolleranza'])){
    $sql .= " WHERE intolleranza = $1 AND marca = $2";
}


$result=pg_prepare($db, 'mysqlquery', $sql);
$data = Array();

if($where <> ''){
    $data[] = $_POST['intolleranza'];
    $data[] = $_POST['marca'];
}
// Elaborare il risultato
$result=pg_execute($db, 'mysqlquery', $data);
?>
<table class="uk-table uk-table-striped">
<tr>
    <th>Ingrediente</th>
    <th>Marca</th>
    <th>Data di acquisto</th>
    <th>Scadenza</th>
    <th>Intolleranza</th>
</tr>
<?php
while($row=pg_fetch_assoc($result)){
    //print_r($row);
    print('<tr>'.PHP_EOL);
    print('<td>'.$row['ingrediente'].'</td>'.PHP_EOL);
    print('<td>'.$row['marca'].'</td>'.PHP_EOL);
    print('<td>'.$row['data_acquisto'].'</td>'.PHP_EOL);
    print('<td>'.$row['scadenza'].'</td>'.PHP_EOL);
    print('<td>'.$row['intolleranza'].'</td>'.PHP_EOL);
    print('</tr>');
    }
?>
</table>
<?php
// Chiudere la connessione
close_pg_connection($db);
?>


</body>

</html>
