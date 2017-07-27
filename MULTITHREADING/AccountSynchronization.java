package JavaSyugyou0719;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountSynchronization {
	private static Account account=new Account();
	public static class DepositTask implements Runnable{
		public void run() {
			try {
				while(true){
					account.deposit((int)(Math.random()*10)+1);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static class WithdrawTask implements Runnable {
		public void run() {
			while(true){
				account.withdraw((int)(Math.random()*10+1));
			}
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
		
		System.out.println("Deopist Task\t\tWithdraw Task\t\tBalance");
	}
}
















































