<?php // Here comes the counter
if(isset($_GET['mod']) && $_GET['mod']=="sum1"){
    if(isset($_COOKIE['visit'])){
        $counter=$_COOKIE['visit'];
        $counter++;
    } else {
        $counter=1;
    }
if(isset($_GET['mod']) && $_GET['mod']=="set0"){
    $counter=0;
    setcookie('visit','');
}
    setcookie('visit', $counter, time()+120);
    setcookie('color', 'blue', time()+120);
}
?>

<!DOCTYPE html>
<html>

<head>
    <?php include('../lib/header.php')?>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Esercizi BDLab</title>
</head>

<body>
    <h1 class="uk-article-title">Contatore con i cookie</h1>
    <?php include('../lib/navigation.php')?>
    
    <div class="uk-panel uk-panel-box uk-panel-box-primary uk-margin">
<?php
echo $counter;
?>
    </div>

<?php
print_r($_COOKIE);
?>
    
    <div>
        <a href="counter.php?mod=sum1">Incrementa il contatore</a>
        <a href="counter.php?mod=set0">Azzera il contatore</a>
    </div>

</body>

</html>
