
public class Horse extends GameToken {

    public Horse(Player owner, GameBoard board) {
        super(owner, board);
    }

    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {
        // check distance
        int dr = moveEndRow - moveStartRow;
        int dc = moveEndCol - moveStartCol;
        if (!((Math.abs(dr) == 2 && Math.abs(dc) == 1) || (Math.abs(dr) == 1 && Math.abs(dc) == 2))) {
            throw new MoveNotPossibleException("Horse can only move one field straight and one diagonal.");
        }
        // Horse goes up or down
        if (Math.abs(dr) == 2) {
            if (board.getField(moveStartRow + Integer.signum(dr), moveStartCol) != null) {
                throw new MoveNotPossibleException("The Horse needs a free field next to it in direction of movement.");
            }
        }
        // Horse goes left or right
        if (Math.abs(dc) == 2) {
            if (board.getField(moveStartRow, moveStartCol + Integer.signum(dc)) != null) {
                throw new MoveNotPossibleException("The Horse needs a free field next to it in direction of movement.");
            }
        }

    }

    public String toString() {
        if (this.getOwner() == Player.BLACK) {
            return "h";
        } else {
            return "H";
        }
    }
}
