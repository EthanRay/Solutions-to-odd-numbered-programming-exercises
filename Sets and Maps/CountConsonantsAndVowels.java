package JavaSyugyou0724;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;

public class CountConsonantsAndVowels {
	public static void main(String[] args) {
		HashSet<Character> set1=new HashSet<Character>(Arrays.asList(new Character[]{'A', 'E', 'I', 'O', 'U'}));
		String filename="C:/Users/Ethan/workspace/Text/tx2.txt";
		BufferedReader in=null;
		int countVowels=0;
		int countConsonants=0;
		String line=null;
		try {
			in=new BufferedReader(new FileReader(filename));
			while ((line=in.readLine().toUpperCase())!=null) {
				for (int i = 0; i < line.length(); i++) {
					if(set1.contains(line.charAt(i)))
					{
						++countVowels;
					}else if (Character.isLetter(line.charAt(i))) {
						countConsonants++;
					}
				}
			}
			System.out.println(countVowels+" "+countConsonants);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
