import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

	 
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
	  
	  public static List<String> wordBreak(String s, List<String> dictionary) {
		    
	        List<String> afterBreak = new ArrayList();
	        if (dictionary.contains(s))
	        	afterBreak.add(s);
	        for ( int i =1; i<= s.length(); i++) {
	        	String left = s.substring(0,i);
	        	if (dictionary.contains(left)) {
	        		List <String> subList = wordBreak(s.substring(i), dictionary);
	        		for (String word: subList) {
	        			afterBreak.add( left + " "+ word);
	        		}
	        	}
	        }
	        
	        return afterBreak;
	        
	    }
	  public static void main(String[] args) throws Exception
	  {
	    String data = readFileAsString("/Users/diembui/eclipse-workspace/Project3-AOA/src/input.txt");
	    String dic = readOutputFileasString("/Users/diembui/eclipse-workspace/Project3-AOA/src/aliceInWonderlandDictionary.txt");
	    String [] input= data.split("\n");
	   
	    String dictionary [] = dic.split("\n");
	    List<String> dict = new ArrayList<>();
	    for (String s : dictionary) {
	    	dict.add(s);
	    }
	    List<String> result= new ArrayList<String>();
	    // I TRIED TO TAKE INPUT.TXT AND PRINT OUT ALL THE OUTPUTS BUT I GOT EMPTY STRINGS EXCEPT "TOUNGESTOES"
	    /*for (String y : input) {
	    	//System.out.println(y);
	    	result = wordBreak(y, dict);
	    	//System.out.println(y + "can be split into " + result);
	    }
	    for ( int i=0; i< input.length; i++) {
	    	//result = wordBreak(input[i], dict);
	    	//System.out.println(input[i] + "can be split into " + result);
	    	
	    }*/
	    result = wordBreak("williamwillwritewonderfulwalrus", dict);
	    System.out.println(result);
	  }
}
