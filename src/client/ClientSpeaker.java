package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSpeaker {
    private Socket server;
    private DataInputStream _dis;
    private DataOutputStream _dos;

    private String command;

    public ClientSpeaker(String _host, int _port) throws IOException {
        server = new Socket(_host, _port);

        _dis = new DataInputStream(server.getInputStream());
        _dos = new DataOutputStream(server.getOutputStream());
    }

    public boolean Registration(String Login, String pass) throws IOException {

        command = "Registration " + Login + ' ' + pass;
        _dos.writeUTF(command);
        _dos.flush();

        // "Success/Error type"
        return Boolean.parseBoolean(_dis.readUTF());
    }

    public int Autorization(String Login, String pass) throws IOException {

        command = "Autorization " + Login + ' ' + pass;
        _dos.writeUTF(command);
        _dos.flush();

        // Permissions (0 - nobody, 1 - client, 2 -manager, 3 -admin), Login
        return Integer.parseInt(_dis.readUTF());
    }

    public String GetCalendar() throws IOException {

        command = "GetCalendar";
        _dos.writeUTF(command);
        _dos.flush();

        // hh dd mm (status 0 1) hh dd mm (status 0 1) .... all entries
        return _dis.readUTF();
    }

    public String GetCarInfo(int id_rec) throws IOException {

        command = "GetCarInfo " + id_rec;
        _dos.writeUTF(command);
        _dos.flush();

        // model number status
        return _dis.readUTF();
    }

    public String GetRecordInfo(int id_rec) throws IOException {

        command = "GetRecordInfo "+id_rec;
        _dos.writeUTF(command);
        _dos.flush();

        // model number status
        return _dis.readUTF();
    }

    public boolean ToBookATime(int id_rec, int time) throws IOException {

        command = "ToBookATime " + id_rec + ' ' + time;
        _dos.writeUTF(command);
        _dos.flush();

        // true/false (BookTime)
        return Boolean.parseBoolean(_dis.readUTF());
    }

    // Manager

    public String GetMyClientsInfo(int id_manager) throws IOException{

        command = "GetMyClientsInfo " + id_manager;/*login*/
        _dos.writeUTF(command);
        _dos.flush();

        // iserid orderid login, userid orderid login ...
        return _dis.readUTF();

    }

    public boolean ChangeStatus(int id_rec, String status) throws IOException {

        command = "ChangeStatus " + id_rec + ' ' + status;
        _dos.writeUTF(command);
        _dos.flush();

        // true false
        return Boolean.parseBoolean(_dis.readUTF());
    }

    public boolean ChangeTime(int id_rec, int time ) throws IOException {

        command = "ChangeTime " + id_rec + ' ' + time;
        _dos.writeUTF(command);
        _dos.flush();

        // true false
        return Boolean.parseBoolean(_dis.readUTF());
    }

    // Administrator

    public boolean ChangeManager(int id_rec, int id_manager) throws IOException {

        command = "ChangeManager " + id_rec + ' ' + id_manager;
        _dos.writeUTF(command);
        _dos.flush();

        // true false
        return Boolean.parseBoolean(_dis.readUTF());
    }

    public boolean SetManager(int id_user) throws IOException{

        command = "SetManager " + id_user;
        _dos.writeUTF(command);
        _dos.flush();

        // true false
        return Boolean.parseBoolean(_dis.readUTF());
    }

    public boolean RemoveManager(int id_user) throws IOException{
        command = "RemoveManager " + id_user;
        _dos.writeUTF(command);
        _dos.flush();

        // true false
        return Boolean.parseBoolean(_dis.readUTF());
    }

    public String GetAllUsersInfo() throws IOException {
        command = "GetAllUsersInfo";
        _dos.writeUTF(command);
        _dos.flush();

        // login id_user login id_user ...
        return _dis.readUTF();
    }

}
