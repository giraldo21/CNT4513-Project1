/*
Author: Juan Martinez
*/
package project1;

public class Main {

    public static void main(String[] args) {
        Server myServer = new Server("ServerThread");
        Client myClient = new Client("ClientThread");
        myServer.start();
        myClient.start();
    }

}
