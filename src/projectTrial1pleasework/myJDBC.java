package projectTrial1pleasework;

import java.sql.*;



public class myJDBC {
	public static void main (String args[]) {
		
		try {
		
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/first_jdbcthing","root","toor");
			Statement statement = connection.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from logincreds");
			
			
			int check = 0;
			
			while(resultset.next()) {
				if (check == 1) {
					int rs = statement.executeUpdate("INSERT INTO logincreds VALUES (\"dboiii\", \"k016rox\", \"Dinesh\");");
					System.out.println(rs);
					String s = resultset.getString("username");
					System.out.println( s + " - " + resultset.getString("password"));	
				} check++;
				
			}
		} catch (Exception e) {
			System.out.println("no");  
		}
	}
}
