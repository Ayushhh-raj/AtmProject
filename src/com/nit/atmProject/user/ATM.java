
//ATM.java
package com.nit.atmProject.user;

import com.nit.atmProject.spec.ATMCard;
import com.nit.atmProject.exceptions.InvalidAmountException;
import com.nit.atmProject.exceptions.InsufficientFundsException;

import java.util.Scanner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class ATM {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
	
		System.out.print("Insert card: ");
		String cardName = scn.next(); scn.nextLine();
		
		try {
			//loading class
			Class<?> cls = Class.forName(cardName);
				
			//creating object by using string, double param constructor	
			Constructor paramConstructor = cls.getConstructor(String.class, double.class);
			
				System.out.print("Enter accHName: ");
				String accHName = scn.nextLine();
				
				System.out.print("Enter balance: ");
				double balance = scn.nextDouble(); scn.nextLine();

			Object obj = paramConstructor.newInstance(accHName, balance);
			System.out.println("obj: "+ obj);
			
		}catch(ClassNotFoundException e) {
			System.out.println(cardName + ".class file is not found");
			
		}catch(NoSuchMethodException | InstantiationException e){
			System.out.println("String, double param constructor is not found");

		}catch(IllegalAccessException e){
			System.out.println("String, double param constructor must be public");
		
		}catch(InvocationTargetException e) {
			e.printStackTrace();	
			
		}catch(ExceptionInInitializerError e){
			Throwable t = e.getCause();
			System.out.println("Error: " + t.getMessage());	
		}
		
		
	}
}
