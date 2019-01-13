package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProtocol extends Thread {

    ServerSpeaker ssp;
    ServerInterface sinterface;
    private ServerSocket ss;
    private Socket client;

    public ServerProtocol(int port, ServerInterface _sinterface) throws IOException{
        ss = new ServerSocket(port);
        sinterface = new Server();
    }

    @Override
    public void run(){

        while (true) {
            try {
                client = ss.accept();
                ssp = new ServerSpeaker(new DataInputStream(client.getInputStream()), new DataOutputStream(client.getOutputStream()), sinterface);
                ssp.start();
            } catch (IOException ex) {
                System.out.println("Сan`t connect to client ERROR");
            }
        }

    }

}

