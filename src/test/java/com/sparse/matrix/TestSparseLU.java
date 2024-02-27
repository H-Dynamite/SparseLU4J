package com.sparse.matrix;

import java.util.Arrays;

public class TestSparseLU {
    public static void main(String[] args) {
        double[][] matrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 10},
        };

        DMatrixSparseCSC sparseCSC = MatrixUtils.convert(matrix, DMatrixSparseCSC.EPS);
        double[] b = {1, 2, 0};
        SparseLU sparseLU = new SparseLU();
        //分解
        sparseLU.setA(sparseCSC);
        //求解
        sparseLU.solve(b);
        System.out.println("求解 b = " + Arrays.toString(b));
    }
}
