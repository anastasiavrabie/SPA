/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import controllers.Controller;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class Server 
{   
    private ServerSocket serverSocket;
    
    public void run() throws IOException
    {
        try 
        {
            serverSocket = new ServerSocket(12345);
            while(true)
            {
                Socket socket = Controller.acceptConnection(serverSocket);
                ClientThread clientThread = new ClientThread(socket);
                clientThread.run();
            }   
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }        
        finally
        {
            try
            {
                serverSocket.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

    
        
    }
}
