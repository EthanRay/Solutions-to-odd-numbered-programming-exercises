package JavaSyugyou0814;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergSort {
	
	private static class SortTask extends RecursiveAction {
		private final int THRESHOLD=500;
		private int[] list;
		public SortTask(int[] list) {
			this.list=list;
		}
		protected void compute() {
			if (list.length<THRESHOLD) {
				Arrays.sort(list);
			}
			else {
				int[] firstHalf=new int[list.length/2];
				System.arraycopy(list, 0, firstHalf, 0, list.length/2);
				
				int[] secondHalf=new int[list.length-list.length/2];
				System.arraycopy(list, list.length/2, secondHalf, 0, list.length-list.length/2);
				
				invokeAll(new SortTask(firstHalf),new SortTask(secondHalf));
				MergSort.merge(firstHalf, secondHalf, list);
				
			}
		}
		
	}
	
	public static void paralleMergeSort(int[] list) {
		RecursiveAction mainTask=new SortTask(list);
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(mainTask);
	}
	
	public static void main(String[] args) {
		final int SIZE=7000000;
		int list1[]=new int[SIZE];
		int[] list2=new int[SIZE];
		for (int i = 0; i < list1.length; i++) {
			list1[i]=list2[i]=(int)(Math.random()*10000000);
		}
		
		paralleMergeSort(list1);
		MergSort.mergeSort(list2);;
	}
}
