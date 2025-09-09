package MEU.AulaColection;

import java.util.*;

public class ExemploCollections {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("Java");
        lista.add("Python");
        lista.add("C");
        lista.add("PHP");
        lista.add("Java");
        System.out.println("Lista: " + lista);

        Set<String> conjunto = new HashSet<>();
        conjunto.add("Java");
        conjunto.add("Python");
        conjunto.add("C");
        conjunto.add("PHP");
        conjunto.add("Java");
        System.out.println("Conjunto: " + conjunto);

        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Java", 1);
        mapa.put("Python", 2);
        mapa.put("C", 3);
        System.out.println("Mapa: " + mapa);

        Queue<String> queue = new LinkedList<>();
        queue.add("Primeiro");
        queue.add("Segundo");
        queue.add("Terceiro");
        System.out.println("Queue: " + queue);

        Collection<String> colecao = new ArrayList<>();
        colecao.add("A");
        colecao.add("B");
        colecao.add("C");
        System.out.println("Colecao: " + colecao);

        System.out.println(colecao.contains("A"));
        System.out.println(colecao.size());

        List<String> listExemplo = new ArrayList<>();
        listExemplo.add("Java");
        listExemplo.add("Python");
        listExemplo.add("C");
        System.out.println(listExemplo.get(0));

        listExemplo.remove(1);

        System.out.println(listExemplo);

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int somaQuadradosPares = numeros.stream().filter(n -> n % 2 == 0).map(n -> n * n).reduce(0, Integer::sum);
        System.out.println(somaQuadradosPares);

        String[] nomes = {"Jicilei", "Gertrudes", "João"};
        for (String nome : nomes) {
            System.out.println(nome);
        }

    }



}
