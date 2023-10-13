#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct registro {
    char nome[50];
    int idade;
    struct registro *prox;
} Registro;

void inserir(Registro **lista, Registro *novo) {
    if (*lista == NULL) {
        *lista = novo;
    } else {
        Registro *aux = *lista;
        while (aux->prox != NULL) {
            aux = aux->prox;
        }
        aux->prox = novo;
    }
}

int buscar(Registro *lista, char *nome) {
    int comparacoes = 0;
    while (lista != NULL) {
        comparacoes++;
        if (strcmp(lista->nome, nome) == 0) {
            return comparacoes;
        }
        lista = lista->prox;
    }
    return comparacoes;
}

int main() {
    char nome_arquivo[100];
    printf("Digite o nome do arquivo: ");
    scanf("%s", nome_arquivo);

    FILE *arquivo = fopen(nome_arquivo, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir arquivo\n");
        return 1;
    }

    Registro *lista = NULL;
    Registro *novo;
    char nome[50];
    int idade;
    while (fscanf(arquivo, "%s", nome) == 1 && strcmp(nome, "FIM") != 0) {
        fscanf(arquivo, "%d", &idade);
        novo = (Registro*) malloc(sizeof(Registro));
        strcpy(novo->nome, nome);
        novo->idade = idade;
        novo->prox = NULL;
        inserir(&lista, novo);
    }

    clock_t inicio = clock();

    char nome_busca[50];
    while (scanf("%s", nome_busca) == 1 && strcmp(nome_busca, "FIM") != 0) {
        int comparacoes = buscar(lista, nome_busca);
        if (comparacoes == -1) {
            printf("NAO\n");
        } else {
            printf("SIM\n");
        }
    }

    clock_t fim = clock();
    double tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;

    
    system ("pause");
    return 0;
}
