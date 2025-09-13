package Meu.exercicioGrafo;

public class GerenciadorDeTarefas {

    private GrafoDeTarefas grafo;

    public GerenciadorDeTarefas() {
        this.grafo = new GrafoDeTarefas();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        this.grafo.adicionarTarefa(tarefa);


    }
}
