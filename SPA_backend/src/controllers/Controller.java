/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import models.Factura;
import models.Product;
import models.User;

/**
 *
 * @author User
 */
public class Controller {
    private DatabaseController databaseController;
    private ClientConnection connection;
    private MessageInterpreter messageInterpreter;

    public Controller(Socket socket){
        databaseController = new DatabaseController();
        connection = new ClientConnection(this, socket);
    }

    public static Socket acceptConnection( ServerSocket serverSocket){
        try {
            return serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setUpMessage(ObjectInputStream input, ObjectOutputStream output){
        messageInterpreter = new MessageInterpreter(input, output);
    }

    public String read(){
        return messageInterpreter.getMessage();
    }

    public int readInt(){return messageInterpreter.getInt();}

    public double readDouble(){return messageInterpreter.getDouble();}

    public void write(Object object){
        if(!messageInterpreter.writeObject(object))
            System.out.println(" - Message sent failed");
        else System.out.println(" - Message sent successful ");
    }
   
   

    public void sendsProductList(){ write(getProducts());}
    //CLIENTS
    public void addUser(User client){ databaseController.exportUserList(client);}
    public void deleteuser(int userID) { databaseController.deleteUser(userID);}
    //print userID
    public void getUserID(User client){  databaseController.getUserID(client);}//???????????????
    //print user info
    public String getUserInfo(int userID) { return databaseController.getUserInfo(userID);}
    
    //ZONE
    public void AccesZone(int userID, String zone) {  databaseController.Acces(userID, zone);}
    public int getUsersInZone(String zone) { return databaseController.getUsersInZone(zone);}
    
    public void addProduct(Product product, int quantity){databaseController.exportProductList(product, quantity);}
     public ArrayList<Product> getProducts(){ return databaseController.getProducts();
    } 

      public void deleteProduct(int idProdus){ databaseController.deleteProduct(idProdus); }
    
    //public void addFactura(Factura factura, int userID){databaseController.exportFacturaList(factura, userID);}

     
     public boolean wantsProductList(String message){return messageInterpreter.wantsProductList(message);}
   
    public boolean wantsToAddProduct(String message){
        return messageInterpreter.wantsToAddProduct(message);
    }
    public boolean wantsToDeleteProduct(Product product){
        return messageInterpreter.wantsToDeleteProduct(product);
    }
    public boolean wantsToAddFactura(String message){
        return messageInterpreter.wantsToAddFactura(message);
    }

  
    public boolean clientDisconected(){
        return messageInterpreter.isClientDisconected();
    }
   
    public User readCustomer(){
        return messageInterpreter.getReadUser();
    }

    public Product readProduct(){return messageInterpreter.getReadProduct();}

    //public Factura readFactura(){return messageInterpreter.getReadFactura();}

   
    public void close(){
        databaseController.close();
        connection.close();
    }

    public boolean wantsNewUser(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Factura readFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addFactura(Factura factura, int idClient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean wantsToDelete(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public boolean wantsToAddCustomer(String message) {
        return true;
    }

    public User readUser() {
        return new User();
    }
}
