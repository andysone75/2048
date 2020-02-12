import java.util.Random;

public class GameField {
    private int[] values;

    public GameField() {
        values = new int[16];
    }

    public GameField(int[] set) {
        if (set.length != 16) throw new IllegalArgumentException("Только 16 плиток");
        values = set;
    }

    public int get(int x, int y) {
        return values[4 * y + x];
    }

    public void set(int x, int y, int value) {
        values[4 * y + x] = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) sb.append("\033[0;31m");
            sb.append(values[i]);
            if (values[i] > 0) sb.append("\033[0m");
            if (i == 15) break;
            if (i % 4 == 3) sb.append("\n-------------\n");
            else sb.append(" | ");
        }
        return sb.toString();
    }

    public void spawn() {
        int pos = (new Random()).nextInt(16);
        while (values[pos] > 0)
            pos = (new Random()).nextInt(16);
        values[pos] = 2;
    }
}
