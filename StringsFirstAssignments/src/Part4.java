import java.lang.*;
import edu.duke.*;
public class Part4 {
	
public void findLinks() {   
        URLResource Page = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html"); 
		for ( String word : Page.words() ) {
		    
		    String wordLower = word.toLowerCase();
		    
			if ( wordLower.contains( "youtube.com" ) && ( wordLower.contains( "https://" ) || wordLower.contains( "http://" ) ) ) {
			    
			    int startQuote = wordLower.indexOf("\"");
			    int endQuote = wordLower.lastIndexOf("\"");
			    String youtubeLink = word.substring( startQuote+1, endQuote );
			    System.out.println( youtubeLink );
       
            }
			
		}
        
    }
}
