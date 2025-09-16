package MEU;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TrabalhandoComArquivos {

    public static void main(String[] args) {
        Path arquivo = Paths.get("arquivo.txt");

//        try{
//            if(!Files.exists(arquivo)){
//                Files.createFile(arquivo);
//            }
//
//            String conteudo = "Conteudo do arquivo";
//            Files.write(arquivo, conteudo.getBytes());
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        Path diretorio = Paths.get("diretorioExemplo");
//
//        try{
//            Files.list(diretorio).forEach(path -> {
//                System.out.println(path);
//            });
//        }catch (IOException e){
//            e.printStackTrace();
//        }


//        try {
//            Path origem = Paths.get("arquivo.txt");
//            Path destino = Paths.get("mudeiNome.txt");
//
//            Files.move(origem,destino);
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        Path path = Paths.get("mudeiNome.txt");

        try {
            BufferedReader br = Files.newBufferedReader(path);
            BufferedWriter bw = Files.newBufferedWriter(path);

            String linha = br.readLine();
            while(linha != null){
                System.out.println(linha);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
