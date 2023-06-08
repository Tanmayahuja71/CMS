package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnectivity{
	static Connection conn=null;
	public JdbcConnectivity() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String pass = "Ranjana@999";
			conn = DriverManager.getConnection(url,userName,pass);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void createDataBase(String databaseName) {
		try {
			Statement stm = conn.createStatement();
			String query = "create database "+databaseName;
			boolean bool = stm.execute(query);
			if(bool) {
				System.out.println("Successfully Created:");
			}
			else {
				System.out.println("Successfully Created:");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteDataBase(String databaseName) {
		try {
			Statement stm = conn.createStatement();
			String query = "drop database "+databaseName;
			boolean bool = stm.execute(query);
			if(bool) {
				System.out.println("Successfully Created:");
			}
			else {
				System.out.println("Successfully Created:");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String takePassword(String userName){
		String userPass = null;
		try {
			Statement stm = conn.createStatement();
			String query = "select password from login where username='"+userName+"'";
			
			ResultSet rs = stm.executeQuery(query);
			
			
			while(rs.next()) {
				userPass = rs.getString(1);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userPass;
	}
	public void addItem(String itemName,int itemId,String itemUnit,int itemQtyPerUnit,int itemPrice,int itemDiscount,int itemQty) {
		try {
			String query = SqlQuery.addStockQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1,itemName);
			preparedStatement.setInt(2,itemId);
			preparedStatement.setString(3,itemUnit);
			preparedStatement.setInt(4,itemQtyPerUnit);
			preparedStatement.setInt(5,itemPrice);
			preparedStatement.setInt(6,itemDiscount);
			preparedStatement.setInt(7,itemQty);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void AddEmpDetails(int ID,String First_Name,String Last_Name,long Phone_No,String Email_Id,String Password) {
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.addEmpDetailsQuery;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,ID);
			preparedStatement.setString(2,First_Name);
			preparedStatement.setString(3,Last_Name);
			preparedStatement.setLong(4,Phone_No);
			preparedStatement.setString(5,Email_Id);
			preparedStatement.setString(6,Password);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String FetchPassword(int ID) {
		
		String pass = null;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.fetchPassQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,ID);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			
			while(rs.next()) {
				pass = rs.getString(1);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return pass;
	}
	public boolean DeleteEmpAccount(int ID) {
		boolean flag = true;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.deleteEmpAccountQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,ID);
			
			flag = preparedStatement.execute();
			System.out.println(flag);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public void AddStockDetails(String name,int id,int qty,String unit,int price,int discount,int stock) {
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.addStockQuery;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setInt(3,qty);
			preparedStatement.setString(4,unit);
			preparedStatement.setInt(5,price);
			preparedStatement.setInt(6,discount);
			preparedStatement.setInt(7,stock);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	public boolean DeleteIteam(int PRODUCT_ID) {
		boolean flag = true;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.deleteIteamQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,PRODUCT_ID);
			
			flag = preparedStatement.execute();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public void UpdateTotalStock(String productName, int TOTAL_STOCK) {
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.addToatlStockQuery;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,TOTAL_STOCK);
			preparedStatement.setString(2,productName);
			
			preparedStatement.execute();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void UpdateMRP(String productName,int MRP) {
		
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.modifyPriceQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,MRP);
			preparedStatement.setString(2,productName);
			
			preparedStatement.execute();
			preparedStatement.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
public void UpdateDiscount(String productName,int discount) {
		
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.modifyDiscountQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1,discount);
			preparedStatement.setString(2,productName);
			
			preparedStatement.execute();
			preparedStatement.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
public int[] fetchStatistics() {
	int arr[]= new int[12];
	try {
		Statement stm = conn.createStatement();
		
		String query = "use CMSData";
		stm.execute(query);
		
		
		query = SqlQuery.fetchTodayDataQuery;
		
		
		ResultSet rs = stm.executeQuery(query);
		while(rs.next()) {
			arr[0]=rs.getInt(1);
			arr[1]=rs.getInt(2);
			arr[2]=rs.getInt(3);
		}
		query = SqlQuery.fetchWeekDataQuery;
		
		
		rs = stm.executeQuery(query);
		while(rs.next()) {
			arr[3]=rs.getInt(1);
			arr[4]=rs.getInt(2);
			arr[5]=rs.getInt(3);
		}
		
		query = SqlQuery.fetchHalfYearDataQuery;
		
		
		rs = stm.executeQuery(query);
		while(rs.next()) {
			arr[6]=rs.getInt(1);
			arr[7]=rs.getInt(2);
			arr[8]=rs.getInt(3);
		}
		
		query = SqlQuery.fetchYearDataQuery;
		
		
		rs = stm.executeQuery(query);
		while(rs.next()) {
			arr[9]=rs.getInt(1);
			arr[10]=rs.getInt(2);
			arr[11]=rs.getInt(3);
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return arr;
}
public String[] fetchProductDetails(String productName) {
	String []str= new String[7];
	try {
		Statement stm = conn.createStatement();
		
		String query = "use CMSData";
		stm.execute(query);
		
		
		query = SqlQuery.fetchProductDetailsQuery;
		
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,productName);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			str[0]=Integer.toString(rs.getInt(1));
			str[1]=rs.getString(2);
			str[2]=Integer.toString(rs.getInt(3));
			str[3]=rs.getString(4);
			str[4]=Integer.toString(rs.getInt(5));
			str[5]=Integer.toString(rs.getInt(6));
			str[6]=Integer.toString(rs.getInt(7));
		}
		preparedStatement.close();
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return str;
}
	
	

}
