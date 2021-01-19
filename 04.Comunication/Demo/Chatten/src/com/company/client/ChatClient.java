package com.company.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    private String hostname;
    private int port;
    private String userName;
    WriteThread writeThread;

    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void init(){
        try {
            Socket socket = new Socket(hostname, port);

            System.out.println("Connected to the chat server");

            new ReadThread(socket, this).start();

            writeThread = new WriteThread(socket, this);
        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

    public void write(String text){
        writeThread.write(text);
    }

    void setUserName( String userName){
        this.userName = userName;
    }

    String getUserName() {
        return this.userName;
    }

    public static void main(String[] args) {

        String hostname =  "192.168.1.131";
        int port = 8989;

        ChatClient client = new ChatClient(hostname, port);
        GUI gui = new GUI(client);
        client.init();
    }
}
