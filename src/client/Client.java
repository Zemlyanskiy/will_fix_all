/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umlore
 */

public class Client implements ClientInterface{
    
    private root Status;
    private int id;
    private ClientSpeaker CS;
    
    public Client() throws IOException {
        CS = new ClientSpeaker();
        id = 0;
    }
    
    public root GiveStatus(){
        return Status;
    }
    
    @Override
    public boolean Registration(String Login, String pass) {
        try {
            return CS.Registration(Login, pass);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Autorization(String Login, String pass) {
        try {
            id = CS.Autorization(Login, pass);
            if (id <= 0 ) {
                return false;
            } 
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Object UpdateCalendar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return CS.UpdateCalendar();
    }

    @Override
    public Object GetMyCar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         //return CS.GetMyCar(id);
    }

    @Override
    public String[] OpenChat(root user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return CS.chat();
    }

    @Override
    public void ToBookATime(int time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // CS.ToBookATime(id, int);
    }

    @Override
    public Object OpenMyClients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return CS.OpenMyClients(id);
    }

    @Override
    public Object OpenRecord(int id_rec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return CS.OpenRecord(id_rec);
    }

    @Override
    public void ChangeStatus(int id_rec, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // CS.ChangeStatus(id_rec, status);
    }

    @Override
    public void ChangeTime(int time, int id_rec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // CS.ChangeTime(id_rec, id);
    }

    @Override
    public void ChangeManager(int id_rec, int id_manager) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // CS.ChangeManager(id_rec, id_manager);
    }

    @Override
    public Object OpenAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // return CS.OpenAllUsers();
    }

    @Override
    public void SetManager(int id_user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // CS.SetManager(id_user);
    }

    @Override
    public void RemoveManager(int id_user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //CS.RemoveManager(id_user);
    }
    
    @Override
    public Object GetAllClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
