package JavaSyugyou0721;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;



import javax.swing.JOptionPane;

public class CountingNumbersEntered {
	
	public static void main(String[] args) {
		TreeMap<Integer, Integer>treeMap=new TreeMap<Integer, Integer>();
		while(true){
			String numString=JOptionPane.showInputDialog(null, "Enter:","Ex22.7",JOptionPane.QUESTION_MESSAGE);
			int number=Integer.parseInt(numString);
			if (number==0) {
				break;
			}
			Integer key=new Integer(number);
			if(treeMap.get(key)!=null){
				int value=(Integer)treeMap.get(key).intValue();
				value++;
				treeMap.put(key, new Integer(value));
			}else{
				treeMap.put(key, new Integer(1));
			}
		}
		Integer max=(Integer)(Collections.max(treeMap.values()));
		Set keys=treeMap.keySet();
		Iterator iterator=keys.iterator();
		
		while(iterator.hasNext()){
			Object key=iterator.next();
			Integer value=(Integer)(treeMap.get(key));
			if(value.equals(max)){
				System.out.println("Number "+key+" occurred most");
			}
		}
	}
}









































