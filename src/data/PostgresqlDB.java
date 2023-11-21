package data;

import data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlDB implements IDB {
    private static PostgresqlDB instance;
    private PostgresqlDB() {
    }
    public static PostgresqlDB getInstance() {
        if (instance == null) {
            instance = new PostgresqlDB();
        }
        return instance;
    }
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/fantasy";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionURL, "postgres", "Fytyfyty121");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
