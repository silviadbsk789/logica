 import java.util.Scanner;

public class ejercicio9 {

    
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        
        int original = number;
        int reversed = 0;
        
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        
        return original == reversed;
    }
    
    public static String getExplanation(int number) {
        if (!isPalindrome(number)) {
            return number + " no es palíndromo.";
        }
        
        int original = number;
        int reversed = 0;
        StringBuilder process = new StringBuilder();
        
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            
            if (process.length() > 0) {
                process.insert(0, " + ");
            }
            process.insert(0, digit + " × 10^" + (String.valueOf(original).length() - String.valueOf(reversed).length()));
            
            number /= 10;
        }
        
        return original + " es palíndromo porque: " + process.toString() + " = " + reversed;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== NÚMERO PALÍNDROMO (MÉTODO MATEMÁTICO) ===");
        
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.print("\nIngrese un número: ");
                int number = scanner.nextInt();
                
                boolean result = isPalindrome(number);
                
                System.out.println("¿El número " + number + " es palíndromo? " + result);
                System.out.println(getExplanation(number));
                
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine();
            }
            
            System.out.print("\n¿Desea probar otro número? (s/n): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("s");
            scanner.nextLine();
        }
        
        System.out.println("¡Gracias por usar el programa!");
        scanner.close();
    }
}   
