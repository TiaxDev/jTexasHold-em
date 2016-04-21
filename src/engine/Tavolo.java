
package engine;

import card.*;
import java.util.ArrayList;

/**
 *
 * @author Mattia Tanzini
 */
public class Tavolo {
    
    private static int SUL_TAVOLO = 0;
    
    public static ArrayList<Carta> flop(Mazzo m){
        return burn(m, 3);
    }
    
    public static ArrayList<Carta> turn(Mazzo m){
        return burn(m, 1);
    }
    
    public static ArrayList<Carta> river(Mazzo m){
        return burn(m, 1);
    }
    
    private static ArrayList<Carta> burn(Mazzo m, int nOfCards){
        ArrayList<Carta> c = new ArrayList<>(nOfCards);
        for(int i = 0; i < nOfCards; i++){
            try{
                m.pescaCarta(); //Carta bruciata
                c.add(m.pescaCarta()); //Carta messa sul tavolo
                
                SUL_TAVOLO++;
            }catch (Exception ex){
                System.err.println(ex.getMessage());
                return null;
            }
        }
        return c;
    }
}
