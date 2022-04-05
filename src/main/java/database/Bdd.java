package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {
    public static Connection getConnection() {
        Connection cnx;
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/hme_todolist?serverTimezone=UTC", "todolist", "cuocgoi2hdem");
            return cnx;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}

