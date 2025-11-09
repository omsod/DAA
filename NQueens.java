public class NQueens {
    static int N = 8; // You can change N as needed
    static int[][] board = new int[N][N];

    // Function to check if placing a queen at board[row][col] is safe
    static boolean isSafe(int row, int col) {
        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    // Recursive function to place queens
    static boolean solve(int row) {
        if (row == N) return true; // All queens placed

        // Skip first row since first queen already placed
        if (row == 0) return solve(row + 1);

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                if (solve(row + 1)) return true;
                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    static void printBoard() {
        for (int[] r : board) {
            for (int c : r)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        board[0][5] = 1; // First queen placed manually

        if (solve(0))
            printBoard();
        else
            System.out.println("No solution exists");
    }
}
