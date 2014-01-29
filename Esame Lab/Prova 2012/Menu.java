import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

class Menu {
    
    public static void main (String args[]) throws IOException {
    
        // Nessun input da CLI -> eccezione
        if (args.length == 0)
            throw new IOException();
        
        // Impostiamo il docente 
        String docente = "";
        for (String s : args)
            docente = docente + " " + s;
        
        // Impostiamo le classi che ci servono
        Scanner in = new Scanner(System.in);
        Registro R = new Registro(docente);
        int n = -1;
        String corso = "";
        int matricola = -1;
        int voto = -1;
        boolean lode = true;
        char c = 'c';
        boolean exec = true; // Esecuzione
        
        // Il programma
        while (exec){
        switch (n) {
            // Aggiungi esame
            case 1: Esame e; // L'esame da aggiungere
            
                    System.out.print("Corso: ");
                    corso = in.nextLine();
                    System.out.print("Matricola: ");
                    matricola = Integer.parseInt(in.nextLine());
                    System.out.print("Esame in 30esimi(n) o (non)approvato (b)? ");
                    
                    while ((c = in.nextLine().charAt(0)) != 'n' && c != 'b'); // Becchiamo la risposta giusta
                    if ( c == 'n' ){ // Esame in 30esimi
                        System.out.print("Voto: ");
                        voto = Integer.parseInt(in.nextLine());
                        System.out.print("Con lode? [s/n] ");
                        while ((c = in.nextLine().charAt(0)) != 's' && c != 'n');
                        // Lode
                        if ( c == 's' )
                            lode = true;
                        else
                            lode = false;
                        // Gestiamo le possibili eccezioni
                        try {
                            e = new Esame30(corso,matricola,voto,lode);
                        } catch (IOException i) {
                            System.out.println("Errore nella creazione dell'esame (i dati sono corretti?)");
                            e = null; // Evitiamo rogne dal compilatore
                            n = -1; // Ritorniamo allo switch
                        }
                    } else { // Esame approvato
                        System.out.print("Approvato? [s/n] ");
                        while ((c = in.nextLine().charAt(0)) != 's' && c != 'n');
                        // Lode
                        if ( c == 's' )
                            lode = true;
                        else
                            lode = false;
                        e = new EsameApprovato(corso,matricola,lode);
                    }
                    if (n == -1)
                        break; // Errore nella creazione dell'esame in 30esimi
                    else {
                    if (R.cercaEsame(corso,matricola) != null)
                        System.out.println("Esame già presente");
                    else {
                        R.aggiungiEsame(e);
                        System.out.println("Esame registrato");
                        }
                    }
                    n = -1; // Torniamo al menu    
                    break; // Fine, alleluja
            // Rimuovi esame
            case 2: System.out.print("Corso: ");
                    corso = in.nextLine();
                    System.out.print("Matricola: ");
                    matricola = Integer.parseInt(in.nextLine());
                    if (R.rimuoviEsame(corso,matricola) != null)
                        System.out.println("Esame rimosso");
                    else
                        System.out.println("Esame non presente");
                    n = -1; // Torniamo al menu    
                    break;
            // Stampa registro e frazione passati        
            case 3: System.out.println(R.toString());
                    System.out.println("Frazione passati: " + (R.frazionePassati() * 100) );
                    n = -1; // Torniamo al menu    
                    break;
            // Stampa registro passati, media dei voti in 30esimi e numero approvati                    
            case 4: ArrayList<Esame> P = new ArrayList<Esame>();
                    // Salviamo gli esami buoni
                    for (int i = 0; i < R.numeroEsami(); i++)
                        if (R.getEsame(i).isPassato())
                            P.add(R.getEsame(i));
                    // Iniziamo i controlli
                    int voti_30 = 0;
                    int num_30 = 0;
                    int num_approvato = 0;
                    for(int i = 0; i < P.size(); i++)
                        if (P.get(i) instanceof Esame30){
                            voti_30 += ((Esame30) P.get(i)).getVoto();
                            num_30++;
                        } 
                        else
                            num_approvato++;
                    // Stampa gli esami
                    for(int i = 0; i < P.size(); i++)
                        System.out.println(P.get(i).toString());        
                    // Stampa la media, se esiste
                    if (num_30 != 0)
                        System.out.println("Media dei voti in 30esimi: " + (((double) voti_30)/num_30));
                    // Stampa il numero degli esami approvati, se esiste
                    if (num_approvato != 0)
                        System.out.println("Esami approvati: " + num_approvato);
                    n = -1;
                    break;
            // Riordina il registro        
            case 5: System.out.println("Riordino il registro...");
                    R.ordina();
                    System.out.println("Registro riordinato.");
                    n = -1;
                    break;
            // Uscita        
            case 6: System.out.println("Uscita in corso...");
                    exec = false;
                    break;
            // Menu
            default:
                    System.out.println(" ----------------------------------------------------------------- ");
                    System.out.println(" Registro del docente: " + R.getDocente());
                    System.out.println(" (1) Verbalizza un esame.");
                    System.out.println(" (2) Rimuovi un esame. ") ;
                    System.out.println(" (3) Stampa il registro completo. ") ;
                    System.out.println(" (4) Stampa un registro con i soli voti sufficienti/approvati. ") ;
                    System.out.println(" (5) Ordina per corso e matricola il registro. ") ;
                    System.out.println(" (6) Esci. ") ;
                    System.out.println(" ----------------------------------------------------------------- ");
                    System.out.print(" -> Scelta: ");
                    n = Integer.parseInt(in.nextLine());
            }
       }    
    }

}


