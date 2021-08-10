package ATM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	static int width=1100,height=612;
	static Point loc= new Point(100,100);
	static JFrame jf = new JFrame();
	static JPanel jp1 = new JPanel();
	static JPanel jp2 = new JPanel();
	static JPanel jp3 = new JPanel();
	static JButton jbt1 = new JButton("取出存款");
	static JButton jbt2 = new JButton("存入账户");
	static JButton jbt3 = new JButton("转账");
	static JButton jbt4 = new JButton("生活花费");
	static JButton jbt5 = new JButton("更改密码");
	static JButton jbt6 = new JButton("请从上述功能中选择......");
	static JButton back = new JButton("返回");
	static JButton confirm = new JButton("确认");
	static JTextField jtf = new JTextField(30);
	static JTextField jtf1 = new JTextField(30);
	static JTextField jtf2 = new JTextField(30);
	static JTextField jtf3 = new JTextField(30);
	static String currentGUI = null;
	
	static Account_Function af=null;
	static int initMoney;
	static String initAccountName;
	static String initPassword;
	
	static{
		jf.setTitle("GUI");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new BorderLayout());
		jf.add(jp1,BorderLayout.CENTER);
	}
	
	public GUI() {
		// TODO Auto-generated constructor stub
	}
	
	private static void GUI_Init(){
		currentGUI = null;
		jtf.setText(null);
		jtf1.setText(null);
		jtf2.setText(null);
		jtf3.setText(null);
		jp1.removeAll();
		jp2 = null;
		jp3 = null;
		jp2 = new JPanel();
		jp3 = new JPanel();
		jf.setSize(width,height);
		jf.setLocation(loc);
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,300,20));
		jp1.setLayout(new GridLayout(7,1));
		jp1.add(jbt1);
		jp1.add(jbt2);
		jp1.add(jbt3);
		jp1.add(jbt4);
		jp1.add(jbt5);
		jp1.add(jbt6);
		jp2.add(back);
		jp2.add(confirm);
		jp1.add(jp2);
		back.setEnabled(true);
		confirm.setEnabled(false);
		
		jbt1.setBackground(Color.GRAY);
		jbt2.setBackground(Color.GRAY);
		jbt3.setBackground(Color.GRAY);
		jbt4.setBackground(Color.GRAY);
		jbt5.setBackground(Color.GRAY);
		jbt6.setBackground(Color.GRAY);
		back.setBackground(Color.GRAY);
		confirm.setBackground(Color.GRAY);
		
		jf.setVisible(true);
	}
	
	private static void GUI_WithdrawMoney() {
		currentGUI = "GUI_WithdrawMoney";
		jp1.removeAll();
		jp2 = null;
		jp3 = null;
		jp2 = new JPanel();
		jp3 = new JPanel();
		JLabel jb = new JLabel("请输入取款金额(单位:元)：");
		
		jf.setSize(width,height);
		jf.setLocation(loc);
		jp1.setLayout(new GridLayout(7,1));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,300,20));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp3.add(jb);
		jp3.add(jtf);
		jp1.add(jp3);
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp2.add(back);
		jp2.add(confirm);
		jp1.add(jp2);
		
		confirm.setEnabled(true);
		jf.setVisible(true);
	}
	
	private static void GUI_SaveMoney() {
		currentGUI = "GUI_SaveMoney";
		jp1.removeAll();;
		jp2 = null;
		jp3 = null;
		jp2 = new JPanel();
		jp3 = new JPanel();
		JLabel jb = new JLabel("请输入存款金额(单位:元)：");
		
		jf.setSize(width,height);
		jf.setLocation(loc);
		jp1.setLayout(new GridLayout(7,1));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,300,20));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp3.add(jb);
		jp3.add(jtf);
		jp1.add(jp3);
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp2.add(back);
		jp2.add(confirm);
		jp1.add(jp2);
		
		confirm.setEnabled(true);
		jf.setVisible(true);
	}
	
	private static void GUI_Transfer(){
		currentGUI = "GUI_Transfer";
		jp1.removeAll();
		jp2 = null;
		jp3 = null;
		jp2 = new JPanel();
		jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JLabel jb1 = new JLabel("我的账户：");
		JLabel jb2 = new JLabel("目标账户：");
		JLabel jb3 = new JLabel("转账金额：");
		JTextField innerjtf = new JTextField("*******************",30);

		jf.setSize(width,height);
		jf.setLocation(loc);
		jf.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(7,1));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,300,20));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		jp5.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		
		jp1.add(new JLabel(""));
		jp5.add(jb1);
		jp5.add(innerjtf);
		jp1.add(jp5);
		jp4.add(jb2);
		jp4.add(jtf1);
		jp1.add(jp4);
		jp3.add(jb3);
		jp3.add(jtf);
		jp1.add(jp3);
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp2.add(back);
		jp2.add(confirm);
		jp1.add(jp2);
		
		innerjtf.setEditable(false);
		confirm.setEnabled(true);
		jf.setVisible(true);
	}
	
	private static void GUI_LivingExpenses() {
		currentGUI = "GUI_LivingExpenses";
		jp1.removeAll();
		jp2 = null;
		jp3 = null;
		jp2 = new JPanel();
		jp3 = new JPanel();
		JLabel jb = new JLabel("请输入缴费金额：");
		JLabel jb1 = new JLabel("请选择缴费类目：");
		JComboBox<String> jcb = new JComboBox<String>();
		JPanel jp4 = new JPanel();
		
		jf.setSize(width,height);
		jf.setLocation(loc);
		jf.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(7,1));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,300,20));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jcb.addItem("--电费--");
		jcb.addItem("--水费--");
		jcb.addItem("--话费--");
		jp4.add(jb1);
		jp4.add(jcb);
		jp1.add(jp4);
		jp3.add(jb);
		jp3.add(jtf);
		jp1.add(jp3);
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp2.add(back);
		jp2.add(confirm);
		jp1.add(jp2);
		
		confirm.setEnabled(true);
		jf.setVisible(true);
	}

	private static void GUI_ChangePassword() {
		currentGUI = "GUI_ChangePassword";
		jp1.removeAll();
		jp2 = null;
		jp3 = null;
		jp2 = new JPanel();
		jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JLabel jb = new JLabel("确认密码");
		JLabel jb1 = new JLabel("账户名称");
		JLabel jb2 = new JLabel("原来密码");
		JLabel jb3 = new JLabel("更改密码");
		
		jf.setSize(width,height);
		jf.setLocation(loc);
		jf.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(7,1));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,300,20));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		jp5.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		jp6.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		
		jp1.add(new JLabel(""));
		jp6.add(jb1);
		jp6.add(jtf3);
		jp1.add(jp6);
		jp5.add(jb2);
		jp5.add(jtf2);
		jp1.add(jp5);
		jp4.add(jb3);
		jp4.add(jtf1);
		jp1.add(jp4);
		jp3.add(jb);
		jp3.add(jtf);
		jp1.add(jp3);
		jp1.add(new JLabel(""));
		jp2.add(back);
		jp2.add(confirm);
		jp1.add(jp2);
		
		confirm.setEnabled(true);
		jtf3.setEditable(false);
		jf.setVisible(true);
	}
	
	private static void GUI_Login() {
		currentGUI = "GUI_Login";
		jp1.removeAll();
		jp2 = null;
		jp3 = null;
		jp2 = new JPanel();
		jp3 = new JPanel();
		jf.setSize(width,height);
		jf.setLocation(loc);
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,300,20));
		jp1.setLayout(new GridLayout(7,1));
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		jp1.add(new JLabel(""));
		jp5.add(new JLabel("账户名称："));
		jp5.add(jtf2);
		jp1.add(jp5);
		jp4.add(new JLabel("设置密码："));
		jp4.add(jtf1);
		jp1.add(jp4);
		jp3.add(new JLabel("初始资金："));
		jp3.add(jtf);
		jp1.add(jp3);
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp2.add(back);
		jp2.add(confirm);
		jp1.add(jp2);
		
		jf.setVisible(true);
	}
	
	
	private static void registerListener() throws IOException{
		jbt1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)  {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				GUI_WithdrawMoney();
			}
		});
		jbt2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				GUI_SaveMoney();
			}
		});
		jbt3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				GUI_Transfer();
			}
		});
		jbt4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				GUI_LivingExpenses();
			}
		});
		jbt5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtf3.setText(af.AccountName);
				jf.setVisible(false);
				GUI_ChangePassword();
			}
		});
		back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				GUI_Init();
			}
		});
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int money = 0;
				try {
					switch(currentGUI) {
					case "GUI_WithdrawMoney":money = Integer.parseInt(jtf.getText());
											if(af.funWithdrawMoney(money)) {
												JOptionPane.showMessageDialog(jf,"账户取款已完成！","确认",JOptionPane.PLAIN_MESSAGE);
												af.hicWithdrawMoney(money);
											}else {
												JOptionPane.showMessageDialog(jf,"账户余额已不足！","警告",JOptionPane.ERROR_MESSAGE);
											}
											break;
					case "GUI_SaveMoney":	money = Integer.parseInt(jtf.getText());
											if(af.funSaveMoney(money)) {
												JOptionPane.showMessageDialog(jf,"账户存款已完成！","确认",JOptionPane.PLAIN_MESSAGE);
												af.hicSaveMoney(money);
											}else {
												JOptionPane.showMessageDialog(jf,"请输入正确金额！","警告",JOptionPane.ERROR_MESSAGE);
											}
											break;
					
					case "GUI_Transfer":	money = Integer.parseInt(jtf.getText());
											String transferAccount = jtf1.getText();
											if(af.funTransfer(transferAccount,money)) {
												JOptionPane.showMessageDialog(jf,"账户转账已完成！","确认",JOptionPane.PLAIN_MESSAGE);
												af.hicTransfer(transferAccount,money);
											}else {
												JOptionPane.showMessageDialog(jf,"请输入正确金额！","警告",JOptionPane.ERROR_MESSAGE);
											}break;
					case "GUI_LivingExpenses":money = Integer.parseInt(jtf.getText());
											if(af.funLivingExpenses(money)) {
												JOptionPane.showMessageDialog(jf,"¥"+jtf.getText()+"缴费已完成！","确认",JOptionPane.PLAIN_MESSAGE);
												af.hicLivingExpenses(money);
											}else {
												JOptionPane.showMessageDialog(jf,"请输入正确金额！","警告",JOptionPane.ERROR_MESSAGE);
											}
											break;
					case "GUI_ChangePassword":if(af.funChangePassword(jtf2.getText(),jtf1.getText(),jtf.getText())){
												JOptionPane.showMessageDialog(jf,"密码已修改！\n新密码："+jtf1.getText(),"确认",JOptionPane.PLAIN_MESSAGE);
												af.hicChangePassword();
											}else {
												JOptionPane.showMessageDialog(jf,"原密码输入错误或新密码两次出入不一致！","警告",JOptionPane.ERROR_MESSAGE);
											}
											break;
					case "GUI_Login":		money = Integer.parseInt(jtf.getText());
											initMoney = money;
											initAccountName = jtf2.getText();
											initPassword = jtf1.getText();
											af = new Account_Function(initMoney,initAccountName,initPassword);
											GUI_Init();
											break;
					default:break;
					}
				}catch(IOException e1) {}
			}
		});
		jf.addComponentListener(new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				loc = jf.getLocation();
//				System.out.println(loc.x+"   "+loc.y);
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI_Login();
		try {
//			System.out.println((int)'0'+"+"+(int)'9');
			registerListener();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
