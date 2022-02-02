public class General extends GameToken{
    public General(Player owner, GameBoard board) {
        super(owner, board);
    }

    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {

        if (! isInPalace(moveEndRow,moveEndCol)){
            throw new MoveNotPossibleException("General is not allowed to leave the palace.");
        }

        // Distance of move == 1 ?
        if (! (Math.abs(moveStartRow-moveEndRow) + Math.abs(moveStartCol-moveEndCol) == 1) ){
            throw new MoveNotPossibleException("General can only move one field.");
        }

        int directionToEnemy = (this.getOwner() == Player.RED) ? 1 : -1;
        int testRow = moveEndRow + directionToEnemy;
        GameToken nextTokenInRow =null;
        while ( 0 <= testRow && testRow <= 9 && nextTokenInRow == null  ){
                nextTokenInRow= this.board.getField(testRow , moveEndCol);
                testRow += directionToEnemy;
        }
        if (nextTokenInRow != null && nextTokenInRow.getClass() == this.getClass() ){
            throw new MoveNotPossibleException("Enemy's General can see you.");
        }

    }

    public String toString(){
        if(this.getOwner() == Player.BLACK  ) {
            return "g";
        } else {
            return "G";
        }
    }

}
