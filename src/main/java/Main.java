
import daos.DAO;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {

    static String username = "huff";
    static String password = "zipcode0";
    static String dbUrl = "jdbc:mysql://localhost:3306/heroGame";
    static Logger log =  Logger.getLogger("Log");

    public static void main(String[] args) {

        log.log(Level.INFO, "the log");
        System.out.println("Connection Initiated.");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Driver Registered");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Connection Established");

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            DAO database = new DAO(statement);
            database.findById(2);


            ///// METHOD CALLS //////


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed");
            return;
        }
        finally {
            try
            {
                if (connection != null)
                    connection.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
