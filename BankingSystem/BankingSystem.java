package BankingSystem;
import java.io.IOException;
import java.util.*;

public class BankingSystem {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        banker b = new banker();
        while(true){
            System.out.println("Enter from the following to execute the command :");
            System.out.println("(1) - Account Creation \t (2) - Check Balance \t (3) - View Personal Data");
            int choice = sc.nextInt();
            switch(choice){
                case 1: b.create();break;
                case 2: b.check_balance();break;
                case 3: b.viewPersonalData();break;
                default: System.out.println("Wrong Choice");
            }
        }
        // sc.close();
    }
}

class Personal_Detail{
    String name;
    String address;
    String PAN_number;
    String Aadhar_number;

    void verify(String name, String address){
        if(name.length() < 2)throw new Error("Name might not valid");
        else if(address.indexOf(" ") == -1 || address.indexOf(',') == -1)throw new Error("Address might not be valid");

    }

    void verify(String pan_number){
        if(pan_number.length() < 11){
            for(int i=0; i<pan_number.length(); i++){
                char ch = pan_number.charAt(i);
                if(!(ch >= '0' && ch<='9' || ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z'))throw new Error("Pan number must contain alphanumberical characters");
            }
        }
    }
}

class Account extends Personal_Detail{
    enum Acc_type{
        SAVINGS,
        CURRENT,
    }
    protected double balance_amount;
    protected String account_number;
    protected Personal_Detail person;
    protected Acc_type accountType;
    Scanner sc = new Scanner(System.in);
    boolean create(){
        try{
            person = new Personal_Detail();
            System.out.println("Enter the following details :");
            System.out.print("Name :");
            person.name = sc.nextLine();
            System.out.print("Address :");
            person.address = sc.nextLine();
            person.verify(person.name,person.address);
            System.out.println("Aadhar Number :");
            person.Aadhar_number = sc.nextLine();
            System.out.println("Pan Number");
            person.PAN_number = sc.nextLine();
            verify(person.PAN_number);
            System.out.println("Please select the following options for the account type :");
            System.out.println("(1) - SAVINGS \t (2) - CURRENT");
            int option = sc.nextInt();
            accountType = option == 1 ? Acc_type.SAVINGS : Acc_type.CURRENT;
            System.out.println("Deposit the money and start your finance journey with LABUK(Los Angeles Bank of United Kingdom)");
            System.out.println("(1) - YES \t (2) - NO");
            option = sc.nextInt();
            if(option == 1)deposit();
            return true;
        }
        catch(Exception e){
            System.out.println("Something went wrong: "+e);
        }
        return false;
    }

    void deposit(){
        System.out.println("Enter the amount of money you want to deposit in you LABUK bank account");
        double val = sc.nextDouble();
        if(val < 0){
            System.out.println("Given amount is not allowed. Please enter a valid amount");
            deposit();
        }
        balance_amount += val;
    }

    boolean withdraw(){
        double WithdrawAmount = sc.nextDouble();
        if(WithdrawAmount < balance_amount){
            balance_amount -= WithdrawAmount;
            System.out.println(WithdrawAmount+" has been successfully withdrawn");
            return true;
        }
        System.out.println("There are not enough funds in you bank account");
        return false;
    }

    void viewBalance(){
        System.out.println("Balance amount in "+account_number+" is : "+balance_amount);
    }

    void viewPersonalDetails(){
        System.out.println("Name : "+person.name);
        System.out.println("Address : "+person.address);
        System.out.println("Aadhar number : "+person.Aadhar_number);
        System.out.println("Pan number : "+person.PAN_number);
    }
}

class banker extends Account{
    // Account[] bankAccnts = new Account[n];
    public banker(){
        super.create();
    }
    // check balance
    public void check_balance(){
        super.viewBalance();
    }
    //view personal Details
    public void viewPersonalData(){
        super.viewPersonalDetails();
    }
}