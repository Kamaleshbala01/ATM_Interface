package AtmInterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class ValidationCheck {
	static UserData data = new UserData();
	
	public static boolean userID(String userID,String pin) {
		try {
			File file = new File("C:/Users/acer/eclipse-workspace/Kamalesh/src/AtmInterface/user.txt");
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String temp = reader.nextLine();
				String [] userDetails = temp.split(" ");
				if(userDetails[0].equals(userID) && userDetails[1].equals(pin)) {
						return true;
					}	
			}
			reader.close();
		}
		catch(IOException  e) {
			System.out.println(e);
		}
		return false;
	}
	public static void printTransactionHIstory(String userID) {
		try {
			File file = new File("C:/Users/acer/eclipse-workspace/Kamalesh/src/AtmInterface/transaction.txt");
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String temp = reader.nextLine();
				String [] transactionDetails = temp.split(" ");
				if(transactionDetails[0].equals(userID)) {
					for(int i=1;i<transactionDetails.length;i++)
						System.out.print(transactionDetails[i]+" ");
					System.out.println();
					}	
				
			}
			reader.close();
		}catch(IOException e) {
		System.out.println(e);
	}
	}
	public static float getBalance(String userID) {
		try {
			File file = new File("C:/Users/acer/eclipse-workspace/Kamalesh/src/AtmInterface/balance.txt");
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String temp = reader.nextLine();
				String [] userDetails = temp.split(" ");
					if(userDetails[0].equals(userID)){
					      return (Float.parseFloat(userDetails[1]));
					}	
			}
			reader.close();
		}
		catch(IOException | NumberFormatException e) {
			System.out.println(e);
		}
		return (float) 0.0;
	}
	public static void deleteLine(String userID,String files) {

		File file = new File("C:/Users/acer/eclipse-workspace/Kamalesh/src/AtmInterface/"+files+".txt");
		StringBuffer string = new StringBuffer(); 
		try {
			Scanner reader = new Scanner(file);
		
			while(reader.hasNextLine()) {
				String lineContent = reader.nextLine();
				String [] balance = lineContent.split(" ");
				if(balance[0].equals(userID)) {
					continue;
				}
				string.append(lineContent).append(System.getProperty("line.separator"));
			}
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(string.toString());
			writer.close();
		}catch(IOException e) {
			System.out.println(e);
		}	
	}
	public static void updataFile(String value,String files) {
		   File file = new File("C:/Users/acer/eclipse-workspace/Kamalesh/src/AtmInterface/"+files+".txt");
		   try {
			   BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			   writer.write(value+"\n");
			   writer.close();
			   
		   }catch(IOException e) {
			   System.out.println(e);
		   }
		}
	public static boolean reciverID(String reciverID) {
	File file = new File("C:/Users/acer/eclipse-workspace/Kamalesh/src/AtmInterface/user.txt");
	try {
		Scanner reader = new Scanner(file);
		while(reader.hasNextLine()) {
			String temp = reader.nextLine();
			String [] userDetails = temp.split(" ");
			if(userDetails[0].equals(reciverID))
				return true;
		}
	}
	catch(IOException e) {
		System.out.println(e);
	}
	return false;
}
	public static String getName(String userID) {
		try {
			File file = new File("C:/Users/acer/eclipse-workspace/Kamalesh/src/AtmInterface/user.txt");
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String temp = reader.nextLine();
				String [] userDetails = temp.split(" ");
				if(userDetails[0].equals(userID)) {
						return userDetails[(userDetails.length)-1];
					}	
			}
			reader.close();
		}
		catch(IOException  e) {
			System.out.println(e);
		}
		return "";
	}
}
