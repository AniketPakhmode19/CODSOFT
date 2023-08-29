package atm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddUser {
	JTextField pinField,atmField,deleteField;
	Random random = new Random();
	
	public void deleteView(String card)throws SQLException{
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
		Font txt = new Font("",Font.BOLD,20);
		SQLManage manage = new SQLManage();
		Success success = new Success();
		
		JLabel atmNumber = new JLabel("ATM CARD NUMBER TO DEACTIVATE");
		atmNumber.setBounds(100,270,500,25);
		atmNumber.setFont(txt);
		deleteField = new JTextField();
		deleteField.setBounds(145,330,300,35);
		frame.add(deleteField);
		frame.add(atmNumber);
		
		JButton procced = new JButton("Done");
		procced.setBounds(200,500,200,50);
		frame.add(procced);
		procced.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = deleteField.getText();
				 try {
			            manage.delete(num);
			            success.deleteView(deleteField.getText());
			         }
				 catch (SQLException e1) {
			            e1.printStackTrace();
			        }
			}
		});
		frame.setVisible(true);
	}
	
	public void addView()throws SQLException{
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
		Font txt = new Font("",Font.BOLD,20);
		SQLManage manage = new SQLManage();
		Success success = new Success();
		
		//.................Name..................
		JLabel name = new JLabel("NAME : ");
		name.setBounds(50,200,100,25);
		name.setFont(txt);
		JTextField nameField = new JTextField();
		nameField.setBounds(50,230,500,30);
		frame.add(nameField);
		frame.add(name);
		
		//.................Card Number..............
		JLabel atmNumber = new JLabel("ATM CARD NUMBER : ");
		atmNumber.setBounds(50,300,500,25);
		atmNumber.setFont(txt);
		atmField = new JTextField();
		atmField.setBounds(50,330,500,30);
		atmField.setEditable(false);
		frame.add(atmField);
		frame.add(atmNumber);
		
		//....................ATM Pin......................
		JLabel atmpin = new JLabel("ATM PIN : ");
		atmpin.setBounds(50,400,500,25);
		atmpin.setFont(txt);
		pinField = new JTextField();
		pinField.setBounds(50,430,200,30);
		pinField.setEditable(false);
		frame.add(pinField);
		frame.add(atmpin);
		
		//....................Balance......................
		JLabel balance = new JLabel("BALANCE : ");
		balance.setBounds(350,400,500,25);
		balance.setFont(txt);
		JTextField balanceField = new JTextField();
		balanceField.setBounds(350,430,200,30);
		frame.add(balanceField);
		frame.add(balance);
		
		//..................AutoGeneration..............
		auto();
		
		//..................Submit.........................
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(200,500,200,50);
		frame.add(submit);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!nameField.getText().equals("")) {
					if(balanceField.getText().equals(""))
						balanceField.setText("0");
					try {
						manage.adding(atmField.getText(), pinField.getText(), nameField.getText(), balanceField.getText());
					}
					catch(SQLException e1){
						e1.printStackTrace();
					}
					success.accountView(atmField.getText(),pinField.getText());
					balanceField.setText("");
					nameField.setText("");
					auto();
				}
			}
		});
		frame.setVisible(true);
	}
	
	public void auto() {
		String str="";
		for(int i=0;i<16;i++) {
			str+=random.nextInt(9-0+1)+0;
		}
		atmField.setText(str);
		str="";
		for(int i=0;i<4;i++) {
			str+=random.nextInt(9-0+1)+0;
		}
		pinField.setText(str);
	}

}
