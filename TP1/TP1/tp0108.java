import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class tp0108 {

    //parte principal que utiliza metodos desenvolvidos abaixo
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String endereco;
        while (!(endereco = scanner.nextLine()).equals("FIM")) {
            URL url = new URL(endereco);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(url.openStream()));
            String linha;
            int numVogaisComAcento = 0, numVogaisSemAcento = 0, numConsoantes = 0, numBr = 0, numTable = 0;
            while ((linha = leitor.readLine()) != null) {
                for (int i = 0; i < linha.length(); i++) {
                    char c = linha.charAt(i);
                    if (isVogalComAcento(c)) {
                        numVogaisComAcento++;
                    } else if (isVogalSemAcento(c)) {
                        numVogaisSemAcento++;
                    } else if (isConsoante(c)) {
                        numConsoantes++;
                    }
                }
            }
            String nomePagina = scanner.nextLine();
            System.out.printf("a(%d) e(%d) i(%d) o(%d) u(%d) á(%d) é(%d) í(%d) ó(%d) ú(%d) à(%d) è(%d) ì(%d) ò(%d) ù(%d) ã(%d) õ(%d) â(%d) ê(%d) î(%d) ô(%d) û(%d) consoante(%d) <br>(%d) <table>(%d) %s\n",
                numVogaisComAcento, numVogaisSemAcento, 0, 0, 0,
                numVogaisComAcento, numVogaisSemAcento, 0, 0, 0,
                numVogaisComAcento, numVogaisSemAcento, 0, 0, 0,
                numVogaisComAcento, numVogaisSemAcento, 0, 0, 0,
                numVogaisComAcento, numVogaisSemAcento, numConsoantes, numBr, numTable, nomePagina);
        }

        scanner.close();
    }

    //vogal com acento
    public static boolean isVogalComAcento(char c) {
        return "AEIOUÀÁÂÃÈÉÊÌÍÎÒÓÔÕÙÚÛaeiouàáâãèéêìíîòóôõùúû".indexOf(c) != -1;
    }
     //vogal sem acento
    public static boolean isVogalSemAcento(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
    //consoante
    public static boolean isConsoante(char c) {
        return Character.isLetter(c) && !isVogalComAcento(c);
    }}