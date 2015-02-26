package file_parsing;
import java.io.*;
import java.util.*;



public class CheckFileType {
	
	
		Scanner test_scan;
				
		public CheckFileType(File test_file)
		{
			try {
				test_scan=new Scanner(test_file);
				
			} 
			catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			
		}
		public String checkFile()
		{
			String currentToken,nextToken;
			String retString = null;
			
			
			while(test_scan.hasNextLine())
			{
				currentToken = test_scan.nextLine().trim();
				nextToken = test_scan.nextLine();
				
				if(currentToken.contains("<?php") || nextToken.contains("<?php"))
				{
					retString = "php";
					break;
					
				}
				else if(currentToken.contains("class") && ( nextToken.contains("def") || nextToken.contains("@") ))
				{
					retString = "ruby";
					break;
					
				}
				else if((currentToken.contains("class") ||nextToken.contains("class")) && ( currentToken.contains("{") || nextToken.contains("{") ))
				{   
					
					retString = "java";
					break;
					
				}
				
				
							
			}
			return retString;
			
		}

	}



