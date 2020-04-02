package serviceLayer;

import dataAccessLayer.BugThread;

public class bugThreadOperations {

    private BugThread bugThread = new BugThread();

    public void addBug(String empId, String bugId, String message) {
        bugThread.setEmployeeId(empId);
        bugThread.setBugId(bugId);
        bugThread.setMessage(message);

        bugThread.create();
    }
    public void deleteBugThread(String id){
        bugThread.setId(id);
        bugThread.delete();
    }
    public void printBugThreads(){
        bugThread.read();
    }
}
