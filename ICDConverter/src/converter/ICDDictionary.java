package converter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ICDDictionary {
	
	private ArrayList<ICDCode> codesList;
	
	public ICDDictionary() throws IOException {
		//TODO
		//add function that gets access to specific ICD code in order to modify it
		
		codesList = new ArrayList<ICDCode>();
		
		//Entry should be as follows: I10{Hypertension, HTN, High blood pressure}
		
		//System.out.println("Populating list...\n");
		populateList();
		
	}

	public void populateList() throws IOException {
		//Reads all lines in codes.txt and converts them to a format that is then
		//used to populate the list with codes and the associated diagnoses
		
		BufferedReader reader = new BufferedReader(new FileReader("codes.txt"));
		
		String textContents = "";
		String line;
		
		while ((line = reader.readLine()) != null) {
			appendList(line);
			textContents += line;
			textContents += "\n";
		}
		
		//System.out.println(textContents);
		
		reader.close();
		
	}
	
	public void appendList(String codeToAppend) {
		//list is the actual list of ICD codes taken from the dictionary
		codeToAppend = codeToAppend.toUpperCase();
		
		ICDCode newCode = new ICDCode(codeToAppend);
		codesList.add(newCode);
	}
	
	public void readList() {
		//Reads all codes and their associated diagnoses
		for (int i = 0; i < codesList.size(); i++) {
			codesList.get(i).readDiagnosis();
		}
	}
	
	public String searchList(String diagnosisToSearch) {
		//Searches entire dictionary for the given diagnosis to see if it is associated with a code
		diagnosisToSearch = diagnosisToSearch.toUpperCase();
		
		for (int i = 0; i < codesList.size(); i++) {
			String returnCode = codesList.get(i).diagnosisSearch(diagnosisToSearch);
			if(returnCode != null) {
				System.out.println(diagnosisToSearch + " is associated with the code " + returnCode);
				return returnCode;
			}
		}
		
		System.out.println(diagnosisToSearch + " is not associated with any code.");
		return null;	
	}
	
	public void clearAndRepopulateDictionary() throws IOException {
		//clears dictionary and re-populates it with formatted codes
		//taken from existing instantiation of list
		System.out.println("Clearing dictionary...\n");
		clearDictionary();
		
		System.out.println("Repopulating dictionary...\n");
		for (int i = 0; i < codesList.size(); i++) {
			appendDictionary(codesList.get(i).getFormattedCode(), false);
		}
		
	}
	
	public void appendDictionary(String codeToAppend, boolean appendList) throws IOException {
		//dictionary is the text file that contains all the codes that the program takes from at the start
		//when populateDictionary() is called
		codeToAppend = codeToAppend.toUpperCase();
		
		if (appendList) {
			appendList(codeToAppend);
		}
		
		FileWriter writer = new FileWriter("codes.txt", true);
		writer.write(codeToAppend + "\n");
		writer.close();
		
		//add code to text file
	}
	
	private void clearDictionary() throws IOException {
		//Should be clearing and re-populating dictionary after every code change
		FileWriter fWriter = new FileWriter("codes.txt", false);
		PrintWriter pWriter = new PrintWriter(fWriter, false);
		pWriter.flush();
		pWriter.close();
		fWriter.close();
	}
	
	public void deleteDiagnosis(String code, String diagnosis) throws IOException {
		//grabs code object from manipulate function and removes selected diagnosis
		ICDCode toManipulate = manipulate(code);
		diagnosis = diagnosis.toUpperCase();
		
		toManipulate.deleteDiagnosis(diagnosis);
		
		clearAndRepopulateDictionary();
	}
	
	public void addDiagnosis(String code, String diagnosis) throws IOException {
		//grabs code object from manipulate function and adds selected diagnosis
		ICDCode toManipulate = manipulate(code);
		toManipulate.addDiagnosis(diagnosis);
		
		clearAndRepopulateDictionary();
	}
	
	private ICDCode manipulate(String code) {
		//Grab an ICDCode object to manipulate (add/remove diagnosis, etc.)
		code = code.toUpperCase();
		ICDCode toManipulate = null;
		
		for (int i = 0; i < codesList.size(); i++) {
			
			if(codesList.get(i).getCode().toUpperCase().equals(code)) {
				toManipulate = codesList.get(i);
			}
		}
		
		return toManipulate;
	}
	
}
