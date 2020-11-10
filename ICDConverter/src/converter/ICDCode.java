package converter;
import java.util.ArrayList;

public class ICDCode {

	private String code;
	private ArrayList<String> diagnoses;
	
	ICDCode(String entry) {
		//For input from codes.txt file
		entry = entry.toUpperCase();
		
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
		entry = entry.toUpperCase();
		
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
		entry = entry.toUpperCase();
		
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
		diagnosisToAdd = diagnosisToAdd.toUpperCase();
		
		this.diagnoses.add(diagnosisToAdd);
	}
	
	public void deleteDiagnosis(String diagnosisToDelete) {
		//Deletes given diagnosis from code object
		diagnosisToDelete = diagnosisToDelete.toUpperCase();
		try {
			for (int i = 0; i < this.diagnoses.size(); i++) {
				if (this.diagnoses.get(i).equals(diagnosisToDelete)) {
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
	
	public ArrayList<String> returnDiagnosis() {
		
		return this.diagnoses;
		
	}
	
	public String diagnosisSearch(String diagnosisToSearch) {
		//Searches associated code object for given diagnosis
		diagnosisToSearch = diagnosisToSearch.toUpperCase();
		
		for (int i = 0; i < this.diagnoses.size(); i++) {
			if (this.diagnoses.get(i).equals(diagnosisToSearch)) {
				//System.out.println(diagnosisToSearch + " exists for the code " + this.code);
				return this.code;
			}
		}
		
		//System.out.println(diagnosisToSearch + " is not an existing key for the code " + this.code);
		return null;
	}

	public String getFormattedCode() {
		//follows I10{Hypertension, HTN, High blood pressure} format
		String formattedCode = "";
		
		formattedCode += (this.getCode() + "{");
		
		for (int i = 0; i < this.diagnoses.size(); i++) {
			formattedCode += (this.diagnoses.get(i) + ", ");
		}
		
		//removing last comma
		formattedCode = formattedCode.substring(0, formattedCode.length()-2);
		formattedCode = (formattedCode + "}");
		
		System.out.println(formattedCode);
		
		return formattedCode;
	}
	
	public void changeCode(String newCode) {
		//Change the code, for example I11.0 to I10
		this.code = newCode;
	}
	
}
