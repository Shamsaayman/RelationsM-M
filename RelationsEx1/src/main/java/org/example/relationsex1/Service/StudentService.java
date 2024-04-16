package org.example.relationsex1.Service;

import lombok.RequiredArgsConstructor;
import org.example.relationsex1.API.ApiException;
import org.example.relationsex1.Model.Course;
import org.example.relationsex1.Model.Student;
import org.example.relationsex1.Model.Teacher;
import org.example.relationsex1.Repository.CourseRepository;
import org.example.relationsex1.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id , Student student){
        Student s = studentRepository.findStudentById(id);
        if(s==null){
            throw new ApiException("Student not found");
        }
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
        studentRepository.save(s);
    }

    public void deleteStudent(Integer id){
        Student s = studentRepository.findStudentById(id);
        if(s==null){
            throw new ApiException("Student not found");
        }
        studentRepository.delete(s);
    }
    public void assignStudentToCourse(Integer student_id , Integer course_id){
        Student s = studentRepository.findStudentById(student_id);
        Course c = courseRepository.findCourseById(course_id);
        if(s==null || c==null){
            throw new ApiException("Cannot Assign");
        }
        s.getCourses().add(c);
        c.getStudents().add(s);
        studentRepository.save(s);
        courseRepository.save(c);
    }

    public Student changeMajor(Integer id , String major){
        Student s = studentRepository.findStudentById(id);
        if(s==null){
            throw new ApiException("Student not found");
        }
        s.setMajor(major);
        s.getCourses().clear();
        studentRepository.save(s);
        return s;
    }
}
