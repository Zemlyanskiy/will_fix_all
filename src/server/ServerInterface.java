package server;

public interface ServerInterface {

    String Registration(String Login, String pass);
    // return true or false
    String Autorization(String Login, String pass);
    // return user_root
    String SendCalendar();

    String SendCarInfo(int id_rec);

    String SendRecordInfo(int id_rec);

    boolean ToBookATime(int id_rec, String time);
    
    String SendChat(int id_rec);
    
    boolean AddMessage(String message, int id_rec, int root);
    
    // Manager

    String SendClientsInfoToManager(int id_manager);

    String ChangeStatus(int id_rec, String status);

    String ChangeTime(int time, int id_rec);
    
    // AdminInterface

    String ChangeManager(int id_rec, int id_manager);

    String SetManager(int id_user);

    String RemoveManager(int id_user);

    String SendAllUsersInfo();
}
