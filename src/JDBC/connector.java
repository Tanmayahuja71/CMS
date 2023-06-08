package JDBC;

	import java.sql.Connection;
	import java.sql.DriverManager;
	public class connector {
	    public static void main(String[] args) {
	        try {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Ranjana@999");
	            System.out.println(con);
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	        System.out.println("Successfully connected");
	    }
	}

