package boardGame;

/**
 *
 * @author Richard
 */
public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMove();

    public boolean possibleMove(Position position) {
        return possibleMove()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMove();
        for (boolean[] mat1 : mat) {
            for (int j = 0; j < mat.length; j++) {
                if (mat1[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
