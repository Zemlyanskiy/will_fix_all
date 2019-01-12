package client;

public interface ClientInterface {
    
    int GetStatus();

    boolean Registration(String Login, String pass);

    int Autorization(String Login, String pass);

    String UpdateCalendar();

    String GetMyCar();

    void OpenRecord(int id_rec);

    void ToBookATime(String str);

    String OpenChat();
    
    boolean SendMessage(String message);
    
    // Manager

    void OpenMyClients();

    void ChangeStatus(int id_rec, String status);

    void ChangeTime(int time, int id_rec);

    // Administrator

    void ChangeManager(int id_rec, int id_manager);

    void OpenAllUsers();

    void SetManager(int id_user);

    void RemoveManager(int id_user);

}
