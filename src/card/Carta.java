
package card;

/**
 *
 * @author Mattia Tanzini
 */
public class Carta {
    
    private Semi s;
    private Valori v;

    public Carta(Semi s, Valori v) {
        this.s = s;
        this.v = v;
    }
    
    public Carta(int s, int v) {
        try {
            this.s = new Semi(s);
            this.v = new Valori(v);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Semi getS() {
        return s;
    }

    public Valori getV() {
        return v;
    }

    @Override
    public String toString() {
        return v.toString() + " " + s.toString();
    }
    
    
    
    
}
