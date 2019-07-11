package com.team;

import java.io.IOException;

public class GameRunner {
    Board board;
    Player player1;
    Player player2;
    InputReader inputReader;
    BoardPrinter boardPrint;
    GameStateCheck gameStateCheck;
    BoardSize boardSize;

    public GameRunner() {
        inputReader = new InputReader();
        player1 = new Player(inputReader.getUserInput("Enter Player Name 1"), 'O');
        player2 = new Player(inputReader.getUserInput("Enter Player Name 2"), 'X');
        boardSize = new BoardSize(3);
        board = new Board(boardSize);
        boardPrint = new BoardPrinter(board.getBoard(), boardSize);
        gameStateCheck = new GameStateCheck(board.getBoard(), boardSize);
    }

    public void play() {
        String playerInput = null;
        int turnCount = 1;
        String winnerOrDraw = "Game Drawn..!!";
        boolean keepPlaying = true;
        Player currentPlayer;
        while (keepPlaying) {
            currentPlayer = turnCount % 2 == 1 ? player1 : player2;
            while (playerInput == null) {
                boardPrint.print();
                playerInput = readAndValidateUserInput(currentPlayer.getName(),
                        currentPlayer.getMark());
            }
            if (gameStateCheck.hasWinner()) {
                winnerOrDraw = currentPlayer.getName() + " wins..!!";
                keepPlaying = false;
            } else if (board.isBoardFull()) {
                keepPlaying = false;
            }
            playerInput = null;
            turnCount++;
        }
        printResult(winnerOrDraw);

    }

    private String readAndValidateUserInput(String userName, char userMark) {
        String playerInput = null;
        try {
            playerInput = inputReader.getUserInput(userName
                    + " turn. Enter [row][col].");
            board.checkForValidCell(playerInput);
            markBoardCell(userMark, playerInput);
        } catch (Exception error) {
            System.out.println("Error message");
            playerInput = null;
        }
        return playerInput;
    }

    private void markBoardCell(char mark, String playerInput) {
        board.markCell(mark, Integer.parseInt(playerInput.substring(0, 1)),
                Integer.parseInt(playerInput.substring(1)));

    }

    private void printResult(String winnerOrDraw) {
        boardPrint.print();
        System.out.println("Result: " + winnerOrDraw);
        System.out.println("Press Enter key to exit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            inputReader.close();
        }
    }
}