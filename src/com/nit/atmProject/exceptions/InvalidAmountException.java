
//invalid Amount Exceptionclass
package com.nit.atmProject.exceptions;

public class InvalidAmountException extends Exception{

public InvalidAmountException(){
super();
}

public InvalidAmountException(String errMsg){
super(errMsg);
}
}
