package JavaSyugyou0814;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ParalleSum {
	
	public static void main(String[] args) {
		final int N = 9000000;
	    double[] list = new double[N];
	    for (int i = 0; i < list.length; i++)
	      list[i] = 1;
	   
	    System.out.println("\nThe sum is " + parallelSum(list));
	}
	
	public static double parallelSum(double[] list) {
		RecursiveTask<Double> task=new SumTask(list, 0, list.length);
		ForkJoinPool pool=new ForkJoinPool();
		return pool.invoke(task);
	}
	
	private static class SumTask extends RecursiveTask<Double>{
		
		private final static int THRESHOLD = 1000;
	    private double[] list;
	    private int low;
	    private int high;

	    public SumTask(double[] list, int low, int high) {
	      this.list = list;
	      this.low = low;
	      this.high = high;
	    }
		
		@Override
		protected Double compute() {
			if (high-low<THRESHOLD) {
				double sum=0;
				for(int i=low;i<high;++i)
					sum+=list[i];
				return new Double(sum);
			} else {
				int mid=(low+high)/2;
				RecursiveTask<Double>left=new SumTask(list, low, mid);
				RecursiveTask<Double>right=new SumTask(list, mid, high);
				
				right.fork();
				left.fork();
				return left.join().doubleValue()+right.join().doubleValue();
			}
		}
		
	}
}













































