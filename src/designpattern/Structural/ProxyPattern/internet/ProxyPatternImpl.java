package designpattern.Structural.ProxyPattern.internet;

public class ProxyPatternImpl {
    public static void main(String[] args){
        OfficeInternetAccess officeInternetAccess = new ProxyInternetAccess("jalal hosseini");
        officeInternetAccess.grantInternetAccess();
    }
}
