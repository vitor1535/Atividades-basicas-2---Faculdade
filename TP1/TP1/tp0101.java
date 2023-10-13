import java.util.Scanner;

public class tp0101 {
    
    //checa se eh palindromo
    public static boolean isPalindromo(String s) {
        
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    
    //parte principal do codigo que recebe input do usuario e testa
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String entrada = sc.nextLine();
            if (entrada.equals("FIM")) {
                break;
            }
            
            String resultado = isPalindromo(entrada) ? "SIM" : "NAO";
            System.out.println(resultado);
        }
        
        sc.close();
    }
}
