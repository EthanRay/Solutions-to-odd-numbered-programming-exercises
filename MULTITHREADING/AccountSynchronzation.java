package JavaSyugyou0814;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountSynchronzation {
	private static Account account=new Account();
	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
		
		System.out.println("Deopist Task\t\tWithdraw Task\t\tBalance");
	}
	
	public static class DepositTask implements Runnable {
		public void run() {
			try {
				while (true) {
					account.desposit((int)(Math.random()*10)+1);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static class WithdrawTask implements Runnable {
		public void run() {
			while (true) {
				account.withdraw((int)(Math.random()*10)+1);
			}
		}
		
	}

	public static class Account{
		private int balance=0;
		public int getBalance()
		{
			return balance;
		}
		public synchronized void desposit(int amount)
		{
			balance+=amount;
			 System.out.println("Deposit " + amount +
				        "\t\t\t\t\t" + getBalance());
			notifyAll();
		}
		public synchronized void withdraw(int amount){
			try {
				while (balance<amount) {
					wait();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			balance-=amount;
			  System.out.println("\t\t\tWithdraw " + amount +
				        "\t\t" + getBalance());
		}
		
	}
}
