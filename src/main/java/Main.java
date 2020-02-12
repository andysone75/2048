import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] tests = new String[] {
            "2 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0", // 0
            "2 2 2 2 0 0 0 0 0 0 0 0 0 0 0 0", // 1
            "0 0 2 2 0 0 0 0 0 0 0 0 0 0 0 0", // 2
            "4 4 2 2 0 0 0 0 0 0 0 0 0 0 0 0", // 3
            "8 2 2 2 0 0 0 0 0 0 0 0 0 0 0 0", // 4
            "8 2 8 2 0 0 0 0 0 0 0 0 0 0 0 0", // 5
            "8 4 4 2 0 0 0 0 0 0 0 0 0 0 0 0", // 6
            "2 0 0 0 2 0 0 0 2 0 0 0 2 0 0 0", // 7
            "2 2 4 4 0 0 0 0 0 0 0 0 0 0 0 0", // 8
            "2 0 0 0 2 0 0 0 4 0 0 0 4 0 0 0", // 9
            "4 0 0 0 4 0 0 0 2 0 0 0 2 0 0 0", // 10
            "2 4 4 8 0 0 0 0 0 0 0 0 0 0 0 0", // 11
            "2 0 0 0 4 0 0 0 4 0 0 0 8 0 0 0", // 12
            "8 0 0 0 4 0 0 0 4 0 0 0 2 0 0 0"  // 13
        };

        Game game = new Game(tests[13]);
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.nextLine();
            if (input.equals("up")) {
                game.swipe(Game.Directions.UP);
            } else if (input.equals("down")) {
                game.swipe(Game.Directions.DOWN);
            } else if (input.equals("left")) {
                game.swipe(Game.Directions.LEFT);
            } else if (input.equals("right")) {
                game.swipe(Game.Directions.RIGHT);
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
