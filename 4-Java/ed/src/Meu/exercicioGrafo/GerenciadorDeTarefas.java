package Meu.exercicioGrafo;

public class GerenciadorDeTarefas {


    public static void main(String[] args) {
        Tarefa tarefa1 = new Tarefa("Resolver os problemas nos circuitos de tentáculo do Dr. Octavio",1);
        Tarefa tarefa2 = new Tarefa("Dar água pro peixe",2);
        Tarefa tarefa3 = new Tarefa("Encher a praia de terra",3);
        Tarefa tarefa4 = new Tarefa("Resolver os exercícios de Desenvolvimento",10);

        GrafoDeTarefas grafo = new GrafoDeTarefas();
        grafo.adicionarTarefa(tarefa1);
        grafo.adicionarTarefa(tarefa2);
        grafo.adicionarTarefa(tarefa3);


        int duracaoTotal = grafo.calcularDuracaoTotal("Resolver os problemas nos circuitos de tentáculo do Dr. Octavio");
    }

    private GrafoDeTarefas grafo;

    public GerenciadorDeTarefas() {
        this.grafo = new GrafoDeTarefas();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        this.grafo.adicionarTarefa(tarefa);
    }
}
