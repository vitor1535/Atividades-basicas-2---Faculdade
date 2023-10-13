
import java.util.Scanner;

public class zQ05 {
    private int topo;
    private int capacidade;
    private Registro[] dados;

    public zQ05(int tamanho) {
        topo = -1;
        capacidade = tamanho;
        dados = new Registro[capacidade];
    }

    public boolean vazia() {
        return (topo == -1);
    }

    public boolean cheia() {
        return (topo == capacidade - 1);
    }

    public void empilhar(Registro registro) {
        if (cheia()) {
            System.out.println("ERRO: pilha cheia!");
            return;
        }
        topo++;
        dados[topo] = registro;
    }

    public Registro desempilhar() {
        if (vazia()) {
            System.out.println("ERRO: pilha vazia!");
            return null;
        }
        Registro aux = dados[topo];
        topo--;
        return aux;
    }

    public void mostrarElementos() {
        if (vazia()) {
            System.out.println("Pilha vazia!");
            return;
        }
        System.out.println("Elementos da pilha:");
        for (int i = topo; i >= 0; i--) {
            System.out.println(dados[i].getNome());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String linha;
        zQ05 pilha = new zQ05(100);

        // Leitura da primeira parte da entrada
        do {
            linha = scanner.nextLine();
            // Faz a leitura dos arquivos, se necessário
        } while (!linha.equals("FIM"));

        // Leitura da segunda parte da entrada
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            linha = scanner.nextLine();
            String[] comando = linha.split(" ");
            switch (comando[0]) {
                case "I":
                    // Inserir na pilha
                    String nomeArquivo = comando[1];
                    Registro registro = new Registro(nomeArquivo);
                    pilha.empilhar(registro);
                    break;
                case "R":
                    // Remover da pilha
                    Registro removido = pilha.desempilhar();
                    if (removido != null) {
                        System.out.println("(R) " + removido.getNome());
                    }
                    break;
                default:
                    System.out.println("Comando inválido!");
                    break;
            }
        }

        // Exibe os elementos da pilha
        pilha.mostrarElementos();
    }
}

class Registro {
    private String nome;

    public Registro(String nomeArquivo) {
        // Lógica para ler arquivo e obter o nome
        nome = "nome do registro";
    }

    public String getNome() {
        return nome;
    }
}