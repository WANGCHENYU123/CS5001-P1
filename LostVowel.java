/**
 * This class is the enter for checking vowel
 * 
 * @author 180007800
 */
public class LostVowel {
	int j=10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0)
		{
			System.out.println("Expected 2 command line arguments, but got 0.");
			System.out.println("Please provide the path to the dictionary file as the first argument and a sentence as the second argument.");
		}
		
		if(args.length == 1)
		{
			System.out.println("Expected 2 command line arguments, but got 1.");
			System.out.println("Please provide the path to the dictionary file as the first argument and a sentence as the second argument.");
		}
		
		if(args.length == 3) 
		{
			System.out.println("Expected 2 command line arguments, but got 3.");
			System.out.println("Please provide the path to the dictionary file as the first argument and a sentence as the second argument.");
		}
		if(args.length == 2) {
			CheckVowel check = new CheckVowel();
			check.findcon(args[0], args[1]);
		}
	}


}