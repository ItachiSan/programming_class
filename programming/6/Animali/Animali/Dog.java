package Animali;
public class Dog implements Animal {
    // Campi
    private static int legs = 4;
    private String color;
    private String chip_code = "0123456789ABCDE";
    
    // Costruttore
    public Dog(){
        color = "Marrone";
    }
    
    // Metodi
    public int numberOfLegs(){
        return legs;
    }
    
    public String sayHello(){
        return "Ciao, sono un cane!";  
    }
    
    public boolean isVegetarian(){
        return false;
    }
        
    public String getColor(){
        return color;    
    }

    public String getChipCode(){
        return chip_code;    
    }
    
    public void setChipCode(String a){
        chip_code = a;
    }
}
