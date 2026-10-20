//Insufficient funds
package com.nit.atmProject.exceptions;

public class InsufficientFundsException extends Exception{

public InsufficientFundsException(){
super();
}

public InsufficientFundsException(String errMsg){
super(errMsg);
}
}
