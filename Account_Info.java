package ATM;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Date;

class Account_Info {
	int SavedMoney=0;
	String AccountName=null;
	String AccountPassword=null;
	String AccountPreviousPassword=null;
	String TransferAccount = null;
	PreviousMessage rm = new PreviousMessage();
	
	String addressSavedMoney = null;
	String addressAccountName = null;
	String addressAccountPassword = null;
	String addressAccountPreviousPassword = null;
	String addressAccountHistoryContent = null;
	
	class PreviousMessage{
		int PreviousSaveMoney=0;
		int PreviousWithdrawMoney=0;
		int PreviousLivingExpenses=0;
		int PreviousTransferMoney=0;
		String PreviousTransferAccount=null;
	};
	
	
	Account_Info(int SavedMoney,String AccountName,String AccountPassword){
		this.SavedMoney = SavedMoney;
		this.AccountName = AccountName;
		this.AccountPassword = AccountPassword;
		this.AccountPreviousPassword = "";
		this.addressSavedMoney = "E://DESKTOP//ATM//"+AccountName+"_SavedMoney.txt";
		this.addressAccountName = "E://DESKTOP//ATM//"+AccountName+"_AccountName.txt";
		this.addressAccountPassword = "E://DESKTOP//ATM//"+AccountName+"_AccountPassword.txt";
		this.addressAccountPreviousPassword = "E://DESKTOP//ATM//"+AccountName+"_AccountPreviousPassword.txt";
		this.addressAccountHistoryContent = "E://DESKTOP//ATM//"+AccountName+"_AccountHistoryContent.txt";
		initAccount();
	}
	
	void initAccount(){
		File accountSavedMoney = new File(addressSavedMoney);
		File accountAccountName = new File(addressAccountName);
		File accountAccountPassword = new File(addressAccountPassword);
		File accountAccountPreviousPassword = new File(addressAccountPreviousPassword);
		File accountAccountHistoryContent = new File(addressAccountHistoryContent);
		
		try {
			RandomAccessFile randomaccount1 = new RandomAccessFile(accountSavedMoney,"rw");
			randomaccount1.write((this.SavedMoney+"").getBytes());
			RandomAccessFile randomaccount2 = new RandomAccessFile(accountAccountName,"rw");
			randomaccount2.write(this.AccountName.getBytes());
			RandomAccessFile randomaccount3 = new RandomAccessFile(accountAccountPassword,"rw");
			randomaccount3.write(this.AccountPassword.getBytes());
			RandomAccessFile randomaccount4 = new RandomAccessFile(accountAccountPreviousPassword,"rw");
			randomaccount4.write((this.AccountPreviousPassword).getBytes());
			RandomAccessFile randomaccount5 = new RandomAccessFile(accountAccountHistoryContent,"rw");
			randomaccount5.write("".getBytes());
			randomaccount1.close();
			randomaccount2.close();
			randomaccount3.close();
			randomaccount4.close();
			randomaccount5.close();
		}catch(IOException e) {
			System.out.println("Account_Info_CLASS中内部动态块产生发生异常："+e.getMessage());
		}
	}
	
	int getSavedMoney() throws IOException {
		File fl = new File(addressSavedMoney);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
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
		messageString = messageString==null ? new StringBuffer("0"):messageString; 
		SavedMoney = (int)Integer.parseInt(messageString.toString());
		ra.close();
		return SavedMoney;
	}
	
	void setSavedMoney(int SavedMoney) throws IOException {
		this.SavedMoney = SavedMoney;
		RandomAccessFile randomaccount = new RandomAccessFile(addressSavedMoney,"rw");
		randomaccount.write((SavedMoney+" ".repeat((SavedMoney+"").length())).getBytes());
		randomaccount.close();
	}
	
	void printSavedMoney() throws IOException {
		File fl = new File(addressSavedMoney);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
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
		SavedMoney = Integer.parseInt(messageString.toString());
		System.out.println("当前余额："+SavedMoney);
		ra.close();
	}
	
	String getAccountPassword() throws IOException {
		File fl = new File(addressAccountPassword);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
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
			messageString.append((char)(byte)onebyte);
		}
		AccountPassword = messageString.toString();
		ra.close();
		return AccountPassword;
	}
	
	void setAccountPassword(String AccountPassword) throws IOException {
		this.AccountPreviousPassword = this.AccountPassword;
		this.AccountPassword = AccountPassword;
		RandomAccessFile randomaccount = new RandomAccessFile(addressAccountPassword,"rw");
		randomaccount.write((AccountPassword+" ".repeat((int) randomaccount.length())).getBytes());
		randomaccount.close();
	}
	
	void printAccountPassword() throws IOException {
		File fl = new File(addressAccountPassword);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
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
			messageString.append((char)(byte)onebyte);
		}
		AccountPassword = messageString.toString();
		System.out.println("当前密码："+AccountPassword);
		ra.close();
	}
	
	String getAccountPreviousPassword() throws IOException {
		File fl = new File(addressAccountPreviousPassword);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
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
			messageString.append((char)(byte)onebyte);
		}
		AccountPreviousPassword = messageString.toString();
		ra.close();
		return AccountPreviousPassword;
	}
	
	void setAccountPreviousPassword() throws IOException {
		RandomAccessFile randomaccount1 = new RandomAccessFile(addressAccountPreviousPassword,"rw");
		RandomAccessFile randomaccount2 = new RandomAccessFile(addressAccountHistoryContent,"rw");
		randomaccount1.write(AccountPreviousPassword.getBytes());
		randomaccount1.close();
		long lnum = randomaccount2.length();
		randomaccount2.seek(lnum);
		randomaccount2.write((new Date()+"\r\n"+"用户将原密码"+AccountPreviousPassword+"修改为"+AccountPassword+"\r\n").getBytes());
		randomaccount2.close();
	}
	
	void printAccountPreviousPassword() throws IOException {
		File fl = new File(addressAccountPreviousPassword);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
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
			messageString.append((char)(byte)onebyte);
		}
		AccountPreviousPassword = messageString.toString();
		ra.close();
		System.out.println("旧密码："+AccountPreviousPassword);
	}
	
	int getPreviousSaveMoney() {
		return rm.PreviousSaveMoney;
	}
	
	void setPreviousSaveMoney(int PreviousSaveMoney) throws IOException {
		rm.PreviousSaveMoney=PreviousSaveMoney;
		File fl = new File(addressAccountHistoryContent);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
		long lnum = ra.length();
		String wrMessage = (new Date()).toString()+"\r\n"+"存入账户：¥"+PreviousSaveMoney+"\r\n";
		ra.seek(lnum);
		ra.write(wrMessage.getBytes());
		ra.close();
	}
	
	void printPreviousSaveMoney() {
		System.out.println("近期存款："+rm.PreviousSaveMoney);
	}
	
	int getPreviousWithdrawMoney() {
		return rm.PreviousWithdrawMoney;
	}
	
	void setPreviousWithdrawMoney(int PreviousWithdrawMoney) throws IOException {
		rm.PreviousWithdrawMoney=PreviousWithdrawMoney;
		File fl = new File(addressAccountHistoryContent);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
		long lnum = ra.length();
		String wrMessage = (new Date()).toString()+"\r\n"+"账户取出：¥"+PreviousWithdrawMoney+"\r\n";
		ra.seek(lnum);
		ra.write(wrMessage.getBytes());
		ra.close();
	}
	
	void printPreviousWithdrawMoney() {
		System.out.println("近期取款：¥"+rm.PreviousWithdrawMoney);
	}
	
	int getPreviousLivingExpenses() {
		return rm.PreviousLivingExpenses;
	}
	
	void setPreviousLivingExpenses(int PreviousLivingExpenses) throws IOException {
		rm.PreviousLivingExpenses=PreviousLivingExpenses;
		File fl = new File(addressAccountHistoryContent);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
		long lnum = ra.length();
		String wrMessage = (new Date()).toString()+"\r\n"+"生活花费：¥"+PreviousLivingExpenses+"\r\n";
		ra.seek(lnum);
		ra.write(wrMessage.getBytes());
		ra.close();
	}
	
	void printPreviousLivingExpenses() {
		System.out.println("上次生活消费：¥"+rm.PreviousLivingExpenses);
	}
//	RecentMessage.RecentTransferMoneyRecentMessage.RecentTransferAccount
	String[] getPreviousTransfer() {
		return new String[] {
				rm.PreviousTransferAccount+"",
				rm.PreviousTransferMoney+""
		};
	}
	
	void setPreviousTransfer(String PreviousTransferAccount,int PreviousTransferMoney) throws IOException {
		rm.PreviousTransferMoney=PreviousTransferMoney;
		rm.PreviousTransferAccount=PreviousTransferAccount;
		File fl = new File(addressAccountHistoryContent);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
		long lnum = ra.length();
		String wrMessage = (new Date()).toString()+"\r\n"+"向账户："+PreviousTransferAccount+"转账￥"+PreviousTransferMoney+"\r\n";
		ra.seek(lnum);
		ra.write(wrMessage.getBytes());
		ra.close();
	}
	
	void printPreviousTransfer() {
		System.out.println("近期转账账户："+rm.PreviousTransferAccount+"\t转账金额：¥"+rm.PreviousTransferMoney);
	}
	
	void printAccountHistoryContent() throws IOException {
		File fl = new File(addressAccountHistoryContent);
		RandomAccessFile ra = new RandomAccessFile(fl,"rw");
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
			messageString.append((char)(byte)onebyte);
		}
		System.out.println(messageString.toString());
		ra.close();
	}
}
