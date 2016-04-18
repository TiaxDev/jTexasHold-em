
package card;

import card.exceptions.InvalidCardException;

/**
 *
 * @author Mattia Tanzini
 */
public class Semi {
    
    private int valore;
    
    public final int CUORI = 1;
    public final int QUADRI = 2;
    public final int FIORI = 3;
    public final int PICCHE = 4;
    
    public Semi(int valore) throws Exception {
        if(valore > 4 || valore < 1) throw new InvalidCardException();
        this.valore = valore;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) throws Exception {
        if(valore > 4 || valore < 1) throw new InvalidCardException();
        this.valore = valore;
    }
    
    @Override
    public String toString(){
        if(this.valore == 1)
            return "CUORI";
        if(this.valore == 2)
            return "QUADRI";
        if(this.valore == 3)
            return "FIORI";
        if(this.valore == 4)
            return "PICCHE";
        
        return "";
    }
}
