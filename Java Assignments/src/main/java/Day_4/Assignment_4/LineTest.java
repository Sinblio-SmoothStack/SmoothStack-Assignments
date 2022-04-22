package Day_4.Assignment_4;/*
Benjamin Schroeder

A tester class to test the Line object and its various functions
 */

import org.junit.jupiter.api.*;

import java.awt.*;

public class LineTest {
    private Line l1;
    private Line l2;
    private Line l3;

    @BeforeEach
    void setup () {
        l1 = new Line(new Point(0,0), new Point(5,5));
        l2 = new Line(new Point(-3,6), new Point(0,9));
        l3 = new Line(new Point(2,4), new Point(4,0));
    }

    @Test
    void getSlope() {
        assert l1.getSlope() == 1;
        assert l2.getSlope() == 1;
        assert l3.getSlope() == -2;
    }

    @Test
    void getDistance() {
        assert Math.abs(l1.getDistance()) - 7.07 < 0.1 && Math.abs(l1.getDistance()) - 7.07 > -0.1;
        assert Math.abs(l2.getDistance()) - 4.24 < 0.1 && Math.abs(l2.getDistance()) - 2.24 > -0.1;
        assert Math.abs(l3.getDistance()) - 4.47 < 0.1 && Math.abs(l3.getDistance()) - 4.47 > -0.1;
    }

    @Test
    void isParallel() {
        assert l1.parallelTo(l2);
        assert !l1.parallelTo(l3);
        assert !l2.parallelTo(l3);
    }

    @AfterEach
    void tearDown() {
        l1 = null;
        l2 = null;
        l3 = null;
    }
}
