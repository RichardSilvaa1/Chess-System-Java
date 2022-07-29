/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author user
 */
public class Rook extends ChessPiece {

    public Rook(Color color, Board board) {
        super(color, board);
    }

    

    @Override
    public String toString() {
        return " R ";
    }

    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getColumns()][getBoard().getColumns()];
        return mat;
    }

}
