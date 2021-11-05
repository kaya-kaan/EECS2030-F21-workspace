package model;

public class Bank {
	private Account[] accounts;
	private int noc;
	
	public Bank() {
		this.accounts = new Account[5];
		this.noc = 0;
	}
	
	public Bank(Bank b) {
		this.accounts = b.getAccounts();
		this.noc = b.getNOC();
	}
	
	public Account[] getAccounts() {
		return this.accounts;
	}
	
	public int getNOC() {
		return this.noc;
	}
	
	public int getNumberOfAccounts() {
		return this.noc;
	}
	
	public Account[] getReferencesOfAccounts() {
		Account[] accs;
		int count = 0;
		
		for (int i = 0 ; i < this.accounts.length ; i++) {
			if(this.accounts[i] != null) {
				count++;
			}
		}
		
		accs = new Account[count];
		count = 0;
		
		for (int i = 0 ; i < this.accounts.length ; i++) {
			if(this.accounts[i] != null) {
				accs[count] = this.accounts[i];
				count++;
			}
		}
		return accs;
	}
	
	public Account[] getCopiesOfAccounts() {
		Account[] accs;
		int count = 0;
		
		for (int i = 0 ; i < this.accounts.length ; i++) {
			if(this.accounts[i] != null) {
				count++;
			}
		}
		
		accs = new Account[count];
		count = 0;
		
		for (int i = 0 ; i < this.accounts.length ; i++) {
			if(this.accounts[i] != null) {
				accs[count] = new Account(this.accounts[i]);
				count++;
			}
		}
		return accs;
	}
	
	public void addAccount(Account a) {
		this.accounts[this.noc] = a;
		this.noc++;
	}
	
	public void addAccounts(Account[] accs) {
		for (int i = 0 ; i < accs.length ; i++) {
			this.accounts[this.noc] = accs[i];
			this.noc++;
		}
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		Bank other = (Bank) obj;

		boolean equalsAccounts = true;
		for (int i = 0 ; i < this.noc ; i++) {
			if(this.accounts[i].equals(other.getAccounts()[i])) {
				
			}else {
				equalsAccounts = false;
			}
		}

		return this.getNOC() == other.getNOC() && equalsAccounts;
	}
	
}
