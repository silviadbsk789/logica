    import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class ejercicio4 {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        // Ordenar los intervalos por su tiempo de fin
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int count = 1; // Contador de intervalos no solapados
        int end = intervals[0][1]; // Tiempo de fin del último intervalo seleccionado
        
        for (int i = 1; i < intervals.length; i++) {
            // Si el inicio del intervalo actual es mayor o igual al fin del último seleccionado
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        
        return intervals.length - count;
    }
    
    // Método para leer intervalos desde el teclado
    public static int[][] readIntervalsFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número de intervalos: ");
        int n = scanner.nextInt();
        
        int[][] intervals = new int[n][2];
        
        System.out.println("Ingrese los intervalos (formato: inicio fin):");
        for (int i = 0; i < n; i++) {
            System.out.print("Intervalo " + (i + 1) + ": ");
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }
        
        return intervals;
    }
    
    // Método para mostrar los intervalos
    public static void printIntervals(int[][] intervals) {
        System.out.println("\nIntervalos ingresados:");
        for (int i = 0; i < intervals.length; i++) {
            System.out.println("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ELIMINACIÓN DE INTERVALOS SOLAPADOS ===");
        
        boolean continuar = true;
        while (continuar) {
            try {
                // Leer los intervalos desde el teclado
                int[][] intervals = readIntervalsFromKeyboard();
                
                // Mostrar los intervalos ingresados
                printIntervals(intervals);
                
                // Calcular y mostrar el resultado
                int result = eraseOverlapIntervals(intervals);
                System.out.println("\nNúmero mínimo de intervalos a eliminar: " + result);
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar buffer
            }
            
            // Preguntar si desea continuar
            System.out.print("\n¿Desea procesar otros intervalos? (s/n): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("s");
        }
        
        System.out.println("¡Gracias por usar el programa!");
        scanner.close();
    }
}

