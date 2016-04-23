
package engine;

/**
 *
 * @author Mattia Tanzini
 */
public class Tavolo {
    
    private double piatto; //Ammontare totale
    private int carteBruciate;
    private double puntataMax;

    /**
     *  Crea nuovo tavolo da poker
     */
    public Tavolo() {
        this.piatto = 0;
        this.carteBruciate = 0;
        this.puntataMax = 0;
    }
}
