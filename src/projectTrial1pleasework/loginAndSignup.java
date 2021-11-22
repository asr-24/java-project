package projectTrial1pleasework;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


public class loginAndSignup {
			
	@SuppressWarnings("finally")
	public int checkUsername (String s, int which) {
		if (which == 0) {
			//System.out.println("1done");
		int flag = 0;
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/first_jdbcthing","root","toor");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from logincreds");
					
			while(resultset.next()) {
				if (s.equals(resultset.getString("username")) == true) {
					
					flag = 1; break;
				} 
			}
			
		 }
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == 0) return 0;
			else return 1;
		}
		
	}
		return 9;
}
		
	@SuppressWarnings("finally") 
	public  int checkPassword (String p, String s) {
		int flag = 0;
		try {
			
					
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/first_jdbcthing","root","toor");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from logincreds");
					
			while(resultset.next()) {
				if (s.equals(resultset.getString("username")) == true && p.equals(resultset.getString("password")) == true) {
					
					flag = 1; break;
				} 
			}
			
		}
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == 0) return 0;
			else return 1;
		}
		
	}
	
	public  String giveUserName (String s) {
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/first_jdbcthing","root","toor");
			Statement statement = connection.createStatement();
			ResultSet resultset = (ResultSet) statement.executeQuery("select logincreds.name, logincreds.username from logincreds where logincreds.username = \"" + s + "\"");
					
			while(resultset.next()) {
				
					return (resultset.getString("name"));
				
			}
			
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		
		return (" ");
		
	}
	
	public  char[] passwordGenerator (int length) {
		     String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		     String non_caps= "abcdefghijklmnopqrstuvwxyz";
		     String chars = "!@#$^&*";
		     String nos = "1234567890";
		     String total = caps + non_caps + chars + nos;
		     Random random = new Random();
		     char[] password = new char[length];

		     password[0] = non_caps.charAt(random.nextInt(non_caps.length()));
		     password[1] = caps.charAt(random.nextInt(caps.length()));
		     password[2] = chars.charAt(random.nextInt(chars.length()));
		     password[3] = nos.charAt(random.nextInt(nos.length()));

		     for(int i = 4; i< length ; i++) {
		        password[i] = total.charAt(random.nextInt(total.length()));
		     }
		     return password;
		  }
	  
	public  int createNewProfile(String name, String username, String password) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/first_jdbcthing","root","toor");
			Statement statement = connection.createStatement();
			String addThese = "\"" + username + "\", \"" + password + "\", \"" + name + "\"";
			statement.executeUpdate("INSERT INTO logincreds VALUES (" + addThese +");");
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public String mainFunction () {
		String username = "";
		String newUsername = "";
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Welcome to ProductiviTea!\t\t");
		LocalDate myObj = LocalDate.now(); 
		System.out.println(myObj);
		System.out.print("\t1. LOGIN (for existing users)\n\t2. SIGNUP (for new users)\n\t > ");
		int ch = sc.nextInt();
		int passedOne = 1;
		while (passedOne == 1) {
		switch(ch) {
		case 1: {
			int cont = 1;
			while (cont == 1) {
			System.out.print("Enter your username > "); username = sc.next(); 
			//System.out.println(username);
			while (true) {
				if (checkUsername(username, 0) == 1) {
					System.out.print("Enter your password > "); String password = sc.next();
					if (checkPassword(password, username) == 1) {
						String name = giveUserName(username);
						System.out.println("Login successful! Welcome to your ProductiviTea account, " + name + "!" );
						cont = 0; 
						passedOne = 0; 
						break;
						
					} else {
						System.out.println("Password incorrect for " + username); 
						System.out.print("Enter 1 to try again for " + username + ", 2 to try for another account, and 0 to exit > "); int ch2 = sc.nextInt();
						if (ch2 == 1) continue;
						else if (ch == 2) break;
						else {cont = 0; break;}
					}
				} else {
					System.out.println("No account found with username - " + username);
					System.out.print("Enter 1 to try again, 0 to exit or \nNew user? Enter 2 to make a new account > "); int ch3 = sc.nextInt();
					if (ch3 == 2 ) {
						ch = ch3;
						cont = 0;
						break;
					} else if (ch3 == 1) {
						break;
					} else {
						cont = 0;
						break;
					}
				}
			}
			
			}
		break;
		} case 2: {
			System.out.println("Hey! Let's make you your own ProductiviTea account!");
			System.out.print("What's your name? > "); String newName = sc.next();
			System.out.print("Create a username for yourself > "); newUsername = sc.next();
			System.out.print("Now you have to make yourself a password, too.\nWant us to make one for you? Enter 1, else enter 0 > ");
			int ch4 = sc.nextInt(); 
			String newPassword;
			if (ch4 == 1) {
				newPassword = new String(passwordGenerator(6));
				System.out.println("Here's the password we made for you - " + newPassword);
			} else {
				System.out.println("Enter your password > "); newPassword = sc.next(); 
			}
			
			while (true) {
				if (createNewProfile(newName, newUsername, newPassword) == 1) {
					System.out.println("User " + newName + " added - " + newUsername);
					passedOne = 0;
					break;
					
				} else {
					System.out.print("Username " + newUsername + " is already in use\nPick another username, please > ");
					newUsername = sc.next();
					continue;					
				}
			}
			
			
		break;
		}
				
	}
	
	}
		
		
		
		if (ch == 1) return (username);
		else return (newUsername);
		
		
	}
	
	
	
}

	
	


