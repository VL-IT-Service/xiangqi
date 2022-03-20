/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jens
 */
public class ElephantTest {
    
    public ElephantTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}





    @Test
    void ElephantMovementTest() throws MoveNotPossibleException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.importBoard("3g5/9/9/9/e8/E8/9/9/1S7/E3G4");
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(4, 0).checkMoveInDetail(4, 0, 6, 2);});
        assertDoesNotThrow( ()->{gameBoard.getField(4, 0).checkMoveInDetail(4, 0, 2, 2);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(5, 0).checkMoveInDetail(5, 0, 4, 2);});
        assertDoesNotThrow( ()->{gameBoard.getField(5, 0).checkMoveInDetail(5, 0, 7, 2);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(0, 0).checkMoveInDetail(0, 0, 2, 2);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(0, 0).checkMoveInDetail(0, 0, 2, 4);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(0, 0).checkMoveInDetail(0, 0, 4, 2);});
        

    }
}


