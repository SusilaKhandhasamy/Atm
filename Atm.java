package javaintren;
import java.util.Scanner;
public class Atm {
	private int balance;
	private int pin;
	
	public Atm(int balance,int pin) {
		this.balance=balance;
		this.pin=pin;
	}
	public void displayMenu() {
		System.out.println("1.getBalance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdrawal");
		System.out.println("4.Change pin");
		System.out.println("5.Exit");
		}
	public void deposit(int amount) {
		balance+=amount;
	}
	public void withdraw(int amount) {
		if(balance<amount) {
			System.out.println("Insufficient funds!");
			return;
		}
		balance-=amount;
	}
	public int getBalance() {
		return balance;
	}
	public boolean validatePin(int pin) {
		return this.pin==pin;
	}
	public void changePin(int newPin) {
		pin=newPin;
		System.out.println("Pin Changed!");
	}
	
public static void main(String[] args) {
	Atm atm=new Atm(1000,1234);
	atm.displayMenu();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Pin");
	int pin=sc.nextInt();
	System.out.println("Entered Pin: "+pin);
	if(atm.validatePin(pin)) {
		int option =0;
		while(option!=5) {
			atm.displayMenu();
			option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Balance: "+atm.getBalance());
				break;
			case 2:
				System.out.println("Enter Amount");
				int amount=sc.nextInt();
				atm.deposit(amount);
				break;
			case 3:
				System.out.println("Enter Amount");
				amount=sc.nextInt();
				atm.withdraw(amount);
				break;
			case 4:
				System.out.println("Enter New Pin");
				int newPin=sc.nextInt();
				atm.changePin(newPin);
				break;
			case 5:
				System.out.println("Thank you for using ATM!");
				break;
			default:
				break;
				}
			}
		}
	else {
		System.out.println("You have entered Invalid pin!");
	}
}
}
