package Meu.exercicioGrafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoDeTarefas {

    private Map<String, Tarefa> tarefas;

    public GrafoDeTarefas() {
        this.tarefas = new HashMap<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        this.tarefas.put(tarefa.getNome(), tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {
        this.tarefas.remove(tarefa.getNome());
    }

    public int calcularDuracaoTotal(Tarefa tarefa) {
        return tarefa.getDuracao() + tarefa.getDependencias().stream().mapToInt(this::calcularDuracaoTotal).sum();
    }

    public List<Tarefa> getTarefas() {
        return new ArrayList<>(this.tarefas.values());
    }

}
