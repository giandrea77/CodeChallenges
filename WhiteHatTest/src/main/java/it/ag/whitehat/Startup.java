package it.ag.whitehat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import com.sun.tools.javac.Main;
import com.whitehatgaming.UserInputFile;

import it.ag.whitehat.entities.ChessGame;
import it.ag.whitehat.entities.board.Cell;
import it.ag.whitehat.entities.utils.WrongMoveException;

public class Startup {

//	public static void main(String[] args) {
//
//		ChessGame chessGame = new ChessGame();
//		chessGame.initialize("Andrea", "CPU");
//
//		boolean stillPlaying = true;
//		String currentPlayer = "CPU";
//
//		Scanner scanner = new Scanner(System.in);
//		String input;
//
//		while (stillPlaying) {
//
//			System.out.println(chessGame.getBoard().toString());
//
//			System.out.println(currentPlayer + "'s Turn:");
//			System.out.println("M - Enter next move");
//			System.out.println("Q - Quit game");
//			input = scanner.nextLine();
//
//			if ( input.equalsIgnoreCase("Q") ) {
//				stillPlaying = false;
//				System.out.println(" #### GAME ABANDONED #### ");
//				continue;
//			} else if ( input.equalsIgnoreCase("M") ) {
//
//				boolean moveIsCorrect = false;
//				do {
//					System.out.print("Current row [0-7]: ");
//					int currentRow = Integer.valueOf(scanner.nextLine());
//
//					System.out.print("Current column [0-7]: ");
//					int currentColumn = Integer.valueOf(scanner.nextLine());
//
//					System.out.print("New row [0-7]: ");
//					int newRow = Integer.valueOf(scanner.nextLine());
//
//					System.out.print("New column [0-7]: ");
//					int newColumn = Integer.valueOf(scanner.nextLine());
//
//					if ( chessGame.getBoard().getPieceAt(new Cell(currentRow, currentColumn)) != null || chessGame.getBoard().isOwned(new Cell(currentRow, currentColumn), currentPlayer)) {
//
//						if ( chessGame.getBoard().getPieceAt(new Cell(currentRow, currentColumn)).moveTo(new Cell(newRow,newColumn), chessGame.getBoard()) == null ) {
//							System.out.println("You are not moving the rigth pieace - try again");
//							moveIsCorrect = false;
//						} else {
//							moveIsCorrect = true;
//						}
//
//
//					} else {
//						moveIsCorrect = false;
//						System.out.println("You are not moving the rigth pieace - try again");
//
//					}
//
//				} while (!moveIsCorrect);
//
//
//			}
//
//			currentPlayer = currentPlayer.equals("CPU") ? "Andrea" : "CPU";
//
//		}
//
//	}

	// public static void main(String[] args) {

	//     ChessGame chessGame = new ChessGame();
	//     chessGame.initialize("Andrea", "CPU");
	//     chessGame.getBoard().getPieceAt(new Cell(6,3)).moveTo(new Cell(4,3), chessGame.getBoard());
	//     System.out.println(chessGame.getBoard().toString());

	//     chessGame.getBoard().getPieceAt(new Cell(1,2)).moveTo(new Cell(3,2), chessGame.getBoard());
	//     System.out.println(chessGame.getBoard().toString());

	//     chessGame.getBoard().getPieceAt(new Cell(7,2)).moveTo(new Cell(5,4), chessGame.getBoard());
	//     System.out.println(chessGame.getBoard().toString());

	// }

	public static void main(String[] args) throws IOException, WrongMoveException {

		String path = "WhiteHatTest/src/main/resources/data/sample-moves.txt";
		File file = new File(path);
		UserInputFile userInputFile = new UserInputFile(file.getAbsolutePath());

		// Initialize the board
		ChessGame chessGame = new ChessGame();
		chessGame.initialize("Player1", "Player2");

		// Initialize the player
		String currentPlayer = "Player1";
		int[] move = new int[4];

		// Initialize the game
		boolean moveIsCorrect = true;
		boolean checkMate = false;

		do {

			move = userInputFile.nextMove();
			System.out.println(currentPlayer + ":  from " + move[0] + " " + move[1] + " to " + move[2] + " " + move[3]);

			// Switch player
			currentPlayer = currentPlayer.equals("Player1") ? "Player2" : "Player1";

			int w = 7 - move[0];
			int x = move[1];
			int y = 7 - move[2];
			int z = move[3];

			// If piece is on the board and owned by player, move
			if ( chessGame.getBoard().getPieceAt(new Cell(x , w)) != null || chessGame.getBoard().isOwned(new Cell(x, w), currentPlayer)) {

				if ( chessGame.getBoard().getPieceAt(new Cell(x, w)).moveTo(new Cell(z,y), chessGame.getBoard()) == null ) {
					System.out.println("You are not moving the rigth pieace - try again");
					moveIsCorrect = false;
				} else {
					moveIsCorrect = true;
				}

			} else {
				moveIsCorrect = false;
				System.out.println("You are not moving the rigth pieace - try again");

			}

			System.out.println(chessGame.getBoard().toString());


		} while ( move != null && moveIsCorrect &&  !checkMate);


	}


}
