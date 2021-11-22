package projectTrial1pleasework;

//import java.io.*;

public class mainApp {
	
		
	public static void main (String args[]) {
		
		String username = " ", name = " ";
		
		loginAndSignup obj1 = new loginAndSignup();
		username = obj1.mainFunction();
				
		name = obj1.giveUserName(username);
		
		quotePrint q = new quotePrint();
		q.quotePrintFunction();
		
		
		vaultFilesSystem vf = new vaultFilesSystem(username, name);
		vf.mainFunction();
		
		
		
		
		
		
//		privateVaultFilesSystem pvf = new privateVaultFilesSystem(username, name);
//		pvf.mainFunction();
		

	}

}
