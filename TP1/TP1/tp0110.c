#include <stdio.h>

int main() {
    int n;
    float valor;
    FILE *arquivo;

    // Abre o arquivo para escrita
    arquivo = fopen("valores.txt", "w");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo\n");
        return 1;
    }

    // Lê o número de valores a serem lidos
    printf("Digite a quantidade de valores a serem lidos: ");
    scanf("%d", &n);

    // Lê os valores e os escreve no arquivo
    for (int i = 0; i < n; i++) {
        printf("Digite o valor %d: ", i+1);
        scanf("%f", &valor);
        fprintf(arquivo, "%.2f\n", valor);
    }

    // Fecha o arquivo
    fclose(arquivo);

    // Reabre o arquivo para leitura
    arquivo = fopen("valores.txt", "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo\n");
        return 1;
    }

    // Move o cursor para o final do arquivo
    fseek(arquivo, 0, SEEK_END);

    // Lê os valores de trás para frente e os mostra na tela
    for (int i = n; i > 0; i--) {
        // Move o cursor para o começo do valor anterior
        fseek(arquivo, -sizeof(float)-1, SEEK_CUR);

        // Lê o valor e mostra na tela
        fread(&valor, sizeof(float), 1, arquivo);
        printf("%.2f\n", valor);
    }

    // Fecha o arquivo
    fclose(arquivo);

    return 0;
}
