package programbrain;

import java.io.PrintWriter;

public interface ProcedureInterface {

    public void ReadChat(int userId, PrintWriter refCursor);

    public void ReadRepair(int userId, PrintWriter refCursor);

    public void ReadUser(int userId, PrintWriter refCursor);

    public void WriteChat(int idOrder, int userId, String message);

    public void WriteReoair(int userId, int idOrder, String date, String time, String comment, int type);

    public void WriteUser(int userId, int idOrder, String email, String password, int type);
}
