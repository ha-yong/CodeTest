import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
	   
		
		System.out.println(duplicateCharCount(inputStr));
			
	    sc.close();
				 
	}
	
	public static int duplicateCharCount(String inputChar) {
		int count = 0;
		
		HashMap<Character, Integer> map =   new HashMap<Character, Integer>();

		for(int i=0; i<inputChar.length(); i++) {
			
			
			if(map.containsKey(inputChar.charAt(i))) {
				
				map.put(inputChar.charAt(i), map.get(inputChar.charAt(i))+1);
				
			}else {
				map.put(inputChar.charAt(i), 1);
			}
			
		}
		
		for(int value : map.values()) {
			  if(value > 1) {
				  count ++;
			  }
		}
		
		return count;
		
	}

}
