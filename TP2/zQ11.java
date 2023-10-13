

import java.util.Scanner;

public class zQ11 {

    private static class Pessoa {
        String nome;
        int anoNascimento;

        Pessoa(String nome, int anoNascimento) {
            this.nome = nome;
            this.anoNascimento = anoNascimento;
        }

        @Override
        public String toString() {
            return nome + " " + anoNascimento;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[1000];
        int n = 0;

        // Lê os dados da entrada padrão
        String nomeArquivo = sc.nextLine();
        while (!nomeArquivo.equals("FIM")) {
            int anoNascimento = sc.nextInt();
            sc.nextLine();
            pessoas[n++] = new Pessoa(nomeArquivo, anoNascimento);
            nomeArquivo = sc.nextLine();
        }

        // Ordena o array de pessoas por ano de nascimento usando o algoritmo de inserção
        for (int i = 1; i < n; i++) {
            Pessoa p = pessoas[i];
            int j = i - 1;
            while (j >= 0 && pessoas[j].anoNascimento > p.anoNascimento) {
                pessoas[j + 1] = pessoas[j];
                j--;
            }
            pessoas[j + 1] = p;
        }

        // Imprime o array de pessoas ordenado
        for (int i = 0; i < n; i++) {
            System.out.println(pessoas[i]);
        }
    }
}

