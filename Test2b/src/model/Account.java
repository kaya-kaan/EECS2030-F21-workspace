package model;

public class Account {
	private String name;
	private int balance;

	private boolean vip;
	private int vipBal;

	public Account(String name, int bal) {
		this.name = name;
		this.balance = bal;

		this.vip = false;
		this.vipBal = 0;
	}
	
	public Account(Account a) {
		this.name = a.getName();
		this.balance = a.getBalance();

		this.vip = a.isVIP();
		this.vipBal = a.getVIPBal();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public boolean isVIP() {
		return this.vip;
	}
	
	public int getVIPBal() {
		return this.vipBal;
	}

	public void switchToVIP(int amount) throws InvalidStatusToSwitchException, InsufficientBalanceException{
		if(this.vip){
			throw new InvalidStatusToSwitchException("Account already has VIP status.");
		}else if(amount > this.balance) {
			throw new InsufficientBalanceException("Balance too low for this action.");
		}else {
			this.vip = true;
			this.vipBal += amount;
			this.balance -= amount;
		}
	}
	
	public void switchToRegular() throws InvalidStatusToSwitchException{
		if(!this.vip){
			throw new InvalidStatusToSwitchException("Account already has regular status.");
		}else {
			this.balance += this.vipBal;
			this.vipBal = 0;
			this.vip = false;
		}
	}

	public String toString() {
		if(this.vip) {
			return "A VIP account owned by " + this.name + " with balance $" + this.balance + " ($" + this.vipBal + 
					" deposited for maintaining the VIP stauts)";
		}else {
			return "A regular account owned by " + this.name + " with balance $" + this.balance;
		}

	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		Account other = (Account) obj;
		
		return this.getName() == other.getName()
				&& this.getBalance() == other.getBalance() && this.isVIP() == other.isVIP();
	}
}
