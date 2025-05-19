package org.example.tictactoe_sockets;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3)
            return false;
        if (board[row][col] != ' ')
            return false;

        board[row][col] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        // Zeilen und Spalten prüfen
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                    board[i][1] == currentPlayer &&
                    board[i][2] == currentPlayer)
                return true;

            if (board[0][i] == currentPlayer &&
                    board[1][i] == currentPlayer &&
                    board[2][i] == currentPlayer)
                return true;
        }

        // Diagonalen prüfen
        if (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer)
            return true;

        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return !checkWin();
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }
}
