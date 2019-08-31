import java.util.ArrayList;

/**
 * This class is for checking vowels in the strings
 * 
 * @author 180007800
 */
public class CheckVowel {
	
	public static String toLowerCaseFirstOne(String s) {
		if(Character.isLowerCase(s.charAt(0))) {
			return s;
		}
		else {
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}
	
	public static String toUpperCaseFirstOne(String s) {
		if(Character.isUpperCase(s.charAt(0))) {
			return s;
		}
		else {
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}
	
	public static String toUpperCase(String s) {
		return s.toUpperCase();
	}
	
	public static String toLowerCase(String s) {
		return s.toLowerCase();
	}
	public void findcon(String file, String tex) {
		char letter; 
		String[] wordarr = tex.split(" ");//jiang wenben fencheng danci
		String[] wordarr1 = tex.split(" ");
 		ArrayList<String> vocabulary= new ArrayList<String> ();
		FileUtil fileutil = new FileUtil();
		vocabulary = fileutil.readLines(file); //huoqu wenjian
		int flag=0;
		int count=0;
		if(vocabulary.size() == 0)
		{
			flag=-1;
			System.out.println("Invalid dictionary, aborting.");
		}
		for(int i=0; i<wordarr.length; i++) {
			int wordlen = wordarr[i].length();
			if(wordarr1[i].contains(",")) {
				StringBuffer del = new StringBuffer(wordarr1[i]);
				del = del.deleteCharAt(wordarr1[i].length()-1);
				wordarr1[i] = del.toString();
			}
			if(wordarr1[i].contains(".")) {
				StringBuffer del = new StringBuffer(wordarr1[i]);
				del = del.deleteCharAt(wordarr1[i].length()-1);
				wordarr1[i] = del.toString();
			}
			for(int j=0; j< wordarr1[i].length();j++) {
			
				StringBuffer strBuffer = new StringBuffer(wordarr1[i]);
				letter = wordarr1[i].charAt(j);
				if((letter>'A' && letter <= 'Z' &&( letter=='E' || letter=='I' || letter=='O' || letter=='U')) 
					|| (letter>'a' && letter <= 'z' &&( letter=='e' || letter=='i' || letter=='o' || letter=='u'))) {
	
					strBuffer= strBuffer.deleteCharAt(j);
					String rest0 = strBuffer.toString();
					if(vocabulary.contains(rest0)||vocabulary.contains(toLowerCaseFirstOne(rest0))||
							vocabulary.contains(toUpperCaseFirstOne(rest0))||vocabulary.contains(toUpperCase(rest0))
							||vocabulary.contains(toLowerCase(rest0))) {
						flag++;
						count++;
						if(i == 0) {
							System.out.print(rest0);
							for(int m = i+1; m < wordarr.length; m++) {
								System.out.print(" " +wordarr[m]);
							}
							System.out.print("\n");
							System.out.print("lostvowel = " + letter);
							
						}
						else if(i>0 && i < wordarr.length-1) {
							for(int n = 0; n < i; n++) {
								System.out.print(wordarr[n]);
								System.out.print(" ");
							}
							System.out.print(rest0);
							if(rest0.length() < wordlen-1) {
								System.out.print(",");
							}
							for(int l = i+1; l < wordarr.length; l++) {
								System.out.print(" " + wordarr[l]);
									}
							System.out.print("\n");
							System.out.print("lostvowel = " + letter);
						}
						else if(i == wordarr.length-1) {
							for(int k=0; k < i; k++) {
								System.out.print(wordarr[k]);
								System.out.print(" ");
							}
							System.out.print(rest0);
							if(rest0.length()<wordlen-1) {
								System.out.print(".");
							}
							System.out.print("\n");
							System.out.print("lostvowel = " + letter);
						}
						System.out.print("\n");
						}
					}
				}		
			}
		if(flag==0) {
			System.out.println("Could not find any alternatives.");
		}
		else if(flag>0)
		{
			System.out.println("Found " + count + " alternatives.");
		}
	}
}
