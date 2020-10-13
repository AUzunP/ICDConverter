package converter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ICDDictionary {
	
	private ArrayList<ICDCode> codesList;
	
	public ICDDictionary() {
		//TODO
		//add function that gets access to specific ICD code in order to modify it
		
		codesList = new ArrayList<ICDCode>();
		
		//Entry should be as follows: I10{Hypertension, HTN, High blood pressure}
		ICDCode	newCode = new ICDCode("I25.10{CAD, Coronary Artery Disease}");
		codesList.add(newCode);
		newCode = new ICDCode("N39.0", "UTI");
		codesList.add(newCode);
		newCode = new ICDCode("E78.5{HLD, High blood cholesterol}");
		codesList.add(newCode);
		newCode = new ICDCode("I10{HTN, Hypertension, High Blood Pressure}");
		codesList.add(newCode);
		
//		searchList("CAD");
//		searchList("HLD");
//		searchList("UTI");
//		searchList("High blood cholesterol");

		readList();
		
	}

	public void populateDictionary() throws IOException {
		//Reads all lines in codes.txt and converts them to a format that is then
		//used to populate the dictionary with codes and the associated diagnoses
		
		BufferedReader reader = new BufferedReader(new FileReader("codes.txt"));
		
		String textContents = "";
		String line;
		
		while ((line = reader.readLine()) != null) {
			textContents += line;
			textContents += " ";
		}
		
		System.out.println(textContents);
		
		reader.close();
		
	}
	
	public void appendList(String codeToAppend) {
		ICDCode newCode = new ICDCode(codeToAppend);
		codesList.add(newCode);
		//add code to text file
	}
	
	public void readList() {
		//Reads all codes and their associated diagnoses
		for (int i = 0; i < codesList.size(); i++) {
			codesList.get(i).readDiagnosis();
		}
	}
	
	public boolean searchList(String diagnosisToSearch) {
		//Searches entire dictionary for the given diagnosis to see if it is associated with a code
		
		for (int i = 0; i < codesList.size(); i++) {
			if(codesList.get(i).diagnosisSearch(diagnosisToSearch)) {
				return true;
			}
		}
		
		return false;
		
	}
	
}
