package JavaSyugyou0724;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountKeywordsJavaSourceCode {
	
	private static String stripLineComments(String line) {
		int index=line.indexOf("//");
		if (index<0) {
			return line;
		} else {
			return line.substring(0,index);
		}
	}
	
	private static String stripLineStringLiterals(String line) {
		int start=line.indexOf("\"");
		int end=line.indexOf("\"",start+1);
		
		while (start>0&&end>0) {
			line=line.substring(0,start)+line.substring(end+1);
			start=line.indexOf("\"");
			end=line.indexOf("\"");
		}
		return line;
	}
	
	private static String stripParagraghComments(String text){
		int start=text.indexOf("/*");
		int end=text.indexOf("*/");
		while (start>0&&end>0) {
			text=text.substring(0,start)+text.substring(end+1);
			start=text.indexOf("/*");
			end=text.indexOf("*/");
		}
		return text;
	}
	
	public static void main(String[] args) {
		String[] keywordString = {"abstract", "finally", "public",
			      "boolean", "float", "return", "break", "for", "short", "byte",
			      "goto", "static", "case", "if", "super", "catch", "implements",
			      "switch", "char", "import", "synchronized", "class",
			      "instanceof", "this", "const", "int", "throw", "continue",
			      "interface", "throws", "default", "long", "transient", "do",
			      "native", "try", "double", "new", "void", "else", "package",
			      "volatile", "extends", "private", "while", "final",
			      "protected", "true", "null"};
		Set<String>keywordSet=new HashSet<String>(Arrays.asList(keywordString));
		
		String text="";
		String filename="C:/Users/Ethan/workspace/Text/tx2.txt";
		BufferedReader in=null;
		try {
			in=new BufferedReader(new FileReader(filename));
			String line=null;
			while ((line=in.readLine())!=null) {
				line=stripLineComments(line);
				line=stripLineStringLiterals(line);
				text+=line+" ";
			}
			text=stripParagraghComments(text);
			
			int C=0;
			String[] tokens=text.split("[ \\[,()\\]]");
			for (int i = 0; i < tokens.length; i++) {
				if (keywordSet.contains(tokens[i])) {
					++C;
				}
			}
			System.out.println(C);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}















































