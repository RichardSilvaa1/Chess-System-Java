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
public class King extends ChessPiece{

    public King(Color color, Board board) {
        super(color, board);
    }

    @Override
    public String toString() {
        return " K ";
    }

    @Override
    public boolean[][] possibleMove() {
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }    
    
}
