<!DOCTYPE html>
<html>

<head>
    <?php include('../lib/header.php')?>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Esercizi BDLab</title>
</head>

<body>
    <h1 class="uk-article-title">Generazione dinamica del menù</h1>
    <?php include('../lib/navigation.php')?>
    <!-- Da qui sotto, cose fatte a lezione; quelle sopra viste anche in passato -->
    
    <!-- Classe UIKit per creare una griglia -->
    <div class="uk-grid">
    <!-- Prende i 2/10 della pagina -->
    <div class="uk-width-2-10">
    
    <!-- nav: tag per indicare una zona piena di link ipertestuali (utili per i browser, si preparano psicologicamente) -->
    <!-- a: marcatore 'anchor', per link ipertestuali (definiti in 'href') -->
    <!-- ul: lista non ordinata, elementi segnati dal tag 'li' -->
    <!-- Comodità del metodo GET: posso passare i parametri a manina! Tipo nei link sotto -->
    <nav>
        <ul class="uk-nav uk-nav-side">
<?php // Bisogna non tabbarlo, altrimenti il primo elemento printato si prende gli spazi.... -.-"
                $menu = Array(
                    'Elenco dei prodotti'       =>'menu.php?mod=list',
                    'Inserisci nuovi prodotti'  =>'menu.php?mod=insert',
                    'Statistiche'               =>'menu.php?mod=stat'
                );
                
                /*
                Nota bene:
                $var='Giovanni'
                print('Ciao $var'); -> Ciao $var
                print("Ciao $var"); -> Ciao Giovanni
                */
                
                $keys=array_keys($menu); // Piglia i valori di ogni chiave dell'array 'menu'
                //print_r($keys);
                foreach($keys as $key){
                    print("\t\t".'<li><a href="'.$menu[$key].'">'.$key.'</a></li>'."\n");
                }
?>
            <!-- Genera:
            <li><a href="menu.php?mod=list">Elenco dei prodotti</a></li>
            <li><a href="menu.php?mod=insert">Inserisci nuovi prodotti</a></li>
            <li><a href="menu.php?mod=stat">Statistiche</a></li>
            -->
        </ul>
    </nav>
    
    </div> <!-- End of 2/10 -->
    
    <div class="uk-width-8-10">
<?php
include_once('../lib/functions.php');
if(isset($_GET['mod'])){
    switch($_GET['mod']){
        case 'insert':
            print('Inserisci');
            break;
        case 'stat':
            print('Statistiche');
            break;
        case 'list':
            print('Elenco');
            break;
    }
} else
    print('Nessun parametro inserito');
?>
    </div>
    
    </div> <!-- End of grid -->
    
</body>

</html>
