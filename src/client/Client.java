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
            System.out.println("Error Client.Registration()");
            return false;
        }
    }

    @Override
    public int Autorization(String Login, String pass) {
        try {
            id = CS.Autorization(Login, pass);
            return id;
        } catch (IOException ex) {
            System.out.println("Error Client.Autorization()");
            return 0;
        }
    }

    @Override
    public /*Object*/ void UpdateCalendar() {
        try {
            CS.UpdateCalendar();
            //return CS.UpdateCalendar();
        } catch (IOException ex) {
            System.out.println("Client.UpdateCalendar() ERROR");
        }
    }

    @Override
    public void/*String*/ GetMyCar() {
        try {
            CS.GetMyCar(id);
            //return CS.GetMyCar(id);
        } catch (IOException ex) {
            System.out.println("Client.GetMyCar() ERROR");
        }
    }

    @Override
    public String[] OpenChat(int root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return CS.chat();
    }

    @Override
    public void ToBookATime(int time) {
        try {
            CS.ToBookATime(id, time);
            // CS.ToBookATime(id, int);
        } catch (IOException ex) {
            System.out.println("Client.ToBookTime() ERROR");
        }
    }

    @Override
    public void/*Object*/ OpenMyClients() {
        try {
            CS.OpenMyClients(id);
            //return CS.OpenMyClients(id);
        } catch (IOException ex) {
            System.out.println("Client.OpenMyClient() ERROR");
        }
    }

    @Override
    public void/*String*/ OpenRecord(int id_rec) {
        try {
            CS.OpenRecord(id_rec);
        } catch (IOException ex) {
            System.out.println("Client.OpenRecord() ERROR");
        }
    }

    @Override
    public void ChangeStatus(int id_rec, String status) {
        try {
            CS.ChangeStatus(id_rec, status);
        } catch (IOException ex) {
            System.out.println("Client.ChangeStatus() ERROR");
        }
    }

    @Override
    public void ChangeTime(int time, int id_rec) {
        try {
            CS.ChangeTime(id_rec, time);
        } catch (IOException ex) {
            System.out.println("Client.ChangeTime() ERROR");
        }
    }

    @Override
    public void ChangeManager(int id_rec, int id_manager) {
        try {
            CS.ChangeManager(id_rec, id_manager);
        } catch (IOException ex) {
            System.out.println("Client.ChangeManager() ERROR");
        }
    }

    @Override
    public void/*Object*/ OpenAllUsers() {
        try {
            CS.OpenAllUsers();
        } catch (IOException ex) {
            System.out.println("Client.OpenAllUsers() ERROR");
        }
    }

    @Override
    public void SetManager(int id_user) {
        try {
            CS.SetManager(id_user);
        } catch (IOException ex) {
            System.out.println("Client.SetManager() ERROR");
        }
    }

    @Override
    public void RemoveManager(int id_user) {
        try {
            CS.SetManager(id_user);
        } catch (IOException ex) {
            System.out.println("Client.RemoveManager() ERROR");
        }
    }
    
    @Override
    public void/*Object*/ GetAllClient() {
        try {
            CS.OpenMyClients(id);    // Это права админа, возможно нужно другую функцию прописать
        } catch (IOException ex) {
            System.out.println("Client.GetAllClient() ERROR");
        }
    }

    @Override
    public int GetMyRoot() {
        try {
            return CS.GetRoot(id);
        } catch (IOException ex) {
            System.out.println("Ошибка в Client.GetMyRoot()");            
            return 0;
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
