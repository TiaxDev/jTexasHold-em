
package card;

import card.exceptions.NoMoreCardException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mattia Tanzini
 */
public class Mazzo {
    
    public final int MAXCARTE = 52;
    private final int INITCARD = 0;
    
    ArrayList<Carta> c;
    private int nextCard;

    public Mazzo() {
        this.c = new ArrayList<>(MAXCARTE);
        this.nextCard = INITCARD;
        init();
    }
    
    private void init() {
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                c.add(new Carta(i+1, j+1));
            }
        }
    }
    
    public Carta getCarta(int index){
        return c.get(index);
    }
    
    public Carta getNextCarta(){
        return c.get(nextCard);
    }
    
    public void mescola(){
        Random r = new Random();
        for(int i = 0; i < c.size(); i++){
            Carta tempCarta = c.get(i);
            int scambioCarta = r.nextInt(MAXCARTE);
            c.set(i, c.get(scambioCarta));
            c.set(scambioCarta, tempCarta);
        }
    }
    
    public Carta pescaCarta() throws Exception{
        if(nextCard >= MAXCARTE) throw new NoMoreCardException();
        return c.get(nextCard++);
    }
    
    @Override
    public String toString(){
        String out = "";
        for(Carta Carta1 : c){
            out = out.concat(Carta1.toString() + "\n");
        }
        return out;
    }
    
}
