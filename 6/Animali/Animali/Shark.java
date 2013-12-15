package Animali;
public class Shark implements Animal {
    // Campi
    private static int legs = 0; // Nessuna gamba
    private static String color;
    private int fins; // Di default 3 pinne
    
    // Costruttore
    public Shark(){
        color="Grigio";
        fins=3;
    }
    
    // Metodi
    public int numberOfLegs(){
        return legs;
    }
    
    public String sayHello(){
        return "Ciao, sono uno squalo!";   
    }
    
    public boolean isVegetarian(){
        return false;
    }
    
    public String getColor(){
        return color;
    }
    
    // Metodi solo dello squalo
    public int numberOfFins(){
        return fins;
    }
    
    public void setFins(int n){
        fins=n;
    }
}
