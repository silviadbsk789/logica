import java.util.Scanner;

public class ejercicio6 {

    
    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    numIslands++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        
        return numIslands;
    }
    
    private static void dfs(int[][] grid, int i, int j, int rows, int cols) {
        // Verificar límites y si es agua o ya visitado
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return;
        }
        
        // Marcar como visitado (cambiar a agua)
        grid[i][j] = 0;
        
        // Explorar las 4 direcciones: arriba, abajo, izquierda, derecha
        dfs(grid, i - 1, j, rows, cols); // Arriba
        dfs(grid, i + 1, j, rows, cols); // Abajo
        dfs(grid, i, j - 1, rows, cols); // Izquierda
        dfs(grid, i, j + 1, rows, cols); // Derecha
    }
    
    // Método para leer la matriz desde el teclado
    public static int[][] readMatrixFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número de filas: ");
        int rows = scanner.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int cols = scanner.nextInt();
        
        int[][] matrix = new int[rows][cols];
        
        System.out.println("Ingrese los elementos de la matriz (0 para agua, 1 para tierra):");
        for (int i = 0; i < rows; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        return matrix;
    }
    
    // Método para mostrar la matriz
    public static void printMatrix(int[][] matrix) {
        System.out.println("\nMatriz ingresada:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CONTADOR DE ISLAS ===");
        
        boolean continuar = true;
        while (continuar) {
            try {
                // Leer la matriz desde el teclado
                int[][] matrix = readMatrixFromKeyboard();
                
                // Mostrar la matriz ingresada
                printMatrix(matrix);
                
                // Crear una copia para no modificar la original
                int[][] gridCopy = new int[matrix.length][];
                for (int i = 0; i < matrix.length; i++) {
                    gridCopy[i] = matrix[i].clone();
                }
                
                // Contar islas
                int result = numIslands(gridCopy);
                System.out.println("Número de islas: " + result);
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar buffer
            }
            
            // Preguntar si desea continuar
            System.out.print("\n¿Desea procesar otra matriz? (s/n): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("s");
            scanner.nextLine(); // Limpiar buffer
        }
        
        System.out.println("¡Gracias por usar el programa!");
        scanner.close();
    }
}
