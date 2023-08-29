package atm;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Pin {
	
	public void pinView(String cardNum) {
		Commons common = new Commons();
		JFrame frame = (JFrame)common.Frame();
		Font txt = new Font("",Font.BOLD,20);
		Home home = new Home();
		Admin admin = new Admin();
		
		//...........Password.................
		JLabel pswd = new JLabel("ENTER YOUR PIN");
		pswd.setBounds(210,250,290,20);
		pswd.setFont(txt);
		JPasswordField pswdField = new JPasswordField();
		pswdField.setBounds(200,300,200,35);
		pswdField.setFont(txt);
		frame.add(pswdField);
		frame.add(pswd);
		
		//.............Button..................
		JButton cont = new JButton("CONTINUE");
		cont.setBounds(200,400,200,50);
		cont.setFont(txt);
		frame.add(cont);
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					SQLManage man = new SQLManage();
					@SuppressWarnings("deprecation")
					ResultSet rst = man.check(cardNum, pswdField.getText());
					if(rst.next()) {
						if(rst.getString("card").equals("admin")) {
							admin.adminView();
							frame.dispose();
						}
						else {
							home.homeView(rst.getInt("id"));
							frame.dispose();
						}
					}
					else {
						Fail fail = new Fail();
						fail.failView("WRONG PIN!!!");
						frame.dispose();
					}
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		
		frame.setVisible(true);
	}
}
