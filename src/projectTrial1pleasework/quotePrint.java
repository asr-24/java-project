package projectTrial1pleasework;

import java.util.Random;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

@SuppressWarnings("unused")
public class quotePrint {
	
	public String scraper() {

		Document doc = null;

		try {
			doc = Jsoup.connect("https://www.keepinspiring.me/positive-quotes-and-sayings/").get();
			Elements quotes = doc.getElementsByTag("p");
			String quotesArr[] = new String[60];
						
			for (int i = 6, j = 0; i < 66; i++, j++) 
				quotesArr[j] = quotes.get(i).text();
			
			Random rand = new Random(); 
		      return (quotesArr[rand.nextInt(60)]); 
		} catch (Exception e) {
			System.out.println(" ");
		}
		
		return ("");

	}

	
	public void quotePrintFunction () {
		System.out.println("\n\n ~ " + scraper() + " ~ \n");
	}

}
