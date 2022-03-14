package com.designpattern.Structural.ProxyPattern.internet;

public class ProxyInternetAccess implements OfficeInternetAccess {
    private String employeeName;
    private RealInternetAccess realInternetAccess;

    public ProxyInternetAccess(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getRole(String emplName) {
        // Check role from the database based on Name and designation
        // return job level or job designation.
        return 9;
    }

    @Override
    public void grantInternetAccess() {
        if(getRole(employeeName)>4){
            realInternetAccess = new RealInternetAccess(employeeName);
            realInternetAccess.grantInternetAccess();
        }
        else
        {
            System.out.println("No Internet access granted. Your job level is below 5");
        }
    }
}
