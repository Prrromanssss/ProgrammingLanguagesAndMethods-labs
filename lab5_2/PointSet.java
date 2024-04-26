package lab5_2;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Comparator;

public class PointSet {
    private Set<Point> points;

    public PointSet(Set<Point> points) {
        this.points = points;
    }

    public Stream<Circle> generateCircles(int k) {
        return points.stream().map(point -> {
            double[] distances = points.stream()
                                       .filter(other -> !other.equals(point))
                                       .mapToDouble(other -> Math.sqrt(Math.pow(other.getX() - point.getX(), 2) + Math.pow(other.getY() - point.getY(), 2)))
                                       .sorted()
                                       .toArray();

            double radius = distances[Math.min(k, distances.length - 1)];

            return new Circle(point, radius);
        });
    }

    public Optional<Double> computeMinimumRectangleArea() {
        if (points.isEmpty()) {
            return Optional.empty();
        }

        double minX = points.stream().mapToDouble(Point::getX).min().getAsDouble();
        double minY = points.stream().mapToDouble(Point::getY).min().getAsDouble();
        double maxX = points.stream().mapToDouble(Point::getX).max().getAsDouble();
        double maxY = points.stream().mapToDouble(Point::getY).max().getAsDouble();

        double width = maxX - minX;
        double height = maxY - minY;

        return Optional.of(width * height);
    }
}