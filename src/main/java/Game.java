public class Game {
    private GameField gf;
    enum Directions { RIGHT, DOWN, LEFT, UP }

    public Game() {
        gf = new GameField();
        gf.spawn();
        System.out.println(gf.toString());
    }

    public Game(String input) {
        String[] integerStrings = input.split(" ");
        int[] integers = new int[integerStrings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(integerStrings[i]);
        }

        gf = new GameField(integers);
        System.out.println(gf.toString());
    }

    public void swipe(Directions dir) {
        switch (dir) {
            case UP:
                swipe_Up();
                break;
            case DOWN:
                swipe_Down();
                break;
            case RIGHT:
                swipe_Right();
                break;
            case LEFT:
                swipe_Left();
                break;
        }

        gf.spawn();
        System.out.println(gf.toString());
    }

    private void swipe_Up()  {
        for (int x = 0; x < 4; x++) {
            int height = 0;
            int[] locked = new int[4];
            for (int y = 0; y < 4; y++) {
                int xy = gf.get(x, y);
                if (xy > 0) {
                    gf.set(x, y, 0);
                    gf.set(x, height, xy);

                    if (height > 0 && locked[height-1] == 0 && gf.get(x, height - 1) == xy) {
                        gf.set(x, height - 1, xy * 2);
                        gf.set(x, height, 0);
                        locked[height-1]++;
                        height--;
                    }

                    height++;
                }
            }
        }
    }

    private void swipe_Down() {
        for (int x = 0; x < 4; x++) {
            int height = 0;
            int[] locked = new int[4];
            for (int y = 3; y >= 0; y--) {
                int xy = gf.get(x, y);
                if (xy > 0) {
                    gf.set(x, y, 0);
                    gf.set(x, 3 - height, xy);

                    if (height > 0 && locked[3-height+1] == 0 && gf.get(x, 3 - height + 1) == xy) {
                        gf.set(x, 3 - height + 1, xy * 2);
                        gf.set(x, 3 - height, 0);
                        locked[3-height+1]++;
                        height--;
                    }

                    height++;
                }
            }
        }
    }

    private void swipe_Left() {
        for (int y = 0; y < 4; y++) {
            int width = 0;
            int[] locked = new int[4];
            for (int x = 0; x < 4; x++) {
                int xy = gf.get(x, y);
                if (xy > 0) {
                    gf.set(x, y, 0);
                    gf.set(width, y, xy);

                    if (width > 0 && locked[width-1] == 0 && gf.get(width - 1, y) == xy) {
                        gf.set(width - 1, y, xy * 2);
                        gf.set(width, y, 0);
                        locked[width-1]++;
                        width--;
                    }

                    width++;
                }
            }
        }
    }

    private void swipe_Right() {
        for (int y = 0; y < 4; y++) {
            int width = 0;
            int[] locked = new int[4];
            for (int x = 3; x >= 0; x--) {
                int xy = gf.get(x, y);
                if (xy > 0) {
                    gf.set(x, y, 0);
                    gf.set(3 - width, y, xy);

                    if (width > 0 && locked[3-width+1] == 0 && gf.get(3 - width + 1, y) == xy) {
                        gf.set(3 - width + 1, y, xy * 2);
                        gf.set(3 - width, y, 0);
                        locked[3-width+1]++;
                        width--;
                    }

                    width++;
                }
            }
        }
    }
}
