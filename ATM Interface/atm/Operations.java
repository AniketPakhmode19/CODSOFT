package atm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Operations {
	SQLManage manage;
	Fail fail;
	Success success;

	Operations() throws SQLException {
		manage = new SQLManage();
		fail = new Fail();
		success = new Success();
	}

	public void opView(String str, int id) throws SQLException {
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
		Font txt = new Font("", Font.BOLD,20);

		// ...............Amount/Pin..............
		JLabel label = new JLabel("Enter the " + str);
		label.setBounds(170,220,290,20);
		label.setFont(txt);
		JTextField amt = new JTextField();
		amt.setBounds(145,280,300,35);
		amt.setFont(txt);
		frame.add(amt);
		frame.add(label);

		// ................Submit..................
		JButton sbt = new JButton("SUBMIT");
		sbt.setBounds(200, 350, 200, 50);
		sbt.setFont(txt);
		frame.add(sbt);
		sbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (str.equals("Withdraw Amount")) {
					try {
						withdrawal(Integer.parseInt(amt.getText()),id);
						success.successView(id);
						frame.dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
				else if (str.equals("Deposit Amount")) {
					try {
						manage.deposit(Integer.parseInt(amt.getText()),id);
						success.successView(id);
						frame.dispose();
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
					}
				} 
				else if (str.equals("New Pin")) {
					try {
						manage.pinchange(amt.getText(),id);
						success.thankView(id);
						frame.dispose();
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		JButton back = new JButton("BACK");
		back.setBounds(200, 450, 200, 50);
		back.setFont(txt);
		frame.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Home h = new Home();
				try {
					h.homeView(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		if (str.equals("Balance")) {
			amt.setVisible(false);
			sbt.setVisible(false);
			label.setText("YOUR TOTAL BALANCE IS  : ");
			JLabel bal;
			try {
				bal = new JLabel(manage.balCheck(id)+""+" Rs");
				bal.setBounds(0, 270, 600, 20);
				bal.setHorizontalAlignment(JLabel.CENTER);
				bal.setFont(txt);
				frame.add(bal);
				success.thankView(id);
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		frame.setVisible(true);
	}

	public void withdrawal(int amount, int id) {
		try {
			int check = manage.withdraw(amount, id);
			if (check==1) {
				success.successView(id);
			} 
			else {
				fail.failView("INSUFFICIENT BALANCE");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
