/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.time.LocalDateTime;

/**
 *
 * @author Umlore
 */

enum root {client, manager, admin};

public interface ClientInterface {
    
    /*
    Сразу скажу Object - это пока не определённый тип данных
    В зависимости от того, как мы будем получать эти данные.
    */
    
    boolean Registration(String Login, String pass);     
    // Регистрация, по умолчанию все клиенты.
    
    int Autorization(String Login, String pass);     
    // Авторизация // возможна замена на root.
    
    int GetMyRoot();
    
    void/*ObjectВсе записи со временем*/ UpdateCalendar();    
    // Получить текущую версию календаря(актуальную)
    
    void/*String*/ GetMyCar();          
    // Получить информацию о своей машине
    // id_rec - локальная переменная для каждого клиента.
    
    String[] OpenChat(int root);   
// Открыть чат( от имени какого пользователя мы открываем,
// позволит менеджеру открывать чат от имени клиента и менеджера.
    
    void ToBookATime(int time);         // забронировать время
    
    // ManagerInterface
    // У нас не будет этих кнопок у пользователя, мы их просто спрячем))
    
    void/*Object/*список*/ OpenMyClients();
    
    void/*String/*запись*/ OpenRecord(int id_rec);
    
    void ChangeStatus(int id_rec, String status);
    // сменить статус заказа на status
    
    void ChangeTime(int time, int id_rec);
    // Изменить время заказа на time. Time с помощью интерфейса определяется.
    
    // AdminInterface
    // Аналогично так же поступим, как и клиент-менеджер.
    // Просто. Прячем. Кнопки...\
    void/*Object/*список*/ GetAllClient();
    // Выдать список всех клиентов
    
    void ChangeManager(int id_rec, int id_manager);
    // Сменить менеджера записи rec, на другого.
    
    void/*Object/*список*/ OpenAllUsers();
    // Выдать список зарегистрированных пользователей
    
    void SetManager(int id_user);
    // Назначить менеджером
    
    void RemoveManager(int id_user);
    // Снять роль менеджера
    
    // That's ALL.
    
}
