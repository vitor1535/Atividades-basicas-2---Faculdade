import java.util.Scanner;

public class tp0111 {

    //checa se eh palindromo
    public static boolean isPalindromo(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            //retorna verdadeiro caso seja
            if (Character.toLowerCase(first) == Character.toLowerCase(last)) {
                return isPalindromo(s.substring(1, s.length() - 1));
            } else {
                //retorna falso caso nao seja
                return false;
            }
        }
    }

    //parte princiapl que usa o metodo ispalindromo com input do usuario
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String linha = scanner.nextLine();
        while (!linha.equals("FIM")) {
            if (isPalindromo(linha)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            linha = scanner.nextLine();
        }
        scanner.close();
    }
}
