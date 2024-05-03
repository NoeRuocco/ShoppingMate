/*

    Il costruttore della classe è stato reso privato per impedire l'istanziazione della classe
    al di fuori della classe stessa.
    La variabile `instance` è stata dichiarata come statica e privata, in modo che solo la classe
    stessa possa accedervi.

 */

package test.example.shoptest.database;

import java.sql.*;

public class ConnectionDB {
    private static ConnectionDB instance;
    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "admin";

    private ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    //synchronized nel caso in cui sia in una modalità che permette il multithread per poter gestire gli accessi
    public static synchronized ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection: " + e.getMessage());
        }
    }
}
