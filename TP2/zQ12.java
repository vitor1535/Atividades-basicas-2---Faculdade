import java.util.Scanner;

class Pessoa {
    String nome;
    int anoNascimento;
    float peso;

    Pessoa(String nome, int anoNascimento, float peso) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.peso = peso;
    }

    public String toString() {
        return nome + " " + anoNascimento + " " + peso;
    }
}

class Lista {
    private Pessoa[] pessoas;
    private int n;

    Lista(int tamanho) {
        pessoas = new Pessoa[tamanho];
        n = 0;
    }

    public void inserir(Pessoa pessoa) {
        pessoas[n] = pessoa;
        n++;
    }

    public void shellsort() {
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && pessoas[j].peso < pessoas[j - h].peso; j -= h) {
                    Pessoa temp = pessoas[j];
                    pessoas[j] = pessoas[j - h];
                    pessoas[j - h] = temp;
                }
            }
            h = h / 3;
        }
    }

    public void imprimir() {
        for (int i = 0; i < n; i++) {
            System.out.println(pessoas[i]);
        }
    }
}

public class zQ12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nomeArquivo = "";
        Lista lista = new Lista(100);

        while (!nomeArquivo.equals("FIM")) {
            nomeArquivo = sc.nextLine();
            if (!nomeArquivo.equals("FIM")) {
                // ler arquivo e adicionar pessoas na lista
                // suponha que o arquivo contém uma pessoa por linha, com nome, ano de nascimento e peso separados por espaço
                String[] dadosPessoa = nomeArquivo.split(" ");
                Pessoa pessoa = new Pessoa(dadosPessoa[0], Integer.parseInt(dadosPessoa[1]), Float.parseFloat(dadosPessoa[2]));
                lista.inserir(pessoa);
            }
        }

        lista.shellsort();
        lista.imprimir();
    }
}
