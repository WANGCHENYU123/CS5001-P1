/**
 * This class is the enter of for inserting consonants. 
 * 
 * @author 180007800
 */
public class AddConsonants {
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
		//LostConsonants b= new LostConsonants();
		if(args.length == 2) {
			InsertConsonants check = new InsertConsonants();
			check.InsertConsonants(args[0], args[1]);
		}
	}
}
