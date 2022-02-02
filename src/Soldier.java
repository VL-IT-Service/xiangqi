public class Soldier extends GameToken{

    public Soldier(Player owner, GameBoard board) {
        super(owner, board);
    }

    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {

        int directionToEnemy = (this.getOwner() == Player.RED) ? 1 : -1;

        if ( ! isAcrossTheRiver(moveStartRow)) {
            if (! ( (moveEndRow - moveStartRow ) == directionToEnemy && (moveStartCol == moveEndCol))) {
                throw new MoveNotPossibleException("Soldier has to move one field towards the enemy");
            }
        } else {
            if (! ( (moveEndRow - moveStartRow ) == directionToEnemy ^ Math.abs(moveStartCol - moveEndCol) == 1)) {
                throw new MoveNotPossibleException("Soldier can not move more than one field");
            }
        }





    }

    public String toString(){
        if(this.getOwner() == Player.BLACK  ) {
            return "s";
        } else {
            return "S";
        }
    }
}
