package atm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends Commons{
	
	public void loginView() {
		Commons common = new Commons();
		JFrame frame = (JFrame)common.Frame();
		Font txt = new Font("",Font.BOLD,20);
		Pin pin = new Pin();
		
		//...............Card Number.................
		JLabel card = new JLabel("ENTER YOUR CARD NUMBER");
		card.setBounds(150,270,290,20);
		card.setFont(txt);
		JTextField cardNumber = new JTextField();
		cardNumber.setBounds(145,330,300,35);
		cardNumber.setFont(txt);
		frame.add(cardNumber);
		frame.add(card);
		
		//..............Admin........................
		JLabel admin = new JLabel("ADMIN LOGIN >");
		admin.setBounds(0,500,570,30);
		admin.setHorizontalAlignment(JLabel.RIGHT);
		admin.setFont(txt);
		frame.add(admin);
		admin.addMouseListener(new MouseAdapter() {   
			public void mousePressed(MouseEvent e) {
				pin.pinView("admin");
				frame.dispose();
			}
		});
		
		//............Button.............................
		JButton cont = new JButton("CONTINUE");
		cont.setBounds(200,400,200,50);
		cont.setFont(txt);
		frame.add(cont);
		cont.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cardNumber.getText().length()==16) {
					pin.pinView(cardNumber.getText());
					frame.dispose();
				}
				else {
					Fail fail = new Fail();
					fail.failView("WRONG CARD NUMBER");
					frame.dispose();
				}
			}
		});
		
		frame.setVisible(true);
	}
}
