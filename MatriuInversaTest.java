import org.junit.Test;

import static org.junit.Assert.*;


public class MatriuInversaTest {

    @Test
    public void tesTransposicio() {
//        double[][] mat1 = { {1,2},{3,4}};
//        double[][] t1 = {{1,3},{2,4}};
//        compareArraysDouble(t1, MatriuInversa.transpose(mat1), 0.01);

        double[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] t2 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        compareArraysDouble(t2, MatriuInversa.transpose(mat2), 0.01);
    }

    @Test
    public void testDeterminant() {
        double[][] mat0 = {{1, 2}, {3, 4}};
        assertEquals(-2, MatriuInversa.calcDeterminant(mat0), 0.001);

        double[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 2, 7}};
        assertEquals(-30, MatriuInversa.calcDeterminant(mat1), 0.001);

        double[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(0, MatriuInversa.calcDeterminant(mat2), 0.001);

        double[][] mat3 = {{21, 26, 33, 66}, {4, 45, 96, 1}, {7, 8, 9, 29}, {43, 17, 32, -4}};
        assertEquals(-197375, MatriuInversa.calcDeterminant(mat3), 0.001);
    }

    @Test
    public void testMinors() {
        double[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(new double[][]{{5, 6}, {8, 9}}, MatriuInversa.getMinor(mat, 0, 0));
        assertArrayEquals(new double[][]{{1, 3}, {7, 9}}, MatriuInversa.getMinor(mat, 1, 1));
        assertArrayEquals(new double[][]{{4, 6}, {7, 9}}, MatriuInversa.getMinor(mat, 1, 0));
        assertArrayEquals(new double[][]{{2, 3}, {5, 6}}, MatriuInversa.getMinor(mat, 0, 2));
    }

    @Test
    public void testCofactors() {
        double[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        compareArraysDouble(new double[][]{{-3, 6, -3}, {6, -12, 6}, {-3, 6, -3}},
                MatriuInversa.calcCofactors(mat), 0.01);
    }

    @Test
    public void testInv1() {
        double[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 2, 7}};
        compareArraysDouble(new double[][]{{-0.77, 0.26, 0.1}, {-0.47, 0.47, -0.2}, {0.9, -0.4, 0.1}},
                MatriuInversa.invert(mat), 0.01);
    }

    @Test
    public void testInv2() {
        double[][] mat = {{1, 2, 3, 3}, {4, 5, 6, 2}, {7, 2, 7, 7}, {1, 6, 5, 2}};
        compareArraysDouble(new double[][]{{-1.55, -0.63, 0.60, 0.84}, {-1.84, -1.10, 0.68, 1.47}, {2.81, 1.78, -1.13, -2.05}, {-0.74, -0.84, 0.47, 0.79}},
                MatriuInversa.invert(mat), 0.01);
    }

    private void compareArraysDouble(double[][] doubles, double[][] invert, double v) {
        for (int i = 0; i < doubles.length; i++) {
            for (int j = 0; j < doubles.length; j++) {
                assertEquals(doubles[i][j], invert[i][j], v);
            }
        }
    }
}
