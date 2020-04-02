package serviceLayer;

import dataAccessLayer.Bug;
import dataAccessLayer.DBQuery;
import dataAccessLayer.DBUpdate;

public class bugOperations {

    private Bug bug = new Bug();
    private DBUpdate dbu = new DBUpdate();
    private DBQuery dbq = new DBQuery();

    public void addBug(String empId, String prodId, String bugName, String description, String tag, String screenshot) {
        bug.setName(dbu.convertSQLString(bugName));
        bug.setDescription(dbu.convertSQLString(description));
        bug.setTag(dbu.convertSQLString(tag));
        bug.setScreenshot(dbu.convertSQLString(screenshot));
        bug.setEmployeeId(empId);
        bug.setProductId(prodId);

        bug.create();
    }

    public void deleteBug(String id){
        bug.setId(id);
        bug.delete();
    }

    public void printBugs(){
        bug.read();
    }

    public String getLastInsert(){
        String str = dbq.doQuery("SELECT LAST_INSERT_ID() FROM bug");
        String[] id = str.split(" ");
        return id[0];
    }
}
