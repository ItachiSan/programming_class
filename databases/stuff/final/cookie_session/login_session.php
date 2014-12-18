<?php
ini_set("error reporting", E_ALL);
session_start();
include_once('../lib/functions.php');
$logged = null;
//Verifico l'esistenza del cookie e di $logged
if(isset($_POST['user'])){
    $myuser=trim(strtolower($_POST['user']));
    $mypsw=trim($_POST['psw']);
    $logged=check_login($myuser, $mypsw);
}
if(isset($_SESSION['is_logged'])){
    $logged=$_COOKIE['is_logged'];
}
if($logged){
    $_SESSION['is_logged']=$logged;
}
if(isset($_GET['mod']) && $_GET['mod'] == 'out'){
    unset($_SESSION['is_logged']);
    $logged=null;
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
    print(' - <a href="login_cookie.php?mod=refresh">Aggiorna</a>');
}
?>
<body>
    <h1 class="uk-article-title">Login con le sessioni</h1>
    <?php include('../lib/navigation.php')?>

<?php
if(!$logged){
show_login_form();
}

if(isset($_GET['mod']) && $_GET['mod'] == 'refresh'){
    echo 'Contenuto della pagina ok';
}

?>
    
    <div class="uk-panel uk-margin">
<?php
print_r($_SESSION);
?>

</body>

</html>
