
import java.util.Scanner;

class Lista {
    
    private int n;
    private Personagem[] personagens;
    
    // construtor
    public Lista() {
        this.n = 0;
        this.personagens = new Personagem[1000];
    }
    
    // método para inserir um personagem no final da lista
    public void inserirFim(Personagem p) {
        if (this.n < this.personagens.length) {
            this.personagens[this.n] = p;
            this.n++;
        }
    }
    
    // método para exibir a lista de personagens
    public void mostrar() {
        for (int i = 0; i < this.n; i++) {
            this.personagens[i].imprimir();
        }
    }
    
    // método para trocar a posição de dois elementos no vetor de personagens
    public void trocar(int i, int j) {
        Personagem temp = this.personagens[i];
        this.personagens[i] = this.personagens[j];
        this.personagens[j] = temp;
    }
    
    // método para encontrar o pivô do quicksort
    public int encontrarPivo(int inicio, int fim) {
        Personagem pivo = this.personagens[inicio];
        int i = inicio + 1;
        int j = fim;
        
        while (i <= j) {
            if (this.personagens[i].getCorDoCabelo().compareTo(pivo.getCorDoCabelo()) <= 0) {
                i++;
            } else if (this.personagens[j].getCorDoCabelo().compareTo(pivo.getCorDoCabelo()) > 0) {
                j--;
            } else if (i <= j) {
                this.trocar(i, j);
                i++;
                j--;
            }
        }
        
        this.trocar(inicio, j);
        return j;
    }
    
    // método recursivo do quicksort
    public void quicksort(int inicio, int fim) {
        if (inicio < fim) {
            int pivo = this.encontrarPivo(inicio, fim);
            this.quicksort(inicio, pivo - 1);
            this.quicksort(pivo + 1, fim);
        }
    }
    
    // método main para testar a implementação
    public static void main(String[] args) {
        Lista lista = new Lista();
        Scanner scanner = new Scanner(System.in);
        
        String nomeArquivo;
        nomeArquivo = scanner.nextLine();
        while (!nomeArquivo.equals("FIM")) {
            Personagem personagem = new Personagem();
            personagem.ler(nomeArquivo);
            lista.inserirFim(personagem);
            nomeArquivo = scanner.nextLine();
        }
        
        lista.quicksort(0, lista.n - 1);
        lista.mostrar();
    }
}
