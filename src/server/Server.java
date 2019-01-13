package server;

import java.sql.Connection;
import java.sql.DriverManager;

public class Server implements ServerInterface{
    private String answer;
    private String Chat;
    
    private String table;

    // Database credentials
    static final String DB_URL = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/evejlbgk";
    static final String USER = "evejlbgk";
    static final String PASS = "s2q8D9vPB9sa5QJTrgW2DaRU98JRHAjR";

    private Connection db;

    public Server(){
        Chat = "0 Hello, Happy New Year!\n1 Hello, Happy New Year too!\n";
        table = "100101 1 110101 1 120101 0";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            db = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    };

    @Override
    public String Registration(String Login, String pass) {
        // Must return true or false
        answer = "true";
        return answer;
    }

    @Override
    public String Autorization(String Login, String pass) {
        // Must return true or false
        // ok. We have user's root in our table. We send this root to client
        // or we will user_id + root 
        // id_user + root
        answer = "4 2";
        return answer;
    }
    
    @Override
    public String SendCalendar() {
        // Must return calendar status
        // hhddmm (status 0 1) hhddmm (status 0 1) .... all entries
        // 100101 - 10:00 01 january
        answer = table;
        return answer;
    }
        
    @Override
    public String SendCarInfo(int id_rec) {
        //  Must return model number status
        answer = "lada r367vo ready";
        return answer;
    }

    @Override
    public String SendRecordInfo(int id_rec) {
        //  Must return model number status
        answer = "toyota r367vo wait for diagnostic";
        return answer;
    }

    @Override
    public boolean ToBookATime(int id_rec, String time) {
        // Time is hhddmm  (101201 - 10:00 12 january)
        // Must return true or false
        time += " 1";        
        
        table += " " + time;
        
        return true;
    }

    @Override
    public String SendChat(int id_rec) {
        answer = Chat;
        
        return answer;
    }
    
    @Override
    public boolean AddMessage(String message, int id_rec, int root) {
        if ((root < 1) || (root > 3)) return false;
        if (root == 1)
            Chat+= "0";
        else Chat+= "1";
        Chat += message + "\n";
        
        return true;
    }
    
    // Manager

    @Override
    public String SendClientsInfoToManager(int id_manager) {
        // Must return orderid login CarModel CarNumber, orderid login CarModel CarNumber
        answer = "1 username1 Lada e228ye 2 username2 Toyota e007uu 3 username3 Lada e228ye 4 username4 Toyota e007uu 5 username5 Lada e228ye 6 username6 Toyota e007uu";
        return answer;
    }

    @Override
    public String ChangeStatus(int id_rec, String status) {
        // Must return true or false
        answer = "true";
        return answer;
    }

    @Override
    public String ChangeTime( int id_rec, String time ) {
        // Must return true or false
        answer = "true";
        System.out.println(time);
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
