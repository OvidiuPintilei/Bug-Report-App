package serviceLayer;

import org.junit.Test;

import static org.junit.Assert.*;

public class bugOperationsTest {

    bugOperations bo = new bugOperations();
    @Test
    public void addBug() {

        try{
            bo.addBug("2","1","Some bug name","This bug came up on test", "yes","C://photos");
            bo.deleteBug(bo.getLastInsert());
        }catch(Exception e){
            assert(false);
        }

    }


    @Test
    public void printBugs() {

        try{
            bo.printBugs();
        }catch (Exception e){
            assert(false);
        }
    }
}