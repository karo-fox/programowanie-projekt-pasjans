public class App {
    public static void main(String[] args) throws Exception {
        int counter = 0;
        try {
            Game game = new Game();
            while (!game.getResult()) {
                counter++;
                game = new Game();
                game.run();
            }
            System.out.println("liczba partii: " + counter);
            System.out.println(game.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
