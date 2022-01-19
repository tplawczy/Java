import java.util.*;
import java.util.Stack.*;
import java.io.*;
public class Solution {
	
		
		public static void main(String []argh) {
		{
			   String sc = "{}()\r\n" + "({()})\r\n" + "{}(\r\n" + "[]\r\n" ;
			  
			   
			   ArrayList<String> wordArrayList = new ArrayList<String>(4);
			   for(String word : sc.split("\r\n")) {
			       wordArrayList.add(word);
			   }
			   System.out.println(wordArrayList.toString());
			 
			   
			   	for (String st : wordArrayList ){
	            String input = st;
	            //Complete the code
	            boolean answer = true;   
	      
	            Stack <Character> ms = new Stack<Character>();
	        if  ((input.length())%2==0)
	        {
	            for(int i=0 ; i < input.length()/2 ;i++ )
	            {   
	                ms.push(input.charAt(i)); 
	                
	            }
	            for(int i =input.length()/2; i < input.length();i++ )
	            {  
	                 char t = ms.pop();
	                if(t !=(input.charAt(i)))
	                    {answer=false;
	         
	                    break;   }
	            }
	            //if(answer==true)
	             //{for(int i=0 ; i<input.length()/2 ;i++  )
	             ///   {
	              //      if(!(ms.get(i) == ms.get(i+1)))
	              //          answer=false;   
	              //  }
	             //}
	         
	        }    
	        else
	            answer=false;
	             
	             
	            
	        
	        if (answer==true)
	            System.out.println("true");
	        else 
	            System.out.println("false");
	        
	        
	        }

	    }

	}

		
}