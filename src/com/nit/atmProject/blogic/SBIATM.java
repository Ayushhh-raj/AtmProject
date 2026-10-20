package com.nit.atmProject.blogic;

import com.nit.atmProject.spec.ATMCard;
import com.nit.atmProject.exceptions.InsufficientFundsException;
import com.nit.atmProject.exceptions.InvalidAmountException;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

//SBI ATM Class

public class SBIATM implements ATMCard{
private static String bankName;
private static String branchName;
private static String ifsc;

private long accNum;
private String accHName;
private double balance;
static{
try( 
BufferedReader br=
                  new BufferedReader(new FileReader("bankdetailsSBI.txt"));


){   			
					
			bankName	= br.readLine();  //reading values from the file	 
			branchName	= br.readLine();  //and storing in SVs		
			ifsc		= br.readLine();	 		
			
			System.out.println("  SBICard class is loaded");
			System.out.println("  bank details are read from file");
			System.out.println("  stored in static fileds\n");
			
		}catch(FileNotFoundException e) {
			throw new RuntimeException("the file 'bankdetailsSBI.txt' is not found\n");
			
		}catch(IOException e) {
			e.printStackTrace();	
			
		}
		
	}
	
	//initializing non-static field accNum	
	{
		
		try(
			DataInputStream dis =
			  new DataInputStream(new FileInputStream("accnumseq3.data"))
		){
			this.accNum = dis.readLong() + 1;
			
		}catch(IOException e){
			//System.out.println("Error: " + e); //e.toString()
			
			this.accNum = 876500000003L;
		}
		
		
		try(
			DataOutputStream dos = 
			  new DataOutputStream(new FileOutputStream("accnumseq3.data"))
		){
			dos.writeLong(this.accNum);
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	//initializing the other 2 instance fields accHName and balance
	public SBIATM(String accHName, double balance) {
		
		this.accHName = accHName;
		this.balance = balance;
		System.out.println("  SBIBankCard object is created\n");
	}
	
	@Override
	public String deposit(double amt)
			throws InvalidAmountException {
		if(amt<=0)
			throw new InvalidAmountException("Don't pass -ve amount");
			
		this.balance = this.balance + amt;

		return alert(amt, "credited");
			
	}
	
	@Override		
	public String withdraw(double amt)
			throws InvalidAmountException, InsufficientFundsException{
		if(amt<0)
			throw new InvalidAmountException("Don't pass -ve amount");
			
		if(amt>balance)
			throw new InsufficientFundsException("Insufficient Funds");
			
		this.balance = this.balance - amt;
		
		return alert(amt, "debited");
			
	}
		
	@Override		
	public void currentBalance(){
		System.out.println("SBI Bank account "+accNum+" balance: " + balance);
	}
	
	private String alert(double amt, String operation) {
		return String.format(
			"The amount %s %s to SBIBank account %d", amt, operation, accNum);
	}
	
	@Override
	public String toString() {
		return "HDFC Bank Account details\n" +  
				" bankName\t: "+ bankName + "\n" +
				" branchName\t: "+ branchName + "\n" +
				" ifsc\t\t: "+ ifsc + "\n" +
				" accNum\t\t: "+ accNum + "\n" +
				" accHName\t: "+ accHName + "\n" +
				" balance\t: "+ balance;
	}
}

