package dataAccessLayer;
import java.sql.*;

import dataAccessLayer.Connector;

public class DBUpdate {

    private Connector con = Connector.getInstance();

    public void doUpdate(String upStr) {
        try {
            Statement s = con.getCon().createStatement();
            s.executeUpdate(upStr);
            System.out.println("Update succeeded!");
        } catch (SQLException e) {
            System.out.println("Update failed: " + e);
        }
    }
    public String convertSQLString(String st){
        return st.replaceAll("'", "''");
    }
}