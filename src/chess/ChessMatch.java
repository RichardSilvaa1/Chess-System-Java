/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 *
 * @author Richard
 */
public class ChessMatch {

    private Board board;

    private int turn;
    private Color currentPlayer;
    private Boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece prometed;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSteup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);

            }
        }
        return mat;
    }

    public ChessPiece performChessPiece(ChessPosition sourcePosition, ChessPosition TargetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = TargetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target ){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }
    
    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("Nao ha peca na posicao de origem");
        }if(board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("Nao existe movimentos possiveis para pecas escolidas");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());

    }

    private void initialSteup() {
        placeNewPiece('c', 1, new Rook(Color.WHITE, board));
        placeNewPiece('c', 2, new Rook(Color.WHITE, board));
        placeNewPiece('d', 2, new Rook(Color.WHITE, board));
        placeNewPiece('e', 2, new Rook(Color.WHITE, board));
        placeNewPiece('e', 1, new Rook(Color.WHITE, board));
        placeNewPiece('d', 1, new Rook(Color.WHITE, board));

        placeNewPiece('c', 7, new Rook(Color.BLACK, board));
        placeNewPiece('c', 8, new Rook(Color.BLACK, board));
        placeNewPiece('d', 7, new Rook(Color.BLACK, board));
        placeNewPiece('e', 7, new Rook(Color.BLACK, board));
        placeNewPiece('e', 8, new Rook(Color.BLACK, board));
        placeNewPiece('d', 8, new Rook(Color.BLACK, board));
    }
}
