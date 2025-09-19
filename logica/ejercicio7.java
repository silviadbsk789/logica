import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ejercicio7 {
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }
        
        return n == 1;
    }
    
    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== NÚMERO FELIZ ===");
        
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.print("Ingrese un número: ");
                int number = scanner.nextInt();
                
                boolean result = isHappy(number);
                
                System.out.println("¿El número " + number + " es feliz? " + result);
                
                // Mostrar explicación si es feliz
                if (result) {
                    System.out.print("Explicación: ");
                    printExplanation(number);
                }
                
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar buffer
            }
            
            System.out.print("\n¿Desea probar otro número? (s/n): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("s");
            scanner.nextLine(); // Limpiar buffer
        }
        
        System.out.println("¡Gracias por usar el programa!");
        scanner.close();
    }
    
    // Método para mostrar la explicación del proceso
    private static void printExplanation(int n) {
        StringBuilder explanation = new StringBuilder();
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int original = n;
            n = getSumOfSquares(n);
            
            explanation.append(getSquaresExplanation(original))
                      .append(" = ")
                      .append(n)
                      .append(", ");
        }
        
        // Eliminar la última coma y espacio
        if (explanation.length() > 0) {
            explanation.setLength(explanation.length() - 2);
        }
        
        System.out.println(explanation.toString());
    }
    
    // Método para obtener la explicación de los cuadrados
    private static String getSquaresExplanation(int n) {
        StringBuilder sb = new StringBuilder();
        int temp = n;
        
        while (temp > 0) {
            int digit = temp % 10;
            if (sb.length() > 0) {
                sb.insert(0, "+");
            }
            sb.insert(0, digit + "²");
            temp /= 10;
        }
        
        // Corregir formato para números con múltiples dígitos
        String result = sb.toString();
        result = result.replace("²+", "² + ");
        return result;
    }
}
