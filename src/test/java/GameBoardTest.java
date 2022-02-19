import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void importBoard_token() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.importBoard("rheagaehr/9/1c5c1/s1s1s1s1s/9/9/S1S1S1S1S/1C5C1/9/RHEAGAEHR");

        assertTrue(gameBoard.getField(0, 0) instanceof Rook);
        assertTrue(gameBoard.getField(0,1) instanceof Horse );
        assertTrue(gameBoard.getField(0,2) instanceof Elephant );
        assertTrue(gameBoard.getField(0,3) instanceof Advisor );
        assertTrue(gameBoard.getField(0,4) instanceof General );
        assertTrue(gameBoard.getField(0,8) instanceof Rook );
        assertTrue(gameBoard.getField(0,7) instanceof Horse );
        assertTrue(gameBoard.getField(0,6) instanceof Elephant );
        assertTrue(gameBoard.getField(0,5) instanceof Advisor );

        assertTrue(gameBoard.getField(9,0) instanceof Rook );
        assertTrue(gameBoard.getField(9,1) instanceof Horse );
        assertTrue(gameBoard.getField(9,2) instanceof Elephant );
        assertTrue(gameBoard.getField(9,3) instanceof Advisor );
        assertTrue(gameBoard.getField(9,4) instanceof General );
        assertTrue(gameBoard.getField(9,8) instanceof Rook );
        assertTrue(gameBoard.getField(9,7) instanceof Horse );
        assertTrue(gameBoard.getField(9,6) instanceof Elephant );
        assertTrue(gameBoard.getField(9,5) instanceof Advisor );


    }

    @Test
    void importBoard_token_player() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.importBoard("rheagaehr/9/1c5c1/s1s1s1s1s/9/9/S1S1S1S1S/1C5C1/9/RHEAGAEHR");

        assertEquals(Player.RED, gameBoard.getField(0,0).getOwner());
        assertEquals(Player.RED, gameBoard.getField(0,1).getOwner() );
        assertEquals(Player.RED, gameBoard.getField(0,2).getOwner() );
        assertEquals(Player.RED, gameBoard.getField(0,3).getOwner() );
        assertEquals(Player.RED, gameBoard.getField(0,4).getOwner() );
        assertEquals(Player.RED, gameBoard.getField(0,8).getOwner() );
        assertEquals(Player.RED, gameBoard.getField(0,7).getOwner() );
        assertEquals(Player.RED, gameBoard.getField(0,6).getOwner() );
        assertEquals(Player.RED, gameBoard.getField(0,5).getOwner() );

        assertEquals(Player.BLACK, gameBoard.getField(9,0).getOwner() );
        assertEquals(Player.BLACK, gameBoard.getField(9,1).getOwner() );
        assertEquals(Player.BLACK, gameBoard.getField(9,2).getOwner() );
        assertEquals(Player.BLACK, gameBoard.getField(9,3).getOwner() );
        assertEquals(Player.BLACK, gameBoard.getField(9,4).getOwner() );
        assertEquals(Player.BLACK, gameBoard.getField(9,8).getOwner() );
        assertEquals(Player.BLACK, gameBoard.getField(9,7).getOwner());
        assertEquals(Player.BLACK, gameBoard.getField(9,6).getOwner() );
        assertEquals(Player.BLACK, gameBoard.getField(9,5).getOwner() );


    }

    @Test
    void exportBoard() {
        GameBoard gameBoard = new GameBoard();
        String fen = "rheagaehr/9/1c5c1/s1s1s1s1s/9/9/S1S1S1S1S/1C5C1/9/RHEAGAEHR";
        gameBoard.importBoard(fen);
        assertEquals(fen, gameBoard.exportBoard());
    }

    @Test
    void makeMove() {
    }

}