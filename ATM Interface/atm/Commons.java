package atm;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Commons {
	
	public Component Frame() {
		JFrame frame = new JFrame("ATM Interface");
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		//...................ATM........................
		
		Font txt = new Font("MONOSPACED",Font.BOLD,50);
		
		JLabel atm = new JLabel("ATM");
		atm.setBounds(0,0,600,120);
		atm.setHorizontalAlignment(JLabel.CENTER);
		atm.setFont(txt);
		//atm.setFont(new Font("",Font.BOLD,20));
		
		JLabel man = new JLabel("MANAGEMENT SYSTEM");
		man.setBounds(0,90,600,40);
		man.setHorizontalAlignment(JLabel.CENTER);
		man.setFont(txt);
		//man.setFont(new Font("",Font.BOLD,20));

		frame.add(atm);
		frame.add(man);
		
		return frame;
		
	}
}
