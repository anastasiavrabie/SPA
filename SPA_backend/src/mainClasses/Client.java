/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Client 
{
    private static Socket clientSocket;
    
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    
    public static void main (String[] args)
    {
        try {
            clientSocket = new Socket ("localhost", 12345);
            
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(clientSocket.getInputStream());
           
            //Creating new client
            System.out.println("Write user info");
            System.out.println("User Name:");
            Scanner scanner = new Scanner(System.in);
            String clientName = scanner.nextLine();
           
            System.out.println("Card info:");
            String userCard = scanner.nextLine();
            String CVV = scanner.nextLine();
            
            System.out.println("Choose Package: Platinum, Gold, Silver, Bronze, Average");
            String userPackage = scanner.nextLine();
            
            out.writeObject(clientName);
            
            out.writeObject(userCard);
            out.writeObject(CVV);
            out.writeObject(userPackage);
            
          
            out.flush();
                    } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
