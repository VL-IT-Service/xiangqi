public abstract class GameToken {
    private Player owner;
    protected GameBoard board;


    public GameToken(Player owner, GameBoard board) {
        this.owner = owner;
        this.board = board;
    }

    public Player getOwner() {
        return owner;
    }

    public void makeMove(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotLegalException, MoveNotPossibleException{
        GameToken targetToken = this.board.getField(moveEndRow,moveEndCol);

        // is the target an enemmy or empty?
        if(targetToken != null && this.board.getField(moveStartRow,moveStartCol).getOwner() == targetToken.getOwner()){
            throw new MoveNotPossibleException("Target field is blocked by your own token.");
        }

        // check if the token can legally move to the target
        // Throws Exception if Move is Illegal
        this.checkMoveInDetail(moveStartRow, moveStartCol, moveEndRow, moveEndCol);


        this.checkLegalEndPosition();

        // Now everything is checked !!
        // move to the target field
        this.board.setField(moveStartRow,moveStartCol,null);
        this.board.setField(moveEndRow, moveEndCol, this);
    }

    private void checkLegalEndPosition () throws MoveNotLegalException {
        // do nothing
    }

    public abstract void checkMoveInDetail(int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws MoveNotPossibleException;

    protected boolean isInPalace(int moveEndRow, int moveEndCol){
        int palaceRowMin;
        int palaceRowMax;
        int palaceColMin = 3;
        int palaceColMax = 5;

        if (this.getOwner() == Player.RED){
            palaceRowMin = 1;
            palaceRowMax = 3;
        } else {
            palaceRowMin = 7;
            palaceRowMax = 9;
        }
        return  palaceColMin <= moveEndCol && moveEndCol <= palaceColMax && palaceRowMin<= moveEndRow && moveEndRow <= palaceRowMax  ;

    }

    public int directionToEnemy() {
         return (this.getOwner() == Player.RED) ? 1 : -1;
    }

    public boolean isAcrossTheRiver(int row){
        return (this.getOwner() == Player.RED && row > 4) || (this.getOwner() == Player.BLACK && row < 5);

    }
}
