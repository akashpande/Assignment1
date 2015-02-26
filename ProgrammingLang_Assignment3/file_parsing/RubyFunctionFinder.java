package file_parsing;
import java.io.*;
import java.util.*;

public class RubyFunctionFinder implements IFunctionFinder {
	
		
			Scanner test_scan;
			ArrayList<String> funName=new ArrayList<String>();
			
			
			int wretTypeIndex,waccModIndex,wfunNameIndex;
			String waccMod,wfunName,wretType;
			
			public RubyFunctionFinder(File test_file)
			{
				try {
					
					test_scan=new Scanner(test_file);
					
				} 
				catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}

			}
			public ArrayList<String> findFunctions() {
				
				String currentToken;
				
				
				while(test_scan.hasNextLine())
				{
					currentToken = test_scan.nextLine().trim();
					 if(currentToken.startsWith("#"))
					{
						
						continue;
						
						
					}
					
					
					else if(currentToken.contains("def") )
					 {
					    
						
						if(currentToken.contains("(") && currentToken.contains(")"))
						{
							wretType=currentToken.substring(currentToken.indexOf("def")+4,currentToken.lastIndexOf("(")).trim();
							funName.add(wretType);
						}
						else if(!currentToken.contains("(") && !currentToken.contains(")"))
						{								
								
							    funName.add((currentToken.substring(currentToken.indexOf("def")+4)));
								
						}
							
						}
					}
					
			
		         

				return funName;
		    }
		}