import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SoldierTest {

    @Test
    void SoldierMovementTest() throws MoveNotPossibleException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.importBoard("rheagaehr/9/1c5c1/s1s1s1s1s/9/9/S1S1S1S1S/1C5C1/9/RHEAGAEHR");
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(3, 0).checkMoveInDetail(3, 0, 3, 1);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(3, 0).checkMoveInDetail(3, 0, 2, 0);});
        assertDoesNotThrow( ()->{gameBoard.getField(3, 0).checkMoveInDetail(3, 0, 4, 0);});
        assertDoesNotThrow( ()->{gameBoard.getField(3, 0).checkMoveInDetail(5, 0, 5, 1);});
        
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(6, 0).checkMoveInDetail(6, 0, 6, 1);});
        assertDoesNotThrow( ()->{gameBoard.getField(6, 0).checkMoveInDetail(6, 0, 5, 0);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(6, 0).checkMoveInDetail(6, 0, 5, 1);});
        
    }
    
    @Test
    void SoldierMovementBehindRiverTest() throws MoveNotPossibleException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.importBoard("9/9/9/9/1S7/7s1/9/9/9/9");
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(5, 1).checkMoveInDetail(5, 1, 4, 1);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(5, 1).checkMoveInDetail(5, 1, 7, 1);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(5, 1).checkMoveInDetail(5, 1, 5, 3);});
        assertDoesNotThrow( ()->{gameBoard.getField(5, 1).checkMoveInDetail(5, 1, 6, 1);});
        assertDoesNotThrow( ()->{gameBoard.getField(5, 1).checkMoveInDetail(5, 1, 5, 0);});
        assertDoesNotThrow( ()->{gameBoard.getField(5, 1).checkMoveInDetail(5, 1, 5, 2);});
        
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(4, 7).checkMoveInDetail(4, 7, 5, 7);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(4, 7).checkMoveInDetail(4, 7, 2, 7);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(4, 7).checkMoveInDetail(4, 7, 4, 5);});
        assertDoesNotThrow( ()->{gameBoard.getField(4, 7).checkMoveInDetail(4, 7, 3, 7 );});
        assertDoesNotThrow( ()->{gameBoard.getField(4, 7).checkMoveInDetail(4, 7, 4, 6);});
        assertDoesNotThrow( ()->{gameBoard.getField(4, 7).checkMoveInDetail(4, 7, 4, 8);});
        
        
        
        
    }
    
}
