package atm;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fail {
	public void failView(String str) {
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
		Font txt = new Font("",Font.BOLD,20);
		
		//..................Fail.................
		JLabel fail = new JLabel("YOUR TRANSACTION FAILED!!!");
		fail.setBounds(0,280,600,50);
		fail.setFont(txt);
		fail.setHorizontalAlignment(JLabel.CENTER);		
		JLabel st = new JLabel(str); 
		st.setBounds(0,320,600,50);
		st.setFont(txt);
		st.setHorizontalAlignment(JLabel.CENTER);
		frame.add(fail);
		frame.add(st);
		
		frame.setVisible(true);
	}
}
