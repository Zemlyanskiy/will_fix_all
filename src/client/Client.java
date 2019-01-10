package client;

import java.io.IOException;

public class Client implements ClientInterface{

    private root Status;
    private int id;
    private ClientSpeaker CS;

    public Client(String _host, int _port) throws IOException {
        CS = new ClientSpeaker(_host, _port);
        id = 0;
    }

    @Override
    public root GetStatus(){
        return Status;
    }

    @Override
    public boolean Registration(String Login, String pass) {
        try {
            return CS.Registration(Login, pass);
        } catch (IOException ex) {
            System.out.println("Error Client.Registration()");
            return false;
        }
    }

    @Override
    public int Autorization(String Login, String pass) {
        try {
            id = CS.Autorization(Login, pass);
            return id;
        } catch (IOException ex) {
            System.out.println("Error Client.Autorization()");
            return 0;
        }
    }

    @Override
    public void UpdateCalendar() {
        try {
            CS.GetCalendar();
            //return CS.UpdateCalendar();
        } catch (IOException ex) {
            System.out.println("Client.UpdateCalendar() ERROR");
        }
    }

    @Override
    public void GetMyCar() {
        try {
            CS.GetCarInfo(id);
            //return CS.GetMyCar(id);
        } catch (IOException ex) {
            System.out.println("Client.GetMyCar() ERROR");
        }
    }

    @Override
    public void OpenRecord(int id_rec) {
        try {
            CS.GetRecordInfo(id_rec);
        } catch (IOException ex) {
            System.out.println("Client.OpenRecord() ERROR");
        }
    }

    @Override
    public void ToBookATime(int time) {
        try {
            CS.ToBookATime(id, time);
            // CS.ToBookATime(id, int);
        } catch (IOException ex) {
            System.out.println("Client.ToBookTime() ERROR");
        }
    }

    // Manager

    @Override
    public void OpenMyClients() {
        try {
            CS.GetMyClientsInfo(id);
        } catch (IOException ex) {
            System.out.println("Client.OpenMyClient() ERROR");
        }
    }

    @Override
    public void ChangeStatus(int id_rec, String status) {
        try {
            CS.ChangeStatus(id_rec, status);
        } catch (IOException ex) {
            System.out.println("Client.ChangeStatus() ERROR");
        }
    }

    @Override
    public void ChangeTime(int time, int id_rec) {
        try {
            CS.ChangeTime(id_rec, time);
        } catch (IOException ex) {
            System.out.println("Client.ChangeTime() ERROR");
        }
    }

    // Administrator

    @Override
    public void ChangeManager(int id_rec, int id_manager) {
        try {
            CS.ChangeManager(id_rec, id_manager);
        } catch (IOException ex) {
            System.out.println("Client.ChangeManager() ERROR");
        }
    }

    @Override
    public void SetManager(int id_user) {
        try {
            CS.SetManager(id_user);
        } catch (IOException ex) {
            System.out.println("Client.SetManager() ERROR");
        }
    }

    @Override
    public void RemoveManager(int id_user) {
        try {
            CS.SetManager(id_user);
        } catch (IOException ex) {
            System.out.println("Client.RemoveManager() ERROR");
        }
    }

    @Override
    public void OpenAllUsers() {
        try {
            CS.GetAllUsersInfo();
        } catch (IOException ex) {
            System.out.println("Client.OpenAllUsers() ERROR");
        }
    }

}
