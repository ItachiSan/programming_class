import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ContoBancario {
    // Campi
    private double deposito;
    private String persona, codice;
    private ArrayList<Double> movimenti = new ArrayList<Double>();
    
    public ContoBancario(String s, double d) throws NoSuchAlgorithmException {
    persona = s;
    deposito = d;
    codice = codice(s);
    }
    
    public ContoBancario(String s) throws NoSuchAlgorithmException {
    this(s,0);
    }
    
    private String codice(String s) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
	md.update(s.getBytes());
	byte[] digest = md.digest();
	StringBuffer sb = new StringBuffer();
	for (byte b : digest) {
	    sb.append(Integer.toHexString((int) (b & 0xff)));
	    }
    return sb.toString();
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
    
    public String getCodice(){
    return codice;
    }
    
    public void saveMovements(String s) throws IOException {
    FileWriter out_file = new FileWriter(s);
    PrintWriter pwr = new PrintWriter(out_file); 
    
    for (int i=0; i < movimenti.size(); i++)
        pwr.printf("%.3f\n",movimenti.get(i));
    
    pwr.flush();
    out_file.close();
    }
    
    public void saveMovements() throws IOException {
    saveMovements("movimenti.txt");
    }

    
    public static void main(String args[]) throws Exception {
    ContoBancario c = new ContoBancario("Giovanni Santini");
    c.versamento(12345678);
    c.prelievo(2.5);
    System.out.printf("Saldo = %.3f\n", c.saldo());
    System.out.println("Codice = " + c.getCodice());
    c.saveMovements();
    }

}
