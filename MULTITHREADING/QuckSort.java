package JavaSyugyou0814;

public 	class QuckSort {
	public static void quickSort(int[] list,int first,int last) {
		if(last>first)
		{
			int piv=partition(list, first, last);
			quickSort(list, first, piv-1);
			quickSort(list, piv+1, last);
		}
	}
	
	
	public static int partition(int[] list,int first,int last) {
		int pivot=list[first];
		int low=first+1;
		int high=last;
		
		while (high>low) {
			while (low<=high&&list[low]<=pivot) {
				low++;
			}
			while (low<=high&&list[high]>pivot) {
				high--;
			}
			if(low<high)
			{
				int tmp=list[high];
				list[high]=list[low];
				list[low]=tmp;
			}
		}
		
		while (high>first&&list[high]>=pivot) {
			high--;
		}
		
		if(pivot>list[high])
		{
			list[first]=list[high];
			list[high]=pivot;
			return high;
		}else {
			return first;
		}
	}
}





























