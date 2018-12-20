package programbrain;
<<<<<<< HEAD
=======
import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.*;
>>>>>>> Connect success, add interface to override procedures
import java.io.PrintWriter;

import static java.lang.System.out;

public class Procedure implements ProcedureInterface {
    @Override
    public void ReadChat(int userId, PrintWriter refCursor) {
<<<<<<< HEAD
        
=======
        /*Connection con = null;
        CallableStatement toesUp = null;
        Statement stmt = null;

        try
        {
            con = ConnectionPool.getConnection();
            stmt = con.createStatement(  );
            // для PostgreSQL сначала нужно создать транзакцию (AutoCommit == false)...
            con.setAutoCommit(false);

            // Настраиваем вызов.
            toesUp = con.prepareCall("{ ? = call ReadChat (userId, refCursor) }");
            toesUp.registerOutParameter(1, Types.OTHER);
            ResultSet getResults = toesUp.getResultSet();
            stmt.execute();

            ResultSet rs = (ResultSet) getResults.getObject(1);
            while (rs.next())
            {
                String name = rs.getString(1);
                int age = rs.getInt(2);
                out.println(name + " was " + age + " years old.");
            }
            rs.close();
        }
        catch (SQLException e)
        {
            // Мы должны защитить эти вызовы.
            try {
                toesUp.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }*/
>>>>>>> Connect success, add interface to override procedures
    }

    @Override
    public void ReadRepair(int userId, PrintWriter refCursor) {

    }

    @Override
    public void ReadUser(int userId, PrintWriter refCursor) {

    }

    @Override
    public void WriteChat(int idOrder, int userId, String message) {

    }

    @Override
    public void WriteReoair(int userId, int idOrder, String date, String time, String comment, int type) {

    }

    @Override
    public void WriteUser(int userId, int idOrder, String email, String password, int type) {

    }
}
