/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.SocketException;

/**
 *
 * @author Blue Mage
 */
public class ChatMain
{
    public static void main(String[] args) throws SocketException
    {
        // Start Server thread
        (new ChatServer()).start();
        // Start Client thread
        (new ChatClient()).start();
    }
}
