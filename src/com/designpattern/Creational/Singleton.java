package com.designpattern.Creational;

public class Singleton {
	  // Private constructor prevents instantiation from other classes
	  private Singleton() {}
	  private static final Singleton INSTANCE = new Singleton();

	  public static Singleton getInstance() {
	    return INSTANCE;
	  }
		   public static void main(String[] args){
			   Singleton instance = Singleton.getInstance();
			   System.out.println("instancea="+instance.toString());
			   
			   Singleton anotherInstance = Singleton.getInstance();
			   System.out.println("anotherInstancea="+anotherInstance.toString());
			   
			   Singleton instance3 = new Singleton();
			   System.out.println("instancea="+instance3.toString());

			   System.out.println("instancea="+new Singleton());
	   }
	}
