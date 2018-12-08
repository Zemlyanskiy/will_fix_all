/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Server;

import java.time.LocalDateTime;

/**
 *
 * @author Umlore
 */
public class Server implements ServerInterface{

    public Server(){};
    
    @Override
    public void GiveCalendar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 1");
    }

    @Override
    public void GiveCar(int id_rec) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 2");
    }

    @Override
    public void GiveClients(int id_manager) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 3");
    }

    @Override
    public void GiveRecord(int id_rec) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 4");
    }

    @Override
    public void GiveAllClient() {
     //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 5");
    }

    @Override
    public void GiveAllUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 6");
    }

    @Override
    public boolean Registration(String Login, String pass) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 7");
        return true;
    }

    @Override
    public int CheckLogPass(String Login, String pass) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 8");
        // return -1; (Если проверка не прошла)
        return 1; // return userID
    }

    @Override
    public void ToBookATime(int id_rec, /*LocalDateTime*/int time) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 9");
    }

    @Override
    public void ChangeStatus(int id_rec, String status) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 10");    
    }

    @Override
    public void ChangeTime(/*LocalDateTime*/int time, int id_rec) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 11"); 
    }

    @Override
    public void ChangeManager(int id_rec, int id_manager) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 12");    
    }

    @Override
    public void SetManager(int id_user) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 13");   
    }

    @Override
    public void RemoveManager(int id_user) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I do it 14");   
    }
    
}
