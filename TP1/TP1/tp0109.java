import java.io.*;

public class tp0109 {

    //parte principal que le "n" numeros reais e salva em arquivo
    public static void main(String[] args) {
        try {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());

            
            RandomAccessFile file = new RandomAccessFile("numeros.txt", "rw");

           
            for (int i = 0; i < n; i++) {
                double num = Double.parseDouble(reader.readLine());
                file.writeDouble(num);
            }

            //fecha arquivo
            file.close();

            
            file = new RandomAccessFile("numeros.txt", "r");

            long pos = file.length();
            while (pos > 0) {
                pos -= 8;
                file.seek(pos);
                double num = file.readDouble();
                System.out.println(num);
            }

            //fecha arquivo
            file.close();

            //mostra erro ao usuario
        } catch (IOException e) {
            System.out.println("Erro ao ler/escrever o arquivo");
        } catch (NumberFormatException e) {
            System.out.println("Número inválido");
        }
    }
}
