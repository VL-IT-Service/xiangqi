
public class Advisor extends GameToken {

    public Advisor(Player owner, GameBoard board) {
        super(owner, board);
    }

    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {
        if (!isInPalace(moveEndRow, moveEndCol)) {
            throw new MoveNotPossibleException("Advisor is not allowed to leave the palace.");
        }

        // Distanz of move == 1 in each direction ?
        if (!(Math.abs(moveStartRow - moveEndRow) == 1 && Math.abs(moveStartCol - moveEndCol) == 1)) {
            throw new MoveNotPossibleException("Advisor can only move one field diagonal.");
        }
    }

    public String toString() {
        if (this.getOwner() == Player.BLACK) {
            return "a";
        } else {
            return "A";
        }
    }
}
