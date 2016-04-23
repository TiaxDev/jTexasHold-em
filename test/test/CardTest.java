
package test;
import card.*;

/**
 *
 * @author Mattia Tanzini
 */
public class CardTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws Exception {
        Mazzo mazzoDiCarte = new Mazzo();
        
        mazzoDiCarte.pescaCarta();
        System.out.println(mazzoDiCarte.toString());
        mazzoDiCarte.mescola();
        System.out.println("");
        System.out.println(mazzoDiCarte.toString());
    }
    
}
