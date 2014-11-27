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
            <li><a href="menu.php?mod=list">Elenco dei prodotti</a></li>
            <li><a href="menu.php?mod=insert">Inserisci nuovi prodotti</a></li>
            <li><a href="menu.php?mod=stat">Statustiche</a></li>
        </ul>
    </nav>
    
    </div> <!-- End of 2/10 -->
    
    <div class="uk-width-8-10">
        Test segnaposto
    </div>
    
    </div> <!-- End of grid -->
    
</body>

</html>
