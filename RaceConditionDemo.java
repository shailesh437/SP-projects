
public class RaceConditionDemo {
	
	public static void main(String[] args) {
	   BankAccount task = new BankAccount();
	   task.setBalance(100);
	   
	   Thread J = new Thread(task);
	   Thread A = new Thread(task);	   
	   J.setName("J");
	   A.setName("A");
	   J.start();
	   A.start();	   
	}
}

class BankAccount implements Runnable {
	private int balance;
	public void setBalance(int balance) {
		this.balance = balance;		
	}
	
	public void run() {
		makeWithdrawal(75);
		if (balance < 0) {
			System.out.println("Money overdrawn!!!");
		}
	}	

	private void makeWithdrawal(int amount) {
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " is about to withdraw ...");
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + " bucks");
	    } else {
	    	System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
	    }
	}
	
}
