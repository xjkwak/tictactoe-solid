package com.team;

import java.util.*;

public class Board {

    private int occupiedCells = 0;
    private char[][] board;
    private Set<String> validCells;
    private int size;

    public Board(BoardSize boardSize) {
        this.size = boardSize.getSize();
        this.board = new char[size][size];
        validCells = new HashSet<String>();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                board[row][column] = ' ';
                validCells.add(row+""+column);
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void markCell(char playerMark, int row, int column) {
        if (board[row][column] != ' ') {
            System.out.println("Error..!!! Cell already occupied.");
        } else {
            board[row][column] = playerMark;
            occupiedCells++;
        }
    }



    public boolean isBoardFull() {
        return size*size == occupiedCells;
    }

    public void checkForValidCell(String inputCell) {
        if(validCells.contains(inputCell)){
            return;
        }else{
            System.out.println("Error invalid input");
        }
    }

}