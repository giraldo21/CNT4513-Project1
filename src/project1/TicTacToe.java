/*
Author: Juan Martinez
*/
package project1;

import javax.swing.JOptionPane;

public class TicTacToe {

    public static void main(String[] args) {
        Board myBoard = new Board();
        myBoard.printBoard();

        int numSpotsTaken=0;
        char piece;
        while (true)
        {   if (numSpotsTaken %2 == 0)
                piece = 'X';
            else
                piece = 'O';

            int x = Integer.parseInt(JOptionPane.showInputDialog("Enter coordX for "+piece));
            int y = Integer.parseInt(JOptionPane.showInputDialog("Enter coordY for "+piece));

           if (myBoard.insert(x,y, piece))
           {   numSpotsTaken++;
               myBoard.printBoard();
               if (myBoard.isGameOver(piece, numSpotsTaken))
                   break;
           }
           else
               JOptionPane.showMessageDialog(null, "Dont be stupid...");
        }
    }
}
