import java.io.*;
import java.util.*;

class ContoBancario {
    // Campi
    private double deposito;
    private String persona;
    private ArrayList<Double> movimenti = new ArrayList<Double>();
    
    public ContoBancario(String s, double d){
    persona = s;
    deposito = d;
    }
    
    public ContoBancario(String s){
    this(s,0);
    }

    public void versamento(double d){
    deposito += d;
    movimenti.add(d);
    }
    
    public void prelievo(double d){
    versamento(-d);
    }
    
    public double saldo(){
    return deposito;
    }
    
    public void saveMovements(String s) throws IOException {
    FileWriter out_file = new FileWriter(s);
    PrintWriter pwr = new PrintWriter(out_file); 
    
    for (int i=0; i < movimenti.size(); i++)
        pwr.println(movimenti.get(i));
    
    pwr.flush();
    out_file.close();
    }
    
    public void saveMovements() throws IOException {
    saveMovements("movimenti.txt");
    }

    
    public static void main(String args[]) throws IOException {
    ContoBancario c = new ContoBancario("Giovanni Santini");
    c.versamento(12345678);
    c.prelievo(2.5);
    System.out.println("Saldo = " + c.saldo());
    c.saveMovements();
    }

}
