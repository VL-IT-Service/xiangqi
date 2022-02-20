
public class Main {

    public static void main(String[] args) {
        // write your code here
        GameServer gs = new GameServer();

        // print the board
        System.out.println(gs.getBoard().exportBoard());

        String move = "b0-c2";
        System.out.println(move);
        try {
            gs.makeMove(move);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gs.getBoard().exportBoard());

        move = "c2-e1";
        System.out.println(move);
        try {
            gs.makeMove(move);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gs.getBoard().exportBoard());

        move = "e1-d3";
        System.out.println(move);
        try {
            gs.makeMove(move);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gs.getBoard().exportBoard());

        move = "e1-d3";
        System.out.println(move);
        try {
            gs.makeMove(move);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gs.getBoard().exportBoard());

        move = "d3-e5";
        System.out.println(move);
        try {
            gs.makeMove(move);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gs.getBoard().exportBoard());

        move = "e5-g6";
        System.out.println(move);
        try {
            gs.makeMove(move);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gs.getBoard().exportBoard());

    }
}
