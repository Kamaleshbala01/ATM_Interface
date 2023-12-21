package AtmInterface;

public class Deposit {
    public static void deposit(int deposit,String dateString) {
        UserData data = new UserData();
        ValidationCheck.deleteLine(data.getUserID(),"balance");
        data.setUserBalance(data.getUserBalance()+deposit);
        ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(data.getUserBalance()),"balance");
        ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(deposit)+" "+"Deposit"+" ON "+dateString,"transaction");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Amount Deposited....!");
        System.out.println("Your account balance is : "+data.getUserBalance());
        System.out.println("----------------------------------------------------------------");
    }
}
