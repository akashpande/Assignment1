package file_parsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaFunctionFinder implements IFunctionFinder{
	Scanner test_scan;
	ArrayList<String> funName=new ArrayList<String>();
	
	
	int wretTypeIndex,waccModIndex,wfunNameIndex;
	String waccMod,wfunName,wretType;
	
	public JavaFunctionFinder(File test_file)
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
			
			if(currentToken.contains("(") && currentToken.contains(")") && !currentToken.endsWith(";"))
			 {
				if(currentToken.startsWith("public")) 
				 {
					
					wretType=currentToken.substring(currentToken.indexOf("public")+6,currentToken.lastIndexOf("(")).trim();
					if(wretType.contains(" "))
					{
						this.funName.add(" public "+wretType.substring(wretType.indexOf(" ")));
					}
				}
				else if(currentToken.startsWith("private")) 
				{
					
					wretType=currentToken.substring(currentToken.indexOf("private")+7,currentToken.lastIndexOf("(")).trim();
					if(wretType.contains(" "))
					{
						this.funName.add(" private "+wretType.substring(wretType.indexOf(" ")));
					}
				}
				else if(currentToken.startsWith("protected")) 
				{
					
					wretType=currentToken.substring(currentToken.indexOf("protected")+9,currentToken.lastIndexOf("(")).trim();
					if(wretType.contains(" "))
					{
						this.funName.add(" protected "+wretType.substring(wretType.indexOf(" ")));
					}
				}
				else{
					wretType=currentToken.substring(0,currentToken.lastIndexOf("(")).trim();
					if(wretType.contains(" "))
					{
						this.funName.add(" default "+wretType.substring(wretType.indexOf(" ")));
					}
					
				}
			}
			
	
         }

		return funName;
    }
	}