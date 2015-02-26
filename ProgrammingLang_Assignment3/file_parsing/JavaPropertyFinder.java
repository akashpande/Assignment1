package file_parsing;
import java.io.*;
import java.util.*;

public class JavaPropertyFinder implements IPropertyFinder{
	Scanner test_scan;
	int count = 0;
	ArrayList<String> property=new ArrayList<String>();

	public JavaPropertyFinder(File test_file) {
		try {
			test_scan=new Scanner(test_file);
			
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

	}

	public ArrayList<String> findProperties()
	{
         String currentToken;
		
         
		while(test_scan.hasNextLine())
		{
			currentToken = test_scan.nextLine().trim();
			
			if(currentToken.contains("(") && currentToken.contains(")") && !currentToken.contains(";"))
			{
				
				if(currentToken.contains("{"))
				{
				   count++;	
				
				}
				while(test_scan.hasNextLine())
				{
				     currentToken = test_scan.nextLine().trim();
				
					    if(currentToken.contains("{"))
					     {
					       count++;	
					     }
					     else if(currentToken.contains("}"))
					      {
						   count--;	
						  }
					     if(count == 0)
					     {
					    	 break;
					     }
				     	
				     
   			  }
			}	
			else if(currentToken.contains("()") && currentToken.contains(";") && currentToken.contains("new"))
			{
				if(currentToken.contains("<") && currentToken.contains(">"))
				currentToken = (currentToken.substring(currentToken.indexOf(">")+1, currentToken.indexOf("=")));
				else
				{   
					int begIndex;
				    currentToken = currentToken.substring(0,currentToken.indexOf("=")).trim();
				    begIndex = currentToken.lastIndexOf(" ")+1;
				    currentToken = currentToken.substring(begIndex);
				    property.add(currentToken);
				   }
			}
			else
			if(currentToken.contains(";") && !currentToken.contains("()") && !currentToken.startsWith("import") && !currentToken.startsWith("/") && !currentToken.startsWith("*"))
			{
				currentToken = currentToken.substring(0,currentToken.indexOf(";")).trim();
				currentToken = currentToken.substring(currentToken.lastIndexOf(" ")+1);
				property.add(currentToken);
			}
			
	    }
		return property;
	}
}