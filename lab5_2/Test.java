package lab5_2;

import java.util.Set;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.*;

public class Test {
    public static void main(String[] args) {
        Set<Point> points = new HashSet<>();
        points.add(new Point(1, 1));
        points.add(new Point(2, 3));
        points.add(new Point(4, 2));
        points.add(new Point(5, 5));

        PointSet pointSet = new PointSet(points);

        Stream<Circle> circleStream = pointSet.generateCircles(2);
        
        Map<Integer, Long> countByInterval = circleStream
                .map(circle -> (int) (circle.getRadius() / 10) * 10)
                .collect(Collectors.groupingBy(interval -> interval, Collectors.counting()));

        countByInterval.forEach((interval, count) -> {
            int start = interval;
            int end = interval + 10;
            System.out.println("Circle count in interval [" + start + ", " + end + "): " + count);
        });

        Optional<Double> minRectangleArea = pointSet.computeMinimumRectangleArea();
        minRectangleArea.ifPresent(area -> System.out.println("Minimum rectangle area: " + area));
    }
}