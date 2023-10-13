#include <stdio.h>
#include <ctype.h> // Biblioteca usada para verificar se um caractere é uma letra

int eh_palindromo(char str[], int inicio, int fim) {
    if (inicio >= fim) { // Se a análise já percorreu toda a string
        return 1; // Retorna verdadeiro, pois todos os caracteres foram iguais
    }
    if (!isalpha(str[inicio])) { // Se o caractere inicial não for uma letra
        return eh_palindromo(str, inicio+1, fim); // Ignora esse caractere e analisa o próximo
    }
    if (!isalpha(str[fim])) { // Se o caractere final não for uma letra
        return eh_palindromo(str, inicio, fim-1); // Ignora esse caractere e analisa o anterior
    }
    if (tolower(str[inicio]) != tolower(str[fim])) { // Se os caracteres comparados forem diferentes
        return 0; // Retorna falso, pois a string não é um palíndromo
    }
    // Se chegou até aqui, continua a análise recursivamente com os próximos caracteres
    return eh_palindromo(str, inicio+1, fim-1);
}

int main() {
    char str[1000]; // Vetor que irá armazenar a string a ser analisada

    do {
        fgets(str, 1000, stdin); // Lê uma linha da entrada padrão
        if (str[0] != 'F' && str[1] != 'I' && str[2] != 'M') { // Se a linha lida não for "FIM"
            int tamanho = strlen(str)-1; // Calcula o tamanho da string lida (desconsiderando o caractere de quebra de linha)
            if (eh_palindromo(str, 0, tamanho-1)) { // Verifica se a string é um palíndromo
                printf("SIM\n"); // Se for um palíndromo, imprime "SIM"
            } else {
                printf("NAO\n"); // Se não for um palíndromo, imprime "NAO"
            }
        }
    } while (str[0] != 'F' && str[1] != 'I' && str[2] != 'M'); // Continua lendo novas linhas até encontrar "FIM"
    
    return 0; // Retorna 0 para indicar que a execução foi bem-sucedida
}