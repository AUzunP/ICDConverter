package converter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ICDDictionary {
	
	public ArrayList<ICDCode> codesList;
	public String codesFilePath = "codes";
	
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
		
		//THIS HAS TO BE CODES.TXT NOT CODES WHEN EXPORTING INTO .exe
		//DO THE SAME FOR OTHER FILE WRITERSd
		BufferedReader reader = new BufferedReader(new FileReader(codesFilePath));
		
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
	
	public String searchListCode(String codeToSearch) {
		
		codeToSearch = codeToSearch.toUpperCase();
		
		for (int i = 0; i < codesList.size(); i++) {
			if (codesList.get(i).getCode().equals(codeToSearch)) {
				//System.out.println("Code found");
				return codesList.get(i).getCode();
			}
		}
		
		//System.out.println("Code not found");
		return null;
	}
	
	public String searchListDiagnosis(String diagnosisToSearch) {
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
		//user input is done through this function, appendList should be true when done through user input
		codeToAppend = codeToAppend.toUpperCase();
		
		//only false when clearing and re-populating
		if (appendList) {
			appendList(codeToAppend);
		}

		//add code to text file		
		FileWriter writer = new FileWriter(codesFilePath, true);
		writer.write(codeToAppend + "\n");
		writer.close();
		
	}
	
	private void clearDictionary() throws IOException {
		//Should be clearing and re-populating dictionary after every code change
		FileWriter fWriter = new FileWriter(codesFilePath, false);
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
	
	public ArrayList<String> returnDiagnoses(String code) {
		
		return manipulate(code).returnDiagnosis();
		
	}
	
	public void deleteCode(String code) throws IOException {
		//Delete given code
		code = code.toUpperCase();
		
		for (int i = 0; i < codesList.size(); i++) {
			
			if (codesList.get(i).getCode().toUpperCase().equals(code)) {
				codesList.remove(i);
			}
			
		}
		
		clearAndRepopulateDictionary();
		
	}
	
	public ICDCode manipulate(String code) {
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
