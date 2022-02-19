import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SoldierTest {

    @Test
    void SoldierMovementTest() throws MoveNotPossibleException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.importBoard("rheagaehr/9/1c5c1/s1s1s1s1s/9/9/S1S1S1S1S/1C5C1/9/RHEAGAEHR");
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(3, 0).checkMoveInDetail(3, 0, 3, 1);});
        assertDoesNotThrow( ()->{gameBoard.getField(3, 0).checkMoveInDetail(3, 0, 4, 0);});
        assertDoesNotThrow( ()->{gameBoard.getField(3, 0).checkMoveInDetail(5, 0, 5, 1);});

    }
}
