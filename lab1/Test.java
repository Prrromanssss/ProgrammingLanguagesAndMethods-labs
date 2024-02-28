import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        // Создаем список координат вершин многоугольника
        List<Point> vertices = new ArrayList<>();
        vertices.add(new Point(0, 0));
        vertices.add(new Point(1, 0));
        vertices.add(new Point(1, 1));
        vertices.add(new Point(0, 1));

        // Создаем неизменяемый многоугольник
        ImmutablePolygon polygon = new ImmutablePolygon(vertices);

        // Выводим вершины многоугольника
        System.out.println("Original Polygon Vertices:");
        for (Point vertex : polygon.getVertices()) {
            System.out.println(vertex);
        }

        // Сдвигаем многоугольник на заданное расстояние
        ImmutablePolygon shiftedPolygon = polygon.shift(1, 1);
        System.out.println("\nShifted Polygon Vertices:");
        for (Point vertex : shiftedPolygon.getVertices()) {
            System.out.println(vertex);
        }

        // Поворачиваем многоугольник вокруг указанной точки на заданный угол
        Point pivot = new Point(0.5, 0.5);
        double angle = Math.PI / 2; // Поворот на 90 градусов (в радианах)
        ImmutablePolygon rotatedPolygon = polygon.rotate(pivot, angle);
        System.out.println("\nRotated Polygon Vertices:");
        for (Point vertex : rotatedPolygon.getVertices()) {
            System.out.println(vertex);
        }
    }
}
