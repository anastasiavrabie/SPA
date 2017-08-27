/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Product implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String productName;
    private double productPrice;
    private int product_id;
    private Product  classic;
    private Product silver ;
    private Product gold ;
    private Product platinum ;
    
    
    public Product(String name, double price, int id) 
    {
        super();
        this.productName = name;
        this.productPrice = price;
        this.product_id = id;
        
    }
    
    public double getProductPrice() { return productPrice; }
    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    
    public Product getClassic() { return classic; }
    public void setClassic(Product classic) { this.classic = new Product("Classic", 290, 1); }

    public Product getSilver() { return silver;}
    public void setSilver(Product silver) {  this.silver = new Product("Silver", 380, 2);}

    public Product getGold() { return gold; }
    public void setGold(Product gold) { this.gold= new Product("Gold", 450, 3);}

    public Product getPlatinum() { return platinum; }
    public void setPlatinum(Product platinum) { this.platinum = new Product("Platinum", 520, 4);}

    public Product() {
    }

    public int generateID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isServices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getProductId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
