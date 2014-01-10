//import PilaStatica.*;

class MirrorDinamico {
    public static void main(String args[]){
        PilaDinamica array = new PilaDinamica();
        
        // Aggiungo la stringa
        for (int i=0; i < args[0].length() ; i++)
            array.push(args[0].charAt(i) );
               
        // E la stampo al contrario
        while ( !array.empty() )
            System.out.print(array.pop());
        System.out.println();
    }
}
