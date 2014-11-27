<?php

$tipo = Array('Prodotto', 'Marca', 'Prezzo');
$prodotto = Array('Spaghetti','Tortiglioni','Acqua','Cioccolato fondente');
$marca = Array('De Cecco','Barilla','Vitasnella','Novi');
$prezzo = Array(0.80, 0.50, 1.50, 3.20);

function pre($data) {
    print '<pre style="background-color: transparent;">';
    var_dump($data);
    print '</pre>';
}

function show_list() {
	global $tipo;
	global $prodotto;
	global $marca;
	global $prezzo;

	print('<table class="uk-table uk-table-striped">');
	print('<caption>Prodotti in magazzino</caption>');
	
	print('<thead><tr>');
	for($i = 0; $i < count($tipo); $i++) {
//	foreach($tipo as $t) {
		print('<th>' . $tipo[$i] . '</th>');
	}
	print('</tr></thead>');

	print('<tbody>');
	for($i = 0; $i < count($prodotto); $i++) {
		print('<tr>');
		print('<td>' . $prodotto[$i] . '</td>');
		print('<td>' . $marca[$i] . '</td>');
		print('<td>' . $prezzo[$i] . '</td>');
		print('</tr>');
	}
	print('</tbody>');

	print('</table>');
}

function show_form(){
    print('
    <form class="uk-form" method="POST" action="menu.php">
    <fieldset data-uk-margin>
    <legend>Inserisci un nuovo prodotto</legend>

    <div class="uk-form-row">
    <input type="text" placeholder="Nome del prodotto" name="prod[name]">
    </div>

    <div class="uk-form-row">
    <input type="text" placeholder="Marca del prodotto" name="prod[brand]">
    </div>
    
    <div class="uk-form-row">
    <input type="number" placeholder="Prezzo del prodotto" name="prod[price]">
    </div>
    
    <button class="uk-button">Inserisci prodotto</button>
    </fieldset>
    </form>
    ');
}
?>
