import java.util.Scanner;

public class tp0106 {

    //parte principal que usa os metodos e devolve a resposta
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            boolean isVowel = isVowelString(str);
            boolean isConsonant = isConsonantString(str);
            boolean isInteger = isIntegerString(str);
            boolean isDouble = isDoubleString(str);
            System.out.println((isVowel ? "SIM" : "NAO") + " " + (isConsonant ? "SIM" : "NAO") + " " +
                    (isInteger ? "SIM" : "NAO") + " " + (isDouble ? "SIM" : "NAO"));

            sc.close();
        }
    }

// testa se eh vogal
public static boolean isVowelString(String str) {
    str = str.toLowerCase();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
            return false;
        }
    }
    return true;
}
//testa se eh consoante
public static boolean isConsonantString(String str) {
    str = str.toLowerCase();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || !Character.isLetter(c)) {
            return false;
        }
    }
    return true;
}

//testa se eh inteiro
public static boolean isIntegerString(String str) {
    str = str.trim();
    if (str.isEmpty()) {
        return false;
    }
    int i = 0;
    if (str.charAt(0) == '+' || str.charAt(0) == '-') {
        i++;
    }
    for (; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }
    }
    return true;
}

//testa se eh double
public static boolean isDoubleString(String str) {
    str = str.trim();
    if (str.isEmpty()) {
        return false;
    }
    int i = 0;
    if (str.charAt(0) == '+' || str.charAt(0) == '-') {
        i++;
    }
    boolean hasDecimal = false;
    for (; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == '.') {
            if (hasDecimal) {
                return false;
            } else {
                hasDecimal = true;
            }
        } else if (c < '0' || c > '9') {
            return false;
        }
    }
    return true;
    
}}

