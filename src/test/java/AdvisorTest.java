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
public class AdvisorTest {
    
    public AdvisorTest() {
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
    void AdvisorMovementTest() throws MoveNotPossibleException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.importBoard("3g1a3/9/9/9/e8/9/9/5A3/9/4G4");
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(9, 5).checkMoveInDetail(9, 5, 8, 6);});
        assertDoesNotThrow( ()->{gameBoard.getField(9, 5).checkMoveInDetail(9, 5, 8, 4);});
        assertThrows(MoveNotPossibleException.class, ()->{gameBoard.getField(2, 5).checkMoveInDetail(2, 5, 3, 6);});
        assertDoesNotThrow( ()->{gameBoard.getField(2, 5).checkMoveInDetail(2, 5, 1, 4);});
    }
}
