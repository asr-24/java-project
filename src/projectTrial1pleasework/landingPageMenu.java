package projectTrial1pleasework;

import java.util.*;
class landingPageMenu {
	
	String username, name;
	
	landingPageMenu (String username) {
		this.username = username;
	};
	
	public void menu (loginAndSignup obj) {
		Scanner sc = new Scanner(System.in);
		name = obj.giveUserName(username);
		
		
		quotePrint q = new quotePrint();
		q.quotePrintFunction();
		
		vaultFilesSystem vf = new vaultFilesSystem(username, name);
		vf.mainFunction();
		
		
		
		
		
		
		
		
		
		sc.close();
	}
	
	
}