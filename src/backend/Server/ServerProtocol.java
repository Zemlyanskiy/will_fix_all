/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umlore
 */
public class ServerProtocol extends Thread {
    
    ServerSpeaker ssp;
    private ServerSocket ss; 
    private Socket client;
    ServerProtocol() throws IOException{
        ss = new ServerSocket(1234);
    }
    
    @Override
    public void run(){
        // 
        while (true) {
            try {                
                client = ss.accept();
                ssp = new ServerSpeaker(new DataInputStream(client.getInputStream()), new DataOutputStream(client.getOutputStream()));
                ssp.run();
            } catch (IOException ex) {
                Logger.getLogger(ServerProtocol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}


