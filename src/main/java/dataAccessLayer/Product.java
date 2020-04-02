package dataAccessLayer;

public class Product {
    private String id;
    private String name;
    private String description;
    private DBUpdate dbu = new DBUpdate();
    private DBQuery dbq = new DBQuery();

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

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public void create() {
        String str = "INSERT INTO product (name, description) VALUES ('" + name + "','" + description + "');";
        dbu.doUpdate(str);
    }

    public void delete() {
        String str = "DELETE FROM product WHERE id = " + id + ";";
        dbu.doUpdate(str);
    }

    public String read(){
        String str = "SELECT * from product;";
        return dbq.doQuery(str);
    }

}
