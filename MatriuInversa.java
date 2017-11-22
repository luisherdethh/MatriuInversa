/**
 * Created by pnegre on 16/11/16.
 */
public class MatriuInversa {
    static double[][] invert(double[][] mat) {

        double det = calcDeterminant(mat);
        double[][] cof = calcCofactors(mat);
        //transpoición
        double[][] trans = transpose(cof);

        for (int i = 0; i < trans.length; i++) {
            for (int j = 0; j < trans[1].length; j++) {
//                trans[i][j] /= det;
                trans[i][j] = trans[i][j] / det;
            }
        }

        return trans;
    }

    static double[][] calcCofactors(double[][] mat) {

//        Lo tercero que hay que hacer. 17:25
        double[][] resultat = new double[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                double[][] menor = getMinor(mat, j, i);
                double det = calcDeterminant(menor);
//                cambiar "+" a "-"
                if ((i + j) % 2 != 0) det = det * -1;
                resultat[i][j] = det;
            }
        }
        return resultat;
    }

    static double[][] getMinor(double[][] mat, int col, int fila) {
        int dim = mat.length;
        double[][] resultat = new double[dim - 1][dim - 1];
        //crear 2 varibles nuevas "yy" i "xx"
        int yy = 0;
        for (int i = 0; i < dim; i++) {
            if (i == fila) continue;
            int xx = 0;
            for (int j = 0; j < dim; j++) {
                if (j != col) {
//                i es la FILA
                    resultat[yy][xx] = mat[i][j];
                    xx++;
                }
            }
            yy++;
        }
        return resultat;
    }

    static double calcDeterminant(double[][] mat) {
        //dim = dimensión
        int dim = mat.length;
        if (dim == 2) {
            double resultat = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
            return resultat;
        }

        double resultat = 0;
        for (int i = 0; i < dim; i++) {
            // 0 --> Por la primera fila
            double factor = mat[0][i];
            if (i % 2 != 0) {
                factor = factor * +-1;
            }
            double[][] min = getMinor(mat, i, 0);
            resultat = resultat + factor * calcDeterminant(min);
        }
        return resultat;

    }

    static double[][] transpose(double[][] mat) {

        //primer test
//        double t = mat[1][0];
//        mat[1][0] = mat[0][1];
//        mat[0][1] = t;
//        return mat;
        //fin 1er test

        double[][] result = new double[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                result[i][j] = mat[j][i];
            }
        }
        return result;
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
