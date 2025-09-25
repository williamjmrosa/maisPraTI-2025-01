package com.t1.springbasics.MEU.mvcbasics.services;

import com.t1.springbasics.MEU.mvcbasics.model.Tarefa;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class TarefaService {

    private final Map<Long, Tarefa> tarefas = new LinkedHashMap<>();

    private final AtomicLong idSequence = new AtomicLong();

    public List<Tarefa> listarTarefas(){
        return new ArrayList<>(banco.values());
    }

    public Tarefa criar(String titulo){
        long id = idSequence.incrementAndGet();
        Tarefa t = new Tarefa(id, titulo, false, );
        banco.put(id, t);
        return t;
    }

    public Optional<Tarefa> buscar(Long id){
        return Optional.ofNullable(banco.get(id));
    }

    public Optional<Tarefa> marcarConcluida(Long id){
        Tarefa t = banco.get(id);
        if(t != null){
            t.setConcluida(true);
        }
        return Optional.ofNullable(t);
    }
}
