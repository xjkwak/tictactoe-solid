package com.team;

public class BoardPrinter {

    private char[][] board;
    private int size;


    public BoardPrinter(char[][] board, BoardSize boardSize) {
        this.board = board;
        this.size = boardSize.getSize();
    }

    public void print() {
        int column, row;
        for (row = size - 1; row >= 0; row--) {
            System.out.print(row + " ");
            for (column = 0; column < size; column++) {
                System.out.print("|" + board[row][column]);
            }
            System.out.println("|");
        }
        System.out.print("   ");
        for (column = 0; column < size; column++) {
            System.out.print(column + " ");
        }
        System.out.println();
    }
}
