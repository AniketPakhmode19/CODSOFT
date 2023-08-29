package StudentManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class DisplayAll extends JFrame implements ActionListener{

	DefaultTableModel model=new DefaultTableModel();
	JFrame frame=new JFrame("Display All");
	JTable jtbl=new JTable(model);

	JButton b1;
	
	public DisplayAll() {
		model.addColumn("Name");
		model.addColumn("Roll Number");
		model.addColumn("Grade");
		model.addColumn("Mobile no");
		model.addColumn("City");
		model.addColumn("Gender");
		
		b1=new JButton("Back");
		add(b1);
		b1.setBounds(180, 420, 120, 30);
		b1.addActionListener(this);
		
		setSize(500,570);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers loaded successfully !");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?useSSL=false","root","root");
			System.out.println("Connection Established !");
			
			String sql="select * from AddStudent";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6)});
			}
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JScrollPane pg =new JScrollPane(jtbl);
		pg.setBounds(20,5,450,400);
		pg.setOpaque(false);
		pg.getViewport().setOpaque(false);
		getContentPane().setLayout(null);
		add(pg);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sa = e.getActionCommand();
		if(sa.equals("Back")) {
			dispose();
		}
	}
}


