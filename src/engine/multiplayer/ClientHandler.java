
package engine.multiplayer;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia Tanzini
 */
public class ClientHandler implements Runnable {
    
    private Socket client;
    
    private BufferedReader in = null;
    private PrintWriter out = null;
    
    public ClientHandler(Socket client) {
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
    
    public void closeConnection(){
        try {
            in.close();
            out.print(Network.END_OF_COMMUNICATION);
            out.flush();
            out.close();
            client.close();
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
        closeConnection();
        try {
            super.finalize();
        } catch (Throwable ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
