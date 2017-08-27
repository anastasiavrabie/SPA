/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;



public class eWallet extends  User
{   
    private static final long serialVersionUID = 1L;
    private Factura userFactura;
    private double toPay;
        
    public eWallet()
    {
        this.userFactura = new Factura();
        this.toPay = userFactura.getToPay();
    }
     
    @Override
    public String toString()
    {  
      return super.printUserInfoByID(super.getUserID()) + userFactura.toString() + "\n\nTotal: " + this.toPay;
    }
    
}
