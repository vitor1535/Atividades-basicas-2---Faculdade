import java.util.Scanner;

public class tp0103 {
    public static void main(String[] args) {
        // Cria um scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Lê a mensagem a ser cifrada
        System.out.print("Digite a mensagem a ser cifrada: ");
        String mensagem = scanner.nextLine();
        
        // Cifra a mensagem usando a cifra de César com chave 3
        String cifrada = cifraCesar(mensagem);
        
        // Exibe a mensagem cifrada na tela
        System.out.println("Mensagem cifrada: " + cifrada);
        
        // Fecha o scanner
        scanner.close();
    }
    
    public static String cifraCesar(String mensagem) {
        int tamanho = mensagem.length();
        String cifrada = "";
        
        for (int i = 0; i < tamanho; i++) {
            char caractere = mensagem.charAt(i);
            
            // Verifica se o caractere é uma letra maiúscula
            if (Character.getType(caractere) == Character.UPPERCASE_LETTER) {
                // Aplica a cifra de César com chave 3
                char cifrado = (char) ((caractere + 3 - 65) % 26 + 65);
                cifrada += cifrado;
            }
            // Verifica se o caractere é uma letra minúscula
            else if (Character.getType(caractere) == Character.LOWERCASE_LETTER) {
                // Aplica a cifra de César com chave 3
                char cifrado = (char) ((caractere + 3 - 97) % 26 + 97);
                cifrada += cifrado;
            }
            // Se não for uma letra, mantém o caractere original
            else {
                cifrada += caractere;
            }
        }
        
        return cifrada;
    }
}