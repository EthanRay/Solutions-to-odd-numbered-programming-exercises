package JavaSyugyou0719;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelArrayInitializer {
	
	public static void main(String[] args) {
		final int N=9000000;
		double[] list=new double[N];
		long startTime=System.currentTimeMillis();
		for(int i=0;i<list.length;++i){
			list[i]=Math.random()*100000;
		}
		long endTime=System.currentTimeMillis();
		System.out.println("Sequential time is "+(endTime-startTime));
		
		startTime=System.currentTimeMillis();
		parallelAssignValues(list);
		endTime=System.currentTimeMillis();
		System.out.println("Time with"+Runtime.getRuntime().availableProcessors()+
				" processors: "+(endTime-startTime));
	}
	
	
	public static void parallelAssignValues(double[] list) {
		RecursiveAction task=new ParallelAssign(list, 0,list.length);
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(task);
	}
	
	
	
	public static class ParallelAssign extends RecursiveAction {
		private final static int THRESHOLD=10000;
		private double[] list;
		private int low;
		private int high;
		
		public ParallelAssign(double[] list,int low,int high) {
			this.list=list;
			this.low=low;
			this.high=high;
		}
		@Override
		protected void compute() {
			Random r=new Random();
			if(high-low<THRESHOLD){
				for(int i=low;i<high;++i)
					list[i]=r.nextDouble();
			}else{
				int mid=(low+high)/2;
				invokeAll(new ParallelAssign(list, low, mid),
						new ParallelAssign(list, mid, high));
			}
		}
	}
}

























































