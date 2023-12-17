package AtmInterface;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UserData data = new UserData();
		System.out.println("----------------------------------------------------------------");
		System.out.println("Welcome to KB ATM.....!");
		System.out.println("----------------------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		String userID,reciverID,pin;
		int count=0,track=0;
		while(count<3) {
			System.out.println("----------------------------------------------------------------");
			System.out.print("Enter your userID for process  :   ");
			userID = scanner.nextLine();
			System.out.println("----------------------------------------------------------------");
			System.out.print("Enter your PIN for validation  :   ");
			pin = scanner.nextLine();
			System.out.println("----------------------------------------------------------------");
			if(ValidationCheck.userID(userID,pin)) {
				track = 1;
				data.setUserID(userID);
				data.setUserName(ValidationCheck.getName(userID));
				data.setUserBalance(ValidationCheck.getBalance(userID));
				break;
			}
			else {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Your userID or PIN is not Valid enter valid userID and PIN...!");
				System.out.println("----------------------------------------------------------------");
				count++;
			}
	    }
		if(track==1) {
			 Date currentDate = new Date();
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     String dateString = dateFormat.format(currentDate);
			int choice;
			System.out.println("----------------------------------------------------------------\n1 for Transaction History\n2 for Withdraw\n3 for Deposit\n4 for Transfer amount\n5 for Check Balance\nOther for Quit\n----------------------------------------------------------------");
			choice = scanner.nextInt();
			switch(choice) {
			case 1: System.out.println("Your transaction History.....!");
				    System.out.println("----------------------------------------------------------------");
				    ValidationCheck.printTransactionHIstory(data.getUserID());
				    System.out.println("----------------------------------------------------------------");
			        break;
			case 2: System.out.println("----------------------------------------------------------------");
			        System.out.print("Enter the amount of withdraw  :  ");
			        int withdraw = scanner.nextInt();
			        System.out.println("----------------------------------------------------------------");
			        if(data.getUserBalance()>=withdraw) {
			        	ValidationCheck.deleteLine(data.getUserID(),"balance");
			        	data.setUserBalance(data.getUserBalance()-withdraw);
			        	ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(data.getUserBalance()),"balance");
			        	ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(withdraw)+" "+"Withdraw"+" ON "+dateString,"transaction");
			        	System.out.println("----------------------------------------------------------------");
			        	System.out.println("Collect your cash : "+withdraw);
			        	System.out.println("----------------------------------------------------------------");
			        }
			        else {
			        	System.out.println("----------------------------------------------------------------");
			        	System.out.println("Insufficience balance ...!");
			        	System.out.print("Check Balance yes/no :  ");
			        	scanner.nextLine();
			        	String flag = scanner.nextLine();
			        	System.out.println("----------------------------------------------------------------");
			            if(flag.equals("yes")) {
			            	System.out.println("----------------------------------------------------------------");
			            	System.out.println("Your account Balance : "+data.getUserBalance());
			            	System.out.println("----------------------------------------------------------------");
			            }
			        }
			        break;
			case 3:  System.out.println("----------------------------------------------------------------");
				     System.out.println("Enter amount of Deposit : ");
			         int deposit = scanner.nextInt();
			         System.out.println("----------------------------------------------------------------");
			         ValidationCheck.deleteLine(data.getUserID(),"balance");
			         data.setUserBalance(data.getUserBalance()+deposit);
			         ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(data.getUserBalance()),"balance");
			         ValidationCheck.updataFile(data.getUserID()+" "+String.valueOf(deposit)+" "+"Deposit"+" ON "+dateString,"transaction");
			         System.out.println("----------------------------------------------------------------");
			         System.out.println("Amount Deposited....!");
			         System.out.println("----------------------------------------------------------------");
			         break;
			case 4:  System.out.println("----------------------------------------------------------------");
					 System.out.print("Enter reciver ID : ");
					 scanner.nextLine();
					 String reciverid = scanner.nextLine();
					 System.out.println("----------------------------------------------------------------");
					 int flag =0;
					 while(count<3) {
							pin = scanner.nextLine();
							if(ValidationCheck.reciverID(reciverid)) {
								flag = 1;
								data.setReciverID(reciverid);
								data.setReciverName(ValidationCheck.getName(reciverid));
								break;
							}
							else {
								System.out.println("----------------------------------------------------------------");
								System.out.println("Enter valid reciverID...!");
								System.out.println("----------------------------------------------------------------");
								count++;
							}
					    }
					 if(flag==1) {
						 System.out.println("----------------------------------------------------------------");
						 System.out.print("Enter the amount to be send to user ID "+reciverid+" : ");
						 int amount = scanner.nextInt();
						 System.out.println("----------------------------------------------------------------");
						 data.setReciverBalance(ValidationCheck.getBalance(reciverid));
							 if(data.getUserBalance()>=amount) {
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
						         System.out.println("----------------------------------------------------------------");
							 }
							 else {
								 System.out.println("----------------------------------------------------------------");
								 System.out.println("Insufficience balance.....!");
								 System.out.println("----------------------------------------------------------------");
							 }
					}
					 break;
			case 5:  System.out.println("----------------------------------------------------------------");
				     System.out.println("Your account balance is : "+data.getUserBalance());
				     System.out.println("----------------------------------------------------------------");
			         break;
		 default : break;			 
			
		}
	}				System.out.println("----------------------------------------------------------------");
					System.out.println("Thanks for using KB ATM.......!\nHave a nice day");
					System.out.println("----------------------------------------------------------------");
	}

}
