package dataAccessLayer;

import java.sql.*;

public final class Connector {
    private static volatile Connector instance;

    private static final String DBURL = "jdbc:mysql://localhost:3306/bugreporttest";
    private static final String USER = "root";
    private static final String PASS = "";
    private Connection con;

    private Connector() {
        createConnection();
    }

    public static Connector getInstance() {
        if (instance == null) {
            synchronized (Connector.class) {
                if (instance == null) {
                    instance = new Connector();
                }
            }
        }
        return instance;
    }

    private void createConnection() {
        try {
            Class.forName(Driver.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.con = null;
        try {
            this.con = DriverManager.getConnection(DBURL, USER, PASS);
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println("Not connecting to database: " + e);
            System.exit(1);
        }
    }

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println("Exception during Connection close: " + e);
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Exception during Statement close: " + e);
        }
    }

    public static void close(ResultSet res) {
        try {
            res.close();
        } catch (SQLException e) {
            System.err.println("Exception during ResultSet close: " + e);
        }
    }
}