package com.t1.api_example.course;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Course>> findAll(){
        List<Course> lista = courseRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

//    @GetMapping("/buscar/{id}")
//    public ResponseEntity<Course> findById(@PathVariable Long id){
//        Optional<Course> courseOpt = courseRepository.findById(id);
//
//        if(courseOpt.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(courseOpt.get());
//    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Course> save(@Valid @RequestBody Course course){
        Course courseSaved = courseRepository.save(course);

        return ResponseEntity.created(URI.create("/courses/cadastrar/" + courseSaved.getId())).body(courseSaved);
    }
}
