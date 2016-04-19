
package engine;

import card.*;
import java.util.ArrayList;

/**
 *
 * @author Mattia Tanzini
 */
public abstract class AbstractGame {
    
    private boolean isFinished;
    private Mazzo cardMazzo;
    
    public void start(){
        init();
        while(true){
            cardMazzo.mescola();
            
        }
    }
    
    private void init(){
        this.isFinished = false;
        this.cardMazzo = new Mazzo();
    }
    
    
}
