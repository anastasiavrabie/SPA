/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import controllers.Controller;
import java.net.Socket;
import models.Factura;
import models.Product;
import models.User;

/**
 *
 * @author User
 */


    public class ClientThread implements Runnable {

    Thread t;
    private Controller instance;

    public ClientThread(Socket socket){
        instance = new Controller(socket);
    }

    @Override
    public void run() {
        while(!instance.clientDisconected()){
            String message = instance.read();
            System.out.println(message);
            
             if(instance.wantsToAddCustomer(message) && !instance.clientDisconected()){
                User user = instance.readUser();
                instance.addUser(user);
            }
           
            else if(instance.wantsProductList(message) && !instance.clientDisconected()){
                instance.sendsProductList();
            }
            else if(instance.wantsToAddProduct(message) && !instance.clientDisconected()){
                Product product = instance.readProduct();
                instance.addProduct(product);
            }
           
           
            else if(instance.wantsToAddFactura(message) && !instance.clientDisconected()){
                Factura factura = instance.readFactura();
                int idClient = instance.readInt();
                instance.addFactura(factura, idClient);
            }
           
            else if (instance.wantsToDelete(message) && !instance.clientDisconected()){
                int idProdus = instance.readInt();
                instance.deleteProduct(idProdus);
            }
            
           
        }
        close();
    }

    public void close(){
        instance.close();
    }
}
