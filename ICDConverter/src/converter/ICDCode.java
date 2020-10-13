package converter;
import java.util.ArrayList;

public class ICDCode {

	private String code;
	private ArrayList<String> diagnoses;
	
	ICDCode(String code, String initialDiagnosis) {
		//For user input
		//TODO
		//Make it so that the search function is not case sensitive and any added
		//is added in lower-case. Maybe make use of separate function
		
		this.diagnoses = new ArrayList<String>();
		this.code = code;
		this.diagnoses.add(initialDiagnosis);
		
	}
	
	ICDCode(String entry) {
		//For input from codes.txt file
		this.diagnoses = new ArrayList<String>();
		
		ArrayList<String> diagnosesArray = new ArrayList<String>();
		
		//Format function automatically adds ICD code to new object
		diagnosesArray = format(entry);
		
		//Adds all diagnoses from diagnoses array to this ICDCode object
		for (int i = 0; i < diagnosesArray.size(); i++) {
			this.diagnoses.add(diagnosesArray.get(i));
		}
		
	}
	
	private ArrayList<String> format(String entry) {
		//Entry should be as follows: I10{Hypertension, HTN, High blood pressure}
		ArrayList<String> codes = new ArrayList<String>();
			
		//grab ICD code from entry
		this.code = formatCode(entry);
		
		String tempCode = "";
		//Get string in between { and } which are the diagnoses
		entry = entry.substring(entry.indexOf('{') + 1, entry.indexOf('}'));
		
		//Separate every string of diagnoses
		for (int i = 0; i < entry.length(); i++) {
			
			//do not include commas in diagnoses
			if(entry.charAt(i) != ',') {
				tempCode += entry.charAt(i);
			}
			
			if (entry.charAt(i) == ',' || i+1 == entry.length()) {
				//remove start and end spaces
				tempCode = tempCode.trim();
				codes.add(tempCode);
				tempCode = "";
			}
		}
		
		return codes;
	}
	
	private String formatCode(String entry) {
		//Goes through string until it hits { and enters the previous string as ICD code
		String code = "";
		
		for (int i = 0; i < entry.length(); i++) {
			if (entry.charAt(i) != '{') {
				code += entry.charAt(i);
			} else {
				return code;
			}
		}
		
		return code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void addDiagnosis(String diagnosisToAdd) {
		//Determine whether string given is single key or bunch of keys separated by commas
		//Might just call format function but without {}
		//Adds given diagnosis to code object
		this.diagnoses.add(diagnosisToAdd);
	}
	
	public void deleteDiagnosis(String diagnosisToDelete) {
		//Deletes given diagnosis from code object
		
		try {
			for (int i = 0; i < this.diagnoses.size(); i++) {
				if (this.diagnoses.get(i) == diagnosisToDelete) {
					System.out.println("Successfully removed " + this.diagnoses.get(i));
					this.diagnoses.remove(i);
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("Removing diagnosis failed. DNE or other reason.");
			return;
		}
		
	}
	
	public void readDiagnosis() {
		//Reads out all diagnoses associated with the code object
		System.out.println("-----------------------------------------------------");
		System.out.println("The diagnoses associated with " + this.code + " are: ");
		for (int i = 0; i < this.diagnoses.size(); i++) {
			System.out.println(this.diagnoses.get(i));
		}
		
	}
	
	public boolean diagnosisSearch(String diagnosisToSearch) {
		//Searches associated code object for given diagnosis
		for (int i = 0; i < this.diagnoses.size(); i++) {
			if (this.diagnoses.get(i).equals(diagnosisToSearch)) {
				System.out.println(diagnosisToSearch + " exists for the code " + this.code);
				return true;
			}
		}
		
		//System.out.println(diagnosisToSearch + " is not an existing key for the code " + this.code);
		return false;
	}
	
}
