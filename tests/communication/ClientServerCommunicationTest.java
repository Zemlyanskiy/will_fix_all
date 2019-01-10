package communication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

import server.*;
import client.*;

import java.io.IOException;

public class ClientServerCommunicationTest {
    String host = "localhost";
    int port = 1234;

    @BeforeClass
    public static void instanceMeasureList() {
        try {
            ServerProtocol protocol = new ServerProtocol(1234,new FakeServer());
            protocol.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void RegistrationTest() throws IOException {
        ClientSpeaker speaker = new ClientSpeaker(host, port);
        boolean answer = speaker.Registration("Login", "Password");

        Assert.assertTrue(answer);
    }

    @Test
    public void AutorizationTest() throws IOException {
        ClientSpeaker speaker = new ClientSpeaker(host, port);
        int answer = speaker.Autorization("Login", "Password");

        Assert.assertEquals(answer, 1);
    }

    @Test
    public void sendCalendar() throws IOException {
        ClientSpeaker speaker = new ClientSpeaker(host, port);
        String answer = speaker.GetCalendar();

        Assert.assertEquals(answer, "22 21 21 22");
    }

    /*
    @Test
    public void sendCarInfo() {
    }

    @Test
    public void sendRecordInfo() {
    }

    @Test
    public void toBookATime() {
    }

    @Test
    public void sendClientInfoToManager() {
    }

    @Test
    public void changeStatus() {
    }

    @Test
    public void changeTime() {
    }

    @Test
    public void changeManager() {
    }

    @Test
    public void setManager() {
    }

    @Test
    public void removeManager() {
    }

    @Test
    public void sendAllUsersInfo() {
    }
    */
}
