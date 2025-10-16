package com.t1.api_example.enrollment;

import com.t1.api_example.course.Course;
import com.t1.api_example.course.CourseRepository;
import com.t1.api_example.enrollment.dto.EnrollmentRequest;
import com.t1.api_example.user.User;
import com.t1.api_example.user.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Enrollments")
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public EnrollmentController(EnrollmentRepository enrollmentRepository, UserRepository userRepository, CourseRepository courseRepository){
        this.enrollmentRepository = enrollmentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Enrollment> save(@Valid @RequestBody EnrollmentRequest enrollment){
        User user = userRepository.findById(enrollment.getUserId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if(user == null){
            throw new RuntimeException("Usuário não encontrado");
        }

        Course course = courseRepository.findById(enrollment.getCourseId()).orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        if(enrollmentRepository.existsByUserAndCourse(user,course)){
            return ResponseEntity.status(409).body((Enrollment) Map.of("erros","Usuário já matriculado no curso"));
            //throw new RuntimeException("Usuário já está inscrito nesse curso");
        }

        Enrollment en = new Enrollment();
        en.setUser(user);
        en.setCourse(course);

        Enrollment enrollmentSaved = enrollmentRepository.save(en);

        return ResponseEntity.created(URI.create("/enrollments/cadastrar/" + enrollmentSaved.getId())).body(enrollmentSaved);
    }

    @GetMapping("/listar/{idCourse}")
    public ResponseEntity<List<Enrollment>> listarAlunosMatriculados(@PathVariable Long idCourse){
        List<Enrollment> enrollments = enrollmentRepository.listarAlunosMatriculados(idCourse);
        return ResponseEntity.ok(enrollments);
    }



}
