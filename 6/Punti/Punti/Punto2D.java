// Classe di un punto nel piano cartesiano
package Punti;
import java.util.*;

class Punto2D {

    // Campi
    private double x,y;
    
    // Costruttori
    public Punto2D(double a, double b){
        x=a;
        y=b;
    }
    
    public Punto2D(){
        x=0;
        y=0;
    }
    
    // Metodi
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
    
    public void setX(double a){
        x=a;
    }

    public void setY(double a){
        y=a;
    }
    
    public void clear(){
        setX(0);
        setY(0);
    }
    
    // Utile per distance()
    private static double differenzaAllaSeconda(double a, double b){
        return Math.pow((a-b), 2);
    }
    
    public static double distance(Punto2D a, Punto2D b){
        return Math.sqrt( differenzaAllaSeconda(a.x, b.x) + differenzaAllaSeconda(a.y, b.y) );
    }
    
    public double distance(Punto2D a){
        return Math.sqrt( differenzaAllaSeconda(this.x, a.x) + differenzaAllaSeconda(this.y, a.y) );
    }
    
    public Punto2D sumCoordinates(Punto2D a){
        return new Punto2D((this.x+a.x),(this.y+a.y));
    }
    
    public Punto2D diffCoordinates(Punto2D a){
        return new Punto2D((this.x-a.x),(this.y-a.y));
    }
    
    public boolean isCloserThan(Punto2D a, double x){
        return (this.distance(a) < x) ? true : false;
    }
    
    public String toString(){
        return "(" + x + "," + y + ")";
    }
    // End of class
        
}
