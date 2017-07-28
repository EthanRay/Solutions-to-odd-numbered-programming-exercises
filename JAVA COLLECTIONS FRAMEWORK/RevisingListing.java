package JavaSyugyou0721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class RevisingListing {
	public static void main(String[] args) {
		  String text = "Have a good day. Have a good class. " +
			      "Have a good visit. Have fun! Have a good class";
		HashMap<String, Integer>hashMap=new HashMap<String, Integer>();
		
		StringTokenizer st1=new StringTokenizer(text, " !?.");
		while (st1.hasMoreTokens()) {
			String key=st1.nextToken();
			if (hashMap.get(key)!=null) {
				int value=((Integer)hashMap.get(key)).intValue();
				++value;
				hashMap.put(key, new Integer(value));
			}else {
				hashMap.put(key, new Integer(1));
			}
		}
		
		TreeMap<String, Integer>treeMap=new TreeMap<String, Integer>(hashMap);
		Set setEntry=treeMap.entrySet();
		Iterator iterator=setEntry.iterator();
		ArrayList<WordOccurrence>list11=new ArrayList<WordOccurrence>();
		while (iterator.hasNext()) {
			StringTokenizer st2=new StringTokenizer(iterator.next().toString(), "=");
			list11.add(new WordOccurrence(st2.nextToken(), Integer.parseInt(st2.nextToken())));
			
		}
		Collections.sort(list11);
		for(int i=0;i<list11.size();++i){
			System.out.println(list11.get(i));
		}
}
}

class WordOccurrence implements Comparable{
	
	String word;
	int wordCount;
	
	public WordOccurrence(String word,int count) {
		this.word=word;
		this.wordCount=count;
	}
	
	
	public int compareTo(Object o) {
		return wordCount-((WordOccurrence)o).wordCount;
	}
	
	@Override
	public boolean equals(Object arg0) {
		return word.equals(((WordOccurrence)arg0).word);
	}
	
	@Override
	public String toString() {
		return word+" "+wordCount;
	}
}


























































































