/*
Author: Juan Martinez
*/

package project1;

import javax.swing.JOptionPane;

public class Board {
    public static final int NROWS = 3;
    public static final int NCOLS = 3;
    public static final char EMPTY = ' ';
    private char[][] table;

    public Board()
    {   table = new char[NROWS][NCOLS];
        initBoard();
    }

    public void initBoard()
    {   for (int i=0; i<NROWS; i++)
            for(int j=0; j<NCOLS; j++)
                table[i][j] = EMPTY;
    }

    public void printBoard()
    {   for (int i=0; i<NROWS; i++)
        {   for(int j=0; j<NCOLS; j++)
            {   System.out.print(table[i][j]);
                if (j !=NCOLS-1)
                    System.out.print(" | ");
            }
            if (i!=NROWS-1)
                System.out.println("\n----------");
        }
        System.out.println("\n");
    }

    public boolean insert(int x, int y, char piece)
    {   if (isInsideRange(x,y) && (table[x][y] == EMPTY) )
        {   table[x][y] = piece;
            return true;
        }
        return false;
    }

    public boolean isInsideRange(int x, int y)
    {   if ((x>=0) && (x<NROWS) && (y>=0) && (y<NCOLS))
            return true;
        return false;
    }

    public boolean isGameOver(char piece, int numSpotsTaken)
    {   if (sbdyWon(piece) || thereIsDraw(numSpotsTaken))
            return true;
        return false;
    }

    public boolean thereIsDraw(int nst)
    {   if (nst == NROWS*NCOLS)
        {   JOptionPane.showMessageDialog(null, "It's a Draw, u both SUCK!");
            return true;
        }
        return false;
    }

    public boolean sbdyWon(char piece)
    {   if (horiz(piece) || vert(piece) || diag(piece))
        {   JOptionPane.showMessageDialog(null, piece+" won this game!");
            return true;
        }
        return false;
    }

    public boolean horiz(char piece)
    {   for (int i=0; i<NROWS; i++)
        {   int count = 0;
            for(int j=0; j<NCOLS; j++)
                if (table[i][j] == piece)
                    count++;
            if (count == NCOLS)
                return true;
         }
         return false;
    }

    public boolean vert(char piece)
    {   for (int i=0; i<NROWS; i++)
        {   int count = 0;
            for(int j=0; j<NCOLS; j++)
                if (table[j][i] == piece)
                    count++;
            if (count == NROWS)
                return true;
         }
         return false;
    }

    public boolean diag(char piece)
    {   if (leftDiag(piece) || rightDiag(piece))
            return true;
        return false;
    }

    public boolean leftDiag(char piece)
    {   int count = 0;
        for (int i=0; i<NROWS; i++)
            if (table[i][i] == piece)
                count++;
        if (count == NROWS)
            return true;
        return false;
    }

    public boolean rightDiag(char piece)
    {   int count = 0;
        int r = 0;
        int c = 2;
        for (int i=0; i<NROWS; i++)
        {    if (table[r][c] == piece)
                count++;
             r++;
             c--;
        }
        if (count == NROWS)
            return true;
        return false;
    }
}

//Your program should allow u to play this game remotely with tcp if u want
//at the same time while ur playing u should be able to chat on UDP

//Due Mar. 7