public class RouteNode<T extends  GraphNode> implements Comparable<RouteNode> {
    private final T current;
    private T previous;
    private double routeScore;
    private double estimatedScore;
    RouteNode(T current) {
        this(current, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    RouteNode(T current, T previous, double routeScore, double estimatedScore) {
        this.current = current;
        this.previous = previous;
        this.routeScore = routeScore;
        this.estimatedScore = estimatedScore;
    }

    public T getCurrent() {
        return current;
    }

    public void setPrevious(T previous) {
        this.previous = previous;
    }

    public void setRouteScore(double routeScore) {
        this.routeScore = routeScore;
    }

    public void setEstimatedScore(double estimatedScore) {
        this.estimatedScore = estimatedScore;
    }

    public T getPrevious() {
        return previous;
    }

    public double getRouteScore() {
        return routeScore;
    }

    public double getEstimatedScore() {
        return estimatedScore;
    }


    @Override
    public int compareTo(RouteNode other) {
        return Double.compare(this.estimatedScore, other.estimatedScore);
    }

    @Override
    public String toString() {
        return current.toString();
    }
}
