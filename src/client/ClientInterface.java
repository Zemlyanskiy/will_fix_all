package client;

public interface ClientInterface {
    
    void RemoveIdRec();
    
    int GetStatus();

    boolean Registration(String Login, String pass);

    int Autorization(String Login, String pass);

    String UpdateCalendar();

    String GetMyCar();

    String OpenRecord(int id_rec);

    void ToBookATime(String str);

    String OpenChat();
    
    boolean SendMessage(String message);
    
    // Manager

    String OpenMyClients();

    void ChangeStatus(String status);

    void ChangeTime(String time);

    // Administrator

    void ChangeManager(int id_rec, int id_manager);

    void OpenAllUsers();

    void SetManager(int id_user);

    void RemoveManager(int id_user);

}
