<?php
ini_set("error reporting", E_ALL);
include_once('../lib/functions.php');
$logged = null;
//Verifico l'esistenza del cookie e di $logged
if(isset($_POST['user'])){
    $myuser=trim(strtolower($_POST['user']));
    $mypsw=trim($_POST['psw']);
    $logged=check_login($myuser, $mypsw);
}
?>

<!DOCTYPE html>
<html>

<head>
    <?php include('../lib/header.php')?>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Esercizi BDLab</title>
</head>
<?php
if($logged){
    print("Ciao $logged");
    print(' - <a href="login_cookie.php?mod=out">Logout</a>');
}
?>
<body>
    <h1 class="uk-article-title">Login con i cookie</h1>
    <?php include('../lib/navigation.php')?>

<?php
if(!$logged){
show_login_form();
}
?>
    
    <div class="uk-panel uk-margin">
<?php
print_r($_COOKIE);
?>

</body>

</html>
