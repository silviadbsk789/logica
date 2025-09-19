import java.util.Scanner;    
public class ejercicio8 {
    
    public static boolean isArmstrong(int number) {
        if (number < 0) {
            return false;
        }
        
        int originalNumber = number;
        int numDigits = countDigits(number);
        int sum = 0;
        
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numDigits);
            number /= 10;
        }
        
        return sum == originalNumber;
    }
    
    private static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    
    // Método para obtener la explicación detallada
    public static String getExplanation(int number) {
        if (!isArmstrong(number)) {
            return number + " no es un número de Armstrong.";
        }
        
        int originalNumber = number;
        int numDigits = countDigits(number);
        StringBuilder explanation = new StringBuilder();
        explanation.append(number).append(" es un número de Armstrong porque: ");
        
        // Reconstruir la explicación
        int temp = originalNumber;
        int sum = 0;
        boolean first = true;
        
        while (temp > 0) {
            int digit = temp % 10;
            int power = (int) Math.pow(digit, numDigits);
            sum += power;
            
            if (!first) {
                explanation.append(" + ");
            }
            explanation.append(digit).append("^").append(numDigits);
            first = false;
            
            temp /= 10;
        }
        
        explanation.append(" = ").append(sum);
        return explanation.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== NÚMERO DE ARMSTRONG ===");
        System.out.println("Un número de Armstrong es igual a la suma de sus dígitos");
        System.out.println("elevados a la potencia de la cantidad de dígitos.");
        
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.print("\nIngrese un número: ");
                int number = scanner.nextInt();
                
                boolean result = isArmstrong(number);
                
                System.out.println("¿El número " + number + " es Armstrong? " + result);
                
                if (result) {
                    System.out.println(getExplanation(number));
                } else {
                    System.out.println(number + " no es un número de Armstrong.");
                    // Mostrar cálculo para comparación
                    int numDigits = countDigits(number);
                    StringBuilder calculation = new StringBuilder();
                    calculation.append("Cálculo: ");
                    
                    int temp = number;
                    boolean first = true;
                    int totalSum = 0;
                    
                    while (temp > 0) {
                        int digit = temp % 10;
                        int power = (int) Math.pow(digit, numDigits);
                        totalSum += power;
                        
                        if (!first) {
                            calculation.append(" + ");
                        }
                        calculation.append(digit).append("^").append(numDigits);
                        first = false;
                        
                        temp /= 10;
                    }
                    
                    calculation.append(" = ").append(totalSum);
                    calculation.append(" ≠ ").append(number);
                    System.out.println(calculation.toString());
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
}
