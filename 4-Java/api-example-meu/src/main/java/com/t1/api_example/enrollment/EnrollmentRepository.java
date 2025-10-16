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

    @Query(value = "SELECT * FROM enrollments e WHERE e.id = :idCourse", nativeQuery = true)
    List<Enrollment> listarAlunosMatriculados(@Param("idCourse") Long idCourse);

    @Query(value = "SELECT e.user_id FROM enrollments e WHERE e.course_id = :courseId ORDER BY e.enrolled_at ASC", nativeQuery = true)
    List<Long> findUserIdsByCourseNative(@Param("courseId") Long courseId);

    @Query(value = "SELECT COUNT(*) FROM enrollments e WHERE e.course_id = :courseId", nativeQuery = true)
    long countByCourseIdNative(@Param("courseId") Long courseId);
}
