package bank;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerAccount 
{
    static long acc_number = 383421241L;
    
	protected long acc=0;
	
	private double balance = 0;
	private int age = 0;
	private String name = "";
	private String gender = "";
	private String password = "";
	private long phoneNumber = 0;
	
	protected int flag = 0;
	
	static ArrayList<CustomerAccount> detailsList = new ArrayList();
	
	
	Scanner s = new Scanner(System.in);
	
	public final void getInformation()
	{
		System.out.println("Enter Your Good Name");
	    this.name = s.nextLine();
	    System.out.println("Enter Your Age");
	    this.age = s.nextInt();
	    System.out.println("Enter Your gender");
	    this.gender = s.next();
	    System.out.println("Enter Your Phone Number");
	    this.phoneNumber = s.nextLong();
	    boolean check;
	    while(true)
	    {
	    	System.out.println("Set the Password for Your Account");
	    	System.out.println("*** please enter your password that must atleast contain one Upper Case Letter,one special character('$','_') and one number ***");
	    	this.password = s.next();
	    	check = passwordchecker.password_check(password);
		    if(check == false)
		    	continue;
		    else 
		    	break;
	    }
	    
	    if(this.flag == 1)
			System.out.println("YOUR ACCOUNT TYPE: CURRENT ACCOUNT account holder's name: " + this.name);
	    if(this.flag == 2)
	    	System.out.println("YOUR ACCOUNT TYPE: SAVINGS ACCOUNT account holder's name: " + this.name);
	    
	    //detailsList.add(this);
	    System.out.println("Your Account Number: " + this.acc);
	}
	
    public final void CreateAccount()
	{
		System.out.println("CHOOSE YOUR ACCOUNT TYPE:");
		System.out.println("Enter C --> currentAccount S --> savingsAccount");
		char acc_type = s.next().charAt(0);
		if(acc_type == 'C' || acc_type == 'c')
		{
		    currentAccount ca = new currentAccount();
		    
		}
		if(acc_type == 'S' || acc_type == 's')
		{
		    savingsAccount sa = new savingsAccount();
		    
		}
	}
	
	public final void deposit()
	{
		while(true)
		{
			System.out.println("ENTER YOUR ACCOUNT NUMBER");
			long acc_number = s.nextLong();
			for(int i =0;i<detailsList.size();i++)
			{
				CustomerAccount c1 = (CustomerAccount)detailsList.get(i);
				if(c1.acc == acc_number)
				{
					if(c1.flag == 1)
						System.out.println("YOUR ACCOUNT TYPE: CURRENT ACCOUNT account holder's name: " + c1.name);
				    if(c1.flag == 2)
				    	System.out.println("YOUR ACCOUNT TYPE: SAVINGS ACCOUNT account holder's name: " + c1.name);
				    
				    while(true)
				    {
				    System.out.println("Enter the amount to deposit");
					double dep_amount = s.nextDouble();
					if(c1.flag == 1 && dep_amount >= 60000)
					{
					    c1.balance += dep_amount;
					    System.out.println("Amount Rs." + dep_amount + "successfully credited to account: " + c1.acc);
					    return;
					}
					else if(c1.flag == 2)
					{
						c1.balance += dep_amount;
					    System.out.println("Amount Rs." + dep_amount + "successfully credited to account: " + c1.acc);
					    return;
					}
					else 
					{
						System.out.println("You Account type - MAXIMUM BALANCE BUSINESS ACCOUNT");
				        System.out.println("SO PLEASE DEPOSIT atleast Rs.60,0000 TO YOUR ACCOUNT!!");
				        i = 0;
						continue;
					}
				  }
			     }
			}
			System.out.println("PLEASE ENTER THE VALID ACCOUNT NUMBER!!!");
			continue;
		}
	}
	
	
	 public final void withDraw()
     {
    	while(true)
    	{
    		System.out.println("ENTER YOUR ACCOUNT NUMBER");
    		long acc_number = s.nextLong();
    		System.out.println("ENTER YOUR ACCOUNT PASSWORD");
    		String pass = s.next();
    		for(CustomerAccount c1 : detailsList)
    		{
    			if(c1.acc == acc_number)
    			{
    				if((c1.password).equals(pass))
    				{
    					if(c1.flag == 1)
    						System.out.println("YOUR ACCOUNT TYPE: CURRENT ACCOUNT account holder's name: " + c1.name);
    				    if(c1.flag == 2)
    				    	System.out.println("YOUR ACCOUNT TYPE: SAVINGS ACCOUNT account holder's name: " + c1.name);
    				    System.out.println("Enter the amount to withdraw");
    					double with_amount = s.nextDouble();
    					if(with_amount > c1.balance)
    					{
    						System.out.println("INSUFFICIENT BALANCE");
    						return;
    					}
    					c1.balance -= with_amount;
    					if(c1.flag == 1 && c1.balance <= 60000)
    					{
    						c1.balance += with_amount;
    						System.out.println("You Account type - MAXIMUM BALANCE BUSINESS ACCOUNT");
    				        System.out.println("SO YOUR ACCOUNT MUST CONTAIN atleast Rs.60,0000!!");
    				        System.out.println("UNABLE TO WITHDRAW!!");
    				        return;
    					}
    					else
    					{
    						System.out.println("Amount Rs." + with_amount + "successfully withdrawn from account: " + c1.acc);
    					    return;
    					}
    				}
    			}
    		}
    		System.out.println("INVALID ACCOUNT NUMBER/PASSWORD TRY AGAIN!!!");
    		continue;
    	}
    }
    
	public final void checkBalance()
    {
    	while(true)
    	{
    		System.out.println("ENTER YOUR ACCOUNT NUMBER");
    		long acc_number = s.nextLong();
    		System.out.println("ENTER YOUR ACCOUNT PASSWORD");
    		String pass = s.next();
    		for(CustomerAccount c1 : detailsList)
    		{
    			if(c1.acc == acc_number)
    			{
    				if((c1.password).equals(pass))
    				{
    					if(c1.flag == 1)
    						System.out.println("YOUR ACCOUNT TYPE: CURRENT ACCOUNT account holder's name: " + c1.name);
    				    if(c1.flag == 2)
    				    	System.out.println("YOUR ACCOUNT TYPE: SAVINGS ACCOUNT account holder's name: " + c1.name);
    				  
    				    System.out.println("YOUR CURRENT ACCOUNT BALANCE" + c1.balance);
    					return;
    				}
    			}
    		}
    		System.out.println("INVALID ACCOUNT NUMBER/PASSWORD TRY AGAIN!!!");
    		continue;
    	}
    }
    
    public final void transferMoney()
    {
    	while(true)
    	{
    		int send_flag = 0,receiver_flag = 0;
        	System.out.println("ENTER YOUR ACCOUNT NUMBER");
    		long acc_number = s.nextLong();
    		System.out.println("ENTER THE RECEIPIENT ACCOUNT NUMBER");
    		long receiver_acc_number =  s.nextLong();
    		CustomerAccount r = null;
    		for(int i=0;i<detailsList.size();i++)
    		{
    			CustomerAccount c1 = (CustomerAccount)detailsList.get(i);
    			if(c1.acc == acc_number)
    			{
    				send_flag = 1;
    				
    			}
    			else if(c1.acc == receiver_acc_number)
    			{
    				r = c1;
    				receiver_flag = 1;
    			}
    		}
    		if(send_flag == 0 ||  receiver_flag == 0)
    			continue;
    		System.out.println("ENTER YOUR ACCOUNT PASSWORD");
    		String pass = s.next();
    		for(CustomerAccount c1 : detailsList)
    		{
    			if((c1.password).equals(pass))
    			{
    				System.out.println("Enter the amount to transfer");
    				long transfer_amount = s.nextLong();
    				c1.balance -= transfer_amount;
    				if(c1.flag == 1 && c1.balance <= 60000)
					{
						System.out.println("You Account type - MAXIMUM BALANCE BUSINESS ACCOUNT");
				        System.out.println("SO YOUR ACCOUNT MUST CONTAIN atleast Rs.60,0000!!");
				        System.out.println("UNABLE TO TRANSFER!!");
				        return;
					}
    				else
    				{
    					r.balance += transfer_amount;
    		            System.out.println("Money Rs." + transfer_amount + "is tranfered from account" + c1.acc +"to account" + r.acc);
    		            System.out.println("your account "+ c1.acc + " current balance is " + c1.balance);
 	                    return;
    			    }
    			}
    		}
    		System.out.println("INVALID ACCOUNT PASSWORD TRY AGAIN!!");
    		continue;
    	}
    }
    
    public final void printCustDetails()
    {
    	for(CustomerAccount c1 : detailsList)
    	{
    		if(c1.flag == 1)
    		{
				System.out.println("CUSTOMER ACCOUNT TYPE: CURRENT ACCOUNT account holder's name: " + c1.name);
				System.out.println("ACCOUNT NUMBER: " + c1.acc + "NAME: " + c1.name + "AGE: " + c1.age + "GENDER: " + c1.gender + "Phone Number" + c1.phoneNumber);
    		}
		    if(c1.flag == 2)
		    {
		    	System.out.println("CUSTOMER ACCOUNT TYPE: SAVINGS ACCOUNT account holder's name: " + c1.name);
		    	System.out.println("ACCOUNT NUMBER: " + c1.acc + "NAME: " + c1.name + "AGE: " + c1.age + "GENDER: " + c1.gender + "Phone Number" + c1.phoneNumber);
		    }
		  
    		
    	}
    }
    
}

class currentAccount extends CustomerAccount
{
    //static ArrayList<currentAccount> ca = new ArrayList();
    
    currentAccount()
    {
    	this.acc = ++acc_number;
        System.out.println("You have chosen currentAccount type - MAXIMUM BALANCE BUSINESS ACCOUNT");
        System.out.println("SO PLEASE DEPOSIT atleast Rs.60,0000 TO YOUR ACCOUNT AFTER CREATING YOUR ACCOUNT!!!");
        this.flag = 1;
        this.getInformation();
        //ca.add(this);
        detailsList.add(this);
    }
}

class savingsAccount extends CustomerAccount
{
    //static ArrayList<savingsAccount> sa = new ArrayList();
    
    savingsAccount()
    {
    	this.acc = ++acc_number;
        System.out.println("You have chosen savingsAccount type - MINIMAL BALANCE ACCOUNT");
        this.flag = 2;
        this.getInformation();
        //sa.add(this);
        detailsList.add(this);
    }
}



