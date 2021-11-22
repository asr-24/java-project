package projectTrial1pleasework;

import java.io.*;

public class filesTrial {
	
	
	
	public static void readFile (String fileName1, String fileName2) {
		String location = "C:\\Eclipse\\thirdTrial\\projectTrial1pleasework\\src\\projectTrial1pleasework\\Files\\";
		int i;
		FileInputStream fin = null;
		FileOutputStream fout = null;

		
		try {
			try {
				fin = new FileInputStream(location + fileName1);
			} catch (IOException e) {
				System.out.println(e);
			}
			try {
				fout = new FileOutputStream(location + fileName2);
			} catch (IOException e9) {
				System.out.println("bleh2");
			}
			
			
			do {
				i = fin.read();
				if (i != -1) { System.out.print((char)i); fout.write(i); }
			} while (i!=-1);
			
		} 		catch (IOException e8) {
			System.out.println("bleh");
		}		 finally {
			try { 
				if (fin!=null) fin.close();
			} catch (IOException e2) {
				System.out.println("Error closing the file can't even do that right idiot");
			}
			try {
				if (fout!=null) fout.close();
			} catch (IOException e2) {
				System.out.println("Error closing the second file can't even do that right idiot");
			}
		}		
		
	}
	
	public static void main (String args[]) {
		System.out.println(System.getProperty("user.dir"));
		readFile("one.txt", "two.txt");
	}

}
