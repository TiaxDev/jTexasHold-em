
package engine;

import card.Mazzo;
import engine.exceptions.InvalidStateException;

/**
 *
 * @author Mattia Tanzini
 */
public class Player {
    
    public final double INIT_MONEY = 1000;
   
    private Mano mano;
    private double soldi;
    private double piatto = 0; //Soldi scommessi
    private int stato;

    public Player(double soldi, Mazzo m) {
        this.mano = new Mano(m);
        this.soldi = soldi;
        this.stato = pState.NORMAL;
    }
    
    public Player(Mazzo m){
        this.mano = new Mano(m);
        this.soldi = INIT_MONEY;
        this.stato = pState.NORMAL;
    }

    public Mano getMano() {
        return mano;
    }

    public double getSoldi() {
        return soldi;
    }
    
    public int getStato(){
        return stato;
    }
    
    public void setStato(int stato) throws Exception {
        if(stato < 0 || stato > 2) throw new InvalidStateException();
        this.stato = stato;
    }
    
    public double getPiatto(){
        return piatto;
    }
    
    public void cleanPiatto(){
        this.piatto = 0;
    }
}
