package com.nit.atmProject.spec;
import com.nit.atmProject.exceptions.InsufficientFundsException;
import com.nit.atmProject.exceptions.InvalidAmountException;

public interface ATMCard{

public String deposit(double amt)
                 throws InvalidAmountException;
public String withdraw(double amt)
                 throws InvalidAmountException,InsufficientFundsException;
public void currentBalance();

}
                