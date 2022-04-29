import java.nio.file.*;
	import java.util.ArrayList;
	import java.util.List;;
	 
	public class Main {
	   
	  public static String readFileAsString(String fileName)throws Exception
	  {
	    String data = "";
	    data = new String(Files.readAllBytes(Paths.get(fileName)));
	    return data;
	  }
	  public static String readOutputFileasString(String fileName)throws Exception
	  {
	    String data = "";
	    data = new String(Files.readAllBytes(Paths.get(fileName)));
	    return data;
	  }
	  public static boolean wordBreak(String s, List<String> dictionary) {
	        // create a dp table to store results of subproblems
	        // value of dp[i] will be true if string s can be segmented
	        // into dictionary words from 0 to i.
	        boolean[] dp = new boolean[s.length() + 1];
	     
	        // dp[0] is true because an empty string can always be segmented.
	        dp[0] = true;
	     
	        for(int i = 0; i <= s.length(); i++){
	            for(int j = 0; j < i; j++){
	                if(dp[j] && dictionary.contains(s.substring(j, i))){
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[s.length()];
	    }
	  public static void main(String[] args) throws Exception
	  {
	    String data = readFileAsString("/Users/diembui/eclipse-workspace/Project3-AOA/src/input.txt");
	    String dic = readOutputFileasString("/Users/diembui/eclipse-workspace/Project3-AOA/src/aliceInWonderlandDictionary.txt");
	    
	    String dictionary [] = dic.split("\n");
	    /*for (int i = 0; i < dictionary.length; i++) {
	        // Printing the elements of String array
	        System.out.print(dictionary[i] + ", ");
	    }*/
	    List<String> dict = new ArrayList<>();
	    for (String s : dictionary) {
	    	dict.add(s);
	    }
	    if(wordBreak("aliceinwonderland", dict))
	        System.out.print("Yes\n");
	    else
	        System.out.print("No\n");
	    
	  
	  
	  
	}
}

 
