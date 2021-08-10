package ATM;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.ListIterator;


public class Account_Function extends Account_Info {
	
	Account_Function(int SavedMoney, String AccountName, String AccountPassword) {
		super(SavedMoney, AccountName, AccountPassword);
		// TODO Auto-generated constructor stub
	}

	//  function Withdraw Money
	public boolean funWithdrawMoney(int withdrawMoney) throws IOException {
		int money= getSavedMoney();
		int leave = money-withdrawMoney;
		if(leave>0) {
			setSavedMoney(leave);
			return true;
		}
		return false;
	}
	
	//	history-content of Withdraw Money
	public void hicWithdrawMoney(int money) throws IOException {
		setPreviousWithdrawMoney(money);
	}
	
	public boolean funSaveMoney(int SaveMoney) throws IOException{
		int money= getSavedMoney();
		int sum = money+SaveMoney;
		if(SaveMoney>0) {
			setSavedMoney(sum);
			return true;
		}
		return false;
	}
	
	public void hicSaveMoney(int money) throws IOException {
		setPreviousSaveMoney(money);
	}
	
	public boolean funTransfer(String account,int Transfer) throws IOException{
		int money= getSavedMoney();
		int Transferlater = money-Transfer;
		RandomAccessFile ra = new RandomAccessFile("E://DESKTOP//ATM//"+account+"_SavedMoney.txt","rw");
		
		ArrayList<Byte> messageByte = new ArrayList<Byte>();
		ListIterator<Byte> iterator = null;
		StringBuffer messageString = new StringBuffer();
		int onebyte = -1;
		while((onebyte=ra.read())!=-1) {
			messageByte.add((byte)onebyte);
		}
		iterator = messageByte.listIterator();
		while(iterator.hasNext()) {
			onebyte = iterator.next();
			if(onebyte>=(int)'0' && onebyte<=(int)'9') {
				messageString.append((char)(byte)onebyte);
			}
		}
		messageString = messageString.toString()==""?new StringBuffer("0"):messageString;
		int transferCountMoney = (int)Integer.parseInt(messageString.toString())+Transfer;
		ra.seek(0); // 读取索引重新拉回开始，否则会以追加的形式写在文件末尾
		if(Transferlater>=0 && Transfer>0) {
			ra.write((transferCountMoney+" ".repeat(messageString.toString().length())).getBytes());
			setSavedMoney(Transferlater);
			ra.close();
			return true;
		}else {
			ra.close();
			return false;			
		}

	}
	
	public void hicTransfer(String account, int money) throws IOException {
		setPreviousTransfer(account,money);
	}

	public boolean funLivingExpenses(int livingExpenses) throws IOException {
		int money = getSavedMoney();
		int later = money-livingExpenses;
		if(later>=0 && livingExpenses>0) {
			setSavedMoney(later);
			return true;
		}else {
			return false;
		}
	}

	public void hicLivingExpenses( int livingExpenses) throws IOException  {
		setPreviousLivingExpenses(livingExpenses);
	}
	
	public boolean funChangePassword(String oldPassword,String newPassword,String renewPassword) throws IOException {
		if(oldPassword.equals(super.AccountPassword) && newPassword.equals(renewPassword)) {
			setAccountPassword(newPassword);
			return true;
		}else {
			return false;
		}
	}
	
	public void hicChangePassword() throws IOException {
		setAccountPreviousPassword();
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			Account_Function af = new Account_Function(1000,"oushuai","12345678");
//			af.funWithdrawMoney(24);
//			af.hicWithdrawMoney(24);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
