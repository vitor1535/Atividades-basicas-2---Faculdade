import java.util.Scanner;

public class tp0115 {
    
    // Método recursivo para verificar se a string é composta somente por vogais
    public static boolean apenasVogaisRecursivo(String s) {
        if(s.length() == 1) {
            return ehVogal(s.charAt(0));
        } else {
            return ehVogal(s.charAt(0)) && apenasVogaisRecursivo(s.substring(1));
        }
    }
    
    // Método iterativo para verificar se a string é composta somente por consoantes
    public static boolean apenasConsoantesIterativo(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(ehVogal(s.charAt(i)) || !Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    // Método iterativo para verificar se a string corresponde a um número inteiro
    public static boolean numeroInteiroIterativo(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    // Método iterativo para verificar se a string corresponde a um número real
    public static boolean numeroRealIterativo(String s) {
        boolean pontoEncontrado = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!Character.isDigit(c)) {
                if(c == '.' && !pontoEncontrado) {
                    pontoEncontrado = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    // Método auxiliar para verificar se um caractere é vogal
    private static boolean ehVogal(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        boolean vogais, consoantes, inteiro, real;
        while(true) {
            s = sc.nextLine();
            if(s.equals("FIM")) break;
            
            vogais = apenasVogaisRecursivo(s);
            consoantes = apenasConsoantesIterativo(s);
            inteiro = numeroInteiroIterativo(s);
            real = numeroRealIterativo(s);
            
            System.out.println((vogais ? "SIM" : "NAO") + " "
                             + (consoantes ? "SIM" : "NAO") + " "
                             + (inteiro ? "SIM" : "NAO") + " "
                             + (real ? "SIM" : "NAO"));
        }
        sc.close();
    }
}
