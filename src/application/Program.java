package application;

import boardGame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
            UI.printBord(chessMatch.getPieces());
            System.out.println("");
            System.out.print("Soucer: ");
            ChessPosition source = UI.readChessPosition(sc);

            System.out.println("");
            System.out.print("Target: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessPiece(source, target);
            
            System.out.println("");
            } catch (ChessException e) {
                System.out.println(e.getLocalizedMessage());
                sc.nextLine();
            } catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
