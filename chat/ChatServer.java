package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * http://docs.oracle.com/javase/tutorial/networking/datagrams/index.html
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/index.html
 *
 * @author Blue Mage
 */
public class ChatServer extends Thread
{

    protected DatagramSocket socket = null;

    public ChatServer() throws SocketException
    {
        this("ChatServer");
    }
    
    public ChatServer(String name) throws SocketException
    {
        super(name);
        socket = new DatagramSocket(50000);
    }

    @Override
    public void run()
    {
        while (true) // while running
        {
            try
            {
                byte[] message = new byte[256];

                // receive message
                DatagramPacket packet = new DatagramPacket(message, message.length);
                socket.receive(packet);
                String[] data = receiveMsg(packet);
                
                // if checksum is "good", print message contents to convo log
                if (chkMsg(data))
                    System.out.println(data[1]);
                else
                    printChkSumError();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public String[] receiveMsg(DatagramPacket packet)
    {
        String allData = new String(packet.getData(), 0, packet.getLength());
        String[] data = allData.split("\n", 2);
        
        return data;
    }
    
    public boolean chkMsg(String[] data)
    {        
        // extract checksum and message strings from packet data
        int chksum = Integer.parseInt(data[0]);
        String msg = data[1];

        // count characters in message
        int numChar = msg.length();
        
        // if checksum count is equal to message count, message is "good"
        if (chksum == numChar)
            return true;
        
        // else, message is bad
        return false; 
    }

    public void printChkSumError()
    {
        System.out.println("The message was not received correctly.");
    }
    
}
