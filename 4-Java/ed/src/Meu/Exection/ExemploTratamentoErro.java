package Meu.Exection;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

public class ExemploTratamentoErro {

    public static void main(String[] args) {

        try{
            int[] numeros = {1,2,3};
            System.out.println(numeros[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro: índice fora dos limites do array!");
            e.printStackTrace();
        }finally {
            System.out.println("Este bloco é sempre executado, mesmo que ocorra erro ou não!");
        }

        try{

            FileReader fr = new FileReader("arquivo.txt");

        }catch (IOException e){
            System.out.println("Erro: Erro ao abrir arquivo!" + e.getMessage());

        }

        //abrirArquivo();

        try{
            String texto = null;
            System.out.println(texto.length());
        }catch (NullPointerException e){
            System.out.println("Erro: Tentativa de acessar um método em um objeto nulo!");
        }

    }

    /*public static void abrirArquivo() throws FileSystemNotFoundException {
        FileReader fr = new FileReader("arquivo.txt");
    }**/
}
