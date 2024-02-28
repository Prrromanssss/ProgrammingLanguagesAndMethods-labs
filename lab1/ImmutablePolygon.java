import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutablePolygon {
    private final List<Point> vertices;

    public ImmutablePolygon(List<Point> vertices) {
        this.vertices = Collections.unmodifiableList(new ArrayList<>(vertices));
    }

    public List<Point> getVertices() {
        return vertices;
    }

    public ImmutablePolygon shift(double deltaX, double deltaY) {
        List<Point> shiftedVertices = new ArrayList<>();
        for (Point vertex : vertices) {
            double newX = vertex.getX() + deltaX;
            double newY = vertex.getY() + deltaY;
            shiftedVertices.add(new Point(newX, newY));
        }
        return new ImmutablePolygon(shiftedVertices);
    }

    public ImmutablePolygon rotate(Point pivot, double angle) {
        List<Point> rotatedVertices = new ArrayList<>();
        double cosTheta = Math.cos(angle);
        double sinTheta = Math.sin(angle);
        for (Point vertex : vertices) {
            double dx = vertex.getX() - pivot.getX();
            double dy = vertex.getY() - pivot.getY();
            double newX = pivot.getX() + (dx * cosTheta - dy * sinTheta);
            double newY = pivot.getY() + (dx * sinTheta + dy * cosTheta);
            rotatedVertices.add(new Point(newX, newY));
        }
        return new ImmutablePolygon(rotatedVertices);
    }

    public String toString() {
        String result = "ImmutablePolygon{vertices=[";
        for (int i = 0; i < vertices.size(); i++) {
            result += vertices.get(i);
            if (i != vertices.size() - 1) {
                result += ", ";
            }
        }
        result += "]}";
        return result;
    }
}