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

    public int getRow(){
	return board.getRow(this);
    }
	
    public int getCol(){
	return board.getCol(this);
    }
}
