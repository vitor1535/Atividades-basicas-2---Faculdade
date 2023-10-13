import java.util.Scanner;

public class tp0113 {
    public static String cifra(String s) {
        if (s.length() == 0) { // Caso base: string vazia
            return "";
        } else {
            char c = s.charAt(0); // Pega o primeiro caractere da string
            if (c >= 'a' && c <= 'z') { // Verifica se é uma letra minúscula
                c = (char) (((c - 'a' + 3) % 26) + 'a'); // Realiza a cifração
            } else if (c >= 'A' && c <= 'Z') { // Verifica se é uma letra maiúscula
                c = (char) (((c - 'A' + 3) % 26) + 'A'); // Realiza a cifração
            }
            // Concatena o caractere cifrado com a cifra dos demais caracteres da string
            return c + cifra(s.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        while (true) {
            s = sc.nextLine();
            if (s.equals("FIM")) { // Verifica se chegou ao fim da entrada
                break;
            }
            System.out.println(cifra(s)); // Imprime a string cifrada
        }
        sc.close();
    }
}
