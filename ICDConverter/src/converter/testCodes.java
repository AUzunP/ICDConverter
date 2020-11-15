package converter;
import java.io.IOException;
import java.util.ArrayList;

public class testCodes {
	
	public static void main(String[] args) throws IOException {
		
		ICDDictionary testDictionary = new ICDDictionary();
		testDictionary.searchListDiagnosis("coronary artery disease");
	}

}
