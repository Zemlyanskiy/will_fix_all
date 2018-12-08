/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Umlore
 */
public class ClientSpeaker {
    // необходим наблюдатель для каждого, возможно доп поток.
    // Функция refresh()
    private Socket server;
    private DataInputStream _dis;
    private DataOutputStream _dos;
    
    private String command;
    
    public ClientSpeaker() throws IOException {
        server = new Socket("localhost",1234); 
        // В последствии ip:port
        _dis = new DataInputStream(server.getInputStream());
        _dos = new DataOutputStream(server.getOutputStream());
    }
    
    public boolean Registration(String Login, String pass) throws IOException {
        
        command = "Registration";
        _dos.writeUTF(command);
        _dos.flush();
        
        _dos.writeUTF(Login);
        _dos.flush();
        
        _dos.writeUTF(pass);
        _dos.flush();
        
        return _dis.readBoolean();
    }   
    // Регистрация, по умолчанию все клиенты.
    
    public int Autorization(String Login, String pass) throws IOException {
        
        command = "CheckingLogPass";
        _dos.writeUTF(command);
        _dos.flush();
        
        _dos.writeUTF(Login);
        _dos.flush();
        
        _dos.writeUTF(pass);
        _dos.flush();
        
        return _dis.readInt();
    }
    
    public void /*ObjectВсе записи со временем*/ UpdateCalendar() throws IOException {
        command = "GiveCalendar";
        _dos.writeUTF(command);
        _dos.flush(); 
    }  
    // Получить текущую версию календаря(актуальную)
    
    void /*Object/*запись*/ GetMyCar(int id_rec) throws IOException {
        command = "GiveCar";
        _dos.writeUTF(command);
        _dos.flush(); 
        
        _dos.writeInt(id_rec);
        _dos.flush();
    }          
    // Получить информацию о своей машине
    // id_rec - локальная переменная для каждого клиента.
    
//    public String[] OpenChat(root user);    Пока что не сделал
// Открыть чат( от имени какого пользователя мы открываем,
// позволит менеджеру открывать чат от имени клиента и менеджера.
    
    public void ToBookATime(int id_rec, int time) throws IOException {         
        command = "ToBookATime";
        _dos.writeUTF(command);
        _dos.flush();   
    
        _dos.writeInt(id_rec);
        _dos.flush();
        
        _dos.writeInt(time);
        _dos.flush();
    }
    // забронировать время
    
    // ManagerInterface
    // У нас не будет этих кнопок у пользователя, мы их просто спрячем))
    
    public void/*Object/*список*/ OpenMyClients(int id_manager) throws IOException{
        command = "GiveClients";
        _dos.writeUTF(command);
        _dos.flush(); 
        
        _dos.writeInt(id_manager);
        _dos.flush(); 
        
    }
    
    public void/*Object/*запись*/ OpenRecord(int id_rec) throws IOException {
        command = "GiveRecord";
        _dos.writeUTF(command);
        _dos.flush(); 
        
        _dos.writeInt(id_rec);
        _dos.flush(); 
    }
    
    public void ChangeStatus(int id_rec, String status) throws IOException {
       command = "ChangeStatus";
        _dos.writeUTF(command);
        _dos.flush(); 
        
        _dos.writeInt(id_rec);
        _dos.flush(); 
        
        _dos.writeUTF(status);
        _dos.flush();
    }
    // сменить статус заказа на status
    
    public void ChangeTime(int id_rec, int time ) throws IOException {
        command = "ChangeTime";
        _dos.writeUTF(command);
        _dos.flush(); 
        
        _dos.writeInt(id_rec);
        _dos.flush(); 
        
        _dos.writeInt(time);
        _dos.flush();
    }
    // Изменить время заказа на time. Time с помощью интерфейса определяется.
    
    // AdminInterface
    // Аналогично так же поступим, как и клиент-менеджер.
    // Просто. Прячем. Кнопки...\
        
    public void ChangeManager(int id_rec, int id_manager) throws IOException {
        command = "ChangeManager";
        _dos.writeUTF(command);
        _dos.flush(); 
        
        _dos.writeInt(id_rec);
        _dos.flush(); 
        
        _dos.writeInt(id_manager);
        _dos.flush();    
    }
    // Сменить менеджера записи rec, на другого.
    
    public void/*Object/*список*/ OpenAllUsers() throws IOException {
        command = "GiveAllClient";
        _dos.writeUTF(command);
        _dos.flush(); 
    }
    // Выдать список зарегистрированных пользователей
    
    public void SetManager(int id_user) throws IOException{
       command = "SetManager";
        _dos.writeUTF(command);
        _dos.flush(); 
        
        _dos.writeInt(id_user);
        _dos.flush();
    }
    // Назначить менеджером
    
    public void RemoveManager(int id_user) throws IOException{
        command = "RemoveManager";
        _dos.writeUTF(command);
        _dos.flush(); 
        
        _dos.writeInt(id_user);
        _dos.flush();
        
        
    }
    // Снять роль менеджера
    
}
