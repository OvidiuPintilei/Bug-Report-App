package dataAccessLayer;

public class BugThread {

    private String id;
    private String employeeId;
    private String bugId;
    private String message;

    private DBUpdate dbu = new DBUpdate();
    private DBQuery dbq = new DBQuery();

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void create(){
        String str = "INSERT INTO bug_thread (message) VALUES ('" + message +"');";
        dbu.doUpdate(str);
    }

    public void delete() {
        String str = "DELETE FROM bug_thread WHERE id = " + id + ";";
        dbu.doUpdate(str);
    }

    public String read(){
        String str = "SELECT * from bug_thread;";
        return dbq.doQuery(str);
    }
}
