package server;

public class Server implements ServerInterface{
    private String answer;

    public Server(){};

    @Override
    public String Registration(String Login, String pass) {
        // Must return true or false
        answer = "true";
        return answer;
    }

    @Override
    public String Autorization(String Login, String pass) {
        // Must return true or false
        answer = "true";
        return answer;
    }
    
    @Override
    public String SendCalendar() {
        // Must return calendar status
        // hhddmm (status 0 1) hhddmm (status 0 1) .... all entries
        // 100101 - 10:00 01 january
        answer = "100101 1 110101 1 120101 0";
        return answer;
    }
        
    @Override
    public String SendCarInfo(int id_rec) {
        //  Must return model number status
        answer = "lada r367vo 0";
        return answer;
    }

    @Override
    public String SendRecordInfo(int id_rec) {
        //  Must return model number status
        answer = "toyota r367vo 0";
        return answer;
    }

    @Override
    public String ToBookATime(int id_rec, int time) {
        // Time is hhddmm  (101201 - 10:00 12 january)
        // Must return true or false
        answer = "true";
        return answer;
    }

    // Manager

    @Override
    public String SendClientsInfoToManager(int id_manager) {
        // Must return iserid orderid login, userid orderid login
        answer = "1 1 username1 2 3 username2";
        return answer;
    }

    @Override
    public String ChangeStatus(int id_rec, String status) {
        // Must return true or false
        answer = "true";
        return answer;
    }

    @Override
    public String ChangeTime(int id_rec, int time) {
        // Must return true or false
        answer = "true";
        return answer;
    }

    // Admin Interface

    @Override
    public String ChangeManager(int id_rec, int id_manager) {
        // Must return true or false
        answer = "true";
        return answer;
    }

    @Override
    public String SetManager(int id_user) {
        // Must return true or false
        answer = "true";
        return answer;
    }

    @Override
    public String RemoveManager(int id_user) {
        // Must return true or false
        answer = "true";
        return answer;
    }

    @Override
    public String SendAllUsersInfo() {
        // Must return user id_user user id_user
        answer = "username1 1 username2 2";
        return answer;
    }
}
