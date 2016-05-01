
package engine.multiplayer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author Mattia Tanzini
 */
public class ServerSocketListener implements Runnable {
    
    private static final int MAX_CLIENTS = 5;
    private static final int LISTEN_PORT = 8880;
    private static final int LISTEN_TIMEOUT = 60000;

    private ServerSocket server;
    private ArrayList<ClientHandler> clients;
    
    private void init(){
        try {
            server = new ServerSocket(LISTEN_PORT);  
            clients = new ArrayList<>();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }
    
    private void start(){
        int nClients = 0;
        boolean end = false;
        
        try {
            System.out.println("Waiting for connections...");
            server.setSoTimeout(LISTEN_TIMEOUT);
        } catch (SocketException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
        while(!end || nClients == MAX_CLIENTS){
            try {
                clients.add(new ClientHandler(server.accept()));
                Thread t = new Thread(clients.get(nClients));
                t.start();
                nClients++;
                System.err.println("-Actual Clients connected: ");
                for(ClientHandler c : clients){
                    System.out.println(c.toString());
                }
            } catch (java.io.InterruptedIOException ex){
                System.err.println("Timed out (60)\n" + ex.getMessage());
                end = true;
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                System.exit(-1);
            }
        }
    }
    
    public ClientHandler getWorker(int index){
        return clients.get(index);
    }
    
    public int getClientsConnected(){
        if(clients != null)
            return clients.size();
        else
            return 0;
    }

    @Override
    public void run() {
        init();
        start();
        while(true){
            
        }
    }
    
}
