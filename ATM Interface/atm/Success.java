package atm;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Success {
	
	Font txt = new Font("",Font.BOLD,20);
	
	public void successView(int id)throws SQLException{
		Home home = new Home();
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
	
		
		//.............Transactions Success...............
		JLabel sucss = new JLabel("TRANSACTION SUCCESSFUL !!!");
		sucss.setBounds(0,280,600,50);
		sucss.setFont(txt);
		sucss.setHorizontalAlignment(JLabel.CENTER);
		frame.add(sucss);
		
		home.homeView(id);
		frame.setVisible(true);
	}
	
	public void thankView(int id)throws SQLException{
		Home home = new Home();
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
		
		//.................Thank You................
		JLabel sucss = new JLabel("THANK YOU !!!");
		sucss.setBounds(0,280,600,50);
		sucss.setFont(txt);
		sucss.setHorizontalAlignment(JLabel.CENTER);
		frame.add(sucss);
		
		home.homeView(id);
		frame.setVisible(true);
	}
	
	public void deleteView(String card)throws SQLException{
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
		
		
		//............User Deleted..................
		JLabel sucss = new JLabel("ACCOUNT SUCCESSFULLY DELETED !!!");
		sucss.setBounds(0,280,600,50);
		sucss.setFont(txt);
		sucss.setHorizontalAlignment(JLabel.CENTER);
		frame.add(sucss);

		JButton back = new JButton("BACK");
		back.setBounds(250,500,100,30);
		frame.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin ad = new Admin();
				ad.adminView();
			}
		});
		
		frame.setVisible(true);
	}
	
	public void accountView(String num,String pin) {
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
		Font txt = new Font("",Font.BOLD,20);
		Font txt1 = new Font("Dialog",Font.PLAIN,15);
		
		//.................User Added........................
		JLabel sucss = new JLabel("ACCOUNT SUCCESSFULLY ADDED !!!");
		sucss.setBounds(0,200,600,50);
		sucss.setFont(txt);
		sucss.setHorizontalAlignment(JLabel.CENTER);
		frame.add(sucss);
		JTextField cardnumber = new JTextField("CARD NUMBER : "+num);
		cardnumber.setBounds(0,300,600,50);
		cardnumber.setFont(txt1);
		cardnumber.setEditable(false);
		cardnumber.setHorizontalAlignment(JLabel.CENTER);
		frame.add(cardnumber);
		JTextField pinnumber = new JTextField("DEFAULT PIN : "+pin);
		pinnumber.setBounds(0,400,600,50);
		pinnumber.setFont(txt1);
		pinnumber.setEditable(false);
		pinnumber.setHorizontalAlignment(JLabel.CENTER);
		frame.add(pinnumber);
		
		JButton back = new JButton("BACK");
		back.setBounds(250,500,100,30);
		frame.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin ad = new Admin();
				ad.adminView();
			}
		});
		
		frame.setVisible(true);
	}
}
