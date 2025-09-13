package Meu;

import java.util.*;

public class Graph<T> {

    private final boolean directed;
    //Mapa que armazena os vértices e seus vizinhos Adjacência
    private final Map<T, Set<T>> adj = new HashMap<>();

    Graph(boolean directed){
        this.directed = directed;
    }

    /**
     * Adiciona um vértice ao grafo
     * @param v vértice a ser adicionado
     */
    public void addVertex(T v){
        adj.putIfAbsent(v, new LinkedHashSet<>());
    }

    /**
     * Adiciona uma aresta ao grafo
     * @param v vértice de origem
     * @param u vértice de destino
     */
    public void addEdge(T v, T u){
        addVertex(u);
        addVertex(v);
        adj.get(v).add(u);
        if(!directed) adj.get(u).add(v);

    }

    /**
     * Retorna os vizinhos de um vértice
     * @param v vértice
     * @return conjunto de vizinhos
     */
    public Set<T> getNeighbors(T v){
        return adj.getOrDefault(v, Set.of());
    }

    /**
     * Retorna o caminho mais curto entre dois vértices
     * @param start vértice de origem
     * @param goal vértice de destino
     * @return lista de vértices que formam o caminho mais curto
     */
    public List<T> bfsShortesPath(T start, T goal) {
        Map<T, T> prev = new HashMap<>();
        Set<T> visited = new HashSet<>();
        Deque<T> queue = new ArrayDeque<>();

        visited.add(start);
        queue.add(start);

        while(!queue.isEmpty()) {
            T current = queue.removeFirst();
            if(current.equals(goal)) break;
            for(T nb : getNeighbors(current)){
                if(visited.add(nb)){
                    prev.put(nb, current);
                    queue.addLast(nb);
                }
            }
        }

        if(!start.equals(goal) && !prev.containsKey(goal)){
            return List.of();
        }

        List<T> path = new ArrayList<>();
        for(T at = goal; at != null; at = prev.get(at)){
            path.add(at);
            if(at.equals(start)) break;
        }

        Collections.reverse(path);

        return path;
    }

    @Override public String toString(){ return adj.toString(); }

    public static void main(String[] args) {
        Graph<String> g = new Graph<>(false);
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "E");
        g.addEdge("D", "F");
        g.addEdge("E", "F");

    System.out.println("Grafo: " + g);
    System.out.println("Caminho minimo de A -> F: " + g.bfsShortesPath("A", "F"));
    }
}
