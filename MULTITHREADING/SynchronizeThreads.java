package JavaSyugyou0719;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizeThreads {
	private Integer sum=new Integer(0);
	
	class SumTask implements Runnable{
		public void run() {
			int value=sum.intValue()+1;
			sum=new Integer(value);
		}
	}
	
	public SynchronizeThreads() {
		ExecutorService executor=Executors.newFixedThreadPool(1000);
		
		for(int i=0;i<1000;++i){
			executor.execute(new SumTask());
		}
		executor.shutdown();
		while(!executor.isTerminated()){
			
		}
	}
}
