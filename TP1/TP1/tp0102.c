#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "string.h"
#include "stdbool.h"


int main()
{
    int method (char palavra[100]);

    char palavra[100];

    //testa se a string corresponde a "FIM"
    while (!(palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M'))
    {
    printf("Digite uma palavra \n");
    gets(palavra);
    method (palavra);
    }

    system ("pause");
    return 0;
}


//metodo para testar se a palavra eh palindromo
int method (char palavra[100])
{

    int i = 0;
    int n;
    int cont = 0;
    int aux = 1;
    bool resultado;

    for (i = 0;i < strlen(palavra); i++)
    {
    if (palavra[i] == palavra[strlen(palavra) - aux])
    {
        cont++;
        aux++;
    }
    else
    {
        aux++;
    }
    }

    //se houver todas as letras espelhadas, retorna 0
    if (cont == strlen(palavra))
    {
    printf("SIM \n");
    resultado = true;
    }
    else
    {
    printf("NAO \n");
    resultado = false;
    }

    if (resultado == true)
    return 0;
    else
    return 1;

}