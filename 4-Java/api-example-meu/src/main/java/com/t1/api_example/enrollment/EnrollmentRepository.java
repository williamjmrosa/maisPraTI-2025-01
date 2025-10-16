package com.t1.api_example.enrollment;

import com.t1.api_example.course.Course;
import com.t1.api_example.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    boolean existsByUserAndCourse(User user, Course course);

    List<Enrollment> findByUser(User user);
    List<Enrollment> findByCourse(Course course);

    @Query("SELECT e FROM Enrollment e WHERE e.id = :idCourse")
    List<Enrollment> listarAlunosMatriculados(@Param("idCourse") Long idCourse);
}
