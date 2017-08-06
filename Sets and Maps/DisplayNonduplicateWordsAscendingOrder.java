package JavaSyugyou0724;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.TreeSet;

public class DisplayNonduplicateWordsAscendingOrder {
	public static void main(String[] args) {
		String filename="C:/Users/Ethan/workspace/Text/tx2.txt";
		TreeSet<String>treeSet=new TreeSet<String>();
		BufferedReader in=null;
		try {
			in=new BufferedReader(new FileReader(filename));
			String lineString=null;
			while ((lineString=in.readLine())!=null) {
				String[] words=lineString.split("[:| |\n|\t|\r|.|,|)|(|-|\"]");
				for (int i = 0; i < words.length; i++) {
					treeSet.add(words[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Iterator iterator=treeSet.iterator();
		System.out.println("\nDisplay words in ascending order ");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
