/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author User
 */
class ClientConnection 
{

private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    public Controller instance;

    public ClientConnection(Controller controller, Socket socket){
        instance = controller;
        this.socket = socket;
        setUpStreams();
    }

    private void setUpStreams(){
        try {
            System.out.println("Starting streams");
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.flush();
            inputStream = new ObjectInputStream(socket.getInputStream());
            instance.setUpMessage(inputStream, outputStream);
            instance.write("Connection succesfull");
        } catch (IOException e) {
            instance.write("Cannot get streams");
        }
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public void close(){
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
        }
    }
}
