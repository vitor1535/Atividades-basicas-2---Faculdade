

public static boolean resolverExpressao(String entrada) {
    int tamanho = entrada.length();
    int i = 0;
    char c = entrada.charAt(i);
    if (c == '(') {
        int j = encontrarPosicaoFechamento(entrada, i);
        if (j == tamanho - 1) {
            return resolverExpressao(entrada.substring(i + 1, j));
        } else {
            char operador = entrada.charAt(j + 1);
            if (operador == ' ') {
                return resolverOperacao(entrada.substring(i + 1, j), entrada.charAt(j + 2), resolverExpressao(entrada.substring(j + 3)));
            } else {
                return resolverOperacao(entrada.substring(i + 1, j), operador, resolverExpressao(entrada.substring(j + 2)));
            }
        }
    } else {
        return Boolean.parseBoolean(String.valueOf(c));
    }
}

public static int encontrarPosicaoFechamento(String entrada, int i) {
    int tamanho = entrada.length();
    int contador = 1;
    int j = i + 1;
    while (j < tamanho && contador > 0) {
        char c = entrada.charAt(j);
        if (c == '(') {
            contador++;
        } else if (c == ')') {
            contador--;
        }
        j++;
    }
    return j - 1;
}

public static boolean resolverOperacao(String op1, char operador, boolean op2) {
    boolean valorOp1 = resolverExpressao(op1);
    if (operador == '&') {
        return valorOp1 && op2;
    } else if (operador == '|') {
        return valorOp1 || op2;
    } else if (operador == '!') {
        return !valorOp1;
    } else {
        return false;
    }
}

public static void tp0114(String[] args) {
    String entrada1 = "3 1 0 1 ((1 | 0) & !0)";
    String entrada2 = "2 1 0 ((1 & 0) | (0 & 1))";
    String entrada3 = "1 1 (1)";

    boolean resultado1 = resolverExpressao(entrada1);
    boolean resultado2 = resolverExpressao(entrada2);
    boolean resultado3 = resolverExpressao(entrada3);

    System.out.println(resultado1 ? "SIM" : "NAO");
    System.out.println(resultado2 ? "SIM" : "NAO");
    System.out.println(resultado3 ? "SIM" : "NAO");
}


