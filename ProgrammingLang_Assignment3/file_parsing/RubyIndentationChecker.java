package file_parsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RubyIndentationChecker implements IIndentationChecker{
	
	Scanner test_scan;
	int count = 0;
	ArrayList<String> property=new ArrayList<String>();

	public RubyIndentationChecker(File test_file)
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


	public String checkIndentation()
	{
         String currentToken;
         String status=null;
		
         
		while(test_scan.hasNextLine())
		{
			currentToken = test_scan.nextLine().trim();
			
			
			if(currentToken.startsWith("#"))
			{
				
				continue;
			}
				
			else if(currentToken.startsWith("class"))
			{
				
     			count++;
			}
			else if(currentToken.startsWith("def"))
			{
				count++;
			}
			else if(currentToken.startsWith("end"))
			{
				count--;
			}
			
			
			if(count == 0)
			{
				status = "Success";
			}
			else if(count != 0)
			{
				status = "Failed";
			}
	
	
		}
		return status;
	}

}
