import java.util.HashSet;
import java.util.Iterator;

class Solution {
    HashSet<Integer> set = new HashSet<Integer>();
    public boolean isPrime(int num) {
    	if(num == 0 || num == 1) 
    		return false;
    	
    	int limit = (int)Math.sqrt(num);
    	
    	for (int i = 2; i<=limit; i++)
    		if (num % i == 0)
    			return false;
    	
    	return true;
 
    }
    public void recurcive(String comb, String others){
        if(!comb.equals(""))
        	set.add(Integer.parseInt(comb)); 
        for(int i=0;i<others.length();i++){
            recurcive(comb+others.charAt(i),others.substring(0,i) +others.substring(i+1));
        }
    }
    public int sol(String str){
    	int count = 0;
        recurcive("",str);
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
        	int number = it.next();
        	if(isPrime(number))
        		count ++;
        }
        
        return count;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        System.out.println(s.sol("42"));
    }
    
}