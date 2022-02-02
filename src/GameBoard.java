public class GameBoard {

    private GameToken[][] fields;

    public GameBoard() {
        this.fields = new GameToken[10][9];

    }

    public void importBoard(String fenString){
        int zeile = 9;
        int spalte = 0;
        for (int index = 0; index < fenString.length(); ++index){
            switch (fenString.charAt(index)){
                case 'a':
                    fields[zeile][spalte] = new Advisor(Player.BLACK, this);
                    break;
                case 'A':
                    fields[zeile][spalte] = new Advisor(Player.RED, this);
                    break;
                case 'c':
                    fields[zeile][spalte] = new Cannon(Player.BLACK, this);
                    break;
                case 'C':
                    fields[zeile][spalte] = new Cannon(Player.RED, this);
                    break;
                case 'e':
                    fields[zeile][spalte] = new Elephant(Player.BLACK, this);
                    break;
                case 'E':
                    fields[zeile][spalte] = new Elephant(Player.RED, this);
                    break;
                case 'g':
                    fields[zeile][spalte] = new General(Player.BLACK, this);
                    break;
                case 'G':
                    fields[zeile][spalte] = new General(Player.RED, this);
                    break;
                case 'h':
                    fields[zeile][spalte] = new Horse(Player.BLACK, this);
                    break;
                case 'H':
                    fields[zeile][spalte] = new Horse(Player.RED, this);
                    break;
                case 'r':
                    fields[zeile][spalte] = new Rook(Player.BLACK, this);
                    break;
                case 'R':
                    fields[zeile][spalte] = new Rook(Player.RED, this);
                    break;
                case 's':
                    fields[zeile][spalte] = new Soldier(Player.BLACK, this);
                    break;
                case 'S':
                    fields[zeile][spalte] = new Soldier(Player.RED, this);
                    break;
                case '/':
                    -- zeile;
                    spalte = -1;
                    break;
                default:
                    int maxNum = Character.getNumericValue(fenString.charAt(index));
                    for (int num = 0; num < maxNum ; ++num){
                        fields[zeile][spalte]=null;
                        ++spalte;
                    }
                    --spalte;


            }
            ++spalte;

        }




    }

    public String exportBoard(){
        // String to return
        String r = "";
        int freefieldCounter;

        for (int zeile = 9; zeile >= 0; --zeile){
            freefieldCounter = 0;
            for (int spalte = 0 ; spalte < 9; ++spalte){
                if (this.fields[zeile][spalte] != null){
                    // have there just been any free fields?
                    // append the counter to String
                    if (freefieldCounter > 0) {
                        r += freefieldCounter;
                    }
                    // reset the counter
                    freefieldCounter = 0;

                    // append the sign for the GameToken on the field
                    r += fields[zeile][spalte].toString();


                }else{
                    ++freefieldCounter;
                }

            }
            // if last fields were empty print the number
            if (freefieldCounter > 0) {
                r += freefieldCounter;
            }
            // end of line (not for the last line)
            if (zeile > 0) {
                r += "/";
            }

        }
    return r;

    }

    public void makeMove(String move) throws MoveNotPossibleException {

        // ask the Token to check if move is legal
        fields[getMoveStartRow(move)][getMoveStartCol(move)].makeMove(
                getMoveStartRow(move)
                ,getMoveStartCol(move)
                ,getMoveEndRow(move)
                ,getMoveEndCol(move)
        );
    }

    public static int getMoveStartCol(String move){
        return Character.getNumericValue(move.charAt(0)) - Character.getNumericValue( 'a');
    }

    public static int getMoveStartRow(String move){
        return Character.getNumericValue(move.charAt(1));
    }

    public static int getMoveEndCol(String move){
        return Character.getNumericValue(move.charAt(3)) - Character.getNumericValue( 'a');
    }

    public static int getMoveEndRow(String move){
        return Character.getNumericValue(move.charAt(4));
    }

    public GameToken getField(int row, int col){
        return fields[row][col];
    }
    public void setField(int row, int col, GameToken tk){
       this.fields[row][col] = tk;
    }

}
