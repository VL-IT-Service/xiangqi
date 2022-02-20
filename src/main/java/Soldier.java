/**
 * represents a Soldier GameToken 
 * @author jens
 */
public class Soldier extends GameToken {
/**
 * creates a Soldier for the respective Player which will be put on the GameBoard
 * @param owner the player who owns this Soldier
 * @param board the GameBoard on which the GameToken is placed
 */
    public Soldier(Player owner, GameBoard board) {
        super(owner, board);
    }

    
    /**
     * checks if the Soldier can move form startPositon to endPositon according to the rules. Soldier can move one field forward. If they cross the river they can also move one field to the side
     * 
     * @param moveStartRow the row number the Soldier starts his move
     * @param moveStartCol the column number the Soldier starts his move
     * @param moveEndRow the row number the Soldier ends his move
     * @param moveEndCol the column number the Soldier ends his move
     * 
     */
    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {

        int directionToEnemy = (this.getOwner() == Player.RED) ? 1 : -1;

        if (!isAcrossTheRiver(moveStartRow)) {
            if (!((moveEndRow - moveStartRow) == directionToEnemy && (moveStartCol == moveEndCol))) {
                throw new MoveNotPossibleException("Soldier has to move one field towards the enemy");
            }
        } else {
            if (!((moveEndRow - moveStartRow) == directionToEnemy ^ Math.abs(moveStartCol - moveEndCol) == 1)) {
                throw new MoveNotPossibleException("Soldier can not move more than one field");
            }
        }

    }

    /**
     * 
     * @return a String representing the Soldier (s for Black, S for Red) 
     */
    public String toString() {
        if (this.getOwner() == Player.BLACK) {
            return "s";
        } else {
            return "S";
        }
    }
}
