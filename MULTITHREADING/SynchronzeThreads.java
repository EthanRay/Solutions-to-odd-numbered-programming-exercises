package JavaSyugyou0814;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronzeThreads {
	private Integer sum=new Integer(0);
	
	public SynchronzeThreads() {
		ExecutorService executor=Executors.newFixedThreadPool(1000);
		
		for(int i=0;i<1000;i++){
			executor.execute(new SumTask());
		}
		
		
		executor.shutdown();
		
		while (!executor.isTerminated()) {
			
		}
	}
	
	class SumTask implements Runnable{
		@Override
		public void run() {
			int va=sum.intValue()+1;
			sum=new Integer(va);
		}
	}
	
	public static void main(String[] args) {
		SynchronzeThreads test=new SynchronzeThreads();
		System.out.println(test.sum);
	}
}
