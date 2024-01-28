package test.com.sparse.matrix;

import com.sparse.matrix.DMatrixSparseCSC;
import com.sparse.matrix.SparseLU;

import java.util.Arrays;

public class TestSparseLu {
    public static void main(String[] args) {
        DMatrixSparseCSC sparseCSC = new DMatrixSparseCSC(3, 3);
        double[][] matrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 10},
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                double value = matrix[i][j];
                if (value != 0.0) {
                    sparseCSC.set(i, j, value);
                }
            }
        }
        double[] b = {1, 2, 0};
        SparseLU sparseLU = new SparseLU();
        //分解
        sparseLU.setA(sparseCSC);
        //求解
        sparseLU.solve(b);
        System.out.println("求解 b = " + Arrays.toString(b));
    }
}
