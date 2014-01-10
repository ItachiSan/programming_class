import java.util.ArrayList;

class Agenda{
    // Campi
    private ArrayList<Impegno> lista;
    private String proprietario;
    
    // Costruttori
    public Agenda(){
        lista = new ArrayList<Agenda>();
    } 

    // Metodi
    public String getProp(){
        return proprietario;
    }
    
    public boolean aggiungiImpegno(Impegno task){
        if (lista.indexOf(task)==-1)
            return lista.add(task);
        else
            return false;
    }
    
    public String toString(){
    // Creo una lista di impegni temporanea... 
    ArrayList<Impegno> lista_temp = new ArrayList<Impegno>();
    // Ci aggiungo tutti quelli che ho...
    for (Impegno task : lista)
        lista_temp.add(task);
    // Riordino la lista temporanea...
    Collections.sort(lista_temp);
    // E finalmente creo la stringa    
    return  "Proprietario: " + proprietario +
            "\nImpegni:" + lista_temp.toString();
    }
    
    public static boolean cerca(ArrayList<Impegno> lista, int g, String nome){
        for (Impegno task : lista)
            if  (task.giorno==g &&
                 task.persona==nome)
                    return true;
        return false;
    }
    
    public boolean controlla(Agenda agenda, int day){
        return cerca(agenda.lista,day,proprietario) && cerca(this.lista,day,agenda.getProp());
    }
}
