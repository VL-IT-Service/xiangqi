
public class GameBoard {

    private GameToken[][] fields;

    public GameBoard() {
        this.fields = new GameToken[10][9];

    }

    public void importBoard(String fenString) {
        int zeile = 9;
        int spalte = 0;
        for (int index = 0; index < fenString.length(); ++index) {
            switch (fenString.charAt(index)) {
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
                    --zeile;
                    spalte = -1;
                    break;
                default:
                    int maxNum = Character.getNumericValue(fenString.charAt(index));
                    for (int num = 0; num < maxNum; ++num) {
                        fields[zeile][spalte] = null;
                        ++spalte;
                    }
                    --spalte;

            }
            ++spalte;

        }

    }

    public String exportBoard() {
        // String to return
        String r = "";
        int freefieldCounter;

        for (int zeile = 9; zeile >= 0; --zeile) {
            freefieldCounter = 0;
            for (int spalte = 0; spalte < 9; ++spalte) {
                if (this.fields[zeile][spalte] != null) {
                    // have there just been any free fields?
                    // append the counter to String
                    if (freefieldCounter > 0) {
                        r += freefieldCounter;
                    }
                    // reset the counter
                    freefieldCounter = 0;

                    // append the sign for the GameToken on the field
                    r += fields[zeile][spalte].toString();

                } else {
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

    public void makeMove(String move, Player player) throws GameTokenDoesNotBelongToPlayerException, GeneralUnprotectedException, MoveNotPossibleException {
        int moveStartRow = getMoveStartRow(move);
        int moveStartCol = getMoveStartCol(move);
        int moveEndRow = getMoveEndRow(move);
        int moveEndCol = getMoveEndCol(move);

        GameToken movingToken = this.getField(moveStartRow, moveStartCol);

        if (movingToken != null) {
            // Is this a GameToken of the active Player
            if (movingToken.getOwner() != player) {
                throw new GameTokenDoesNotBelongToPlayerException("moving GameToken does not belong to active player");
            }
            GameToken targetToken = this.getField(moveEndRow, moveEndCol);

            // is the target an enemmy or empty?
            if (targetToken != null && player == targetToken.getOwner()) {
                throw new MoveNotPossibleException("Target field is blocked by your own token.");
            }

            // ask the Token to check if move is legal (throws MoveNotPossibleException if not)
            movingToken.checkMoveInDetail(moveStartRow, moveStartCol, moveEndRow, moveEndCol);

            // the token might move if own general is not left unprotected
            // do as if the move is done and try to check
            this.setField(moveStartRow, moveStartCol, null);
            this.setField(moveEndRow, moveEndCol, movingToken);
            try {
                this.checkGeneralUnprotectedPosition(player, moveStartRow, moveStartCol, moveEndRow, moveEndCol);
            } catch (GeneralUnprotectedException e) {
                // undo the move because some GameToken can hit the General
                this.setField(moveStartRow, moveStartCol, movingToken);
                this.setField(moveEndRow, moveEndCol, targetToken);
                // rethrow the exception
                throw e;
            }
        } else {
            throw new MoveNotPossibleException("The start field of the move is empty.");
        }

    }

    private void checkGeneralUnprotectedPosition(Player player, int moveStartRow, int moveStartCol, int moveEndRow, int moveEndCol) throws GeneralUnprotectedException {

        GameToken general = getGeneral(player);
        int generalRow = general.getRow();
        int generalCol = general.getCol();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 9; col++) {
                if (this.getField(row, col) != null && this.getField(row, col).getOwner() != player) {
                    this.getField(row, col).checkHitForeignGeneral(generalRow, generalCol);
                }
            }

        }

    }

    private GameToken getGeneral(Player owner) {

        // General is in the palace, so no need to search all fields
        GameToken general = null;
        int palaceRowMin;
        int palaceRowMax;
        int palaceColMin = 3;
        int palaceColMax = 5;

        if (owner == Player.RED) {
            palaceRowMin = 0;
            palaceRowMax = 2;
        } else {
            palaceRowMin = 7;
            palaceRowMax = 9;
        }

        for (int row = palaceRowMin; row <= palaceRowMax; row++) {
            for (int col = palaceRowMin; col <= palaceColMax; col++) {
                if (getField(row, col) instanceof General) {
                    general = getField(row, col);
                }
            }
        }
        return general;

    }

    public static int getMoveStartCol(String move) {
        return Character.getNumericValue(move.charAt(0)) - Character.getNumericValue('a');
    }

    public static int getMoveStartRow(String move) {
        return Character.getNumericValue(move.charAt(1));
    }

    public static int getMoveEndCol(String move) {
        return Character.getNumericValue(move.charAt(3)) - Character.getNumericValue('a');
    }

    public static int getMoveEndRow(String move) {
        return Character.getNumericValue(move.charAt(4));
    }

    public GameToken getField(int row, int col) {
        return fields[row][col];
    }

    public void setField(int row, int col, GameToken tk) {
        this.fields[row][col] = tk;
    }

    public int getRow(GameToken gt) {
        int answer;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 9; col++) {
                if (getField(row, col) == gt) {
                    answer = row;
                }
            }
        }
        return answer = 0;
    }

    public int getCol(GameToken gt) {
        int answer = 0;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 9; col++) {
                if (getField(row, col) == gt) {
                    answer = col;
                }
            }
        }
        return answer;
    }

}
