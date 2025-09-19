import java.util.HashSet;
import java.util.Scanner;
public class ejercicio2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== VERIFICAR SUMA DE DOS NÚMEROS ===");
        System.out.println("Determina si existen dos números que sumen exactamente el target");
        System.out.println();
        
        while (true) {
            // Pedir al usuario que ingrese el array
            System.out.print("Ingresa los números separados por espacios: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("salir")) {
                System.out.println("¡Hasta luego!");
                break;
            }
            
            if (input.isEmpty()) {
                System.out.println("Por favor, ingresa al menos un número.");
                continue;
            }
            
            // Convertir la entrada a array de números
            String[] partes = input.split(" ");
            int[] nums = new int[partes.length];
            
            try {
                for (int i = 0; i < partes.length; i++) {
                    nums[i] = Integer.parseInt(partes[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa solo números válidos.");
                continue;
            }
            
            // Pedir el target
            System.out.print("Ingresa el target: ");
            int target;
            
            try {
                target = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Target debe ser un número válido.");
                continue;
            }
            
            // Verificar si existen dos números que sumen el target
            boolean resultado = existenDosSuma(nums, target);
            
            // Mostrar resultado
            System.out.println("Array: " + java.util.Arrays.toString(nums));
            System.out.println("Target: " + target);
            System.out.println("¿Existen dos números que sumen " + target + "? " + resultado);
            System.out.println("----------------------------------------");
        }
        
        scanner.close();
    }
    
    public static boolean existenDosSuma(int[] nums, int target) {
        HashSet<Integer> vistos = new HashSet<>();
        
        for (int num : nums) {
            int complemento = target - num;
            
            if (vistos.contains(complemento)) {
                return true;
            }
            
            vistos.add(num);
        }
        
        return false;
    }
}

