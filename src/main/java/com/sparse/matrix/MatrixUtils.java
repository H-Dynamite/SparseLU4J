package com.sparse.matrix;
public class MatrixUtils {
    public static DMatrixSparseCSC convert(double circuitMatrix[][], double tol) {
        int nonzero = 0;
        for (int i = 0; i != circuitMatrix.length; i++)
            for (int j = 0; j != circuitMatrix.length; j++) {
                if (circuitMatrix[i][j] != 0) {
                    nonzero++;
                }
            }
        DMatrixSparseCSC dst = new DMatrixSparseCSC(circuitMatrix.length, circuitMatrix.length, nonzero);
        dst.nz_length = 0;
        dst.col_idx[0] = 0;
        int i, j;
        for (i = 0; i != circuitMatrix.length; i++) {
            for (j = 0; j != circuitMatrix.length; j++) {
                double value = circuitMatrix[j][i];
                if (!(Math.abs(value) <= tol)) {
                    dst.nz_rows[dst.nz_length] = j;
                    dst.nz_values[dst.nz_length] = value;
                    ++dst.nz_length;
                }
            }
            dst.col_idx[i + 1] = dst.nz_length;
        }

        return dst;
    }

}
