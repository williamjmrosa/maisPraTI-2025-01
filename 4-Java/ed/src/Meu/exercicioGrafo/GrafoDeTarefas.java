package Meu.exercicioGrafo;

import java.util.*;

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

    public int calcularDuracaoTotal(String nome) throws TarefaNaoEncontradaException, DependenciaCircularExeption {
        Tarefa tarefa = this.tarefas.get(nome);
        if(tarefa == null){
            throw new TarefaNaoEncontradaException("Tarefa não encontrada: " + nome);
        }

        Set<Tarefa> visitados = new HashSet<>();
        return calcularDuracaoTotalRecursiva(tarefa, visitados);
    }

    private int calcularDuracaoTotalRecursiva(Tarefa tarefa, Set<Tarefa> visitadas) {
        if(visitadas.contains(tarefa)) {
            throw new DependenciaCircularExeption("Dependência circular: " + tarefa.getNome());
        }

        visitadas.add(tarefa);

        int duracaoTotal = tarefa.getDuracao();

        for(Tarefa dependencia : tarefa.getDependencias()) {
            duracaoTotal += calcularDuracaoTotalRecursiva(dependencia, visitadas);
        }

        visitadas.remove(tarefa);

        return duracaoTotal;
    }

    public List<Tarefa> listarTarefasComDuracaoMaiorQue(int duracaoMinima) {
        return this.tarefas
                .values()
                .stream()
                .filter(t-> t.getDuracao() < duracaoMinima)
                .toList();
    }

    public void addDependencia(String nome, Tarefa dependencia) {
        Tarefa tarefa = this.tarefas.get(nome);
    }

}
