package models;


import java.util.ArrayList;

public class Factura extends eWallet 
{
    private static final long serialVersionUID = 1L;
    private ArrayList<BoughtProduct> boughtProducts;
    private static int id = 0;
    private double toPay;

    public Factura() 
    {
        super();
        this.boughtProducts = new ArrayList<>();
        this.id = generateID();
        this.toPay = 0;
    }
    
    
    public ArrayList<BoughtProduct> getBoughtProducts() { return boughtProducts;}
    public void setBoughtProducts(ArrayList<BoughtProduct> boughtProducts) {this.boughtProducts = boughtProducts; }
    public int getId() { return id; }
    public void setID(int id) { this.id = id; }

    public void addProduct(BoughtProduct prod)
    {         
        this.getBoughtProducts().add(prod);
        this.toPay += prod.getBoughtProductPrice();       
    }
   
    public void removeProduct(BoughtProduct prod) 
    {
        this.getBoughtProducts().remove(prod);
        this.toPay -= prod.getBoughtProductPrice() ;       
    }
    
    public static int generateID()
    {
        return id++;
    }

    @Override
    public String toString() 
    {
        return "Factura:"+ id + "\n" + "\n" + getBoughtProducts();
    }
    
    public double getToPay() { return toPay; }

    public void add(String string, double aDouble, double aDouble0, int aInt, boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getTotalFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public  ArrayList getListaProduse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


