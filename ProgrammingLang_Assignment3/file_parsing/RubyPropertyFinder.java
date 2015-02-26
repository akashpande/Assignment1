package file_parsing;
import java.io.*;
import java.util.*;

public class RubyPropertyFinder implements IPropertyFinder {
	
			Scanner test_scan;
			int count = 0;
			ArrayList<String> property=new ArrayList<String>();

			public RubyPropertyFinder(File test_file)
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
					
					
					if(currentToken.startsWith("#"))
					{
						
						continue;
					}
						
					else if(currentToken.startsWith("@@"))
					{
						
		     			property.add(currentToken.substring(currentToken.indexOf("@@")+2,currentToken.indexOf("=")-1));
					}
					
					
			    }
				return property;
			}
		}
