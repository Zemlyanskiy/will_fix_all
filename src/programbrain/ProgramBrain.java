package programbrain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProgramBrain {

    // Database credentials
    static final String DB_URL = "jdbc:postgresql://manny.db.elephantsql.com:5432/gelqajsy";
    static final String USER = "gelqajsy";
    static final String PASS = "RWybXei9YWXS7t_Vk7bHdFI_fCq7dHdg";

    public static void main(String[] argv) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:postgresql://host:port/database";
        String username = "database";
        String password = "password";

        try {
            Connection db = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM people");
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(2));
                System.out.print("Column 2 returned ");
                System.out.println(rs.getString(3));
            }
            rs.close();
            st.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}