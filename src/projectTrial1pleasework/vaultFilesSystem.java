package projectTrial1pleasework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.awt.Desktop;
import java.awt.desktop.*;


@SuppressWarnings("unused")
public class vaultFilesSystem {
	
	String username, name;
	
	vaultFilesSystem(String username, String name) {
		this.username = username;
		this.name = name;
	}
	
	public void makeNewEntry () {
		
				
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter the name of the file you wish to add to your database > ");
		String fileName = sc.next();
		
		String ID = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		
			
		Connection connection;
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/first_jdbcthing","root","toor");
			Statement statement = connection.createStatement();
			String addThese = "\"" + ID + "\", \"" + fileName + "\", \"" + username + "\"";  
			statement.executeUpdate("INSERT INTO files VALUES (" + addThese +");");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void displayFileHeader(int n, String fileName) {
		String location = "C:\\Eclipse\\thirdTrial\\projectTrial1pleasework\\src\\projectTrial1pleasework\\Files\\";
		FileInputStream fin = null;
		
		System.out.print(n + " - ");
					
		try {
			try {
				fin = new FileInputStream(location + fileName);
			} catch (IOException e) {
				System.out.println(e);
			}
						
			int i = 0, stringPos = 0;
						
			do {				
					i = fin.read();
					System.out.print((char)i);
					stringPos++;
				
			} while (i!=-1 && stringPos<20);
			
			System.out.println("...");
			
		} 	catch (IOException e8) {
			System.out.println("bleh");
		}	finally {
			try { 
				if (fin!=null) fin.close();
			} catch (IOException e2) {
				System.out.println("Error closing the file can't even do that right idiot");
			}
		}
	}
	
	public void openFiles (String ID) {
		Scanner sc = new Scanner(System.in);
		String location = "C:\\Eclipse\\thirdTrial\\projectTrial1pleasework\\src\\projectTrial1pleasework\\Files\\";
		Connection connection;
		
		String fileName = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/first_jdbcthing","root","toor");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from files where ID = \"" + ID + "\"");
			int l = 0;
			while (resultset.next()) {
				
				fileName = resultset.getString("fileName");
				
				char timestampArr[] = new char[20];
				int j = 0, k = 0;
				
				for (int i = 0; i < 19; i++) {
					if (i == 4 || i == 7) timestampArr[j++] = '/';
					else if (i == 10) timestampArr[j++] = ' ';
					else if (i == 13 || i == 16) timestampArr[j++] = ':';
					else {
						timestampArr[j++] = ID.charAt(k++); 
					}
				}
				
				String timestamp = new String(timestampArr);
				
				FileInputStream fin = null;
				
				if (l++ == 0) {
					
					System.out.println("\n\nYour entry for " + timestamp + "... ");
					
					try {
						try {
							fin = new FileInputStream(location + fileName);
						} catch (IOException e) {
							System.out.println(e);
						}
									
						int i = 0;
									
						do {				
								i = fin.read();
								System.out.print((char)i);
							
						} while (i!=-1);
						
						
						
					} 	catch (IOException e8) {
						System.out.println("bleh");
					}	finally {
						try { 
							if (fin!=null) fin.close();
						} catch (IOException e2) {
							System.out.println("Error closing the file can't even do that right idiot");
						}
					}
					
					
				}
				
		
		
			}
			
			System.out.print("\n\n\nWant to open this file for editing? Enter 1 to continue > ");
			int ch = sc.nextInt();
			
			if (ch == 1) {
				File file = new File (location + fileName);
				Desktop desktop = Desktop.getDesktop();
				if (file.exists())
					try {
						desktop.open(file);
						return;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void mainFunction () {
		
		Scanner sc = new Scanner(System.in);
		
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/first_jdbcthing","root","toor");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from files where username = \"" + username + "\"");
			int count = 1;
			while (resultset.next()) {
				try {
					displayFileHeader(count++, resultset.getString("fileName"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 				
			}
			
			resultset = statement.executeQuery("select * from files where username = \"" + username + "\"");
			
			if (count>1) {
				System.out.print("Wish to open these entries? Enter 1 > ");
				int ch1 = sc.nextInt();
				if (ch1 == 1) {
					System.out.print("Enter the serial number of the entry you wish to see > ");
					int tempID = sc.nextInt();
					int p = 0;
					
					while (resultset.next()) {
						try {
							if (p == tempID-1) {
								openFiles(resultset.getString("ID"));
							} else p++;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 				
					}
					
				}
				
			}
			
			if (count == 1) {
				System.out.println("No files found! Let's make you a new one!");
				makeNewEntry(); mainFunction();
			} else {
				System.out.print("Let's make a new entry for today? Enter 1 to continue > ");
				int ch = sc.nextInt();
				if (ch == 1) { makeNewEntry(); mainFunction();}
				
			}
			
			
		} catch (SQLException Illegaloperationonemptyresultset) {
			// TODO Auto-generated catch block
			//System.out.println("What");
			makeNewEntry();
			mainFunction();
		}
		
		
	}

}
