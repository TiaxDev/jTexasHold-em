
package engine;

import card.Carta;
import card.Mazzo;
import java.util.ArrayList;

/**
 *
 * @author Mattia Tanzini
 */
public class Mano {
    
    public final int NUMCARTE = 2;
    
    private ArrayList<Carta> c;

    public Mano(Mazzo m) {
        c = new ArrayList<>(NUMCARTE);
        init(m);
    }
    
    private void init(Mazzo m){
        for(int i = 0; i < NUMCARTE; i++){
            try {
                c.add(i, m.pescaCarta());
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    public Carta getCarta(int index){
        return c.get(index);
    }
    
    public void setCarta(int index, Carta c){
        this.c.set(index, c);
    }
    
    @Override
    public String toString(){
        String out = "";
        for(Carta Carta1 : c){
            out = out.concat(Carta1.toString() + "\n");
        }
        return out;
    }
    
    public int valore(){
        /*Il valore è ipotizzato come somma dei valori delle due carte (per il TexasHold'em)*/
        return 0;
    }
    
    public int valore(ArrayList<Carta> sulTavolo){
        /*Da implementare*/
        return 0;
    }
    
    
}
