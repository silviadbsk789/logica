public class ejercicio1{

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "abcde";

        System.out.println(subcadenaPalindroma(s1)); // → "bab"
        System.out.println(subcadenaPalindroma(s2)); // → "bb"
        System.out.println(subcadenaPalindroma(s3)); // → "a"
    }

    public static String subcadenaPalindroma(String s) {
        if (s == null || s.length() < 1) return "";
        int inicio = 0, fin = 0;
        for (int i = 0; i < s.length(); i++) {
            // Expandir desde centro único (longitud impar)
            int len1 = expandirDesdeCentro(s, i, i);
            // Expandir desde centro doble (longitud par)
            int len2 = expandirDesdeCentro(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > fin - inicio) {
                inicio = i - (maxLen - 1) / 2;
                fin = i + maxLen / 2;
            }
        }
        return s.substring(inicio, fin + 1);
    }
    
    private static int expandirDesdeCentro(String s, int izquierda, int derecha) {
        while (izquierda >= 0 && derecha < s.length() && 
        s.charAt(izquierda) == s.charAt(derecha)) {
        izquierda--;
        derecha++;
        }
        return derecha - izquierda - 1;
    }
}