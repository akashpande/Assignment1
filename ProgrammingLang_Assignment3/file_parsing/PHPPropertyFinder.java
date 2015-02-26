package file_parsing;
import java.io.*;
import java.util.*;

public class PHPPropertyFinder implements IPropertyFinder {
	

	
		Scanner test_scan;
		int count = 0;
		ArrayList<String> property=new ArrayList<String>();

		public PHPPropertyFinder(File test_file)
		{
			try
			{
				test_scan=new Scanner(test_file);
				
			} 
			catch (FileNotFoundException e)
			{
				
				e.printStackTrace();
			}

		}

		
		public ArrayList<String> findProperties()
		{
	         String currentToken;
			
	        
			while(test_scan.hasNextLine())
			{
				currentToken = test_scan.nextLine().trim();
				if(currentToken.startsWith("/*"))
				{
					
					while(!test_scan.nextLine().trim().contains("*/"))
						{
						
					    continue;
						}
				}
				
				else if(currentToken.startsWith("#"))
				{
					
					continue;
				}
				else if(currentToken.startsWith("//"))
				{
		        	continue;
				}
				else if(currentToken.contains("(") && currentToken.contains(")"))
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
				
				else if(currentToken.contains(";"))
				{
	
					if(currentToken.contains("="))
					{
						property.add(currentToken.substring(currentToken.indexOf("$")+1, currentToken.indexOf("=")-1));
						
					}
					else
					{
						property.add(currentToken.substring(currentToken.indexOf("$")+1, currentToken.indexOf(";")-1));
					}
				}
				
				
		    }
			return property;
		}
	}
