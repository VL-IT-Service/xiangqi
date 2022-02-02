public class Main {

    public static void main(String[] args) {
	// write your code here
        GameServer gs = new GameServer();

        // print the board
        System.out.println(gs.getBoard().exportBoard());




        String move = "b0-a9";
        System.out.println(move);
        try {
            gs.makeMove(move);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(gs.getBoard().exportBoard());

        move = "c0-e2";
        System.out.println(move);
        try {
            gs.makeMove(move);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(gs.getBoard().exportBoard());



    }
}
