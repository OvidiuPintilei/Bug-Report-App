package serviceLayer;

import dataAccessLayer.DBUpdate;
import dataAccessLayer.Employee;

public class employeeOperations {

    private Employee employee = new Employee();
    private DBUpdate dbu = new DBUpdate();


    public void addEmployee(String name, String role) {
        employee.setName(dbu.convertSQLString(name));
        employee.setRole(dbu.convertSQLString(role));
        employee.create();
    }

    public void deleteEmployee(String id) {
        employee.setId(id);
        employee.delete();
    }

    public void printEmployees(){
        employee.read();
    }

}
