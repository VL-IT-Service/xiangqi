public class Cannon extends GameToken{
    public Cannon(Player owner, GameBoard board) {
        super(owner, board);
    }

    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {

    }

    public String toString(){
        if(this.getOwner() == Player.BLACK  ) {
            return "c";
        } else {
            return "C";
        }
    }
}
