public class SpiralMatrixII{
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        // 4 directions
        int leftBound = 0, upperBound = 0;
        int rightBound = n - 1, lowerBound = n - 1;
        int num = 1;
        while (num <= n * n){
            // upper row
            if (upperBound <= lowerBound){
                for (int i = leftBound; i <= rightBound; i++){
                    matrix[upperBound][i] = num++;
                }
                // move the upperBound
                upperBound++;
            }

            // right col
            if (leftBound <= rightBound){
                for (int i = upperBound; i <= lowerBound; i++){
                    matrix[i][rightBound] = num++;
                }
                rightBound--;
            }

            // bottom row
            if (upperBound <= lowerBound){
                for (int i = rightBound; i >= leftBound; i--){
                    matrix[lowerBound][i] = num++;
                }
                lowerBound--;
            }

            // leftCol
            if (leftBound <= rightBound){
                for (int i = lowerBound; i >= upperBound; i--){
                    matrix[i][leftBound] = num++;
                }
                leftBound++;
            }
        }

        return matrix;
    }

    public static void main(String[] args){
        System.out.println(generateMatrix(5));
    }
}