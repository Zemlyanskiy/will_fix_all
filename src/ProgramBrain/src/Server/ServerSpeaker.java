/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umlore
 */
public class ServerSpeaker extends Thread {
    
    private DataInputStream _dis;
    private DataOutputStream _dos;
    
    private ServerInterface ServInt;
    
    private String command;
    
    ServerSpeaker(DataInputStream dis, DataOutputStream dos){
        _dis = dis;
        _dos = dos;
        ServInt = new Server();
    }
            
    @Override
    public void run(){
       while (true) {
            try {
                command = _dis.readUTF();
                          
            switch (command) {
                case "GiveCalendar": { 
                    /*_dos.write()*/ServInt.GiveCalendar(); // скорее всего give calendar
                    // _dos.flush
                    break;
                }
                case "GiveCar": {
                    int id_rec = _dis.readInt();
                    /*_dos.write()*/ServInt.GiveCar(id_rec);
                    // _dos.flush
                     break;
                } 
                case "GiveClients" : {
                    int id_manager = _dis.readInt();
                    /*_dos.write()*/ServInt.GiveClients(id_manager);
                     break;
                }
                
                case "GiveRecord": {
                    int id_rec = _dis.readInt();
                    /*_dos.write()*/ServInt.GiveRecord(id_rec);
                    // _dos.flush
                     break;
                }
                case "GiveAllClient" : {
                      /*_dos.write()*/ServInt.GiveAllClient();
                      // _dos.flush
                       break;
                }
                
                case "Registration" : {
                    String Login = _dis.readUTF();
                    String pass = _dis.readUTF();
                    
                    _dos.writeBoolean(ServInt.Registration(Login, pass));
                    _dos.flush();
                     break;
                }
                
                case "CheckingLogPass" : {
                    String Login = _dis.readUTF();
                    String pass = _dis.readUTF();
                    
                    _dos.writeInt(ServInt.CheckLogPass(Login, pass));
                    _dos.flush(); 
                    break;
                    
                }
                
                case "ToBookATime" : {
                    int id_rec = _dis.readInt();
                    int time = _dis.readInt();
                    ServInt.ToBookATime(id_rec, time);
                }
                case "ChangeStatus" : {
                    int id_rec = _dis.readInt();
                    String stat = _dis.readUTF();
                    ServInt.ChangeStatus(id_rec, stat);
                     break;
                }
                
                case "ChangeTime" : {
                    int id_rec = _dis.readInt();
                    int time = _dis.readInt();
                    ServInt.ChangeTime(time, id_rec);
                    break;
                }
                
                case "ChangeManager" : {
                    int id_rec = _dis.readInt();
                    int id_manager = _dis.readInt();
                    ServInt.ChangeManager(id_rec, id_manager);
                    break;
                }
                
                case "SetManager" : {
                   int id_user = _dis.readInt();
                   ServInt.SetManager(id_user);
                   break;
                }
                
                case "RemoveManager" : {
                    int id_user = _dis.readInt();
                    ServInt.RemoveManager(id_user);
                }
            }
        } catch (IOException ex) {
                Logger.getLogger(ServerSpeaker.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
/* 
    
   
    // OTHER FUNCTION
    // User
    
   
    
    // AdminInterface
        
    void ChangeManager(int id_rec, int id_manager);
        
    void SetManager(int id_user);
    
    void RemoveManager(int id_user);
*/

