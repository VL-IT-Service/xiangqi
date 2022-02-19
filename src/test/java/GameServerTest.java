import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServerTest {



    @Test
    void checkMoveFormat() {
        GameServer gs = new GameServer();
        assertTrue(gs.checkMoveFormat("e1-e9"));
        assertTrue(gs.checkMoveFormat("i1-i9"));
        assertFalse(gs.checkMoveFormat("A3-F7"));
        assertFalse(gs.checkMoveFormat("zuludsufsdadfiausf"));
        assertFalse(gs.checkMoveFormat("a3:a2"));
        assertFalse(gs.checkMoveFormat("ag:a2"));
    }

    @Test
    void makeMove() {




    }
}