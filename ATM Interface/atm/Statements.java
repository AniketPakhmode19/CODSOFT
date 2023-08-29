package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Statements {
	Success success;
	public void stateView(int id)throws SQLException{
		DefaultTableModel model = new DefaultTableModel();
		Commons commons = new Commons();
		JFrame frame = (JFrame)commons.Frame();
		SQLManage manage = new SQLManage();
		success = new Success();
		
		//.................Label...................
		JLabel label = new JLabel("MINI STATEMENTS");
		label.setBounds(0,200,575,30);
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.add(label);
		
		//.................Table....................
		@SuppressWarnings("serial")
		JTable table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model=(DefaultTableModel)table.getModel();
		model.addColumn("ID");
		model.addColumn("DEPOSIT");
		model.addColumn("WITHDRAW");
		model.addColumn("BALANCE");
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(50, 250, 500, 200);
		frame.add(sc);
		
		//..................TableData......................
		ResultSet rst = manage.stmt(id);
		int i=0;
		while(rst.next()) {
			model.addRow(new Object[0]);
			model.setValueAt(rst.getInt("transid"),i,0);
			if(rst.getString("stat").equals("dep")) {
				model.setValueAt(rst.getString("amount"),i,1);
				model.setValueAt("-",i,2);
			}
			else {
				model.setValueAt("-",i,1);
				model.setValueAt(rst.getString("amount"), i, 2);
			}
			model.setValueAt(rst.getInt("bal"),i,3);
			i++;
		}
		success.thankView(id);
		frame.setVisible(true);
		JButton back = new JButton("BACK");
		back.setBounds(250,500,100,30);
		frame.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Home h = new Home();
				try {
					h.homeView(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
