package JavaSyugyou0721;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;

//C:/Users/Ethan/workspace/

public class CountingWordFile {
	public static void main(String[] args) {
		String filename="C:/Users/Ethan/workspace/Text/tx2.txt";
		
		TreeMap<String, Integer>treeMap=new TreeMap<String, Integer>();
		
		BufferedReader in=null;
		
		try {
			//Scanner input=new Scanner(new File(filename));
			in=new BufferedReader(new FileReader(filename));
			String line=null;
			while ((line=in.readLine())!=null) {
				String[] words=line.split("[ \n\t\r.,;?'\")(]");
				for (int i = 0; i < words.length; i++) {
					if (words[i].trim().length()<1) {
						continue;
					}
					String key=words[i].toLowerCase();
					if (treeMap.get(key)!=null) {
						int value=((Integer)treeMap.get(key)).intValue();
						value++;
						treeMap.put(key, new Integer(value));
						
					} else {
						treeMap.put(key, new Integer(1));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Set<Entry<String, Integer>>set=treeMap.entrySet();
		for (Entry<String, Integer> entry : set) {
			System.out.println(entry.getValue()+"\t"+entry.getKey());
		}
	}
}





































