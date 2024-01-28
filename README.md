# SparseLU4J

非常轻量的稀疏矩阵LU分解和求解库，无任何依赖，仅仅四个文件，从EJML中移植而来，主要用于GWT项目，也可以使用于其他Java引用。
### 注意事项
1、矩阵仅仅支持CSC稀疏矩阵格式

使用方式如下:

### 初始化矩阵

```
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
```

### LU分解

```
SparseLU sparseLU = new SparseLU();
  //分解
sparseLU.setA(sparseCSC);
```

### 求解

```
double[] b = {1, 2, 0};
sparseLU.solve(b);
System.out.println("求解 b = " + Arrays.toString(b));
```