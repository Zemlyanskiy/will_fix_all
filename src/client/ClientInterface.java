package client;

enum root {client, manager, admin};

public interface ClientInterface {

    root GetStatus();

    boolean Registration(String Login, String pass);

    int Autorization(String Login, String pass);

    void UpdateCalendar();

    void GetMyCar();

    void OpenRecord(int id_rec);

    void ToBookATime(int time);

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
