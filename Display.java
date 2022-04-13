package bank;
import java.util.ArrayList;
import java.util.Scanner;

interface ATMGUI 
{
    public void DisplayScreen();
     
}


//383421242

//383421243
public class Display implements ATMGUI
{
	public void DisplayScreen()
	{
		Scanner sc = new Scanner(System.in);
		CustomerAccount b = new CustomerAccount();
		while(true)
		{
			System.out.println();
			System.out.println("***SERVICE PROVIDED BY OUR BANK***");
			System.out.println("PRESS 1 TO CREATE ACCOUNT");//CREATE ACCOUNT BUTTON
			System.out.println("PRESS 2 TO DEPOSIT");//DEPOSIT BUTTON
			System.out.println("PRESS 3 TO WITHDRAW");//WITHDRAW BUTTON
			System.out.println("PRESS 4 TO CHECK BALANCE");//CHECK BALANCE BUTTON
			System.out.println("PRESS 5 TO TRANSFER MONEY");//RANSFER MONEY BUTTON
			System.out.println("PRESS 7 TO EXIT");//EXIT BUTTON
			System.out.println("ENTER YOUR CHOICE");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
			{
				//BANKPROCESS b = new BANKPROCESS();			
				b.CreateAccount();
				
				//b.printCustDetails();
				continue;
			}
			
			case 2:
			{		
				b.deposit();
				//b.printCustDetails();
				continue;
			}
			case 3:
			{		
				b.withDraw();
				//b.printCustDetails();
				continue;
			}
			case 4:
			{		
				b.checkBalance();
				//b.printCustDetails();
				continue;
			}
			case 5:
			{		
				b.transferMoney();
				//b.printCustDetails();
				continue;
			}
			case 6:
			{
				b.printCustDetails();
				continue;
			}
			case 7:
			{		
				break;
			}
			}
			System.out.println("*** THANK YOU ***");
			break;
		}
	}
	
	public static void main(String[] args) 
	{
			ATMGUI a = new Display();//LISKOV SUBSTITUTION PRINCIPLE
			a.DisplayScreen();
	}

}
