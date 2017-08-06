package JavaSyugyou0724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SyntaxHighlighting {
	static String[] keywordString = {
	    "abstract", "assert", "boolean",
	    "break", "byte", "case", "catch", "char", "class", "const",
	    "continue", "default", "do", "double", "else", "enum",
	    "extends", "for", "final", "finally", "float", "goto", "if",
	    "implements", "import", "instanceof", "int", "interface",
	    "long", "native", "new", "package", "private", "protected",
	    "public", "return", "short", "static", "strictfp", "super",
	    "switch", "synchronized", "this", "throw", "throws",
	    "transient", "try", "void", "volatile", "while",
	    "true", "false", "null"};
	
	static HashSet<String> keywordSet=new HashSet<String>(Arrays.asList(keywordString));
	
	public static void main(String[] args) {
		String filename="C:/Users/Ethan/workspace/Text/tx2.txt";
		String filename2="C:/Users/Ethan/workspace/Text/javaH.html";
		
		try {
			Scanner input = new Scanner(new File(args[0]));
		    PrintWriter output = new PrintWriter(new File(args[1]));
		    
		    JavaToHTML(input, output);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	 static boolean stringToken = false;
	 static String inputFileName;
	 
	 public static void JavaToHTML(Scanner input, PrintWriter output) {
		    try {
		      output.format("%s\r\n", "<html>");
		      output.format("%s\r\n", "<head>");
		      output.format("%s\r\n",
		        "<title>Intro to Java Programming, 6E - " + inputFileName +
		        "</title>");
		      output.format("%s\r\n",
		        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">");
		      output.format("%s\r\n", "<style type = \"text/css\">");
		      output.format("%s\r\n",
		        "body {font-family: \"Courier New\", sans-serif; font-size: 100%; color: black}");

		      output.format("%s\r\n",
		        ".keyword {color: #000080; font-weight: bold}");
		      output.format("%s\r\n", ".comment {color: #008000}");
		      output.format("%s\r\n", ".literal {color: #0000ff}");

		
		      output.format("%s\r\n", ".keyword {color: black; font-weight: bold}");
		      output.format("%s\r\n", ".comment {color: #77797C}");
		      output.format("%s\r\n", ".literal {color: #007346; font-weight: bold}");
		      output.format("%s\r\n", "</style>");

		      output.format("%s\r\n", "</head>");
		      output.format("%s\r\n", "<body>");
		      output.format("%s\r\n", "<pre>");

		      String text = "";
		      String temp;

		      // Read all lines
		      while (input.hasNext()) {
		        temp = input.nextLine();
		        text += temp + "\r\n";
		      }

		      text = text.replaceAll(">", "&gt;");
		      text = text.replaceAll("<", "&lt;");
		      translateToHTML(text, input, output);

		      output.format("%s\r\n", "</pre>");
		      output.format("%s\r\n", "</body>");
		      output.format("%s\r\n", "</html>");
		    }
		    catch (Exception ex) {
		      System.out.println(ex);
		    }
		    finally {
		      try {
		        input.close();
		        output.close();
		      }
		      catch (Exception ex) {
		      }
		    }
		  }
	 
	/** Translate Java source code to HTML */
	  static void translateToHTML(String text, Scanner input, PrintWriter output) throws Exception {
		    text = text.replaceAll("// ", "LINECOMMENT");
		    text = text.replaceAll("/\\*", "BLOCKCOMMENT");

		    String token;

		    while (text != null && text.length() > 0) {
		      // * and / are in conflict with /* and //
		       String[] parts = text.split("[%\\+\\-\\*/\r\n\t \\[\\].;(){},]", 2);

		      token = parts[0];

		      if (token.length() > 1 && token.startsWith("LINECOMMENT")) {
		        output.format("%s", "<span class = \"comment\">");
		        parts = text.split("\r\n", 2);
		        text = parts[1];
		        output.format("%s", parts[0].replaceAll("LINECOMMENT", "// "));
		        output.format("%s", "</span>\r\n");
		        continue;
		      }
		      else if (token.length() > 1 && token.startsWith("BLOCKCOMMENT")) {
		        output.format("%s", "<span class = \"comment\">");
		        parts = text.split("\\*/", 2);
		        text = parts[1];

		        output.format("%s", parts[0].replaceAll("BLOCKCOMMENT", "/*") + "*/");
		        output.format("%s", "</span>");
		        continue;
		      }
		      else if (token.length() > 1 && token.matches("'\\w'*")) {
		        output.format("%s", "<span class = \"literal\">");
		        output.format("%s", token);
		        output.format("%s", "</span>");
		      }
		      else if (token.startsWith("\"") && token.endsWith("\"") &&
		               (token.length() > 1)) {
		        output.format("%s", "<span class = \"literal\">" + token
		                      + "</span>");
		      }
		      else if (token.startsWith("'") && token.endsWith("'") &&
		               (token.length() > 1)) {
		        output.format("%s", "<span class = \"literal\">" + token
		                      + "</span>");
		      }
		      else if (token.equals("' '")) {
		        output.format("%s", "<span class = \"literal\">" + token
		                      + "</span>");
		      } 
		      else if (token.startsWith("\"") && token.endsWith("\"") &&
		               (token.length() == 1)) {
		        if (stringToken) {
		          output.format("%s", token + "</span>");
		          stringToken = false;
		        }
		        else {
		          output.format("%s", "<span class = \"literal\">" + token);
		          stringToken = true;
		        }
		      }
		      else if (token.startsWith("\"")) {
		        output.format("%s", "<span class = \"literal\">" + token);
		        stringToken = true;
		      }
		      else if (token.endsWith("\"") && (!token.endsWith("\\\""))) {
		        output.format("%s", token);
		        output.format("%s", "</span>");
		        stringToken = false;
		      }
		      else if (token.matches("\\d+")) { // Check if numeric
		        output.format("%s", "<span class = \"literal\">" + token +
		                      "</span>");
		      }
		      else if (!stringToken && keywordSet.contains(token)) {
		        output.format("%s", "<span class = \"keyword\">" + token +
		                      "</span>");
		      }
		      else {
		        output.format("%s", token);
		      }

		      if (token.length() < text.length()) {
		        if (text.charAt(token.length()) == '<')
		           output.format("%s", "&lt;");
		        else if (text.charAt(token.length()) == '>')
		          output.format("%s", "&gt;");
		        else
		          output.format("%s", text.charAt(token.length()));
		      }

		      if (parts.length == 2) {
		        text = parts[1];
		      }
		    }
		  }
}





































































