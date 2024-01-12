import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[][] input = new int [][] {
                {0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        };
        Set<Coordinate> setCoords = new HashSet<>();
        Map<Integer, Set<Integer>> connections = new HashMap<>();
        for (int y = 0; y < input.length; y ++) {
            for (int x = 0; x < input[y].length; x++) {
                if (input[y][x] == 0) continue;
                Coordinate cord = new Coordinate(x, y);
                setCoords.add(new Coordinate(x, y));
                Set<Integer> nears = new HashSet<>();
                if (x - 1 >= 0 && input[y][x-1] == 1)
                    nears.add(new Coordinate(x-1,y).getId());
                if (y - 1 >= 0 && input[y-1][x] == 1)
                    nears.add(new Coordinate(x,y-1).getId());
                if (x + 1 < input[y].length && input[y][x+1] == 1)
                    nears.add(new Coordinate(x+1,y).getId());
                if (y + 1 < input.length && input[y+1][x] == 1)
                    nears.add(new Coordinate(x,y+1).getId());
                connections.put(cord.getId(), nears);
            }
        }
        Graph<Coordinate> graph = new Graph<>(setCoords, connections);
        TargetScorer targetScorer = new TargetScorer();
        CoordScorer scorer = new CoordScorer();
        RouteFinder<Coordinate> routeFinder = new RouteFinder<>(graph, scorer, targetScorer);
        routeFinder.findRoute(new Coordinate(5, 0), new Coordinate(5, 3)).forEach(System.out::println);
    }
}
