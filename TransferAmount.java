package AtmInterface;

public class TransferAmount {
    public static void transferMoney(int amount,String dateString) {
        UserData data = new UserData();
        data.setUserBalance(data.getUserBalance()-amount);
        data.setReciverBalance(data.getReciverBalance()+amount);
        ValidationCheck.deleteLine(data.getUserID(),"balance");
        ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(data.getUserBalance()),"balance");
        ValidationCheck.deleteLine(data.getReciverID(),"balance");
        ValidationCheck.updataFile(data.getReciverID()+" "+String.valueOf(data.getReciverBalance()),"balance");
        ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(amount)+" "+"Transfered To "+data.getReciverName()+" ON "+dateString,"transaction");
        ValidationCheck.updataFile(data.getReciverID()+" "+String.valueOf(amount)+" "+"Recived form "+data.getUserName()+" ON "+dateString,"transaction");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Transfer sucessfully processed....!");
        System.out.println("Your account Balance : "+data.getUserBalance());
        System.out.println("----------------------------------------------------------------");
    }

}
