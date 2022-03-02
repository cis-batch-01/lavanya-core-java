package com.technocis.corejava.practice;

public class ExceptionHandlingSample {
public static void main(String[] args) {
	
	
	int num1=25, num2=0,res;
	try
	{
		res=num1/num2;
	}
catch(Exception e)
	{
	//System.out.println(e.getMessage());   // only msg
	// System.out.println(e);  // what error + msg 
	System.out.println("(not divisible by 0)"+ e.getLocalizedMessage());   //get msg  and get localized msg both are same
}
}
}