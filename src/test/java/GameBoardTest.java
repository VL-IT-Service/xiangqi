import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void importBoard() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.importBoard("rheagaehr/9/1c5c1/s1s1s1s1s/9/9/S1S1S1S1S/1C5C1/9/RHEAGAEHR");
        assertAll(
                () -> assertEquals("rheagaehr/9/1c5c1/s1s1s1s1s/9/9/S1S1S1S1S/1C5C1/9/RHEAGAEHR", gameBoard.exportBoard() )
        );

    }

    @Test
    void exportBoard() {
    }

    @Test
    void makeMove() {
    }

    @Test
    void getField() {
    }

    @Test
    void setField() {
    }
}