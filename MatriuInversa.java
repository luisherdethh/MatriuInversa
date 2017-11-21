/**
 * Created by pnegre on 16/11/16.
 */
public class MatriuInversa {
    static double[][] invert(double[][] mat) {
        return null;
    }

    static double[][] calcCofactors(double[][] mat) {
        return null;
    }

    static double[][] getMinor(double[][] mat, int x, int y) {
        return null;
    }

    static double calcDeterminant(double[][] mat) {
        return 0;
    }

    static double[][] transpose(double[][] mat) {
        return null;
    }

    // Funció que mostra una matriu per pantalla
    static void printMat(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("%06.2f ", mat[i][j]);
            }
            System.out.println();
        }
    }
}
