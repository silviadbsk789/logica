import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ejercicio5 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // Si el carácter ya está en el conjunto, mover left hasta eliminarlo
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            // Agregar el carácter actual al conjunto
            charSet.add(currentChar);
            
            // Actualizar la longitud máxima
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // Método para encontrar y mostrar la subcadena misma (opcional)
    public static String findLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            charSet.add(currentChar);
            
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SUBCADENA MÁS LARGA SIN CARACTERES REPETIDOS ===");
        
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.print("Ingrese una cadena: ");
                String input = scanner.nextLine();
                
                if (input.isEmpty()) {
                    System.out.println("La cadena no puede estar vacía.");
                    continue;
                }
                
                int length = lengthOfLongestSubstring(input);
                String substring = findLongestSubstring(input);
                
                System.out.println("Cadena ingresada: \"" + input + "\"");
                System.out.println("Longitud de la subcadena más larga: " + length);
                System.out.println("Subcadena: \"" + substring + "\"");
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            System.out.print("\n¿Desea procesar otra cadena? (s/n): ");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");
        }
        
        System.out.println("¡Gracias por usar el programa!");
        scanner.close();
    }
}
