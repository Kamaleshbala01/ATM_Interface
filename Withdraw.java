package AtmInterface;

public class Withdraw {
    public static void withdraw(int withdraw,String dateString) {
        UserData data = new UserData();
        ValidationCheck.deleteLine(data.getUserID(),"balance");
        data.setUserBalance(data.getUserBalance()-withdraw);
        ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(data.getUserBalance()),"balance");
        ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(withdraw)+" "+"Withdraw"+" ON "+dateString,"transaction");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Collect your cash : "+withdraw);
        System.out.println("----------------------------------------------------------------");
    }
}
