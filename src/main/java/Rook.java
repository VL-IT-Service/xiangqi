public class Rook extends GameToken{
    public Rook(Player owner, GameBoard board) {
        super(owner, board);
    }

    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {
        // ceck that it is not a diagonal movement
        boolean forward = moveStartRow - moveEndRow != 0;
        boolean sideways = moveStartCol - moveEndCol != 0;

        if (forward && sideways){
            throw new MoveNotPossibleException("Rook can move in only one direction");
        }

        // check if the fields between Start and End are free
        // end is already checked in GameToken.makemove()
        boolean free = true;
        int moveDirection;
        if (forward){
            moveDirection = Integer.signum(moveEndRow-moveStartRow);
            for (int i = moveStartRow + moveDirection; moveDirection == 1 ? i < moveEndRow : i>moveEndRow ; i += moveDirection){
                free = free && (board.getField(i,moveStartCol)==null);
            }
        } else {
            moveDirection = Integer.signum(moveEndCol-moveStartCol);
            for (int i = moveStartCol + moveDirection; moveDirection == 1 ? i < moveEndCol : i>moveEndCol ; i += moveDirection){
                free = free && (board.getField(moveStartRow,i)==null);
            }
        }

        if (!free){
            throw new MoveNotPossibleException("Rook can't jump over other token.");
        }


    }



    public String toString(){
        if(this.getOwner() == Player.BLACK  ) {
            return "r";
        } else {
            return "R";
        }
    }
}
