
package card;

import card.exceptions.InvalidCardException;

/**
 *
 * @author Mattia Tanzini
 */
public class Valori {
    
    private int valore;
    
    public final int ASSO = 1;
    public final int DUE = 2;
    public final int TRE = 3;
    public final int QUATTRO = 4;
    public final int CINQUE = 5;
    public final int SEI = 6;
    public final int SETTE = 7;
    public final int OTTO = 8;
    public final int NOVE = 9;
    public final int DIECI = 10;
    public final int JACK = 11;
    public final int DONNA = 12;
    public final int RE = 13;
    
    public Valori(int valore) throws Exception{
        if(valore < 0 || valore > 13) throw new InvalidCardException();
        this.valore = valore;
    }
    
    public int getValore(){
        return this.valore;
    }
    
    public void setValore(int valore) throws Exception {
        if(valore < 0 || valore > 13) throw new InvalidCardException();
        this.valore = valore;
    }
    
    @Override
    public String toString(){
        switch(this.valore){
            case 1:
                return "ASSO";
            case 2:
                return "DUE";
            case 3:
                return "TRE";
            case 4:
                return "QUATTRO";
            case 5:
                return "CINQUE";
            case 6:
                return "SEI";
            case 7:
                return "SETTE";
            case 8:
                return "OTTO";
            case 9:
                return "NOVE";
            case 10:
                return "DIECI";
            case 11:
                return "JACK";
            case 12:
                return "DONNA";
            case 13:
                return "RE";
            default:
                return "";
        }
    }
}
