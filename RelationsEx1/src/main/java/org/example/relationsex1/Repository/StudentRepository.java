package org.example.relationsex1.Repository;

import org.example.relationsex1.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById (Integer id);
}
