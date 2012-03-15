package app;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client extends Thread
{
    private int port;
    private InetAddress address;
    private DatagramSocket socket = null;
    private DatagramPacket packet;
    private byte[] sendBuf = new byte[256];

    public Client(int port, InetAddress address, DatagramSocket socket)
    {
        this.port = port;
        this.address = address;
        this.socket = socket;
    }

    public void run()
    {
    }
}
