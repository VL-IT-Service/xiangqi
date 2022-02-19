public class Cannon extends GameToken{
    public Cannon(Player owner, GameBoard board) {
        super(owner, board);
    }

    @Override
    public void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException {
        // ceck that it is not a diagonal movement
        boolean forward = moveStartRow - moveEndRow != 0;
        boolean sideways = moveStartCol - moveEndCol != 0;

        if (forward && sideways){
            throw new MoveNotPossibleException("Cannon can move/strike in only one direction");
        }

        // check if the fields between Start and End are free
        // end is already checked in GameToken.makemove()
        int numberOfFreeFields = 0;
        int moveDirection;

        if (forward){
            moveDirection = Integer.signum(moveEndRow-moveStartRow);
            for (int i = moveStartRow + moveDirection; moveDirection == 1 ? i < moveEndRow : i>moveEndRow ; i += moveDirection){
                if (board.getField(i,moveStartCol)!=null){
                    ++numberOfFreeFields;
                }
            }
        } else {
            moveDirection = Integer.signum(moveEndCol-moveStartCol);
            for (int i = moveStartCol + moveDirection; moveDirection == 1 ? i < moveEndCol : i>moveEndCol ; i += moveDirection){
                if (board.getField(moveStartRow,i)!=null){
                    ++numberOfFreeFields;
                }
            }
        }
        if (numberOfFreeFields==1 && board.getField(moveEndRow,moveEndCol)==null){
            throw new MoveNotPossibleException("Cannon can't move over one token to empty field.");
        }
        if (numberOfFreeFields==0 && board.getField(moveEndRow,moveEndCol)!=null){
            throw new MoveNotPossibleException("Cannon can't strike directly.");
        }
        if (numberOfFreeFields>1){
            throw new MoveNotPossibleException("Cannon can't move over more than one token.");
        }

    }



    public String toString(){
        if(this.getOwner() == Player.BLACK  ) {
            return "c";
        } else {
            return "C";
        }
    }
}
