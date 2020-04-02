package dataAccessLayer;

public class Employee {
    private String id;
    private String name;
    private String role;

    private DBUpdate dbu = new DBUpdate();
    private DBQuery dbq = new DBQuery();

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void create() {
        String str = "INSERT INTO employee (name, role) VALUES ('" + name + "','" + role + "');";
        dbu.doUpdate(str);
    }

    public void delete() {
        String str = "DELETE FROM employee WHERE id = " + id + ";";
        dbu.doUpdate(str);
    }

    public String read(){
        String str = "SELECT * from employee;";
        return dbq.doQuery(str);
    }
}
