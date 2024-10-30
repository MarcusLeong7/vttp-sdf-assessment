package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TicTacToe {

    private String txtFile;

    private char[][] board;
    private final int width = 3;
    private int height = 3;
    private static final char PLAYER = 'X';
    private static final char SERVER = 'O';
    private static final char EMPTY = '.';

    private int generation = 0;


    public TicTacToe(String txtFile) {
        this.txtFile = txtFile;
        this.board = new char[height][width];
        initializeBoard();
    }


    public void readFile() throws IOException {

        Reader dis = new FileReader(txtFile);
        BufferedReader br = new BufferedReader(dis);
        String line;

        while ((line = br.readLine()) != null) {

            for (int i = 0; i < 3; i++) {
                if (!line.isEmpty()) {
                    char position = line.charAt(i);
                    int row = 0;

                    switch (position) {

                        case 'X':
                            getPosition(row, i, PLAYER);
                            break;

                        case 'O':
                            getPosition(row, i, SERVER);
                            break;

                        case '.':
                            getPosition(row, i, EMPTY);
                            break;

                        default:
                            System.out.println("Invalid character input");
                    }  row++;

                } 

            }

        }

    }

    public void getPosition(int row, int col, char value) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid position.");
        }
        board[row][col] = value;
    }

    // Print current board state
    public void printBoard() {
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0; j < 3; j++) {
                System.out.println(board[i][j]);
            }
        }
    }

    //Initializing of the board
    public void initializeBoard() {
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }

    }

    public boolean checkWin (char player) {
        
        return true;
    }

    

    
}
