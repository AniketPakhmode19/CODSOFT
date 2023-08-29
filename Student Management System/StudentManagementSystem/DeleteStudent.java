package StudentManagementSystem;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DeleteStudent extends JFrame implements ActionListener {
	
	JLabel l1,l2;
	JTextField t1;
	JButton b1,b2;
	Container con;
	
	public DeleteStudent() {
		
		con = getContentPane();
		
		ImageIcon icon = new ImageIcon("D:\\CodeSoft\\CodeSoft\\images\\s4.jpg");
		
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,500,570);
		getContentPane().add(label);
		setTitle("Delete Student Record");
		
		l1=new JLabel("Student Roll Number : ");
		label.add(l1);
		l1.setBounds(100,140,140,30);
		
		l2=new JLabel();
		label.add(l2);
		l2.setBounds(150,260,200,30);
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		t1=new JTextField();
		label.add(t1);
		t1.setBounds(250,140,140,30);
		
		b1=new JButton("Delete Student");
		label.add(b1);
		b1.setBounds(100,200,140,30);
		b1.addActionListener(this);
		
		b2=new JButton("Back");
		label.add(b2);
		b2.setBounds(250,200,140,30);
		b2.addActionListener(this);

		
		setSize(500,570);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Delete Student")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Drivers loaded successfully !");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?useSSL=false","root","root");
				System.out.println("Connection Established !");
				String s1;
				
				s1=t1.getText();
				
				String sql = "delete from AddStudent where rollno=(?)";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1,s1);

				
				int rs = ps.executeUpdate();
				
				System.out.println("Student Deleted Successfully...");
				if(rs>0) {
					l2.setText("Deleted Successfully");
				}
				else {
					l2.setText("Record NOT Found");
				}
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}	
		
		if(s.equals("Back")) {
			dispose();
		}
		
	}
}


