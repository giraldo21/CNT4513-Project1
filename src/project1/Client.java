/*
Author: Juan Martinez
*/
package project1;

import javax.swing.JOptionPane;

public class Client extends Thread {
    private String name;

    public Client(String data)
    {   name = data;
    }

    public void run()
    {   while (true)
        {   String input = JOptionPane.showInputDialog("Enter a text:");
            JOptionPane.showMessageDialog(null, "You typed "+input);
        }
    }
}

