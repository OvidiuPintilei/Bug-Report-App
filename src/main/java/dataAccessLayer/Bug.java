package dataAccessLayer;

public class Bug {

    private String id;
    private String name;
    private String description;
    private String tag;
    private String screenshot;
    private String employeeId;
    private String productId;

    private DBUpdate dbu = new DBUpdate();
    private DBQuery dbq = new DBQuery();

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getProductId() { return productId; }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }



    public void create(){
        String str = "INSERT INTO bug (name, description, tag, screenshot) VALUES ('" + name +"', '" + description + "', '"+ tag + "', '" + screenshot +"');";
        dbu.doUpdate(str);
    }

    public void delete() {
        String str = "DELETE FROM bug WHERE id = " + id + ";";
        dbu.doUpdate(str);
    }

    public String read(){
        String str = "SELECT * from bug;";
        return dbq.doQuery(str);
    }
}
