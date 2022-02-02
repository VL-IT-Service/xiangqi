public class Horse extends GameToken{
    public Horse(Player owner, GameBoard board) {
        super(owner, board);
    }

    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {

    }

    public String toString(){
        if(this.getOwner() == Player.BLACK  ) {
            return "h";
        } else {
            return "H";
        }
    }
}
