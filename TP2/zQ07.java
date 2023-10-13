

import java.util.Scanner;
import java.io.*;
import java.time.Duration;
import java.time.Instant;

class Registro {
    String nome;
    int idade;
    String endereco;
}

class Lista {
    public Registro[] registros;
    public int tamanho;

    public Lista(int capacidade) {
        registros = new Registro[capacidade];
        tamanho = 0;
    }

    public boolean insere(Registro registro) {
        if (tamanho == registros.length) {
            return false;
        }
        registros[tamanho] = registro;
        tamanho++;
        return true;
    }

    public boolean pesquisa(String chave) {
        for (int i = 0; i < tamanho; i++) {
            if (registros[i].nome.equals(chave)) {
                return true;
            }
        }
        return false;
    }
}

public class zQ07 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Parte 1 - leitura dos registros do arquivo
        Lista lista = new Lista(1000); // ajuste o tamanho da lista conforme necessário
        String nomeArquivo;
        System.out.println("Digite o nome do arquivo (ou FIM para finalizar a leitura):");
        nomeArquivo = scanner.nextLine();
        while (!nomeArquivo.equals("FIM")) {
            try (Scanner scannerArquivo = new Scanner(new File(nomeArquivo))) {
                while (scannerArquivo.hasNextLine()) {
                    Registro registro = new Registro();
                    registro.nome = scannerArquivo.nextLine();
                    registro.idade = Integer.parseInt(scannerArquivo.nextLine());
                    registro.endereco = scannerArquivo.nextLine();
                    lista.insere(registro);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado: " + nomeArquivo);
            }
            nomeArquivo = scanner.nextLine();
        }

        // Parte 2 - pesquisa na lista
        String chave;
        System.out.println("Digite o elemento a ser pesquisado (ou FIM para finalizar a pesquisa):");
        chave = scanner.nextLine();
        int numComparacoes = 0;
        while (!chave.equals("FIM")) {
            Instant inicio = Instant.now();
            boolean resultado = lista.pesquisa(chave);
            Instant fim = Instant.now();
            Duration duracao = Duration.between(inicio, fim);
            numComparacoes += lista.tamanho;
            System.out.println(resultado ? "SIM" : "NAO" + "\t" + duracao.toMillis() + "\t" + lista.tamanho);
            chave = scanner.nextLine();
        }

        
        
    }
}

