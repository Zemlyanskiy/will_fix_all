/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.time.LocalDateTime;

/**
 *
 * @author Umlore
 */
public interface ServerInterface {
    
    // Нужны обсерверы.
    
    // String[] OpenChat(root user);   
    // Открыть чат( от имени какого пользователя мы открываем,
    // позволит менеджеру открывать чат от имени клиента и менеджера.
    // Боюсь, что это будет не так весело
         
    // SENDERS ! ! ! 
    
    void/*Все записи со временем*/ SendCalendar();  
    // Отправить текущую версию календаря(актуальную)
    
    
    void/*запись*/ GiveCar(int id_rec);          
    // Отправить информацию о своей машине
    
    void/*список*/ GiveClients(int id_manager);
    // Отправить клиентов менеджера
        
    void/*запись*/ GiveRecord(int id_rec);
    // Отослать конкретную запись менеджеру
    
    void /*список*/ GiveAllClient();
    // Отослать список всех клиентов админу
    
    void/*список*/ GiveAllUsers();
    //    String[] OpenChat(root user);   
    // Открыть чат( от имени какого пользователя мы открываем,
    // позволит менеджеру открывать чат от имени клиента и менеджера.
    // Боюсь, что это будет не так весело
         
    // SENDERS ! ! ! 
    // Послать список зарегистрированных пользователей админу
    
    // OTHER FUNCTION
    // User
    
    boolean Registration(String Login, String pass);
    // Регистрация нового клиента    
    
    int CheckLogPass(String Login, String pass);
    // Авторизация
         
    void ToBookATime(int id_rec, /*LocalDateTime*/ int time); 
// забронировать время
    
    // Manager   
    
    void ChangeStatus(int id_rec, String status);
    // сменить статус заказа на status
    
    void ChangeTime(/*LocalDateTime*/int time, int id_rec);
    // Изменить время заказа на time. Time с помощью интерфейса определяется.
    
    // AdminInterface
        
    void ChangeManager(int id_rec, int id_manager);
    // Сменить менеджера записи rec, на другого.
        
    void SetManager(int id_user);
    // Назначить менеджером
    
    void RemoveManager(int id_user);
    // Снять роль менеджера
    
    int GetRoot(int id_user);
    
}
