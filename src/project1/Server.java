/*
Author: Juan Martinez
*/
package project1;

import javax.swing.JOptionPane;

public class Server extends Thread {
    private String name;

    public Server(String data)
    {   name = data;
    }

    public void run()
    {   int count = 0;
        while (true)
        {   System.out.println("I am the server  "+count);
            count = (count==10)?count=0:count+1;
        }
    }
}

