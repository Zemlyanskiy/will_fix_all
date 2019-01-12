package server;

import java.io.IOException;

public class ServerRun {

    public static void main(String args[]) {
        ServerProtocol SP;
        try {
            SP = new ServerProtocol(1234, new Server());
            SP.start();
            System.out.println("Сервер запустился!");
        } catch (IOException ex) {
            System.out.println("ServerStart() ERROR");
        }
    }
}
