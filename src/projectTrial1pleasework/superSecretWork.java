package projectTrial1pleasework;

import java.util.ArrayList;
import java.util.Random;
import java.awt.List;
import java.io.*;

public class superSecretWork {
	
	static int codeKey[] = new int[10];
	
	protected static void codeGenerator () {
		Random rand = new Random(); 		
		for (int i = 0; i < 10; i++) 	{	
			codeKey[i] = rand.nextInt(9)+1;	
			System.out.println(codeKey[i]); }
	}
	
	public static void main (String args[]) {
		codeGenerator();
		
		String fileName1 = "one.txt";
		String fileName2 = "temp.txt";
		
		String location = "C:\\Eclipse\\thirdTrial\\projectTrial1pleasework\\src\\projectTrial1pleasework\\Files\\";
		
		int i = 0;
		
		FileWriter writer = null;
		try {
			writer = new FileWriter(location + fileName2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		try {
			try {
				fin = new FileInputStream(location + fileName1);
			} catch (IOException e) {
				System.out.println(e);
			}
			
			
			
			int counter = 0, stringPos = 0;
			int codeKeyInt = 0, a = 1, b = 2, c = a+b;
			
			do {
				
				System.out.print("here - " + counter + ", c =  " + c );
				
				if (counter == c) {
					System.out.println("  YO  wrote this -  " + codeKey[codeKeyInt] + "\n");
					writer.write(String.valueOf(codeKey[codeKeyInt]));
					a = b;
					b = c;	
					c = a+b;
					codeKey[codeKeyInt++] = 0;
					
					
				} else {
					i = fin.read();
					System.out.print("had to write this -  " + (char)i);
					if (i!=-1) {						
						i+= codeKey[stringPos%10];
						writer.write((char)i);
						System.out.print("    wrote this -  " + (char)i + "\n");
						stringPos++;
					}	
				}
				
				counter++;
				
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
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		//---------- DECODE 
		
//		String fileName3 = "temp4.txt";
//		String fileName4 = "temp2.txt";
//
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		File file = new File(location + fileName3);
//		BufferedReader reader = null;
//		
//		try {
//		    reader = new BufferedReader(new FileReader(file));
//		    String text = null;
//		
//		    while ((text = reader.readLine()) != null) {
//		    	
//		    	if (counter == c && codeKeyInt<10) {
//					i = fin.read();
//					codeKey[codeKeyInt] = list.add(Integer.parseInt(text[counter++]));;
//					System.out.println("cK - " + Integer.valueOf(codeKey[codeKeyInt++]));
//					a = b;
//					b = c;	
//					c = a+b;	
//				} 
//				counter++;
//		    	
//		        
//		    }
//		} catch (FileNotFoundException e) {
//		    e.printStackTrace();
//		} catch (IOException e) {
//		    e.printStackTrace();
//		} finally {
//		    try {
//		        if (reader != null) {
//		            reader.close();
//		        }
//		    } catch (IOException e) {
//		    }
//		}
//		
//		//print out the list
//		System.out.println(list);
//
//
//		
//			
//		 i = 0;
//		
//		
//		try {
//			try {
//				fin = new FileInputStream(location + fileName3);
//			} catch (IOException e) {
//				System.out.println(e);
//			}
//			try {
//				fout = new FileOutputStream(location + fileName4);
//			} catch (IOException e9) {
//				System.out.println("bleh2");
//			}
//			
//			int counter = 0, stringPos = 0;
//			int codeKeyInt = 0, a = 1, b = 2, c = a+b;
//			
//			do {
//				
//				//System.out.print("here - " + counter + ", c =  " + c );
//				
////				if (counter == c && codeKeyInt<10) {
////					i = fin.read();
////					codeKey[codeKeyInt] = (char)i;
////					System.out.println("cK - " + Integer.valueOf(codeKey[codeKeyInt++]));
////					a = b;
////					b = c;	
////					c = a+b;	
////				} 
////				counter++;
//				
//			} while (codeKeyInt<10);
//			
//			a = 1;
//			b = 2;
//			c = a+b;
//			do {
//				
//					i = fin.read();
//					
//					if (counter == c) {
//						a = b;
//						b = c;
//						c = a+b;
//						
//					} 
//					else {
//						if (i!=-1) {						
//							i-= codeKey[stringPos%10];
//							fout.write((char)i);
//							System.out.println("    wrote this -  " + (char)i + "\n");
//							stringPos++;
//							}
//						
//					} 
//				
//				counter++;
//				
//			} while(i!=1);
//			
//		} 		catch (IOException e8) {
//			System.out.println("bleh");
//		}		 finally {
//			try { 
//				if (fin!=null) fin.close();
//			} catch (IOException e2) {
//				System.out.println("Error closing the file can't even do that right idiot");
//			}
//			try {
//				if (fout!=null) fout.close();
//			} catch (IOException e2) {
//				System.out.println("Error closing the second file can't even do that right idiot");
//			}
//			
//		}		
//
//		
//
//		
		
		


		
		
		
				
	}

}

