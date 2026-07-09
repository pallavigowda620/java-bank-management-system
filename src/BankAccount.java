public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;

    }
    @Override
    public String toString(){
        return "Account Number: "+ accountNumber +
                " ,Account Holder Name: "+ accountHolderName +
                " ,Balance: "+ balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public double getBalance(){
        return balance;
    }



    public void deposit(double amount){
        if(amount > 0 ){
            balance += amount;
            System.out.println("Deposited ₹" + amount + " Sucessfully!");
        } else {
            System.out.println("Deposit amount must  be greater than zero.");
        
        }

    }

    public void withdraw(double amount){
        if(amount <= 0){
           System.out.println("Withdrawl amount should be greater than zero");
        }else if(amount > balance){
            System.out.println("Insufficient balance!");
        
        } else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " Successfully!");
        }
        
    }


}

