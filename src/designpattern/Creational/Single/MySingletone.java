package designpattern.Creational.Single;

public class MySingletone {
    private MySingletone(){};
    private static MySingletone Instance = new MySingletone();

    public static MySingletone getMySingletone(){return Instance;};

    public  static void main(String args[]){
        System.out.println("object 1 ="+ getMySingletone());
        System.out.println("object 2 ="+ getMySingletone());
        System.out.println("object 3 ="+ getMySingletone());
        System.out.println("object 3 ="+ new MySingletone());

    }
}
