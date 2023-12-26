public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.run();
        if (game.getResult()) {
            System.out.println(game.toString());
        }
    }
}
