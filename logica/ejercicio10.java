import java.util.Scanner;
public class ejercicio10 {
    
    // Función que multiplica un número grande (almacenado en array de dígitos) por un entero x
    static int multiplicar(int x, int resultado[], int tam) {
        int carry = 0; // acarreo
        for (int i = 0; i < tam; i++) {
            int prod = resultado[i] * x + carry;
            resultado[i] = prod % 10; // guardamos el dígito
            carry = prod / 10;       // actualizamos acarreo
        }

        // procesamos el acarreo restante
        while (carry != 0) {
            resultado[tam] = carry % 10;
            carry = carry / 10;
            tam++;
        }
        return tam;
    }

    // Función para calcular el factorial de n
    static void factorial(int n) {
        int[] resultado = new int[5000]; // capacidad suficiente para guardar los dígitos
        resultado[0] = 1; // inicializa con 1
        int tam = 1;      // tamaño actual (número de dígitos)

        // multiplicamos desde 2 hasta n
        for (int x = 2; x <= n; x++) {
            tam = multiplicar(x, resultado, tam);
        }

        // imprimimos el número en orden inverso
        for (int i = tam - 1; i >= 0; i--) {
            System.out.print(resultado[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número n: ");
        int n = sc.nextInt();
        System.out.print("Factorial de " + n + " es: ");
        factorial(n);
        sc.close();
    }
}

