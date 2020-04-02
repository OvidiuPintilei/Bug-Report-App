package dataAccessLayer;

import java.sql.*;
import dataAccessLayer.Connector;

public class DBQuery {

    private Connector con = Connector.getInstance();

    public String doQuery(String qStr) {
        String finalStr = "";
        try {
            Statement s = con.getCon().createStatement();
            ResultSet r = s.executeQuery(qStr);
            ResultSetMetaData rsmd = r.getMetaData();
            finalStr = "";
            int colCount = rsmd.getColumnCount();
            int[] colWidth = new int[colCount];
            for(int i = 0; i < colCount; i++) {
                colWidth[i] = rsmd.getColumnDisplaySize(i + 1);
                if(colWidth[i] > 35)
                    colWidth[i] = 35;
            }

            int rowCount = 0;
            while(r.next()) {
                for(int i = 0; i < colCount; i++) {
                    Object obj = r.getObject(i + 1);
                    String str;
                    if (obj != null) {
                        String data = obj.toString();
                        str = data + ' ';
                    } else {
                        return "";
                    }
                    finalStr = finalStr + str;
                }
                finalStr += "\n";
                rowCount++;
            }

            if(rowCount == 0)
                return "No results ";
            r.close();

        } catch (SQLException e){
            return "Query failed: " + e;
        }

        return finalStr;
    }
}
