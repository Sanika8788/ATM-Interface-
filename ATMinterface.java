package JavaProject;

import java.util.Scanner;

class BankAccount{
	
	String name;
	String userName;
	String password;
	String accountNo;
    float balance = 10000f;
    int transaction = 0;
    String transactionHistory = "";
    
    public void register() {
    	    Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter your Name: ");
			this.name = sc.nextLine();
			System.out.println("\nEnter your Username: ");
			this.userName = sc.nextLine();
			System.out.println("\nEnter your Password: ");
			this.password = sc.nextLine();
			System.out.println("\nEnter your Account Number: ");
			this.accountNo = sc.nextLine();
         	System.out.println("\nRegistration Successful. Please Log in to ypur Bank account ");
    			
    }
    public boolean login() {
    	boolean ialogin = false;
    	Scanner sc = new Scanner(System.in);
			while(!ialogin) {
				System.out.println("\nEnter your username: ");
				String Username = sc.nextLine();
				if(Username.equals(userName)) {
					while(! ialogin) {
						System.out.println("\nEnter your password: ");
						String Password = sc.nextLine();
						if(Password.equals(Password)) {
							System.out.println("\nLogin Succesfully");
							ialogin = true;
						}
						else {
							System.out.println("\nIncorrect Password");
						}
					}
				}else {
					System.out.println("\nUsername not found");
				}
			}
		
    	return ialogin;
    }
    
    public void withdraw() {
    	System.out.println("\nEnter Amount to Withdraw: ");
    	Scanner sc = new Scanner(System.in);
			float amount = sc.nextFloat();
			try {
				if(amount <= 1000) {
					transaction++;
					balance -= amount;
					System.out.println("\nWithdral Successful.");
					String str = amount + "Rs Withdrawn\n";
					transactionHistory = transactionHistory.concat(str);
				}else {
					System.out.println("Insufficent balance.");
				}
			}catch(Exception e) {
				
			}
    }
    
    public void deposit() {
    	System.out.println("\nEnter Amount to Deposit: ");
    	Scanner sc = new Scanner(System.in);
			float amount = sc.nextFloat();
			try {
				if(amount <= 10000f) {
					transaction++;
					balance += amount;
					System.out.println("\nDeposit Successful.");
					String str = amount + "Rs deposited\n";
					transactionHistory = transactionHistory.concat(str);
				}else {
					System.out.println("Sorry. The limit is 10000.");
				}
			}catch(Exception e) {
				
			}
    }
    
    public void trsansfer() {
    	Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter Receipent`s Name: ");
			String receipent = sc.nextLine();
			System.out.println("\nEnter Amount to transfer: ");
				float amount = sc.nextFloat();
				try {
					if(balance>= amount) {
					if(amount <= 50000f) {
						transaction++;
						balance -= amount;
						System.out.println("\nSuccessfully transferred to "+ receipent);
						String str = amount + "Rs tranasferred to " + receipent+"\n";
						transactionHistory = transactionHistory.concat(str);
					}else {
						System.out.println("Sorry. The limit is 50000.");
					}
				}else{
					System.out.println("\nInsuffient balance.");
				}}catch(Exception e) {
					
			} 	
	}
    
    public void checkbalance() {
    	System.out.println("\n"+balance+"Rs");
    }
    
    public void transHistory() {
    	if(transaction ==0) {
    		System.out.println("No Transactions happened");
    	}else {
    		System.out.print("\n"+transactionHistory);
    	}
    }
}

public class ATMinterface {

	public static int takenIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while(!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if(flag && input>limit || input<1) {
					System.out.println("Choose the number between 1 to "+limit);
					flag = false;
				}
			}catch(Exception e) {
				System.out.println("Enter only integer value.");
				flag = false;
			}
		}
		return input;
	}
	
	public static void main (String[] args) {
		System.out.println("\n*********************WELCOME TO OPTIYX ATM INTERFACE********************");
		System.out.println("\n1.Register \n2.Exit");
		System.out.println("Choose one option");
		int choose = takenIntegerInput(2);
		
		if(choose == 1) {
			BankAccount b= new BankAccount();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.println("Choose one option");
				int ch = takenIntegerInput(2);
				if(ch==1) {
					if(b.login()) {
						System.out.println("\n*********************WELCOME BACK"+b.name+"********************");
						boolean isFinished = false;
						while(!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.println("Choose one option");
							int c = takenIntegerInput(2);
							switch(c) {
							case 1:
								b.withdraw();
							case 2:
								b.deposit();
							case 3:
								b.trsansfer();
							case 4:
								b.checkbalance();
							case 5:
								b.transHistory();
							case 6:
								isFinished = true;
								break;
							}
						}
					}
				}else {
					System.exit(0);
				}
			}
		}else {
			System.exit(0);
		}
		
	}
}
