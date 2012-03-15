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

                // compute checksum

                // if checksum is bad, respond to client with error message

                // else print message in conversation log
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void receiveMsg()
    {
    
    }
    
    public void computeChkSum()
    {
        
    }

    public void printChkSumError()
    {
        
    }
    
}
