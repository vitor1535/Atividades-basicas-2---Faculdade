

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Lista {
    private String[] nomes;

    //Lista que recebe os nomes
    public Lista(String[] nomes) {
        this.nomes = nomes;
    }

    //metodo que ordena por seleçao
    public void ordenaSelecao() {
        int n = nomes.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (nomes[j].compareTo(nomes[min_idx]) < 0) {
                    min_idx = j;
                }
            }
            String temp = nomes[min_idx];
            nomes[min_idx] = nomes[i];
            nomes[i] = temp;
        }
    }

    //metodo para imprimir na tela
    public void imprimeLista() {
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}

//Onde esta o metodo main para aplicar os metodos
public class zQ09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomes = new String[1000];
        int n = 0;

        while (true) {
            String arquivo = sc.nextLine();
            if (arquivo.equals("FIM")) {
                break;
            }

            try {
                File file = new File(arquivo);
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    nomes[n] = reader.nextLine();
                    n++;
                }
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado: " + arquivo);
            }
        }

        Lista lista = new Lista(nomes);
        lista.ordenaSelecao();
        lista.imprimeLista();
    }
}
