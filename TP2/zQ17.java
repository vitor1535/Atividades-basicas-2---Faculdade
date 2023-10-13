/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Vitor
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Lista {
    private List<Personagem> personagens;

    public Lista() {
        this.personagens = new ArrayList<>();
    }

    public void add(Personagem personagem) {
        this.personagens.add(personagem);
    }

    public void ordenarPorHomeWorld() {
        mergeSort(0, this.personagens.size() - 1);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, meio, fim);
        }
    }

    private void merge(int inicio, int meio, int fim) {
        List<Personagem> auxiliar = new ArrayList<>();
        for (int i = inicio; i <= fim; i++) {
            auxiliar.add(this.personagens.get(i));
        }
        int i = 0, j = meio - inicio + 1, k = inicio;
        while (i <= meio - inicio && j < auxiliar.size()) {
            if (auxiliar.get(i).getHomeWorld().compareTo(auxiliar.get(j).getHomeWorld()) <= 0) {
                this.personagens.set(k++, auxiliar.get(i++));
            } else {
                this.personagens.set(k++, auxiliar.get(j++));
            }
        }
        while (i <= meio - inicio) {
            this.personagens.set(k++, auxiliar.get(i++));
        }
        while (j < auxiliar.size()) {
            this.personagens.set(k++, auxiliar.get(j++));
        }
    }

    public List<Personagem> getPersonagens() {
        return this.personagens;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = scanner.nextLine();
        Lista lista = new Lista();

        while (!nomeArquivo.equals("FIM")) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
                String linha = br.readLine();

                while (linha != null) {
                    String[] dados = linha.split(";");
                    Personagem personagem = new Personagem(
                            dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]),
                            Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), dados[6], dados[7], dados[8]
                    );
                    lista.add(personagem);
                    linha = br.readLine();
                }

                br.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + nomeArquivo);
                e.printStackTrace();
            }

            nomeArquivo = scanner.nextLine();
        }

        lista.ordenarPorHomeWorld();

        for (Personagem personagem : lista.getPersonagens()) {
            System.out.println(personagem.getNome() + " " + personagem.getHomeWorld());
        }
    }
}
