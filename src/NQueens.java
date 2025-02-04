
import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        System.out.println("-----Meletakkan N Queens pada N*N Papan Catur-----");
        System.out.print("\nMasukkan Jumlah N : ");
        N = in.nextInt();
        System.out.println("\nSolusinya :\n ");
        placeQueens(N);
    }

    private static void placeQueens(int gridSize) {

        if (gridSize < 4) {
            System.out.println("Tidak Ada Solusi yang Tersedia");
        } else {
            int[][] board = new int[gridSize][gridSize];
            placeAllQueens(board, 0);
            printBoard(board);
        }
    }

    private static boolean placeAllQueens(int board[][], int row) {
        if (row >= board.length) {
            return true;
        }

        boolean isAllQueensPlaced = false;
        for (int j = 0; j < board.length; j++) {

            if (isSafe(board, row, j)) {
                board[row][j] = 1;
                isAllQueensPlaced = placeAllQueens(board, row + 1);
            }
            if (isAllQueensPlaced) {
                break;
            } else {
                board[row][j] = 0;
            }
        }
        return isAllQueensPlaced;
    }

    private static boolean isSafe(int board[][], int row, int col) {

        //Check Left Upper Diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //Check Right Upper Diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //Check in same Column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
        System.out.println("");
    }

}
