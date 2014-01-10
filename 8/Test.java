class Test {
    // Giusto per testare le classi
    public static void main(String args[]){
    // Le nostre classi!
    Agenda agenda = new Agenda();
    Impegno task1, task2, task3;
    task1 = new Impegno(1,2,3,"Pippo");
    task2 = new Impegno(1,3,4,"Pluto");
    task3 = new Impegno(1,4,5,"Paperino");
    
    // Test Impegno
    System.out.println("L'oggetto creato costa " + bla.getPrezzo());
    System.out.println("La sua categoria e' " + bla.getCategoria());
    System.out.println("La descrizione dell'oggetto e' la seguente " + bla.getDesc());
    System.out.println("Riepilogo: \n" + bla.toString());
    // Test Carrello
    System.out.println("Aggiungo al carrello!");
    carrello.metti(bla);
    System.out.println("Il carrello ora ha " + carrello.size() + " elemento/i");
    System.out.println("Rimuovo dal carrello!");
    carrello.togli(bla);
    System.out.println("Il carrello ora ha " + carrello.size() + " elemento/i");
    System.out.println("Aggiungo al carrello 3 volte!");
    for (int i=0; i<3; i++) carrello.metti(bla);
    System.out.println("Il carrello ora ha " + carrello.size() + " elemento/i");
    System.out.println("Tolgo i duplicati!");
    carrello.togliDup();
    System.out.println("Il carrello ora ha " + carrello.size() + " elemento/i");
    }    

}
