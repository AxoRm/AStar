import java.util.Arrays;

public class Coordinate implements GraphNode {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X: " + x + " Y: " + y;
    }

    @Override
    public int getId() {
        final int[] numbers = {x, y};
        return Arrays.hashCode(numbers);
    }
}