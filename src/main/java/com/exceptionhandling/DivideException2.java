package com.exceptionhandling;

public class DivideException2 {
	
    public static void main(String[] args) {
    	int result  = division(100,0);        // Line 2    
        System.out.println("result : "+result);                   
    }

    public static int division(int totalSum, int totalNumber) {
    	int quotient = -1;
    	System.out.println("Computing Division.");  
    	try{
    		quotient  = totalSum/totalNumber;
    	}
    	catch(Exception e){
    		System.out.println("Exception : "+ e.getMessage());
    	}
    	finally{
    		if(quotient != -1){
    			System.out.println("Finally Block Executes");
    			System.out.println("Result : "+ quotient);
    		}else{
    			System.out.println("Finally Block Executes. Exception Occured");
    			return quotient;
    		}
    		
    	}
    	return quotient;
    }
}
