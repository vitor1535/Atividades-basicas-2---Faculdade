#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//testa se eh vogal
int somenteVogais(char *str) {
    for (int i = 0; i < strlen(str); i++) {
        if (!isalpha(str[i])) {
            return 0;
        }
        if (str[i] != 'a' && str[i] != 'e' && str[i] != 'i' && str[i] != 'o' && str[i] != 'u' &&
            str[i] != 'A' && str[i] != 'E' && str[i] != 'I' && str[i] != 'O' && str[i] != 'U') {
            return 0;
        }
    }
    return 1;
}
 //testa se eh consoante
int somenteConsoantes(char *str) {
    for (int i = 0; i < strlen(str); i++) {
        if (!isalpha(str[i])) {
            return 0;
        }
        if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u' ||
            str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O' || str[i] == 'U') {
            return 0;
        }
    }
    return 1;
}
 //testa se eh inteiro
int numeroInteiro(char *str) {
    for (int i = 0; i < strlen(str); i++) {
        if (!isdigit(str[i]) && !(i == 0 && (str[i] == '+' || str[i] == '-'))) {
            return 0;
        }
    }
    return 1;
}

//testa se eh real
int numeroReal(char *str) {
    int ponto = 0;
    for (int i = 0; i < strlen(str); i++) {
        if (!isdigit(str[i]) && !(i == 0 && (str[i] == '+' || str[i] == '-')) && str[i] != '.') {
            return 0;
        }
        if (str[i] == '.') {
            ponto++;
        }
    }
    if (ponto != 1) {
        return 0;
    }
    return 1;
}
 //parte principal que usa os metodos acima e devolve resposta sim/nao
int main() {
    char entrada[100];
    while (fgets(entrada, 100, stdin) != NULL) {
        entrada[strcspn(entrada, "\r\n")] = '\0'; 
        printf("%s %s %s %s\n", somenteVogais(entrada) ? "SIM" : "NÃO",
                               somenteConsoantes(entrada) ? "SIM" : "NÃO",
                               numeroInteiro(entrada) ? "SIM" : "NÃO",
                               numeroReal(entrada) ? "SIM" : "NÃO");
    }
    return 0;
}