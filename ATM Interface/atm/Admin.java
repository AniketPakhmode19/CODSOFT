package atm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Admin {
	public void adminView() {
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
		Font txt = new Font("",Font.BOLD,15);
		
		//................AddUser...............
		JButton add = new JButton("ADD USER");
		add.setBounds(150,170,300,100);
		frame.add(add);
		add.setFont(txt);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddUser user = new AddUser();
				try {
					user.addView();
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				frame.dispose();
			}
		});
		
		//................Delete User................
		JButton delete = new JButton("DELETE USER");
		delete.setBounds(150,300,300,100);
		frame.add(delete);
		delete.setFont(txt);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				AddUser user = new AddUser();
				try {
					user.deleteView("");
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				frame.dispose();
			}
		});
		
		//..................Exit...............
		JButton exit = new JButton("EXIT");
		exit.setBounds(150,430,300,100);
		frame.add(exit);
		exit.setFont(txt);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		frame.setVisible(true);
	}

}
