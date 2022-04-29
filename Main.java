import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

	 
	public class Main {
	   
	  public static String[] readFileAsString(String fileName)throws Exception
	  {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    List<String> listofStrings = new ArrayList<String>();
	    String line = br.readLine();
	    
	    while(line != null) {
	    	listofStrings.add(line);
	    	line = br.readLine();
	    }
	    br.close();
	    String[] array = listofStrings.toArray(new String[0]);
	    return array;
	    
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
	        			afterBreak.add(left + " "+ word);
	        			
	        		}
	        	}
	        }
	        
	        
	        return afterBreak;
	        
	    }
	  public static void main(String[] args) throws Exception
	  {
	    String[] input = readFileAsString("input.txt");
	    String dic = readOutputFileasString("aliceInWonderlandDictionary.txt");
	    
	    
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
	    int count = 0;
	  
	    for(int i = 0; i < input.length; i++) {
	    	//input = input.replace("\n", "");
	    	//System.out.println(input[i]);
	    	//System.out.println(dictionary[i]);
	    	result = wordBreak(input[i], dict);
	    	for (String line : result) {
	    		String[] tmp = line.split("\\s+");
	    		count += tmp.length;
	    	}
	    	if(result.isEmpty()) {
	    		System.out.println(input[i] + " cannot be split into aiW words");
	    	}
	    	else if (result.size() >= 2 )
	    		System.out.println(input[i] + " can be split in different ways: " + result);
	    	else {
	    		System.out.println(input[i] + " can be split into " + count + " aiW word[s]: " + result);
	    	}
	    	count = 0;
	    }
	    //System.out.println(dictionary[1]);
	    //System.out.println("hello");
	  }
}
