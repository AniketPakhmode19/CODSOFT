package StudentManagementSystem;

import java.awt.Container;
import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SearchStudent extends JFrame implements ActionListener {
	
	JLabel l1,l2;
	JTextField t1;
	JButton b1,b2;
	Container con;
	
	
	public SearchStudent() {
		
		con = getContentPane();
		ImageIcon icon = new ImageIcon("D:\\CodeSoft\\CodeSoft\\images\\s2.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,500,570);
		getContentPane().add(label);
		setTitle("Search Student");
		
		
		l1=new JLabel("Roll Number");
		label.add(l1);
		l1.setBounds(100,140,140,30);
		
		l2=new JLabel("");
		label.add(l2);
		l2.setBounds(120,230,450,100);
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		t1=new JTextField();
		label.add(t1);
		t1.setBounds(200,140,140,30);
		
		b1=new JButton("Search");
		label.add(b1);
		b1.setBounds(100,200,120,30);
		b1.addActionListener(this);
		
		b2=new JButton("Close");
		label.add(b2);
		b2.setBounds(250,200,120,30);
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
		if(s.equals("Search")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Drivers loaded successfully !");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?useSSL=false","root","root");
				System.out.println("Connection Established !");
				
				String s1=t1.getText();
				@SuppressWarnings("unused")
				Statement st=con.createStatement();
				String sql = "select * from AddStudent where rollno=(?)";
				PreparedStatement ps = con.prepareStatement(sql);
		
				ps.setString(1,s1);
				
				ResultSet rs = ps.executeQuery();

				if(rs.next()) {
					JOptionPane.showMessageDialog(null, " Name : "+rs.getString(1)+"\n"+
							" Roll No : "+rs.getInt(2)+"\n"+
							" Grade : "+rs.getString(3)+"\n"+
							" Mobile NO : "+rs.getString(4)+"\n"+
							" City : "+rs.getString(5)+"\n"+
							" Gender : "+rs.getString(6));
				}
				else {
					l2.setText("Student Record Not Found");
				}
			} 
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(s.equals("Close")) {
			dispose();
		}
	}
}


