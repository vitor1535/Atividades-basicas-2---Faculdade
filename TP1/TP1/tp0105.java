import java.util.Scanner;
import java.util.Stack;

public class tp0105 {
    
    //parte principal onde vai pegar input do usuario, calcula e devolve sim/nao
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] valores = new boolean[n];
        for (int i = 0; i < n; i++) {
            valores[i] = scanner.nextBoolean();
        }
        String expressao = scanner.next();
        boolean resultado = calcularExpressao(expressao, valores);
        System.out.println(resultado ? "SIM" : "NÃO");

        scanner.close();
    }
    
    //metodo que calcula expressao
    public static boolean calcularExpressao(String expressao, boolean[] valores) {
        Stack<Boolean> pilha = new Stack<>();
        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            if (caractere == ' ') {
                continue;
            } else if (caractere == '0') {
                pilha.push(false);
            } else if (caractere == '1') {
                pilha.push(true);
            } else if (caractere == '&') {
                boolean valor2 = pilha.pop();
                boolean valor1 = pilha.pop();
                pilha.push(valor1 && valor2);
            } else if (caractere == '|') {
                boolean valor2 = pilha.pop();
                boolean valor1 = pilha.pop();
                pilha.push(valor1 || valor2);
            } else if (caractere == '!') {
                boolean valor = pilha.pop();
                pilha.push(!valor);
            } else {
                int indice = caractere - 'a';
                pilha.push(valores[indice]);
            }
        }
        return pilha.pop();
    }
    
}
