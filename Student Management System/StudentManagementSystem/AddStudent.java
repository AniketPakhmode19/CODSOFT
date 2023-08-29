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
public class AddStudent extends JFrame implements ActionListener {
	JTextField t1,t2,t3,t4,t5,t6;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,icon;
	Container con;
	
	public AddStudent() {
		
		con=getContentPane();
		ImageIcon icon = new ImageIcon("D:\\CodeSoft\\CodeSoft\\images\\s3.jpg");
		JLabel label = new JLabel(icon);
		label.setText("Student Managment Sysstem");
		label.setBounds(0,0,500,570);
		getContentPane().add(label);
		setTitle("Add Student Details");
		
		l1=new JLabel("Name");
		label.add(l1);
		l2=new JLabel("Roll No");
		label.add(l2);
		l3=new JLabel("Grade");
		label.add(l3);
		l4=new JLabel("Mobile No");
		label.add(l4);
		l5=new JLabel("City");
		label.add(l5);
		l6=new JLabel("Gender");
		label.add(l6);
		
		l7=new JLabel("");
		label.add(l7);
		l7.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		l1.setBounds(100,100,140,30);
		l2.setBounds(100,140,140,30);
		l3.setBounds(100,180,140,30);
		l4.setBounds(100,220,140,30);
		l5.setBounds(100,260,140,30);
		l6.setBounds(100,300,140,30);
		l7.setBounds(130,350,400,60);
		
		t1=new JTextField();
		label.add(t1);
		t2=new JTextField();
		label.add(t2);
		t3=new JTextField();
		label.add(t3);
		t4=new JTextField();
		label.add(t4);
		t5=new JTextField();
		label.add(t5);
		t6=new JTextField();
		label.add(t6);
		
		t1.setBounds(170,100,140,30);
		t2.setBounds(170,140,140,30);
		t3.setBounds(170,180,140,30);
		t4.setBounds(170,220,140,30);
		t5.setBounds(170,260,140,30);
		t6.setBounds(170,300,140,30);
		
		JButton add,delete,close;
		add=new JButton("Add");
		label.add(add);
		delete=new JButton("Delete");
		label.add(delete);
		close=new JButton("Cancel");
		label.add(close);
		
		add.setBounds(10, 420, 120, 50);
		add.addActionListener(this);
		
		delete.setBounds(180,420,120,50);
		delete.addActionListener(this);
		
		close.setBounds(360,420,120,50);
		close.addActionListener(this);
		
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
		if(s.equals("Add")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Drivers loaded successfully !");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?useSSL=false","root","root");
				System.out.println("Connection Established !");
				String sql = "insert into AddStudent values(?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, t1.getText());
				ps.setInt(2,Integer.parseInt(t2.getText()));
				ps.setString(3, t3.getText());
				ps.setString(4, t4.getText());
				ps.setString(5, t5.getText());
				ps.setString(6, t6.getText());
				
				int rs = ps.executeUpdate();
				
				if(rs > 0) {
					l7.setText("Student Record Added Successfully !");
				}					
				else 
					l7.setText("ERROR (Record not added !)");
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				
				ps.close();
				con.close();
			} 
			catch (Exception e1) {
				// TODO Auto-generated catch block
				l7.setText("All Filed Required.");
				l7.setBounds(170,360,200,30);
				System.out.println("Student Record Not Added ...");
				e1.printStackTrace();
			}		
		}
		
		if(s.equals("Cancel")) {
			dispose();
		}
	
		if(s.equals("Delete")) {
			@SuppressWarnings("unused")
			DeleteStudent d = new DeleteStudent();
		}
	}
}
