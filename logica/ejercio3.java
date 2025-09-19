import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercio3 {
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int n = matrix.length;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Recorrer de izquierda a derecha en la fila superior
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            // Recorrer de arriba a abajo en la columna derecha
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Recorrer de derecha a izquierda en la fila inferior (si existe)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // Recorrer de abajo a arriba en la columna izquierda (si existe)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
    
    // Método para leer la matriz desde el teclado
    public static int[][] readMatrixFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño de la matriz (n x n): ");
        int n = scanner.nextInt();
        
        int[][] matrix = new int[n][n];
        
        System.out.println("Ingrese los elementos de la matriz fila por fila:");
        for (int i = 0; i < n; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
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
        
        System.out.println("=== RECORRIDO EN ESPIRAL DE MATRIZ ===");
        
        boolean continuar = true;
        while (continuar) {
            try {
                // Leer la matriz desde el teclado
                int[][] matrix = readMatrixFromKeyboard();
                
                // Mostrar la matriz ingresada
                printMatrix(matrix);
                
                // Calcular y mostrar el recorrido en espiral
                List<Integer> spiralResult = spiralOrder(matrix);
                System.out.println("\nRecorrido en espiral: " + spiralResult);
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            // Preguntar si desea continuar
            System.out.print("\n¿Desea procesar otra matriz? (s/n): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("s");
        }
        
        System.out.println("¡Gracias por usar el programa!");
        scanner.close();
    }
}

