package JavaSyugyou0719;

public class Account {
	private int balance=0;
	public int getBalance() {
		return balance;
	}
	public synchronized void deposit(int amout) {
		balance+=amout;
		System.out.println("Deposit"+amout+"\t\t\t\t\t"+getBalance());
		notifyAll();
	}
	public synchronized void withdraw(int amout){
		try {
			while(balance<amout)
				wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		balance-=amout;
		System.out.println("\t\t\tWithdraw " + amout +
		        "\t\t" + getBalance());
	}
}
