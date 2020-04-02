package presentation;

import serviceLayer.productOperations;

public class Main {

    public static void main(String[] args) {

        productOperations po = new productOperations();

        //po.addProduct("A project", "This handles nothing.");
        //po.deleteProduct("4");
        //po.printProducts();
        System.out.println(po.getLastInsert());
    }
}
