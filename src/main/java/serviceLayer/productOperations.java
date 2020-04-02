package serviceLayer;

import dataAccessLayer.DBQuery;
import dataAccessLayer.DBUpdate;
import dataAccessLayer.Product;

public class productOperations {

    private Product product = new Product();
    private DBUpdate dbu = new DBUpdate();

    private DBQuery dbq = new DBQuery();

    public void addProduct(String name, String description) {
        product.setName(dbu.convertSQLString(name));
        product.setDescription(dbu.convertSQLString(description));
        product.create();
    }

    public void deleteProduct(String id) {
        product.setId(id);
        product.delete();
    }

    public void printProducts(){
        String str = product.read();
        System.out.println(str);
    }

    public String getLastInsert(){
        String str = dbq.doQuery("SELECT LAST_INSERT_ID() FROM product");
        String[] id = str.split(" ");
        return id[0];
    }
}
