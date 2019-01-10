package communication;

import com.sun.corba.se.spi.activation.Server;
import server.*;

public class FakeServer implements ServerInterface {
    private String answer;

    public FakeServer(){};

    @Override
    public String Registration(String Login, String pass) {
        answer = "true";
        return answer;
    }

    @Override
    public String Autorization(String Login, String pass) {
        answer = "1";
        return answer;
    }

    @Override
    public String SendCalendar() {
        answer = "22 21 21 22";
        return answer;
    }

    @Override
    public String SendCarInfo(int id_rec) {
        answer = "true";
        return answer;
    }

    @Override
    public String SendRecordInfo(int id_manager) {
        answer = "true";
        return answer;
    }

    @Override
    public String ToBookATime(int id_rec, int time) {
        answer = "true";
        return answer;
    }

    // Manager

    @Override
    public String SendClientInfoToManager(int id_rec) {
        answer = "true";
        return answer;
    }

    @Override
    public String ChangeStatus(int id_rec, String status) {
        answer = "true";
        return answer;
    }

    @Override
    public String ChangeTime(int id_rec, int time) {
        answer = "true";
        return answer;
    }

    // Admin Interface

    @Override
    public String ChangeManager(int id_rec, int id_manager) {
        answer = "true";
        return answer;
    }

    @Override
    public String SetManager(int id_user) {
        answer = "true";
        return answer;
    }

    @Override
    public String RemoveManager(int id_user) {
        answer = "true";
        return answer;
    }

    @Override
    public String SendAllUsersInfo() {
        answer = "true";
        return answer;
    }
}
