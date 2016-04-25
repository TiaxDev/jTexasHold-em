

package engine.multiplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia Tanzini
 */
public class ClientConnect implements Runnable {
    
    private static final int CONNECT_PORT = 8484;
    
    private String host;
    private int port;
    
    private Socket server;
    
    private BufferedReader in = null;
    private PrintWriter out = null;
    

    public ClientConnect(String host) {
        this.host = host;
        this.port = CONNECT_PORT;
    }
    

    @Override
    public void run() {
        try {
            //Creates socket connection
            server = new Socket(host, port);
            
            out = new PrintWriter(server.getOutputStream(), true);
            out.flush();
            in = new BufferedReader(new InputStreamReader(server.getInputStream()));
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
            server.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public String read(){
        String fromServer = null;
        
        try {
            if(!in.ready())
                return fromServer;
            if((fromServer = in.readLine()) != null){
                return fromServer;
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return fromServer;
    }
    
    public void write(Object obj){
        out.println(obj);
        out.flush();
    }
    
    @Override
    public String toString(){
        return server.toString();
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
