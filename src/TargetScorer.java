public class TargetScorer implements Scorer<Coordinate> {
    @Override
    public double computeCost(Coordinate from, Coordinate to) {
        return Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2);
    }
}
