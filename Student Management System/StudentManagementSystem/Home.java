package StudentManagementSystem;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



@SuppressWarnings("serial")
public class Home extends JFrame implements ActionListener{
	
	JButton b1,b2,b3,b4,b5;
	Container con;
	
	public Home() {
		con=getContentPane();
		
		ImageIcon icon = new ImageIcon("D:\\CodeSoft\\CodeSoft\\images\\s1.jpg");
		
		JLabel label = new JLabel(icon);
		label.setText("Student");
		label.setBounds(0,0,500,570);
		getContentPane().add(label);
		setTitle("Student Managment System");
		
		b1=new JButton("Add Student");
		label.add(b1);
		b2=new JButton("Delete Student");
		label.add(b2);
		b3=new JButton("Display All Student");
		label.add(b3);
		b4=new JButton("Search");
		label.add(b4);
		b5=new JButton("Close");
		label.add(b5);
				
		b1.setBounds(180,80,150,40);
		b1.addActionListener(this);
		b2.setBounds(180,160,150,40);
		b2.addActionListener(this);
		b3.setBounds(180,240,150,40);
		b3.addActionListener(this);
		b4.setBounds(180,320,150,40);
		b4.addActionListener(this);
		b5.setBounds(180,400,150,40);
		b5.addActionListener(this);
		
		setSize(500,570);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Home h =new Home();
		h.setVisible(true);
		h.setSize(500,570);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Add Student")) {
			@SuppressWarnings("unused")
			AddStudent st = new AddStudent();
		}
		if(s.equals("Delete Student")) {
			@SuppressWarnings("unused")
			DeleteStudent dt = new DeleteStudent();
		}
		
		if(s.equals("Search")) {
			@SuppressWarnings("unused")
			SearchStudent ss= new SearchStudent();
		}
		
		if(s.equals("Display All Student")) {
			@SuppressWarnings("unused")
			DisplayAll da = new DisplayAll();
		}
		
		if(s.equals("Close")) {
			dispose();
		}
	}
}
