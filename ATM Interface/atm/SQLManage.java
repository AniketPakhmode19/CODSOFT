package atm;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManage {
	Connection con;
	
	SQLManage()throws SQLException{
		@SuppressWarnings("unused")
		String usr = "root";
		@SuppressWarnings("unused")
		String pass = "root";
		@SuppressWarnings("unused")
		String url = "jdbc:mysql://localhost:3306/atm?useSSL=false";
		con =  DriverManager.getConnection(url,usr,pass);		
	}
	
	public ResultSet check(String usr,String pass) throws SQLException{
		String str = "SELECT * FROM users WHERE card='"+usr+"'And pin='"+pass+"'";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		return rst;
	}
	
	public void deposit(int amt,int id) throws SQLException{
		String str = "UPDATE users SET bal = bal+'"+amt+"'WHERE id="+id;
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
		int bal = balCheck(id);
		str = "INSERT into transactions(id,amount,stat,bal)VALUES("+id+","+amt+",'dep',"+bal+")";
		Statement stm2 = con.createStatement();
		stm2.executeUpdate(str);
	}
	
	public int withdraw(int amt,int id) throws SQLException{
		int bal = balCheck(id);
		if(bal>=amt) {
			String str = "UPDATE users SET bal=bal-'"+amt+"'WHERE id="+id;
			Statement stm = con.createStatement();
			stm.executeUpdate(str);
			bal-=amt;
			str = "INSERT INTO transactions(id,amount,stat,bal)VALUES("+id+","+amt+",'wit',"+bal+")";
			Statement stm2 = con.createStatement();
			stm2.executeUpdate(str);
			return 1;
		}
		return 0;
	}
	
	public void pinchange(String pin,int id) throws SQLException{
		String str = "UPDATE users SET pin='"+pin+"'WHERE id="+id;
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}
	
	public int balCheck(int id) throws SQLException{
		String str = "SELECT bal FROM users where id="+id;
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		rst.next();
		return rst.getInt("bal");
	}
	
	public ResultSet stmt(int id) throws SQLException{
		String str = "SELECT * FROM transactions where id='"+id+"'order by transid desc";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		return rst;
	}
	
	public void adding(String card,String pin,String name,String bal)throws SQLException{
		String str = "INSERT INTO users(card,pin,uname,bal)values('"+card+"','"+pin+"','"+name+"',"+bal+")";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}
	
	public void delete(String card)throws SQLException{
		 String str = "DELETE FROM users WHERE card = ?";
	        PreparedStatement stm = con.prepareStatement(str);
	        stm.setString(1, card);
	        stm.executeUpdate();
	        stm.close();
	}

}
