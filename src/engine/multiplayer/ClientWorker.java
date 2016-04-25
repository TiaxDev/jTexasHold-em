
package engine.multiplayer;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Mattia Tanzini
 */
public class ClientWorker implements Runnable {
    
    private static final int EXEC_ERR = -1;
    
    private Socket client;
    
    private BufferedReader in = null;
    private PrintWriter out = null;
    
    public ClientWorker(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        try {
            //Creates socket connection 
            out = new PrintWriter(client.getOutputStream(), true);
            out.flush();
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public String read(){
        String fromClient = null;
        try {
            if(!in.ready())
                return fromClient;
            if((fromClient = in.readLine()) != null){
                return fromClient;
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return fromClient;
    }
    
    public void write(Object obj){
        out.println(obj);
        out.flush();
    }
    
    @Override
    public String toString(){
        return client.toString();
    }
    
    @Override
    protected void finalize(){
        try {
            in.close();
            out.close();
            client.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(EXEC_ERR);
        }
    }
    
}
