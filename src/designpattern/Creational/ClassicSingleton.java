package designpattern.Creational;

public class ClassicSingleton {
	 private ClassicSingleton() {};
	   private static ClassicSingleton instance = null;
	   public static ClassicSingleton getInstance() {
	      if(instance == null) {
	         instance = new ClassicSingleton();
	      }
	      return instance;
	   }
	   
	   public static void main(String[] args){
		   ClassicSingleton instance = ClassicSingleton.getInstance();
		   System.out.println("instance =  "+instance.toString());
		   
		   ClassicSingleton anotherInstance = ClassicSingleton.getInstance();
		   System.out.println("anotherInstance =  "+anotherInstance.toString());
		   
		   ClassicSingleton instance3 = new ClassicSingleton();
		   System.out.println("instance3 = "+instance3.toString());
	   }
	   
	}

 