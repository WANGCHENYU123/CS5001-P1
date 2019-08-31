import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is for inserting consonants
 * 
 * @author 180007800
 */
public class InsertConsonants {
	// First capital letter -> Lowercase letter
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	// first lowercase letter -> capital letter
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	// Lowercase letter -> capital letter
	public static String toUpperCase(String s) {
		return s.toUpperCase();
	}

	// Capital letter-> lowercase letter
	public static String toLowerCase(String s) {
		return s.toLowerCase();
	}

	// Insert consonants between the letters and check with the file
	public void InsertConsonants(String FileName, String InputTex) {

		String[] Consonants = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v",
				"w", "x", "y", "z" };
		String[] WordStr = InputTex.split(" ");// divide the InputTex into words
		String[] WordStr1 = InputTex.split(" ");
		// read the file
		ArrayList<String> Vocabulary = new ArrayList<String>();
		FileUtil fileutil = new FileUtil();
		Vocabulary = fileutil.readLines(FileName);
		int flag = 0;// whether have alternatives
		// read file fail
		if (Vocabulary.size() == 0) {
			flag = -1;
			System.out.println("Invalid dictionary, aborting.");
		}

		int count = 0; // count the alternatives
		for (int i = 0; i < WordStr.length; i++) {
			int Wordlen = WordStr[i].length(); // the length of each words
			// delete punctuation
			StringBuffer DelPunc = new StringBuffer(WordStr1[i]);
			if (WordStr1[i].contains(",")) {
				DelPunc = DelPunc.deleteCharAt(WordStr1[i].length() - 1);
				WordStr1[i] = DelPunc.toString();
			}
			if (WordStr1[i].contains(".")) {
				DelPunc = DelPunc.deleteCharAt(WordStr1[i].length() - 1);
				WordStr1[i] = DelPunc.toString();
			}
			// insert the consonants between each letters and check
			for (int m = 1; m < WordStr1[i].length(); m++) {
				for (int n = 0; n < Consonants.length; n++) {
					StringBuffer strBuffer = new StringBuffer(WordStr1[i]);
					strBuffer.insert(m, Consonants[n]);
					String Rest0 = strBuffer.toString(); // results after inserting a consonant
					if (Vocabulary.contains(Rest0) || Vocabulary.contains(toLowerCaseFirstOne(Rest0))
							|| Vocabulary.contains(toUpperCaseFirstOne(Rest0))
							|| Vocabulary.contains(toUpperCase(Rest0)) || Vocabulary.contains(toLowerCase(Rest0))) {
						flag++;
						count++;
						// if checking is successful, print the whole sentence or phrases
						if (i == 0) {
							System.out.print(Rest0);
							for (int p = i + 1; p < WordStr.length; p++) {
								System.out.print(" " + WordStr[p]);
							}
						} else if (i > 0 && i < WordStr.length - 1) {
							for (int p = 0; p < i; p++) {
								System.out.print(WordStr[p]);
								System.out.print(" ");
							}
							System.out.print(Rest0);
							if (Rest0.length() > Wordlen + 1) {
								System.out.print(",");
							}
							for (int q = i + 1; q < WordStr.length; q++) {
								System.out.print(" " + WordStr[q]);
							}
						} else if (i == WordStr.length - 1) {
							for (int p = 0; p < i; p++) {
								System.out.print(WordStr[p]);
								System.out.print(" ");
							}
							System.out.print(Rest0);
							if (Rest0.length() > Wordlen + 1) {
								System.out.print(".");
							}
						}
						System.out.print("\n");
					}
				}
			}
		}
		if (flag == 0) {
			System.out.println("Could not find any alternatives.");
		} else if (flag > 0) {
			System.out.println("Found " + count + " alternatives.");
		}
	}
}
