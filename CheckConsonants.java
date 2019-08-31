import java.util.ArrayList;
/**
 * This class is for checking consonants in the strings
 * 
 * @author 180007800
 */
public class CheckConsonants {
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

	// find the consonants in the sentence or phrases, and then check with the file
	public void FindCheck(String file, String tex) {
		char Letter;
		String[] WordStr = tex.split(" ");// divide the InputTex into words
		String[] WordStr1 = tex.split(" ");
		// read the file
		ArrayList<String> Vocabulary = new ArrayList<String>();
		FileUtil fileutil = new FileUtil();
		Vocabulary = fileutil.readLines(file); // huoqu wenjian
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
			if (WordStr1[i].contains(",")) {
				StringBuffer DelPunc = new StringBuffer(WordStr1[i]);
				DelPunc = DelPunc.deleteCharAt(WordStr1[i].length() - 1);
				WordStr1[i] = DelPunc.toString();
			}
			if (WordStr1[i].contains(".")) {
				StringBuffer del = new StringBuffer(WordStr1[i]);
				del = del.deleteCharAt(WordStr1[i].length() - 1);
				WordStr1[i] = del.toString();
			}
			// find the consonants in the sentence or phrases, and then check with the file
			for (int j = 0; j < WordStr1[i].length(); j++) {

				StringBuffer strBuffer = new StringBuffer(WordStr1[i]);
				Letter = WordStr1[i].charAt(j);
				if ((Letter > 'A' && Letter <= 'Z' && Letter != 'E' && Letter != 'I' && Letter != 'O' && Letter != 'U')
						|| (Letter > 'a' && Letter <= 'z' && Letter != 'e' && Letter != 'i' && Letter != 'o'
								&& Letter != 'u')) {
					strBuffer = strBuffer.deleteCharAt(j);
					String Rest0 = strBuffer.toString(); // results after inserting a consonant
					if (Vocabulary.contains(Rest0) || Vocabulary.contains(toLowerCaseFirstOne(Rest0))
							|| Vocabulary.contains(toUpperCaseFirstOne(Rest0))
							|| Vocabulary.contains(toUpperCase(Rest0)) || Vocabulary.contains(toLowerCase(Rest0))) {
						flag++;
						count++;
						// if checking is successful, print the whole sentence or phrases
						if (i == 0) {
							System.out.print(Rest0);
							for (int m = i + 1; m < WordStr.length; m++) {
								System.out.print(" " + WordStr[m]);
							}
						} else if (i > 0 && i < WordStr.length - 1) {
							for (int m = 0; m < i; m++) {
								System.out.print(WordStr[m]);
								System.out.print(" ");
							}
							System.out.print(Rest0);
							if (Rest0.length() < Wordlen - 1) {
								System.out.print(",");
							}
							for (int n = i + 1; n < WordStr.length; n++) {
								System.out.print(" " + WordStr[n]);
							}
						} else if (i == WordStr.length - 1) {
							for (int m = 0; m < i; m++) {
								System.out.print(WordStr[m]);
								System.out.print(" ");
							}
							System.out.print(Rest0);
							if (Rest0.length() < Wordlen - 1) {
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
