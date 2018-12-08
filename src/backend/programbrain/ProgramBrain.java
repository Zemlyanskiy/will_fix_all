/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.programbrain;
import backend.Client.*;
import backend.Server.*;

import java.io.IOException;

/**
 *
 * @author Umlore
 */
public class ProgramBrain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("I am Alive");

        Server server = new Server();
        server.GiveAllClient();
        server.GiveAllUsers();

    }
    
}
