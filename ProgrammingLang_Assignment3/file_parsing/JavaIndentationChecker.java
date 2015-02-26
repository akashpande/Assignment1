package file_parsing;
import java.io.*;
import java.util.*;

public class JavaIndentationChecker implements IIndentationChecker{
	Scanner test_scan;
	int count=0;
	
	public JavaIndentationChecker(File test_file)
	{
		try {
			test_scan=new Scanner(test_file);
			
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public String checkIndentation()
	{
		String currentToken;
		String status = null;
		
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
				status = "Success";
			}
			else if(count !=0)
			{
				status = "Failed";
			}
			
          
         }
		return status;
	}
}