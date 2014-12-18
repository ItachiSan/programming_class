<!DOCTYPE html>
<html>
<head>
<?php include ('../lib/header.php'); ?>
<title>
Esercizi BDlab
</title>
</head>
<body>
<h1 class="uk-article-title">Passaggio di parameter GET/POST</h1>
<?php include ('../lib/navigation.php'); ?>

<div class="uk-panel uk-panel-box uk-panel-box-primary uk-margin">
<?php

include_once "../lib/functions.php";

if(isset($_GET['check-par-type']) && $_GET['check-par-type']=="get"){
    $parameters = $_GET;
}elseif(isset($_POST['check-par-type']) && $_POST['check-par-type']=="post"){
    $parameters = $_POST;
}else{
    $parameters = array();
}

pre($parameters);

?>
</div>


<div class="uk-panel uk-margin">
	<form class="uk-form" action="<?php echo $_SERVER['PHP_SELF'];?>" method="GET">
	<div class="uk-text-bold">
	Passaggio di parametri con il metodo GET
	</div>
	
	<fieldset data-uk-margin>
		<label>Dati anagrafici:</label>
	    <input type="text" name="person[name]" placeholder="Nome" />
	    <input type="text" name="person[surname]" placeholder="Cognome" />
		<input type="number" step="1" name="person[height]" placeholder="Altezza (cm)" />
		<input type="text" name="person[birthdate]" placeholder="Data di nascita"/>
		<select name="pref_col">
            <option value="#FFFFFF" style="color: #FFFFFF;">Bianco</option>
            <option value="#FF0000" style="color: #FF0000;">Rosso</option>
            <option value="#00FF00" style="color: #00FF00;">Verde</option>
            <option value="#0000FF" style="color: #0000FF;" selected>Blu</option>
            <option value="#000000" style="color: #000000;">Nero</option>
            <option value="#FFFF00" style="color: #FFFF00;">Giallo</option>
        </select>
		<input type="hidden" name="check-par-type" value="get">
	    <button class="uk-button">Invia</button>
	</fieldset>
	
	</form>
</div>

<hr class="uk-article-divider" />

<div class="uk-panel uk-margin">
	<form class="uk-form" action="<?php echo $_SERVER['PHP_SELF'];?>" method="POST">
	<div class="uk-text-bold">
	Passaggio di parametri con il metodo POST
	</div>
	
	<fieldset data-uk-margin>
	<label>Dati anagrafici:</label>
	    <input type="text" name="person[name]" placeholder="Nome" />
	    <input type="text" name="person[surname]" placeholder="Cognome" />
		<input type="number" step="1" name="person[height]" placeholder="Altezza (cm)" />
		<input type="text" name="person[birthdate]" placeholder="Data di nascita" />
		<select name="pref_col">
            <option value="#FFFFFF" style="color: #FFFFFF;">Bianco</option>
            <option value="#FF0000" style="color: #FF0000;">Rosso</option>
            <option value="#00FF00" style="color: #00FF00;">Verde</option>
            <option value="#0000FF" style="color: #0000FF;" selected>Blu</option>
            <option value="#000000" style="color: #000000;">Nero</option>
            <option value="#FFFF00" style="color: #FFFF00;">Giallo</option>
        </select>
		<input type="hidden" name="check-par-type" value="post">
	    <button class="uk-button">Invia</button>
	</fieldset>
	
	</form>
</div>

<?php

if($parameters){
    $person = $parameters['person'];
    ?>
    <hr class="uk-article-divider" />
    <div class="uk-panel uk-margin">
        <div class="uk-grid" style="color: <?php echo $parameters['pref_col'];?>">
        <div class="uk-width-3-10">
        <span class="uk-text-bold">Nome e cognome: </span> 
        <?php echo $person['name']." ".$person['surname'];?>
        </div>
        
        <div class="uk-width-3-10">
        <span class="uk-text-bold">Data di nascita: </span>
        <?php echo $person['birthdate'];?>
        </div>       
        
        <div class="uk-width-3-10">
        <span class="uk-text-bold">Altezza: </span>
        <?php echo $person['height'];?>
        </div>     
            
            
        </div>
    </div>
<?php
}
?>

</body>
</html>