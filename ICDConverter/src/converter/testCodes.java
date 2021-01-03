package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class testCodes {
	
    public static void main( String[] args ) throws IOException {
    	
    	ICDDictionary testDictionary = new ICDDictionary();
    	testDictionary.searchListDiagnosis("coronary artery disease");
    	
    	//Could stand to clean this all up and rename variables/functions
    	//Figure out how to implement into ICDCode app after updating UI
    	
    	System.out.println("----------------------------------------------");
    	
        Document doc = null;
        
        ArrayList<String> siteList = new ArrayList<String>();
        
        //manual addition of site for testing
        //siteList.add("https://www.icd10data.com/ICD10CM/Codes/Z00-Z99/Z77-Z99/Z96-/Z96.651");
        
        siteList = searchGoogle("right total hip arthroplasty");
        
        try {
        	//URL for ICD 10 website
        	doc = Jsoup.connect(siteList.get(0)).get();
		} catch (IOException e) {
			System.out.println("Couldn't fetch document...");
			e.printStackTrace();
		}
        
        //identifier is the class in html file that contains the ICD code
        Elements identifier = doc.getElementsByClass("identifier");
        identifier.toArray();
        System.out.println(parseIdentifier(identifier.get(0).toString()));
        
        Elements bodyContent = doc.getElementsByClass("body-content");
        String unformattedSynonyms = bodyContent.toString();
        
        int synonymStart = unformattedSynonyms.indexOf("Approximate Synonyms");
        
        //Start substring at "Approximate Synonym"
        unformattedSynonyms = unformattedSynonyms.substring(synonymStart);
        //Need second statement ensure </ul> is the one selected AFTER "Approximate Synonym" and not before
        unformattedSynonyms = unformattedSynonyms.substring((unformattedSynonyms.indexOf("<ul>") + 4 ), 
        		unformattedSynonyms.indexOf("</ul>"));
        
        //System.out.println("UNFORMATTED SYNONYMS ------------------------------");
        //System.out.println(unformattedSynonyms);
        
        ArrayList<String> formattedSynonyms = new ArrayList<String>();
        
        formattedSynonyms = parseSynonyms(unformattedSynonyms);
        
        //System.out.println(siteList.toString());
        System.out.println("Approximate Synonyms");
        
        for (int i = 0; i < formattedSynonyms.size(); i++) {
        	System.out.println(formattedSynonyms.get(i));
        }
        
    }
    
    public static ArrayList<String> parseSynonyms(String synonyms) {
    	
    	//currently only parses from icd10data.com
    	
    	ArrayList<String> formattedSynonyms = new ArrayList<String>();
    	
    	//Split string at new lines into array
    	String[] synonymArray = synonyms.split("\r\n | \n | \r");
    	
    	for (int i = 0; i < synonymArray.length; i++) {
    		try {
    			//remove tags from start and end
    			formattedSynonyms.add(synonymArray[i].substring(5, ((synonymArray[i].length())-5)));
    		} catch (Exception e) {
    		}
    	}
    	
    	//System.out.println(formattedSynonyms.toString());
    	
    	return formattedSynonyms;
    }
    
    public static String parseIdentifier(String identifier) {
    	
    	String formattedCode = identifier.substring((identifier.indexOf('>')+1), identifier.lastIndexOf('<'));
    	
    	return formattedCode;
    }
    
    public static ArrayList<String> searchGoogle(String searchEntry) throws IOException {
    	
    	try {
    		//replace spaces in search entry with '+' to validate search URL
    		searchEntry = searchEntry.replace(' ', '+');
    	} catch (Exception e) {
    		System.out.println("No spaces to remove from search entry.");
    	}
    	
    	System.out.println("Search entry: " + searchEntry);
    	
    	ArrayList<String> ICDResults = new ArrayList<String>();
    	
    	//NOT MY CODE AFTER THIS POINT-----------------------------------------------------------------
    	
    	//personal API key
    	String key="AIzaSyDkQQbwP33naYfFeWGmR1xlpDHic4LQN84";
        String qry="ICD+10+" + searchEntry;
        URL url = new URL(
                "https://www.googleapis.com/customsearch/v1?key=" + key + 
                "&cx=013036536707430787589:_pqjad5hr1a&q="+ qry + "&alt=json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getInputStream())));
        
        String output;
        //System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {

            if(output.contains("\"link\": \"")){                
                String link = output.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
                //Prints out first page links of google search result
                //System.out.println(link);   
                
                if(link.contains("icd10data.com")) {
                	//Adds only results of icd10data.com to list
                	//Can expand on this with different parsing
                	ICDResults.add(link);
                }
                
            }     
        }
        
        connection.disconnect();
    	
        return ICDResults;
    }
    
}