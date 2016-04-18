
package test;
import card.*;
import engine.*;
import java.io.*;

/**
 *
 * @author Mattia Tanzini
 */
public class CardTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Creo mazzo...");
        Mazzo cardMazzo = new Mazzo();
        System.out.println("End");
        System.out.println("Mescolo...");
        cardMazzo.mescola();
        System.out.println(cardMazzo.toString());
        Mano giocatore1 = new Mano(cardMazzo);
        System.out.println("Mano giocatore 1: \n" + giocatore1.toString());
        System.out.println("Sul tavolo: \n");
        r.read();
        System.out.println("Flop: \n" + Tavolo.flop(cardMazzo));
        r.read();
        System.out.println("Turn: \n" + Tavolo.turn(cardMazzo));
        r.read();
        System.out.println("River: \n" + Tavolo.river(cardMazzo));
        
        
       
        
    }
    
}
