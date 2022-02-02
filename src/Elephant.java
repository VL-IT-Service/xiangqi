public class Elephant extends GameToken{
    public Elephant(Player owner, GameBoard board) {
        super(owner, board);
    }

    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {
        // do not cross the river
        if ( isAcrossTheRiver(moveEndRow) ) {
            throw new MoveNotPossibleException("The Elephant can not cross the river.");
        }
        // move 2 fields diagonal (check the distance)
        if (! (Math.abs(moveStartRow-moveEndRow) == 2 && Math.abs(moveStartCol-moveEndCol) == 2 )){
            throw new MoveNotPossibleException("The Elephant only moves 2 fields diagonal.");
        }
        // Distance is 2 two fields in each direection
        // artihmetic average is the middle
        // check if field in the middle is empty
        if (this.board.getField((moveStartRow+moveEndRow)/2,(moveStartCol+moveEndCol)/2) != null) {
            throw new MoveNotPossibleException("The diagonal is blocked by another token.");
        }

    }

    public String toString(){
        if(this.getOwner() == Player.BLACK  ) {
            return "e";
        } else {
            return "E";
        }
    }
}
