package file_parsing;

import java.io.*;
import java.util.*;

public class JavaClassFinder implements IClassFinder {
	
	Scanner test_scan;
	ArrayList<String> classes = new ArrayList<String>();
	
	public JavaClassFinder(File test_file)
	       {
					try {
						test_scan=new Scanner(test_file);
						
					} 
					catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}

	      }

	@Override
	public ArrayList<String> findClasses() {
		String currentToken;
		
		String currClassToken;
		
		 
		int beginIndex,endIndex;
		
		
		while(test_scan.hasNextLine())
		{
			currentToken = test_scan.nextLine().trim();
			
			if(currentToken.contains("class"))
			{
				beginIndex = currentToken.indexOf("class")+6;					
				
				currClassToken = currentToken.substring(beginIndex);
				
				
				if(currClassToken.contains(" "))
				{
					endIndex=currClassToken.indexOf(" ");
					
					currClassToken=currClassToken.substring(0,endIndex);
					
				}
				else if(currClassToken.contains("{"))
				{
					endIndex=currClassToken.indexOf("{");
					currClassToken=currClassToken.substring(0,endIndex);
					
				}
				classes.add(currClassToken);
			   
			}				
		}
		
		return classes;
	}


}
