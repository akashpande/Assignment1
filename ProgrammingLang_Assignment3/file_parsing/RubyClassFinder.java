package file_parsing;
import java.io.*;
import java.util.*;


public class RubyClassFinder implements IClassFinder {
	
			Scanner test_scan;
			ArrayList<String> classes = new ArrayList<String>();
			
			public RubyClassFinder(File test_file)
			       {
							try {
								test_scan=new Scanner(test_file);
								
							} 
							catch (FileNotFoundException e) {
								
								e.printStackTrace();
							}

			      }

			
			public ArrayList<String> findClasses() {
				String currentToken;
				
				String currClassToken;
				
				 
				int beginIndex;
				
				
				while(test_scan.hasNextLine())
				{
					currentToken = test_scan.nextLine();
					
					
					 if(currentToken.contains("class"))
					
					    {
								   
								
									beginIndex = currentToken.indexOf("class")+6;					
									
									currClassToken = currentToken.substring(beginIndex);
									
									classes.add(currClassToken);
									
								}				
					    }
				
				
			
					return classes;

			}
		}

