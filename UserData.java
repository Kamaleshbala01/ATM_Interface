package AtmInterface;

public class UserData {
	private static String userID;
	private static String reciverID;
	private static float userBalance;
	private static float reciverBalance;
	private static String userName,reciverName;
		

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReciverName() {
		return reciverName;
	}
	public void setReciverName(String reciverName) {
		this.reciverName = reciverName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getReciverID() {
		return reciverID;
	}
	public void setReciverID(String reciverID) {
		this.reciverID = reciverID;
	}
	public float getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(float userBalance) {
		this.userBalance = userBalance;
	}
	public float getReciverBalance() {
		return reciverBalance;
	}
	public void setReciverBalance(float reciverBalance) {
		this.reciverBalance = reciverBalance;
	}
}
