/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vitor
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Pessoa {
    private String nome;
    private int anoNascimento;

    public Pessoa(String nome, int anoNascimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }
}

class Lista {
    private Pessoa[] pessoas;
    private int tamanho;

    public Lista(int capacidade) {
        pessoas = new Pessoa[capacidade];
        tamanho = 0;
    }

    public void adiciona(Pessoa pessoa) {
        if (tamanho < pessoas.length) {
            pessoas[tamanho] = pessoa;
            tamanho++;
        }
    }

    public void ordenaBolha() {
        for (int i = tamanho - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (pessoas[j].getAnoNascimento() > pessoas[j + 1].getAnoNascimento()) {
                    Pessoa temp = pessoas[j];
                    pessoas[j] = pessoas[j + 1];
                    pessoas[j + 1] = temp;
                }
            }
        }
    }

    public void imprime() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(pessoas[i].getNome() + " " + pessoas[i].getAnoNascimento());
        }
    }
}

public class zQ16 {
    public static void main(String[] args) throws FileNotFoundException {
        Lista lista = new Lista(100);

        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();

        while (!entrada.equals("FIM")) {
            File arquivo = new File(entrada);
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String[] dados = leitor.nextLine().split(",");
                Pessoa pessoa = new Pessoa(dados[0], Integer.parseInt(dados[1]));
                lista.adiciona(pessoa);
            }

            entrada = sc.nextLine();
        }

        lista.ordenaBolha();
        lista.imprime();
    }
}
