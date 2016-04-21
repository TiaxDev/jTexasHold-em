
package engine;

import card.Mazzo;
import java.util.ArrayList;

/**
 *
 * @author Mattia Tanzini
 */
public class PokerMano {
    
    private Mazzo m;
    private ArrayList<Player> p;
    
    private boolean isRunning;
    
    public void start(int nPlayers){
        init(nPlayers);
        
        while(isRunning){
            
            //Stampa debug
            for(int i = 0; i < p.size(); i++){
                System.out.println("GIOCATORE " + i + ",");
                System.out.println(p.get(i).getMano().toString());
                
            }
            
            //Primo giro di scommesse
            
            //FLOP (prime 3 carte)
            
            //Secondo giro di scommesse
            
            //TURN (altra carta)
            
            //Terzo giro di scommesse
            
            //RIVER (ultima carta)
            
            //Quarto giro di scommesse
            
            //Calcolo vincitore mano
            
            isRunning = false;
        }
    }
    
    private void init(int nPlayers){
        m = new Mazzo();
        m.mescola();
        isRunning = true;
        
        p = new ArrayList<>(nPlayers);
        for(int i = 0; i < nPlayers; i++){
            p.add(new Player(m));
        }
        
        try {
            //Set dei due blind (primo e secondo giocatore
            p.get(0).setStato(pState.BIG_BLIND);
            p.get(1).setStato(pState.SMALL_BLIND);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    private void betLoop(){
        /*Giro di scommesse:
          Per tutti i giocatori si fa un loop per le scommesse, finchè il piatto
          non sarà full (tutti hanno scommesso la stessa somma di denaro)*/
        boolean isReady = false;
        
        while(!isReady){
            for(Player p1 : p){
                //Aspetto comando (tra fold, call, raise, check)
            }
        }
    }
}
