package com.team;

public class GameStateCheck {

    private char[][] board;
    private int size;
    public GameStateCheck(char[][] board, BoardSize boardSize) {
        this.board = board;
        this.size = boardSize.getSize();
    }
    public boolean hasWinner() {
        return (checkRowsForWinner() || checkColumnsForWinner() || checkDiagonalsForWinner());
    }

    public boolean checkRowsForWinner() {
        for (int row = 0; row < size; row++) {
            if (checkRow(row)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumnsForWinner() {
        for (int column = 0; column < size; column++) {
            if (checkColumn(column)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonalsForWinner() {
        return checkFirstDiagonal() || checkSecondDiagonal();
    }

    private boolean checkRow(int row) {
        char cell1 = board[row][0];
        int column = 1;
        while (column < size) {
            if (cell1 == ' ' || cell1 != board[row][column]) {
                return false;
            }
            column++;
        }

        return true;
    }

    private boolean checkColumn(int column) {
        char cell1 = board[0][column];
        int row = 1;
        while (row < size) {
            if (cell1 == ' ' || cell1 != board[row][column]) {
                return false;
            }
            row++;
        }
        return true;
    }

    private boolean checkFirstDiagonal() {
        char cell1 = board[0][0];
        int rowColumn = 1;
        while (rowColumn < size) {
            if (cell1 == ' ' || cell1 != board[rowColumn][rowColumn]) {
                return false;
            }
            rowColumn++;
        }
        return true;
    }

    private boolean checkSecondDiagonal() {
        char cell1 = board[0][2];
        int row = 1;
        int column = 1;
        while (row < size) {
            if (cell1 == ' ' || cell1 != board[row][column]) {
                return false;
            }
            row++;
            column--;
        }
        return true;
    }
}
