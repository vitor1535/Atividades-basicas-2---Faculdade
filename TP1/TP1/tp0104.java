
import java.util.Random;

public class tp0104 {

    //substitui a letra
    public static String substituirLetra(String string) {
        Random random = new Random();
        char letra1 = (char) (random.nextInt(26) + 'a');
        char letra2 = (char) (random.nextInt(26) + 'a');
        while (letra1 == letra2) {
            letra2 = (char) (random.nextInt(26) + 'a');
        }

        //retorna a string com a letra substituida
        return string.replace(letra1, letra2);
    }

    //parte principal onde pega input do usuario e testa
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (scanner.hasNextLine()) {
            String entrada = scanner.nextLine();
            String saida = substituirLetra(entrada);
            System.out.println(saida);

            scanner.close();
        }
    }
}