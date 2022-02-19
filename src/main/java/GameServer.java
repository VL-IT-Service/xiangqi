import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameServer {

    private Player activePlayer;
    private GameStatus gameStatus;

    public Player getActivePlayer() {
        return activePlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public GameBoard getBoard() {
        return board;
    }

    private GameBoard board;

    public GameServer() {
        this.board = new GameBoard();
        this.board.importBoard("rheagaehr/9/1c5c1/s1s1s1s1s/9/9/S1S1S1S1S/1C5C1/9/RHEAGAEHR");
        this.gameStatus = GameStatus.OPEN;
        this.activePlayer = Player.RED;
    }

    public GameServer(String fenString) {
        this.board = new GameBoard();
        this.board.importBoard(fenString);
        this.gameStatus = GameStatus.OPEN;
        this.activePlayer = Player.RED;
    }

    public void toggleActivePlayer(){
       activePlayer =  ( activePlayer == Player.RED ) ? Player.BLACK : Player.RED;
    }

    public boolean checkMoveFormat(String move){
            // check whether the move matches the pattern with RegEx
            // START Character a-i followed by Digit Minussign a-i Digit END
            // if this matches, the String has the right length and structure
            String patternString = "^[a-i]\\d-[a-i]\\d$";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(move);
            return matcher.matches();
    }

    public String makeMove(String move) throws MoveFormatException, GameTokenDoesNotBelongToPlayerException,GeneralUnprotectedException, MoveNotPossibleException{
        // Check if move has a legal format
        if(checkMoveFormat(move)){
            // delegate move to the board
            this.board.makeMove(move, activePlayer);
        } else {
            throw new MoveFormatException("Move had wrong format! Should be like 'a3-c4' ");
        }
        // return the new FenString from the board representing the new situation
        return this.board.exportBoard();
    }
    
    public void importBoard (String fenString){
        this.board.importBoard(fenString);
    }
    
    public String exportBoard(){
        return this.board.exportBoard();
    }
}
