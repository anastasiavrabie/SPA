package models;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class BoughtProduct implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Product product;
   
    private int productQuantity;
    private double toPay;
    
    
    public BoughtProduct(Product product, int productQuantity)
    {
        super();
        this.productQuantity = productQuantity;       
        if(product.equals(product.getClassic())) { this.product = product.getClassic(); }
        if(product.equals(product.getSilver())) { this.product = product.getSilver(); }
        if(product.equals(product.getGold())) {this.product = product.getGold(); }
        if(product.equals(product.getPlatinum())){ this.product = product.getPlatinum(); }
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getProductQuantity() { return productQuantity; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }
    
    public double  getBoughtProductPrice(){return this.toPay *= this.productQuantity; }    
        
    @Override
    public String toString () { return "Bought Product: " + product.getProductName() + "\ncantitae: " + productQuantity + ""; }

   

            
}
