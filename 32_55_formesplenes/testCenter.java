public class testCenter {
    public static void main(String[] args) {
        // Test 1: Matriz de tamaño par
        boolean[][] matrix1 = new boolean[4][6];
        int[] center1 = getCenter(matrix1);
        System.out.println("Test 1 - Matriz de tamaño par:");
        printMatrixWithCenter(matrix1, center1);

        // Test 2: Matriz de tamaño impar
        boolean[][] matrix2 = new boolean[5][7];
        int[] center2 = getCenter(matrix2);
        System.out.println("\nTest 2 - Matriz de tamaño impar:");
        printMatrixWithCenter(matrix2, center2);

        // Test 3: Matriz cuadrada de tamaño par
        boolean[][] matrix3 = new boolean[6][6];
        int[] center3 = getCenter(matrix3);
        System.out.println("\nTest 3 - Matriz cuadrada de tamaño par:");
        printMatrixWithCenter(matrix3, center3);

        // Test 4: Matriz cuadrada de tamaño impar
        boolean[][] matrix4 = new boolean[3][10];
        int[] center4 = getCenter(matrix4);
        System.out.println("\nTest 4 - Matriz cuadrada de tamaño impar:");
        printMatrixWithCenter(matrix4, center4);

        // Test 5: Matriz cuadrada de tamaño 10x5
        boolean[][] matrix5 = new boolean[10][5];
        int[] center5 = getCenter(matrix5);
        System.out.println("\nTest 5 - Matriz cuadrada de tamaño 10x5");
        printMatrixWithCenter(matrix5, center5);
    }

    public static int[] getCenter(boolean[][] taula) {
        int[] center = new int[2]; // [vertical, horizontal]

        // Calcul vertical
        if (taula[0].length % 2 == 0) {
            center[0] = taula[0].length / 2 - 1;
        } else {
            center[0] = taula[0].length / 2;
        }

        // Calcul horizontal
        if (taula.length % 2 == 0) {
            center[1] = taula.length / 2 - 1;
        } else {
            center[1] = taula.length / 2;
        }

        return center;
    }

    public static void printMatrixWithCenter(boolean[][] matrix, int[] center) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == center[1] && j == center[0]) {
                    System.out.print("↑ ");
                } else {
                    System.out.print(matrix[i][j] ? "X " : ". ");
                }
            }
            System.out.println();
        }
    }
}
