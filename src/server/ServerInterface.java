package server;

public interface ServerInterface {

    String Registration(String Login, String pass);

    String Autorization(String Login, String pass);

    String SendCalendar();

    String SendCarInfo(int id_rec);

    String SendRecordInfo(int id_rec);

    String ToBookATime(int id_rec, int time);
    
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
