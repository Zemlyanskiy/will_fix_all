package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class ServerSpeaker extends Thread {

    private DataInputStream _dis;
    private DataOutputStream _dos;

    private ServerInterface ServInt;

    private String command;
    private String data;
    private String answer;

    ServerSpeaker(DataInputStream dis, DataOutputStream dos, ServerInterface server){
        _dis = dis;
        _dos = dos;
        ServInt = server;
    }

    @Override
    public void run(){
       while (true) {
            try {
                data = _dis.readUTF();
                StringTokenizer stok = new StringTokenizer(data, " ");
                command = stok.nextToken();

                switch (command) {
                    case "Registration": {
                        String Login = stok.nextToken();
                        String pass = stok.nextToken();

                        answer = ServInt.Registration(Login, pass);

                        _dos.writeUTF(answer);
                        _dos.flush();

                        break;
                    }

                    case "Autorization": {
                        String Login = stok.nextToken();
                        String pass = stok.nextToken();

                        answer = ServInt.Autorization(Login, pass);

                        _dos.writeUTF(answer);
                        _dos.flush();

                        break;
                    }
                    case "GetCalendar": {
                        answer = ServInt.SendCalendar();// скорее всего give calendar

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }
                    case "GetCarInfo": {
                        int id_rec = Integer.parseInt(stok.nextToken());
                        answer = ServInt.SendCarInfo(id_rec);

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }
                    case "GetRecordInfo": {
                        int id_rec = Integer.parseInt(stok.nextToken());
                        answer = ServInt.SendRecordInfo(id_rec);

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }
                    case "ToBookATime": {
                        int id_rec = Integer.parseInt(stok.nextToken());
                        String time = stok.nextToken();
                        System.out.println(time);
                        
                        _dos.writeBoolean(ServInt.ToBookATime(id_rec, time));
                        _dos.flush();
                        
                        break;
                    }

                    case "GetChat" : {
                        int id_rec = Integer.parseInt(stok.nextToken());
                        answer = ServInt.SendChat(id_rec);

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }
                    
                    case "AddMessage": {
                        int id_rec = Integer.parseInt(stok.nextToken());
                        int root = Integer.parseInt(stok.nextToken());
                        command = stok.nextToken("\n");
                        
                        _dos.writeBoolean(ServInt.AddMessage(command, id_rec, root));            
                        break;
                    }
                    
                    // Manager

                    case "GetMyClientsInfo": {
                        int id_manager = Integer.parseInt(stok.nextToken());
                        answer = ServInt.SendClientsInfoToManager(id_manager);

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }
                    case "ChangeStatus": {
                        int id_rec = Integer.parseInt(stok.nextToken());
                        String stat = stok.nextToken();
                        answer = ServInt.ChangeStatus(id_rec, stat);

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }

                    case "ChangeTime": {
                        
                        System.out.println(stok.countTokens());
                        
                        int id_rec = Integer.parseInt(stok.nextToken());
                        data = stok.nextToken();
                        
                        System.out.println(data + " " + id_rec);
                        
                        answer = ServInt.ChangeTime(id_rec, data);

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }

                    // Administrator

                    case "ChangeManager": {
                        int id_rec = Integer.parseInt(stok.nextToken());
                        int id_manager = Integer.parseInt(stok.nextToken());
                        answer = ServInt.ChangeManager(id_rec, id_manager);

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }

                    case "SetManager": {
                        int id_user = Integer.parseInt(stok.nextToken());
                        answer = ServInt.SetManager(id_user);

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }

                    case "RemoveManager": {
                        int id_user = Integer.parseInt(stok.nextToken());
                        answer = ServInt.RemoveManager(id_user);

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }

                    case "GetAllUsersInfo": {
                        answer = ServInt.SendAllUsersInfo();

                        _dos.writeUTF(answer);
                        _dos.flush();
                        break;
                    }
        }
            } catch (IOException ex) {
                System.out.println("Connection error!");
                break;
            }
        }
    }
}

/* AdminInterface:
 *
 *    void ChangeManager(int id_rec, int id_manager);
 *    void SetManager(int id_user);
 *    void RemoveManager(int id_user);
 */