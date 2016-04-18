
package engine;

/**
 *
 * @author Mattia Tanzini   
 */
public enum State {
    DEALER('D'), SMALL_BLIND('S'), BIG_BLIND('B');
    
    private char value;

    private State(char value) {
        this.value = value;
    }
}
