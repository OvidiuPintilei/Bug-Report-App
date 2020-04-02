package serviceLayer;


import static org.junit.Assert.*;

public class productOperationsTest {
    private productOperations po =  new productOperations();

    @org.junit.Test
    public void addProduct() {
        try{
            po.addProduct("Test project", "This project is for testing");
            po.deleteProduct(po.getLastInsert());
        } catch(Exception e){
            assert(false);
        }

    }

    @org.junit.Test
    public void printProducts() {

        try{
            po.printProducts();
        }catch (Exception e){
            assert(false);
        }
    }
}