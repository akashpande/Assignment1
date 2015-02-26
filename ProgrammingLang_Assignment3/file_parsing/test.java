package file_parsing;
import java.io.*;
import java.util.*;


public class test {

	static String file;	
	static ArrayList<String> classes;
	static ArrayList<String> functions;
	static ArrayList<String> properties;
	static String indentationStatus;
		

			public static void main(String[] args) throws FileNotFoundException {
				System.out.println("Enter the path");		
			    File input_file = new File(new Scanner(System.in).next());
			    IClassFinder classfinder;
			    IFunctionFinder functionfinder;
			    IPropertyFinder propertyfinder;
			    IIndentationChecker indentationchecker;
			    
			    
			    if(input_file.exists())
			    {
			    	
			    	CheckFileType file_type=new CheckFileType(input_file);
			    	file = file_type.checkFile();
			    	
			    	if(file == "java")
			    	{
			    		System.out.println("This is Java");
			    		
			    		classfinder = new JavaClassFinder(input_file);
			    		classes=classfinder.findClasses();			    		
			    	    System.out.println("The Classes are : "+classes);
			    		
			    		functionfinder  = new JavaFunctionFinder(input_file);
			    		functions = functionfinder.findFunctions();
			    		System.out.println("Functions are :"+functions);
			    		
			    		propertyfinder  = new JavaPropertyFinder(input_file);
			    		properties=propertyfinder.findProperties();
			    		System.out.println("Properties are:"+properties);
			    		
			    		indentationchecker = new JavaIndentationChecker(input_file);
			    		indentationStatus=indentationchecker.checkIndentation();
			    		System.out.println("The Indentation Status is:"+indentationStatus);
			    		
			    	}
			    	else if(file == "ruby")
			    	{
			    		System.out.println("This is ruby");
			    		classfinder = new RubyClassFinder(input_file);
			    		classes=classfinder.findClasses();
			    		System.out.println("The Classes are : "+classes);
			    		
			    		functionfinder = new RubyFunctionFinder(input_file);
			    		functions = functionfinder.findFunctions();
			    		System.out.println("Functions are :"+functions);
			    		
			    		propertyfinder = new RubyPropertyFinder(input_file); 
			    		properties = propertyfinder.findProperties();
			    		System.out.println("Properties are:"+properties);
			    		
			    		indentationchecker = new RubyIndentationChecker(input_file);
			    		indentationStatus=indentationchecker.checkIndentation();
			    		System.out.println("The Indentation Status is:"+indentationStatus);
			    		
			    		
			    	}
			    	else if(file == "php")
			    	{
			    		System.out.println("this is php");
			    		classfinder = new PHPClassFinder(input_file);
			    		classes=classfinder.findClasses();
			    		System.out.println("The Classes are : "+classes);
			    		
			    		functionfinder = new PHPFunctionFinder(input_file);
			    		functions = functionfinder.findFunctions();
			    		System.out.println("Functions are :"+functions);
			    		
			    		propertyfinder = new PHPPropertyFinder(input_file); 
			    		properties = propertyfinder.findProperties();
			    		System.out.println("Properties are:"+properties);
			    		
			    		indentationchecker = new PHPIndentationChecker(input_file);
			    		indentationStatus=indentationchecker.checkIndentation();
			    		System.out.println("The Indentation Status is:"+indentationStatus);
			    		
			    	}
			    	else
			    	{
			    		System.out.println("this is not a valid file..");
			    	}
			    	
			    	
			    }
				

			}

		

	}


