package vttp.batch5.sdf.task02;

public class Evaluator {

    public static char EMPTY = '.';
    public static final int[] X_DELTA = { 
        -1,  0,  1, -1, 1, -1, 0, 1
     };
     public static final int[] Y_DELTA = { 
        -1, -1, -1,  0, 0,  1, 1, 1
     };
    
    public static int countPossibleMoves (int x , int y, char[][] board) {
        int empty = 0;
        int height = board.length;
        int width = board[0].length;

        for (int i = 0; i < X_DELTA.length; i++) {
            // Get the position to examine
            int lX = x + X_DELTA[i];
            int lY = y + Y_DELTA[i];
            if ((lX < 0) || (lX >= width))
               continue;
            if ((lY < 0) || (lY >= height))
               continue;
            if (board[lY][lX] == EMPTY)
               empty++;
         }

         return empty;

    }
}
