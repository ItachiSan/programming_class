//import PilaStatica.*;

class Mirror {
    public static void main(String args[]){
        PilaStatica array = new PilaStatica();
        
        // Aggiungo la stringa
        try {    
            for (int i=0; i < args[0].length() ; i++)
                array.push(args[0].charAt(i) );
            } catch (PilaPienaException e) {
                System.out.println(e.toString());
            }
            
        // E la stampo al contrario
        while ( !array.empty() )
            System.out.print(array.pop());
        System.out.println();
    }
}
