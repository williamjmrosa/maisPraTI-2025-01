//package com.t1.springbasics.MEU.mvcbasics.controller;
//
//import com.t1.springbasics.MEU.mvcbasics.model.Tarefa;
//import com.t1.springbasics.MEU.mvcbasics.services.TarefaService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//@RequestMapping("/tarefas")
//public class TarefaController {
//
//    private final TarefaService service;
//
//    public TarefaController(TarefaService tarefaService) {
//        this.service = tarefaService;
//    }
//
//    @GetMapping
//    public List<Tarefa> listarTarefas() {
//        return service.listarTarefas();
//    }
//
//    @PostMapping
//    public ResponseEntity<Tarefa> criar (@RequestBody Tarefa novaTarefa){
//        Tarefa criada = service.criar(novaTarefa.getTitulo());
//        return ResponseEntity.created(URI.create("/api/tarefas/" + criada.getId())).body(criada);
//    }
//}
