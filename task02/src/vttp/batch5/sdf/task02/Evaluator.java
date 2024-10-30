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
    
     // Attempt at pseudocode for utility evaluation
     // Possible Evaluation using minimax algorithm for best possible move???
     //Minimax Algorithm
     private int minimax(int depth, boolean isMax) {
        if (checkWin(server)) {
            return 10;
        }
        if (checkWin(player)) {
            return -10;
        }
        if (!hasEmptyCell()) {
            return 0;
        }

        if (isMax) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.lenth; j++) {
                if (board[i][j] == empty) {
                    board[i][j] = server;
                    int score = minimax(depth + 1, false);
                    board[i][j] = empty;
                    bestScore = Math.max(score, bestScore);
                }
            }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.lenth; j++) {
                if (board[i][j] == empty) {
                    board[i][j] = player;
                    int score = minimax(depth + 1, true);
                    board[i][j] = empty;
                    bestScore = Math.min(score, bestScore);
                }
            }
            }
            return bestScore;
            // Reflecting the score from the perspective of the minimizing player (the player or opponent), 
            // aiming to minimize the maximizing player’s (server’s) score
        }
    }

    // AI's move
    public int getBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;
        for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.lenth; j++) {
            if (board[i][j] == empty) {
                // Simulates server move
                board[i][j] = server;
                // Evaluates the best possible score to which a player might potentially respond to
                int score = minimax(0, false);
                // Undo the move
                board[i][j] = empty;
                // Update the best move if this score is higher
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i + 1;
                }
            }
        }
        }
        return bestMove;
    }
}
